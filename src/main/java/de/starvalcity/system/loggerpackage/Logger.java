package de.starvalcity.system.loggerpackage;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.command.CommandSender;

public class Logger {

    public static void logInsufficientPermissions(CommandSender commandSender) {
        Core.getPlugin().getLogger().info("Der Spieler ");
    }
}
