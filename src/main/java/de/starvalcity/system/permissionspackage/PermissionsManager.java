package de.starvalcity.system.permissionspackage;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.*;

public class PermissionsManager extends Core {

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
    // Permissions \\

    /* Group permissions */
    public static String system_projectManagement = "system.projectmanagement";
    public static String system_administrator = "system.administrator";
    public static String system_developer = "system.developer";
    public static String system_seniorModerator = "system.seniormoderator";
    public static String system_moderator = "system.moderator";
    public static String system_supporterPlus = "system.supporterplus";
    public static String system_supporter = "system.supporter";
    public static String system_testSupporter = "system.testsupporter";
    public static String system_builder = "system.builder";
    public static String system_youtuber = "system.youtuber";
    public static String system_twitchStreamer = "system.twitchstreamer";
    public static String system_contributor = "system.contributor";
    public static String system_vip = "system.vip";
    public static String system_exStaff = "system.exstaff";
    public static String system_player = "system.player";

    /* General permissions */
    public static String staff_mode_use = "staffmode.use";

    /*---------------------------------------------------------------------------------------------------------------*/
    // Functions \\

    /* Core Functions */

}
