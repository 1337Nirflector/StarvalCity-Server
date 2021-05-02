package de.starvalcity.system.commands.staff;

import de.starvalcity.system.basepackage.SystemLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_staff implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            SystemLogger.logPlayerRelatedCommand();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

        }
        return true;
    }
}
