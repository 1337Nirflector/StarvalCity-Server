package de.starvalcity.handlers;

import org.bukkit.entity.Player;

import java.util.*;

public class StaffHandler {

   public static List<UUID> staffMembers = new ArrayList<>();

    public static List<UUID> getStaffMembers() {
        return staffMembers;
    }

    public static void setStaffMember(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        staffMembers.add(playerUniqueId);
    }

    public static void removeStaffMember(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        staffMembers.remove(playerUniqueId);
    }
}
