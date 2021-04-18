package de.starvalcity.system.basepackage;

public class SystemLogger {

    public static void logPlayerRelatedCommand() {
        Core.getPlugin().getLogger().severe(SystemMessagesManager.DE_player_related_command);
        Core.getPlugin().getLogger().severe(SystemMessagesManager.EN_player_related_command);
    }
}
