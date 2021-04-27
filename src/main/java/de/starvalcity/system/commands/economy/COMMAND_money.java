package de.starvalcity.system.commands.economy;

import de.starvalcity.system.basepackage.*;
import de.starvalcity.system.features.EconomyManager;
import de.starvalcity.system.files.deGER;
import de.starvalcity.system.files.enENG;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_money  implements CommandExecutor {

    static String ENG_insufficient_permissions_PATH = FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH;
    static String GER_insufficient_permissions_PATH = FilePathManager.GER_frequent_messages_insufficient_permissions_PATH;
    static String ENG_command_money_PATH = FilePathManager.ENG_command_messages_money_command_PATH;
    static String GER_command_money_PATH = FilePathManager.GER_command_messages_money_command_PATH;

    static String ENG_insufficient_permissions_MSG = enENG.getFile().getString(ENG_insufficient_permissions_PATH);
    static String GER_insufficient_permissions_MSG = deGER.getFile().getString(GER_insufficient_permissions_PATH);
    static String ENG_command_money_MSG = enENG.getFile().getString(ENG_command_money_PATH);
    static String GER_command_money_MSG = deGER.getFile().getString(GER_command_money_PATH);

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            SystemLogger.logPlayerRelatedCommand();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                if (player.hasPermission(PermissionsManager.economy_client_money)) {
                    if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                        player.sendMessage(ENG_command_money_MSG + EconomyManager.getPlayerMoney(player));
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    } else if (LanguageManager.germanPlayers.contains(player.getUniqueId())) {
                        player.sendMessage(GER_command_money_MSG + EconomyManager.getPlayerMoney(player));
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                    }
                } else {
                    if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                        player.sendMessage(ENG_insufficient_permissions_MSG);
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        SystemLogger.logPlayerNoPermissions(player);
                    } else if (LanguageManager.germanPlayers.contains(player.getUniqueId())) {
                        player.sendMessage(GER_insufficient_permissions_MSG);
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                        SystemLogger.logPlayerNoPermissions(player);
                    }
                }
            }
        }
        return true;
    }
}
