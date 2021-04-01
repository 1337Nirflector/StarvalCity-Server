package de.starvalcity.system.basepackage;

public class FileStringManager {


    //    public static String DE_language_command_usage = "§7[§6StarvalCity§7]§4 Nutzung: §7/language <info; set>";
    //
    //    public static String EN_language_command_usage = "§7[§6StarvalCity§7]§4 Usage: §7/language <info; set>";

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: configuration.yml */

    public static String configuration_creation_PATH = "Do_not_remove_or_change.Created";
    public static String configuration_author_PATH = "Do_not_remove_or_change.Author";
    public static String configuration_discordURL_PATH = "Do_not_remove_or_change.DiscordURL";
    public static String configuration_spigotURL_PATH = "Do_not_remove_or_change.SpigotURL";
    public static String configuration_version_PATH = "Do_not_remove_or_change.Version";
    public static String configuration_language_PATH = "Plugin.System_language";

    public static String configuration_creation_CONTENT = "This file has been created " +
            "with the plugin version " + Core.getPlugin().getDescription().getVersion();
    public static String configuration_author_CONTENT = "1337Nirflector";
    public static String configuration_discordURL_CONTENT = "https://discord.gg/hyndDfPh";
    public static String configuration_spigotURL_CONTENT = "https://www.spigotmc.org/members/1337nirflector.1015805/";
    public static String configuration_version_CONTENT = Core.getPlugin().getDescription().getVersion();

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: de_GER.yml */

    public static String DE_prefix_PATH = "German_messages.Prefix";
    public static String DE_insufficient_permissions_PATH = "German_messages.Unzureichende_Rechte";
    public static String DE_prefix_CONTENT = "§7[§6StarvalCity§7] ";
    public static String DE_insufficient_permissions_CONTENT = "§4Du darfst diesen Befehl nicht ausführen!";

    public static String DE_language_command_usage = "§4Nutzung: §7/language <info; set>";

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: en_ENG.yml */

    public static String EN_prefix_PATH = "English_messages.Prefix";
    public static String EN_prefix_CONTENT = "§7[§6StarvalCity§7] ";

    public static String EN_insufficient_permissions_PATH = "English_messages.Insufficient_permissions";
    public static String EN_insufficient_permissions_CONTENT = "§4You are not allowed to execute this command!";

    public static String EN_language_command_usage = "§4Usage: §7/language <info; set>";

    /* -------------------------------------------------------------------------------------------------------------- */
}
