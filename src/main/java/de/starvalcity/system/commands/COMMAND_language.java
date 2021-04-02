package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.*;
import de.starvalcity.system.files.de_GER;
import de.starvalcity.system.files.en_ENG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class COMMAND_language implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(MessagesManager.DE_player_related_command);
            Bukkit.getConsoleSender().sendMessage(MessagesManager.EN_player_related_command);
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location playerLocation = player.getLocation();
            UUID playerUUID = player.getUniqueId();
            if (strings.length == 0) {
                player.sendMessage(en_ENG.getFile().getString(en_ENG.getFile().getString(FileStringManager.EN_language_command_usage_PATH)));
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage(de_GER.getFile().getString(de_GER.getFile().getString(FileStringManager.DE_language_command_usage_PATH)));
                player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("info")) {
                    if (LanguageManager.englishPlayers.contains(playerUUID)) {
                        player.sendMessage(en_ENG.getFile().getString(FileStringManager.EN_language_command_info_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(de_GER.getFile().getString(FileStringManager.DE_language_command_info_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    } else if (!LanguageManager.englishPlayers.contains(playerUUID) && !LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(en_ENG.getFile().getString(FileStringManager.EN_something_went_wrong_PATH));
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage(de_GER.getFile().getString(FileStringManager.DE_something_went_wrong_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    }
                }
                if (strings[0].equalsIgnoreCase("set")) {
                    if (LanguageManager.englishPlayers.contains(playerUUID)) {
                        player.sendMessage(en_ENG.getFile().getString(FileStringManager.EN_language_command_usage_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(de_GER.getFile().getString(FileStringManager.DE_language_command_usage_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    } else if (!LanguageManager.englishPlayers.contains(playerUUID) && !LanguageManager.germanPlayers.contains(playerUUID)) {
                        player.sendMessage(en_ENG.getFile().getString(FileStringManager.EN_something_went_wrong_PATH));
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage(de_GER.getFile().getString(FileStringManager.DE_something_went_wrong_PATH));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    }
                }
            }
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("set")) {
                    if (strings[1].equalsIgnoreCase("english")) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            player.sendMessage(en_ENG.getFile().getString(FileStringManager.EN_language_command_set_already_set_PATH));
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(playerUUID)) {
                            LanguageManager.englishPlayers.add(playerUUID);
                            LanguageManager.germanPlayers.remove(playerUUID);
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (!LanguageManager.englishPlayers.contains(playerUUID) && !LanguageManager.germanPlayers.contains(playerUUID)) {
                            LanguageManager.englishPlayers.add(playerUUID);
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                    }
                    if (strings[1].equalsIgnoreCase("german")) {
                        if (LanguageManager.englishPlayers.contains(playerUUID)) {
                            LanguageManager.englishPlayers.remove(playerUUID);
                            LanguageManager.germanPlayers.add(playerUUID);
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (!LanguageManager.germanPlayers.contains(playerUUID)) {
                            LanguageManager.englishPlayers.remove(playerUUID);
                            LanguageManager.germanPlayers.add(playerUUID);
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (!LanguageManager.englishPlayers.contains(playerUUID) && !LanguageManager.germanPlayers.contains(playerUUID)) {
                            LanguageManager.germanPlayers.add(playerUUID);
                            player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}