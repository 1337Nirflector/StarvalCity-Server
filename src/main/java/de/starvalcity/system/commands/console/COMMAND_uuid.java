package de.starvalcity.system.commands.console;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.files.deGER;
import de.starvalcity.system.files.enENG;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class COMMAND_uuid implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            if (strings.length == 0) {
                Core.getPlugin().getLogger().severe(enENG.getFile().getString("ENG_command_messages_uuid_usage_PATH"));
                Core.getPlugin().getLogger().severe(deGER.getFile().getString("GER_command_messages_uuid_usage_PATH"));
            }
            if (strings.length == 1) {
                Player targetPlayer = Bukkit.getPlayer(strings[0]);
                if (targetPlayer != null) {
                    Core.getPlugin().getLogger().info(enENG.getFile().getString("") + "§e " + targetPlayer.getUniqueId());
                    Core.getPlugin().getLogger().info(deGER.getFile().getString("") + "§e " + targetPlayer.getUniqueId());
                } else {
                    Core.getPlugin().getLogger().severe(enENG.getFile().getString(""));
                    Core.getPlugin().getLogger().severe(deGER.getFile().getString(""));
                }
            }
            if (strings.length > 1) {
                Core.getPlugin().getLogger().severe(enENG.getFile().getString(""));
                Core.getPlugin().getLogger().severe(deGER.getFile().getString(""));
            }
        }
        return true;
    }
}
