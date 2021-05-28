package de.starvalcity.commands.staff;

import de.starvalcity.files.deGER;
import de.starvalcity.files.enENG;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.handlers.SoundHandler;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.loggerpackage.Logger;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;
import java.util.UUID;

public class IPCOMMAND implements CommandExecutor {

    String ip_own = PermissionsManager.ip_own;
    String ip_other = PermissionsManager.ip_other;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            if (strings.length == 0) {
                Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_own_PATH));
                Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_own_PATH));
            }
            if (strings.length == 1) {
                Player targetplayer = Bukkit.getPlayer(strings[0]);
                String targetplayerName = targetplayer.getName();
                InetSocketAddress targetplayerIP = targetplayer.getAddress();
                if (targetplayer == null) {
                    Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_null_PATH));
                    Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_PATH) + " " + targetplayerName);
                    Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_null_PATH));
                    Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_PATH) + " " + targetplayerName);
                } else {
                    Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_other_PATH) + " " + targetplayerIP);
                    Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_PATH) + " " + targetplayerName);
                    Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_other_PATH) + " " + targetplayerIP);
                    Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_PATH) + " " + targetplayerName);
                }
            }
            if (strings.length > 1) {
                Bukkit.getConsoleSender().sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_usage_PATH));
                Bukkit.getConsoleSender().sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_usage_PATH));
            }
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            InetSocketAddress playerIP = player.getAddress();
            UUID playerUniqueId = player.getUniqueId();
            if (strings.length == 0) {
                if (player.hasPermission(ip_own)) {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_own_PATH) + playerIP);
                    } else {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_own_PATH) + playerIP);
                    }
                } else {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_insufficient_permissions_PATH));
                        Logger.logInsufficientPermissions(player);
                    } else {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_insufficient_permissions_PATH));
                        Logger.logInsufficientPermissions(player);
                    }
                }
            }
            if (strings.length == 1) {
                Player targetplayer = Bukkit.getPlayer(strings[0]);
                String targetplayerName = targetplayer.getName();
                InetSocketAddress targetplayerIP = targetplayer.getAddress();
                if (targetplayer == null) {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_null_PATH));
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_PATH) + " " + targetplayerName);
                    } else {
                        SoundHandler.playErrorSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_null_PATH));
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_PATH) + " " + targetplayerName);
                    }
                } else {
                    if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_other_PATH) + " " + targetplayerIP);
                        player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_requested_targetplayer_PATH) + " " + targetplayerName);
                    } else {
                        SoundHandler.playSuccessSound(player);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_other_PATH) + " " + targetplayerIP);
                        player.sendMessage(deGER.getFile().getString(FilePathManager.GER_requested_targetplayer_PATH) + " " + targetplayerName);
                    }
                }
            }
            if (strings.length < 1) {
                if (LanguageHandler.getEnglishPlayers().contains(playerUniqueId)) {
                    SoundHandler.playErrorSound(player);
                    player.sendMessage(enENG.getFile().getString(FilePathManager.ENG_ip_usage_PATH));
                    Logger.logInvalidUsage(player);
                } else {
                    SoundHandler.playErrorSound(player);
                    player.sendMessage(deGER.getFile().getString(FilePathManager.GER_ip_usage_PATH));
                    Logger.logInvalidUsage(player);
                }
            }
        }
        return true;
    }
}
