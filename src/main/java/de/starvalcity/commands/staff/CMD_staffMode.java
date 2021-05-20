package de.starvalcity.commands.staff;

import de.starvalcity.system.corepackage.Core;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class CMD_staffMode implements CommandExecutor, Listener {
    private final Core server;

    public CMD_staffMode(Core server) {
        this.server = server;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            this.sendPlayerRelatedToLogger();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                if (player.hasPermission(""))
            }
        }
        return true;
    }

    private void sendPlayerRelatedToLogger() {
        server.getLogger().severe(SystemMessagesManager.playerRelatedCommand);
    }
}
