package de.starvalcity.concepts.fractions.police;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DutyHandler {

    public static List<UUID> playersInDuty = new ArrayList<>();

    public static List<UUID> getPlayersInDuty() {
        return playersInDuty;
    }

    public static void setDuty(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        playersInDuty.add(playerUniqueId);
    }

    public static void removeDuty(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        playersInDuty.remove(playerUniqueId);
    }
}
