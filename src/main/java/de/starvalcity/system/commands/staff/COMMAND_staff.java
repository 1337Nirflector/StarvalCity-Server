package de.starvalcity.system.commands.staff;

import de.starvalcity.system.arraylists.StaffMode;
import de.starvalcity.system.basepackage.*;
import de.starvalcity.system.files.deGER;
import de.starvalcity.system.files.enENG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class COMMAND_staff implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.DE_player_related_command);
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.EN_player_related_command);
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location playerLocation = player.getLocation();
            UUID playerUUID = player.getUniqueId();
            if (strings.length == 0) {
                if (!player.hasPermission(PermissionsManager.staff_general)) {
                    if (LanguageManager.englishPlayers.contains(playerUUID)) {
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    }
                } else {
                    if (LanguageManager.englishPlayers.contains(playerUUID)) {
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_prefixes_staff_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_prefixes_staff_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    }
                }
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("info")) {
                    if (!player.hasPermission(PermissionsManager.staff_info)) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            player.sendMessage(deGER.getFile().getString(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        }
                    } else {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            for (UUID staffMembers : StaffMode.staffMembers) {
                                player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_prefixes_staff_PATH) + staffMembers.toString());
                                player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            }
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            for (UUID staffMembers : StaffMode.staffMembers) {
                                player.sendMessage(deGER.getFile().getString(FilePathManager.GER_prefixes_staff_PATH) + staffMembers.toString());
                                player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            }
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("join")) {
                    if (!player.hasPermission(PermissionsManager.staff_join)) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            player.sendMessage(deGER.getFile().getString(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        }
                    } else {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            if (!StaffMode.staffMembers.contains(playerUUID)) {
                                StaffMode.setStaffMember(playerUUID);
                                player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_prefixes_staff_PATH));
                                player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                            } else {

                            }
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("leave")) {
                    if (!player.hasPermission(PermissionsManager.staff_leave)) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            player.sendMessage(deGER.getFile().getString(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        }
                    }
                }

            }
        }
        return true;
    }
}