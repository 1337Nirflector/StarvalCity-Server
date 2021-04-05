package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.basepackage.PermissionsManager;
import de.starvalcity.system.basepackage.SystemMessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class COMMAND_idn implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.DE_player_related_command);
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.EN_player_related_command);
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUUID = player.getUniqueId();
            if (!player.hasPermission(PermissionsManager.idn_general)) {
                if (LanguageManager.englishPlayers.contains(playerUUID)) {

                }
            }
        }
        return true;
    }
}
