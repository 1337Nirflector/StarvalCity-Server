package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class COMMAND_staffchat implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.DE_player_related_command);
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.EN_player_related_command);
        }
        if (commandSender instanceof Player) {
            if (strings.length == 0) {
                if (commandSender.hasPermission(PermissionsManager.staffchat_general)) {
                    if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.ENG_command_messages_staffchat_usage_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 10);
                        SystemLogger.logInvalidUsage(commandSender);
                    } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.GER_command_messages_staffchat_usage_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 10);
                        SystemLogger.logInvalidUsage(commandSender);
                    }
                } else {
                    if (LanguageManager.englishPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 10);
                        SystemLogger.logPlayerNoPermissions(commandSender);
                    } else if (LanguageManager.germanPlayers.contains(((Player) commandSender).getUniqueId())) {
                        commandSender.sendMessage(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH);
                        ((Player) commandSender).playSound(((Player) commandSender).getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 10);
                        SystemLogger.logPlayerNoPermissions(commandSender);
                    }
                }
            }
        }
        return true;
    }
}
