package me.MitchT.BookShelf.Commands;

import me.MitchT.BookShelf.BookShelfPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class BSC_Help extends BSCommand {
    public BSC_Help(BookShelfPlugin plugin){
        super(plugin);
    }
    @Override
    public void onPlayerCommand(Player sender, Command command, String[] args) {

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
