package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.files.deGER;
import de.starvalcity.system.files.enENG;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_uuid implements CommandExecutor {

    String ENG_targetplayer_null = FilePathManager.ENG_frequent_messages_requested_targetplayer_null_PATH;
    String GER_targetplayer_null = FilePathManager.GER_frequent_messages_requested_targetplayer_null_PATH;
    String ENG_too_many_arguments = FilePathManager.ENG_frequent_messages_too_many_arguments_PATH;
    String GER_too_many_arguments = FilePathManager.GER_frequent_messages_too_many_arguments_PATH;
    String ENG_uuid_usage = FilePathManager.ENG_command_messages_uuid_usage_PATH;
    String GER_uuid_usage = FilePathManager.GER_command_messages_uuid_usage_PATH;
    String ENG_uuid_msg = FilePathManager.ENG_command_messages_uuid_command_PATH;
    String GER_uuid_msg = FilePathManager.GER_command_messages_uuid_command_PATH;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            if (strings.length == 0) {
                Core.getPlugin().getLogger().severe(enENG.getFile().getString(ENG_uuid_usage));
                Core.getPlugin().getLogger().severe(deGER.getFile().getString(GER_uuid_usage));
            }
            if (strings.length == 1) {
                Player targetPlayer = Bukkit.getPlayer(strings[0]);
                if (targetPlayer != null) {
                    Core.getPlugin().getLogger().info(enENG.getFile().getString(ENG_uuid_msg) + "§e " + targetPlayer.getUniqueId());
                    Core.getPlugin().getLogger().info(deGER.getFile().getString(GER_uuid_msg) + "§e " + targetPlayer.getUniqueId());
                } else {
                    Core.getPlugin().getLogger().severe(enENG.getFile().getString(ENG_targetplayer_null));
                    Core.getPlugin().getLogger().severe(deGER.getFile().getString(GER_targetplayer_null));
                }
            }
            if (strings.length > 1) {
                Core.getPlugin().getLogger().severe(enENG.getFile().getString(ENG_too_many_arguments));
                Core.getPlugin().getLogger().severe(deGER.getFile().getString(GER_too_many_arguments));
            }
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                    player.sendMessage(enENG.getFile().getString(ENG_uuid_usage));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                } else {
                    player.sendMessage(deGER.getFile().getString(GER_uuid_usage));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
                }
            }
        }
        return true;
    }
}
