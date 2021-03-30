package de.starvalcity.system.basepackage;

public class FileStringManager {

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: configuration.yml */

    public static String configuration_creation_path = "Do_not_remove_or_change.Created";
    public static String configuration_author_path = "Do_not_remove_or_change.Author";
    public static String configuration_discordURL_path = "Do_not_remove_or_change.DiscordURL";
    public static String configuration_spigotURL_path = "Do_not_remove_or_change.SpigotURL";
    public static String configuration_version_path = "Do_not_remove_or_change.Version";

    public static String configuration_language_path = "Plugin.System_language";

    public static String configuration_creation_path_CONTENT = "This file has been created " +
            "with the plugin version " + Core.getPlugin().getDescription().getVersion();
    public static String configuration_author_path_CONTENT = "1337Nirflector";
    public static String configuration_discordURL_path_CONTENT = "https://discord.gg/hyndDfPh";
    public static String configuration_spigotURL_path_CONTENT = "https://www.spigotmc.org/members/1337nirflector.1015805/";
    public static String configuration_version_path_CONTENT = Core.getPlugin().getDescription().getVersion();

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: messages.yml */

    public static String DE_insufficient_permissions = "§7[§6StarvalCity§7]§4 You are not allowed to execute this command!";

    public static String DE_plugin_authors = "§7[§6StarvalCity§7]§7 Authors: §e" + Core.getPlugin().getDescription().getAuthors();
    public static String DE_plugin_contributors = "§7[§6StarvalCity§7]§7Contributors: §e" + Core.getPlugin().getDescription().getContributors();
    public static String DE_plugin_reload = "§7[§6StarvalCity§7]§2 Plugin reloading...";
    public static String DE_plugin_reloaded = "§7[§6StarvalCity§7]§2 Plugin successfully reloaded!";
    public static String DE_plugin_api_version = "§7[§6StarvalCity§7]§7 API Version: §e" + Core.getPlugin().getDescription().getAPIVersion();
    public static String DE_plugin_version = "§7[§6StarvalCity§7]§7 Version: §e" + Core.getPlugin().getDescription().getVersion();



    /* -------------------------------------------------------------------------------------------------------------- */
}
