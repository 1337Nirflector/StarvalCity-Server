package de.starvalcity.system.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class Language implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof ConsoleCommandSender) {
            if(strings[0].equalsIgnoreCase("set")) {
                if(strings[1].equalsIgnoreCase("enUK")) {
                    commandSender.sendMessage();
                }
            }
        }
        return true;
    }
}
