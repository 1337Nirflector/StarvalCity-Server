package de.starvalcity.concepts.fractions;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FractionsHandler {

    public static List<UUID> policeMembers = new ArrayList<>();

    public static List<UUID> getPoliceMembers() {
        return policeMembers;
    }

    public static void setPoliceMember(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        policeMembers.add(playerUniqueId);
    }

    public static void removePoliceMember(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        policeMembers.remove(playerUniqueId);
    }
}
