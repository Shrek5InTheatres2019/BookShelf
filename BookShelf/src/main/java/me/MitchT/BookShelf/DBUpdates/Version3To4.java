package me.MitchT.BookShelf.DBUpdates;

import me.MitchT.BookShelf.BookShelfPlugin;
import me.MitchT.BookShelf.Shelves.ItemGenerator;
import me.MitchT.BookShelf.util.ItemStackSerializer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Version3To4 extends Version {
    public Version3To4(Logger logger, ResultSet r, BookShelfPlugin plugin) {
        super(logger, r, plugin);
    }

    public void close(ResultSet r) throws SQLException
    {
        plugin.close(r);
    }

    @Override
    public void doUpdate() {
        try {
            logger.info("Updating database to version 4");
            Map<String, Integer> s = new HashMap<String, Integer>();
            ArrayList<Integer> ii = new ArrayList<Integer>();
            r = plugin.runQuery("SELECT * FROM enchant");
            while (r.next()) {
                s.put(r.getString("type"), r.getInt("level"));
                ii.add(r.getInt("loc"));
            }
            close(r);
            plugin.runQuery("ALTER TABLE enchant DROP COLUMN type");
            plugin.runQuery("ALTER TABLE enchant DROP COLUMN level");
            plugin.runQuery("ALTER TABLE enchant ADD itemString TEXT");
            int index = 0;
            for (Map.Entry<String, Integer> entry : s.entrySet()) {
                String type = entry.getKey();
                Integer val = entry.getValue();
                Enchantment enchantment = Enchantment.getByName(type);
                ItemStack i = ItemGenerator.generateEnchantedBook(enchantment, val);
                String itemString = ItemStackSerializer.convertItemStackToString(i);
                plugin.runQuery("UPDATE enchant SET itemString='" + itemString + "' WHERE loc=" + ii.get(index) + ";");
                index++;
            }
            plugin.runQuery("UPDATE version SET version=4");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
