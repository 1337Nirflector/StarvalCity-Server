package de.starvalcity.commands;

import de.starvalcity.files.deGER;
import de.starvalcity.files.enENG;
import de.starvalcity.files.loggerMessages;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.handlers.SoundHandler;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class OnlinePlayersCOMMAND implements CommandExecutor {

    String generalPermission = PermissionsManager.onlineplayers_use;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(loggerMessages.getFile().getString(FilePathManager.GER_onlineplayers_command_PATH)
            + Bukkit.getOnlinePlayers());
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUniqueId = player.getUniqueId();
            if (strings.length == 0) {
                if (player.hasPermission(generalPermission)) {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_onlineplayers_command_PATH) +
                                Bukkit.getOnlinePlayers());
                    } else {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_onlineplayers_command_PATH) +
                                Bukkit.getOnlinePlayers());
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
                if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                    SoundHandler.playErrorSound(player);
                    player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_insufficient_permissions_PATH));
                } else {
                    SoundHandler.playErrorSound(player);
                    player.sendMessage(deGER.getFile().getString(FilePathManager.GER_insufficient_permissions_PATH));
                }
            }
        }
        return true;
    }
}
