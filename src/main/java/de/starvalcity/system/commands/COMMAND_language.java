package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.*;
import de.starvalcity.system.files.en_ENG;
import de.starvalcity.system.files.de_GER;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class COMMAND_language implements CommandExecutor, Listener {

    String subcommand_info = "info";
    String subcommand_set = "set";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            if (LanguageManager.systemLanguage.contains("en_ENG")) {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MessagesManager.EN_player_related_command);
                return true;
            } else if (LanguageManager.systemLanguage.contains("de_GER")) {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MessagesManager.DE_player_related_command);
                return true;
            }
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Location playerLocation = player.getLocation();
            UUID playerUniqueId = player.getUniqueId();
            if (strings.length == 0) {
                if (!player.hasPermission(PermissionsManager.language_all)) {
                    if (LanguageManager.englishPlayers.contains(playerUniqueId)) {
                        player.sendMessage(Objects.requireNonNull(en_ENG.getFile().getString(FileStringManager.EN_insufficient_permissions_PATH)));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        return true;
                    } else if (LanguageManager.germanPlayers.contains(playerUniqueId)) {
                        player.sendMessage(Objects.requireNonNull(de_GER.getFile().getString(FileStringManager.DE_insufficient_permissions_PATH)));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        return true;
                    }
                } else if (player.hasPermission(PermissionsManager.language_all)) {
                    if (LanguageManager.englishPlayers.contains(playerUniqueId)) {
                        player.sendMessage(Objects.requireNonNull(en_ENG.getFile().getString(FileStringManager.EN_language_command_usage)));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        return true;
                    } else if (LanguageManager.germanPlayers.contains(playerUniqueId)) {
                        player.sendMessage(Objects.requireNonNull(de_GER.getFile().getString(FileStringManager.DE_language_command_usage)));
                        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        return true;
                    }
                }
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase(subcommand_info)) {
                    if (!player.hasPermission(PermissionsManager.language_info)) {
                        if (LanguageManager.englishPlayers.contains(playerUniqueId)) {
                            player.sendMessage(Objects.requireNonNull(en_ENG.getFile().getString(FileStringManager.EN_insufficient_permissions_PATH)));
                        }
                    }
                }
            }
        }
        return false;
    }
}

