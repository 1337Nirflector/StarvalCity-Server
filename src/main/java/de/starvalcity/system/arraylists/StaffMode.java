package de.starvalcity.system.arraylists;

import java.util.ArrayList;
import java.util.UUID;

public class StaffMode {

    public static ArrayList<UUID> staffMembers = new ArrayList<>();
    public static ArrayList<UUID> englishStaff = new ArrayList<>();
    public static ArrayList<UUID> germanStaff = new ArrayList<>();

    public static void setStaffMember(UUID player) {
        staffMembers.add(player);
    }

    /*
    public static boolean isInStaffMode(UUID player) {
        return staffMembers.contains(player);
    } */
}
