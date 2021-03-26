package de.starvalcity.system.configuration;

import de.starvalcity.system.basepackage.Core;

import java.util.List;

public class FileStringHandler {

    //----------------------------------------------------------------------------------------------------------------//

    public static String mainConfigurationName = "configuration";

    //----------------------------------------------------------------------------------------------------------------//

    public static String authorSection = "Do_not_remove_or_modify.Author";
    public static String contributorSection = "Do_not_remove_or_modify.Contributors";
    public static String discordSection = "Do_not_remove_or_modify.Discord";
    public static String versionSection = "Do_not_remove_or_modify.Plugin_Version";
    public static String spigotSection = "Do_not_remove_or_modify.Spigot_Source";

    //----------------------------------------------------------------------------------------------------------------//

    public static List<String> authors = Core.getPlugin().getDescription().getAuthors();
    public static String discord = "https://discord.gg/HBjMcjFKpD";
    public static List<String> contributors = Core.getPlugin().getDescription().getContributors();
    public static String spigot = "https://www.spigotmc.org/members/1337nirflector.1015805/";
    public static String version = Core.getPlugin().getDescription().getVersion();
}
