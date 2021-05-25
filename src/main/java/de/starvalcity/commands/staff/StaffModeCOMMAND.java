package de.starvalcity.commands.staff;

import de.starvalcity.files.deGER;
import de.starvalcity.files.enENG;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.handlers.SoundHandler;
import de.starvalcity.handlers.StaffHandler;
import de.starvalcity.system.corepackage.Core;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class StaffModeCOMMAND implements CommandExecutor {

    public static String generalPermission = PermissionsManager.staff_mode_use;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            this.sendPlayerRelatedToLogger();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUniqueId = player.getUniqueId();
            if (strings.length == 0) {
                if (player.hasPermission(generalPermission)) {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        if (StaffHandler.getStaffMembers().contains(playerUniqueId)) {
                            StaffHandler.removeStaffMember(player);
                            SoundHandler.playSuccessSound(player);
                            player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_left_staff_mode_PATH));
                        } else {
                            StaffHandler.setStaffMember(player);
                            SoundHandler.playSuccessSound(player);
                            player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_joined_staff_mode_PATH));
                        }
                    }
                    if (LanguageHandler.getGermanPlayers().contains(playerUniqueId)) {
                        if (StaffHandler.getStaffMembers().contains(playerUniqueId)) {
                            StaffHandler.removeStaffMember(player);
                            SoundHandler.playSuccessSound(player);
                            player.sendMessage(deGER.getFile().getString(FilePathManager.GER_left_staff_mode_PATH));
                        } else {
                            StaffHandler.setStaffMember(player);
                            SoundHandler.playSuccessSound(player);
                            player.sendMessage(deGER.getFile().getString(FilePathManager.GER_joined_staff_mode_PATH));
                        }
                    }
                } else {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_insufficient_permissions_PATH));
                    } else {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_insufficient_permissions_PATH));
                    }
                }
            }
            if (strings.length > 0) {
                if (player.hasPermission(generalPermission)) {
                    if (LanguageHandler.englishPlayers.contains(playerUniqueId)) {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_staff_mode_usage_PATH));
                    } else {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_staff_mode_usage_PATH));
                    }
                }
            }
        }
        return true;
    }

    private void sendPlayerRelatedToLogger() {
        Core.getPlugin().getLogger().severe(SystemMessagesManager.playerRelatedCommand);
    }
}
