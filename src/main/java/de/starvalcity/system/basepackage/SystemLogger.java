package de.starvalcity.system.basepackage;

import org.bukkit.command.CommandSender;

public class SystemLogger {

    public static void logPlayerRelatedCommand() {
        Core.getPlugin().getLogger().severe(SystemMessagesManager.DE_player_related_command);
        Core.getPlugin().getLogger().severe(SystemMessagesManager.EN_player_related_command);
    }

    public static void logPlayerNoPermissions(CommandSender commandSender) {
        Core.getPlugin().getLogger().severe("§2Der Spieler§e " + commandSender.getName() + "§2 versuchte einen Befehl" +
                " auszuführen, aber scheiterte an:§c Fehlerzahl 1 - Unzureichende Rechte");
        Core.getPlugin().getLogger().severe("§2The player§e " + commandSender.getName() + "§2 tried to execute a command" +
                " but failed with: §cError code 1 - Insufficient permissions");
    }

    public static void logInvalidUsage(CommandSender commandSender) {
        Core.getPlugin().getLogger().severe("§2Der Spieler§e " + commandSender.getName() + "§2 versuchte einen Befehl " +
                "auszuführen, aber scheiterte an:§c Fehlerzahl 2 - Falsche Nutzung");
        Core.getPlugin().getLogger().severe("§2The player§e " + commandSender.getName() + "§2 tried to execute a command " +
                "but failed with: §cError code 2 - Invalid usage");
    }
}
