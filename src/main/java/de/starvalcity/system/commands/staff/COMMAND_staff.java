package de.starvalcity.system.commands.staff;

import de.starvalcity.system.arraylists.StaffMode;
import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.basepackage.PermissionsManager;
import de.starvalcity.system.basepackage.SystemLogger;
import de.starvalcity.system.files.deGER;
import de.starvalcity.system.files.enENG;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_staff implements CommandExecutor {

    String ENG_already_in_staff_mode = FilePathManager.ENG_command_messages_staff_already_PATH;
    String GER_already_in_staff_mode = FilePathManager.GER_command_messages_staff_already_PATH;
    String ENG_insufficient_permissions = FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH;
    String GER_insufficient_permissions = FilePathManager.GER_frequent_messages_insufficient_permissions_PATH;
    String ENG_staff_mode_usage = FilePathManager.ENG_command_messages_staff_usage_PATH;
    String GER_staff_mode_usage = FilePathManager.GER_command_messages_staff_usage_PATH;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            SystemLogger.logPlayerRelatedCommand();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                if (player.hasPermission(PermissionsManager.staff_general)) {
                    if (StaffMode.staffMembers.contains(player.getUniqueId())) {
                        if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                            player.sendMessage(enENG.getFile().getString(ENG_staff_mode_usage));
                        } else {
                            player.sendMessage(deGER.getFile().getString(GER_staff_mode_usage));
                        }
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                        SystemLogger.logInvalidUsage(player);
                    }
                } else {
                    if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                        player.sendMessage(enENG.getFile().getString(ENG_insufficient_permissions));
                    } else {
                        player.sendMessage(deGER.getFile().getString(GER_insufficient_permissions));
                    }
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                    SystemLogger.logPlayerNoPermissions(player);
                }
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("join")) {
                    if (player.hasPermission(PermissionsManager.staff_join)) {
                        if (StaffMode.staffMembers.contains(player.getUniqueId())) {
                            if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                                player.sendMessage(enENG.getFile().getString(ENG_already_in_staff_mode));
                                // System Logger already in staff mode
                            } else {
                                player.sendMessage(deGER.getFile().getString(GER_already_in_staff_mode));
                                // System Logger already in staff mode
                            }
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                        } else {
                            if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                                StaffMode.englishStaff.add(player.getUniqueId());
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
}
