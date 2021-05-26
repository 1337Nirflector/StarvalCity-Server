package de.starvalcity.system.loggerpackage;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.command.CommandSender;

public class Logger {

    public static void logInsufficientPermissions(CommandSender commandSender) {
        Core.getPlugin().getLogger().info("§cThe player§e " + commandSender.getName() + "§c tried to use a" +
                " command but failed with: §6error code §b0 §6- §bInsufficient Permissions");
    }

    public static void logInvalidUsage(CommandSender commandSender) {
        Core.getPlugin().getLogger().info("§cThe player§e " + commandSender.getName() + "§c tried to use a" +
                " command but failed with: §6error code §b1 §6- §bInvalid Usage");
    }

    public static void logCommandDisabled(CommandSender commandSender) {
        Core.getPlugin().getLogger().info("§cThe player§e " + commandSender.getName() + "§c tried to use a" +
                " command but failed with: §6error code §b2 §6- §bCommand Disabled");
    }

    public static void logPlayerRelatedCommand() {
        Core.getPlugin().getLogger().info("§cThis command can only be executed by a §eplayer§c!");
    }
}
