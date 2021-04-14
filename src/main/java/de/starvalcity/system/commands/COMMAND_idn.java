package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.basepackage.PermissionsManager;
import de.starvalcity.system.basepackage.SystemMessagesManager;
import de.starvalcity.system.files.de_GER;
import de.starvalcity.system.files.en_ENG;
import de.starvalcity.system.generations.IDN;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
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
            Location playerLocation = player.getLocation();
            UUID playerUUID = player.getUniqueId();
            if (!player.hasPermission(PermissionsManager.idn_general)) {
                if (LanguageManager.englishPlayers.contains(playerUUID)) {
                    player.sendMessage(en_ENG.getFile().getString(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH));
                    player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                    player.sendMessage(de_GER.getFile().getString(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH));
                    player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                }
            } else {
                if (strings.length == 0) {
                    if (player.hasPermission(PermissionsManager.idn_general)) {
                    if (LanguageManager.englishPlayers.contains(playerUUID)) {
                        player.sendMessage(en_ENG.getFile().getString(FilePathManager.ENG_command_messages_idn_command_usage_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(de_GER.getFile().getString(FilePathManager.GER_command_messages_idn_command_usage_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        }
                    }
                }
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("view")) {
                        if (player.hasPermission(PermissionsManager.idn_view)) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            player.sendMessage(en_ENG.getFile().getString(FilePathManager.ENG_command_messages_idn_command_view_PATH) + IDN.getIDN(playerUUID));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            player.sendMessage(de_GER.getFile().getString(FilePathManager.GER_command_messages_idn_command_view_PATH) + IDN.getIDN(playerUUID));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                    }
                    if (strings[0].equalsIgnoreCase("recreate")) {
                        if (player.hasPermission(PermissionsManager.idn_recreate)) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            IDN.getFile().set(player.toString(), IDN.createIDN());
                            player.sendMessage(en_ENG.getFile().getString(FilePathManager.ENG_command_messages_idn_command_recreate_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            IDN.getFile().set(player.toString(), IDN.createIDN());
                            player.sendMessage(de_GER.getFile().getString(FilePathManager.GER_command_messages_idn_command_recreate_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
