package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.*;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_language implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            SystemLogger.logPlayerRelatedCommand();
        }
        if (commandSender instanceof Player) {
            if (strings.length == 0) {
                if (commandSender.hasPermission(PermissionsManager.language_general)) {
                    if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.ENG_command_messages_language_command_usage_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.GER_command_messages_language_command_usage_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                    }
                } else {
                    if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        SystemLogger.logPlayerNoPermissions(commandSender);
                    } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        SystemLogger.logPlayerNoPermissions(commandSender);
                    }
                }
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("info")) {
                    if (commandSender.hasPermission(PermissionsManager.language_info)) {
                        if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.ENG_command_messages_language_command_info_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.GER_command_messages_language_command_info_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                    } else {
                        if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logPlayerNoPermissions(commandSender);
                        } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logPlayerNoPermissions(commandSender);
                        }
                    }
                } else if (strings[0].equalsIgnoreCase("set")) {
                    if (commandSender.hasPermission(PermissionsManager.language_set)) {
                        if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.ENG_command_messages_language_command_usage_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logInvalidUsage(commandSender);
                        } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.GER_command_messages_language_command_usage_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logInvalidUsage(commandSender);
                        }
                    } else {
                        if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logPlayerNoPermissions(commandSender);
                        } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                            commandSender.sendMessage(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH);
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                            SystemLogger.logPlayerNoPermissions(commandSender);
                        }
                    }
                }
            }
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("set")) {
                    if (commandSender.hasPermission(PermissionsManager.language_set)) {
                        if (strings[1].equalsIgnoreCase("english")) {
                            commandSender.sendMessage(FilePathManager.ENG_command_messages_language_command_set_PATH);
                            LanguageManager.englishPlayers.add(((Player) commandSender).getUniqueId());
                            LanguageManager.germanPlayers.remove(((Player) commandSender).getUniqueId());
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        } else if (strings[1].equalsIgnoreCase("german")) {
                            commandSender.sendMessage(FilePathManager.GER_command_messages_language_command_set_PATH);
                            LanguageManager.englishPlayers.remove(((Player) commandSender).getUniqueId());
                            LanguageManager.germanPlayers.add(((Player) commandSender).getUniqueId());
                            ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}
