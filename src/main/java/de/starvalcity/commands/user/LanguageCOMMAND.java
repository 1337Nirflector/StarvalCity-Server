package de.starvalcity.commands.user;

import de.starvalcity.system.loggerpackage.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class LanguageCOMMAND implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            Logger.logPlayerRelatedCommand();
        }
        return true;
    }
}
