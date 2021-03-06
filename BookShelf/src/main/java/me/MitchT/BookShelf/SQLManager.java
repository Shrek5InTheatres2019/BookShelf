package me.MitchT.BookShelf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import me.MitchT.BookShelf.DBUpdates.DBUpdate;
import me.MitchT.SimpleSQL.Database;
import me.MitchT.SimpleSQL.MySQL;
import me.MitchT.SimpleSQL.SQLite;

/**
 * 
 * BookShelf - A Bukkit & Spigot mod allowing the placement of items
 * into BookShelves. <br>
 * Copyright (C) 2012-2014 Mitch Talmadge (mitcht@aptitekk.com)<br>
 * <br>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.<br>
 * <br>
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br>
 * <br>
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 * 
 * @author Mitch Talmadge (mitcht@aptitekk.com)
 */
public class SQLManager
{
    private BookShelfPlugin plugin;
    private MySQL mysqlDB;
    private SQLite sqliteDB;
    private Logger logger;
    private ResultSet r;
    private final int currentDatabaseVersion = 3;
    
    public SQLManager(BookShelfPlugin plugin, Logger logger)
    {
        this.plugin = plugin;
        this.logger = logger;
        
        connectToDatabase();
        validateTables();
    }
    
    public void connectToDatabase()
    {
        boolean useMySQL = plugin.getConfig().getBoolean(
                "database.mysql_enabled");
        String host = plugin.getConfig().getString("database.hostname");
        int port = plugin.getConfig().getInt("database.port");
        String dbname = plugin.getConfig().getString("database.database");
        String user = plugin.getConfig().getString("database.username");
        String pass = plugin.getConfig().getString("database.password");
        String prefix = plugin.getConfig().getString("database.prefix");
        if(useMySQL)
        {
            this.mysqlDB = new MySQL(logger, prefix, host, port, dbname, user,
                    pass);
            try
            {
                mysqlDB.open();
            }
            catch(Exception e)
            {
                logger.info(e.getMessage());
                plugin.getPluginLoader().disablePlugin(plugin);
            }
        }
        else
        {
            sqliteDB = new SQLite(logger, prefix, plugin.getDataFolder()
                    .getAbsolutePath(), "Shelves");
            try
            {
                sqliteDB.open();
            }
            catch(Exception e)
            {
                logger.info(e.getMessage());
                plugin.getPluginLoader().disablePlugin(plugin);
            }
        }
    }
    
    public boolean isUsingMySQL()
    {
        return this.mysqlDB != null;
    }
    
    public void validateTables()
    {
        sqlDoesVersionExist();
        if(getDbVersion() == 1)
            doDelimiterFix();
        updateDb();
        logger.info("[BookShelf] Current Database Version: " + getDbVersion());
        if(isUsingMySQL())
        {
            runQuery("CREATE TABLE IF NOT EXISTS items (id INT NOT NULL AUTO_INCREMENT, x INT, y INT, z INT, title VARCHAR(128), author VARCHAR(128), lore TEXT, damage INT, enumType TEXT, loc INT, amt INT, pages TEXT, PRIMARY KEY (id));");
            runQuery("CREATE TABLE IF NOT EXISTS copy (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS enable (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS enchant (x INT, y INT, z INT, loc INT, itemString VARCHAR(1024));");
            runQuery("CREATE TABLE IF NOT EXISTS maps (x INT, y INT, z INT, loc INT, durability SMALLINT);");
            runQuery("CREATE TABLE IF NOT EXISTS shop (x INT, y INT, z INT, bool INT, price INT);");
            runQuery("CREATE TABLE IF NOT EXISTS display (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS names (x INT, y INT, z INT, name VARCHAR(64));");
            runQuery("CREATE TABLE IF NOT EXISTS donate (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS owners (x INT, y INT, z INT, ownerString TEXT);");
        }
        else
        {
            runQuery("CREATE TABLE IF NOT EXISTS items (id INTEGER PRIMARY KEY, x INT, y INT, z INT, title TEXT, author TEXT, lore TEXT, damage INT, enumType TEXT, loc INT, amt INT, pages TEXT);");
            runQuery("CREATE TABLE IF NOT EXISTS copy (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS enable (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS enchant (x INT, y INT, z INT, loc INT, itemString STRING);");
            runQuery("CREATE TABLE IF NOT EXISTS maps (x INT, y INT, z INT, loc INT, durability SMALLINT);");
            runQuery("CREATE TABLE IF NOT EXISTS shop (x INT, y INT, z INT, bool INT, price INT);");
            runQuery("CREATE TABLE IF NOT EXISTS display (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS names (x INT, y INT, z INT, name TEXT);");
            runQuery("CREATE TABLE IF NOT EXISTS donate (x INT, y INT, z INT, bool INT);");
            runQuery("CREATE TABLE IF NOT EXISTS owners (x INT, y INT, z INT, ownerString TEXT);");
        }
        logger.info("[BookShelf] Database Loaded.");
    }
    
    private int getDbVersion()
    {
        int version = -1;
        try
        {
            sqlDoesVersionExist();
            r = runQuery("SELECT * FROM version");
            if(r.next())
                version = r.getInt("version");
            close(r);
            return version;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    private void sqlDoesVersionExist()
    {
        if(isUsingMySQL())
        {
            try
            {
                r = runQuery("SHOW TABLES LIKE 'version';");
                if(r.next())
                {
                    close(r);
                    return;
                }
                else
                    close(r);
                
                r = runQuery("SHOW TABLES LIKE 'items';");
                if(!r.next())
                {
                    close(r); //Looks like we are making a new database.
                    logger.info("[BookShelf] Creating Database...");
                    runQuery("CREATE TABLE IF NOT EXISTS version (version INT);");
                    runQuery("INSERT INTO version (version) VALUES("
                            + currentDatabaseVersion + ");");
                }
                else
                { //We aren't making a new database, but version doesn't exist.... Let's add it.
                    close(r);
                    logger.info("[BookShelf] Adding version to Database...");
                    r = runQuery("SHOW TABLES LIKE 'version';");
                    if(!r.next())
                    {
                        close(r);
                        runQuery("CREATE TABLE IF NOT EXISTS version (version INT);");
                        runQuery("INSERT INTO version (version) VALUES(0);");
                    }
                    else
                    {
                        close(r);
                    }
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                
                r = runQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='version';");
                if(r.next())
                {
                    close(r);
                    return;
                }
                else
                    close(r);
                
                r = runQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='items';");
                if(!r.next())
                {
                    close(r); //Looks like we are making a new database.
                    logger.info("[BookShelf] Creating Database...");
                    runQuery("CREATE TABLE IF NOT EXISTS version (version INT);");
                    runQuery("INSERT INTO version (version) VALUES("
                            + currentDatabaseVersion + ");");
                }
                else
                { //We aren't making a new database, but version doesn't exist.... Let's add it.
                    close(r);
                    r = runQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='version';");
                    if(!r.next())
                    {
                        close(r);
                        logger.info("[BookShelf] Adding version to Database...");
                        runQuery("CREATE TABLE IF NOT EXISTS version (version INT);");
                        runQuery("INSERT INTO version (version) VALUES(0);");
                    }
                    else
                    {
                        close(r);
                    }
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private void updateDb()
    {
        
        //Note to self: Update currentDatabaseVersion!! :)
        int version = -1;
        try
        {
            r = runQuery("SELECT * FROM version");
            if(r.next())
                version = r.getInt("version");
            close(r);
            DBUpdate updater = new DBUpdate(logger, r, plugin);
            switch(version)
            {
                case 0:
                    updater.doUpdate(version);
                    updateDb();
                    break;
                case 1:
                    updater.doUpdate(version);
                    updateDb();
                    break;
                case 2:
                    updater.doUpdate(version);
                    updateDb();
                    break;
                case 3:
                    updater.doUpdate(version);
                    updateDb();
                    break;
                default:
                    break;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    private void doDelimiterFix()
    {
        try
        {
            ArrayList<Integer> ids = new ArrayList<Integer>();
            ArrayList<String> pageStrings = new ArrayList<String>();
            r = runQuery("SELECT * FROM items;");
            while(r.next())
            {
                ids.add(r.getInt("id"));
                pageStrings.add(r.getString("pages"));
            }
            close(r);
            for(int i = 0; i < ids.size(); i++)
            {
                if(pageStrings.get(i) != null)
                {
                    String pages = pageStrings.get(i).replaceAll(":", "�");
                    pages = pages.replaceAll("'", "''");
                    runQuery("UPDATE items SET pages='" + pages + "' WHERE id="
                            + ids.get(i) + ";");
                }
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void setAutoCommit(boolean autoCommit)
    {
        try
        {
            getDatabase().getConnection().setAutoCommit(autoCommit);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void commit()
    {
        try
        {
            getDatabase().getConnection().commit();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public ResultSet runQuery(String query)
    {
        try
        {
            return getDatabase().query(query);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    private Database getDatabase()
    {
        if(mysqlDB != null)
            return mysqlDB;
        else
            return sqliteDB;
        
    }
    
    public void close(ResultSet r) throws SQLException
    {
        r.close();
        getDatabase().setShouldWait(false);
        synchronized(getDatabase().getSynchronized())
        {
            getDatabase().getSynchronized().notify();
        }
    }
    
    public void shutDown()
    {
        getDatabase().close();
    }
}
