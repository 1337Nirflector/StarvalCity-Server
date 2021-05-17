package de.starvalcity.system.permissionspackage;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.*;

public class PermissionsManager extends Core {

    public PermissionsManager(Core plugin) {
    }

    public static FileConfiguration permissionsFile;

    public static List<String> groups = new ArrayList<>();
    public static List<String> permissions = new ArrayList<>();

    public static Map<UUID, String> userGroups = new HashMap<>();
    public static Map <UUID, PermissionAttachment> userPermissions = new HashMap<>();
    public static Map<String, String> permissionsChildren = new HashMap<>();

    /*---------------------------------------------------------------------------------------------------------------*/
    // Groups \\

    public static String projectManagement = "Project Management";
    public static String administrator = "Administrator";
    public static String developer = "Developer";
    public static String seniorModerator = "Senior Moderator";
    public static String moderator = "Moderator";
    public static String supporterPlus = "Supporter+";
    public static String supporter = "Supporter";
    public static String testSupporter = "Test Supporter";
    public static String builder = "Builder";
    public static String youtuber = "YouTuber";
    public static String twitchStreamer = "Twitch-Streamer";
    public static String contributor = "Contributor";
    public static String vip = "VIP";
    public static String exStaff = "Ex-Staff";
    public static String player = "Player";

    /*---------------------------------------------------------------------------------------------------------------*/
    // Functions \\

    /* Core Functions */
    public static void setupPermissions(Player player) {
        PermissionAttachment permissionAttachment = player.addAttachment(plugin);
        PermissionsManager.userPermissions.put(player.getUniqueId(), permissionAttachment);
        PermissionsManager.setPermission(player.getUniqueId());


    }

    public static void setPermission(UUID uuid) {
        PermissionAttachment permissionAttachment = PermissionsManager.userPermissions.get(uuid);

        for (String groups : permissionsFile.getConfigurationSection("Groups").getKeys(false)) {
            for (String permissions : permissionsFile.getStringList("Groups." + groups + ".permissions")) {
                permissionAttachment.setPermission(permissions, true);
            }
        }
    }
}
