package me.MitchT.BookShelf.Commands;

import me.MitchT.BookShelf.BookShelfPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.mozilla.javascript.Undefined;

import static java.lang.Integer.parseInt;

public class BSC_Help extends BSCommand {
    public BSC_Help(BookShelfPlugin plugin){
        super(plugin);
    }
    @Override
    public void onPlayerCommand(Player sender, Command command, String[] args) {
        try {
            sender.performCommand("help bookshelf " + args[0]);
        }catch(ArrayIndexOutOfBoundsException e){
            sender.performCommand("help bookshelf");
        }
    }

    @Override
    public void onConsoleCommand(ConsoleCommandSender sender, Command command, String[] args) {
        return;
    }

    @Override
    public void onCommandBlockCommand(CommandSender sender, Command command, String[] args) {
        return;
    }
}
