package de.starvalcity.system.configuration;

import de.starvalcity.system.basepackage.Core;

import java.util.List;

public class MessageHandler {

    //----------------------------------------------------------------------------------------------------------------//

    public static String startupLine = "------------------------------------------------------------------";
    public static String startupBlankLine = "                                                       ";
    public static String startupAuthorsLine = "§2This plugin has been developed by: §e" + Core.getPlugin().getDescription().getAuthors();
    public static String startupAPIVersionLine = "§eAPI Version: " + Core.getPlugin().getDescription().getAPIVersion();
    public static String startupVersionLine = "§ePlugin Version: " + Core.getPlugin().getDescription().getVersion();

    //----------------------------------------------------------------------------------------------------------------//

    public static String shutdownLine = "------------------------------------------------------------------";
    public static String shutdownBlankLine = "                                                       ";
    public static String shutdownAuthorsLine = "§2This plugin has been developed by: §e" + Core.getPlugin().getDescription().getAuthors();
    public static String shutdownAPIVersionLine = "§eAPI Version: " + Core.getPlugin().getDescription().getAPIVersion();
    public static String shutdownVersionLine = "§ePlugin Version: " + Core.getPlugin().getDescription().getVersion();

    //----------------------------------------------------------------------------------------------------------------//

}
