package de.starvalcity.system.basepackage;

public class FileStringManager {


    //    public static String DE_language_command_usage = "§7[§6StarvalCity§7]§4 Nutzung: §7/language <info; set>";
    //
    //    public static String EN_language_command_usage = "§7[§6StarvalCity§7]§4 Usage: §7/language <info; set>";

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: configuration.yml */
    /* File Type: Main configuration */

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
    /* File Type: German message configuration */

    // Frequent
    public static String DE_prefix_PATH = "German_messages.Prefix";
    public static String DE_prefix_CONTENT = "§7[§6StarvalCity§7] ";
    public static String DE_insufficient_permissions_PATH = "German_messages.Unzureichende_Rechte";
    public static String DE_insufficient_permissions_CONTENT = "§4Du darfst diesen Befehl nicht ausführen!";
    public static String DE_something_went_wrong_PATH = "German_messages.Kritischer_Fehler";
    public static String DE_something_went_wrong_CONTENT = "§4Kritischer Fehler! Bitte melde diesen Fehler sofort einem " +
            "§bTechniker§4 oder einem §cAdministrator§4!";

    // Commands
    public static String DE_language_command_usage_PATH = "German_messages.Language_befehl_nutzung";
    public static String DE_language_command_usage_CONTENT = "§4Nutzung: §7/language <info; set>";
    public static String DE_language_command_info_PATH = "German_messages.Language_befehl_info";
    public static String DE_language_command_info_CONTENT = "§2Deine aktuelles Sprachpaket ist §e";
    public static String DE_language_command_set_already_set_PATH = "German_messages.Language_sprache_bereits_gesetzt";
    public static String DE_language_command_set_already_set_CONTENT = "§4Dein aktuelles Sprachpaket ist bereits §eDeutsch!";
    public static String DE_language_command_successfully_set_PATH = "German_messages.Language_sprache_erfolgreich_gesetzt";
    public static String DE_language_command_successfully_set_CONTENT = "§2Sprache erfolgreich gesetzt!";

    /* -------------------------------------------------------------------------------------------------------------- */
    /* File: en_ENG.yml */
    /* File Type: English message configuration */

    // Frequent
    public static String EN_prefix_PATH = "English_messages.Prefix";
    public static String EN_prefix_CONTENT = "§7[§6StarvalCity§7] ";
    public static String EN_insufficient_permissions_PATH = "English_messages.Insufficient_permissions";
    public static String EN_insufficient_permissions_CONTENT = "§4You are not allowed to execute this command!";
    public static String EN_something_went_wrong_PATH = "English_messages.Critical_system_error";
    public static String EN_something_went_wrong_CONTENT = "§4Critical error! Please report this error to a §bDeveloper " +
            "§4or an §cAdministrator§4!";

    // Commands
    public static String EN_language_command_usage_PATH = "English_messages.Language_command_usage";
    public static String EN_language_command_usage_CONTENT = "§4Usage: §7/language <info; set>";
    public static String EN_language_command_info_PATH = "English_messages.Language_command_info";
    public static String EN_language_command_info_CONTENT = "§2Your current language is§e ";
    public static String EN_language_command_set_already_set_PATH = "English_messages.Language_language_already_set";
    public static String EN_language_command_set_already_set_CONTENT = "§4Your current language has been already set to §eEnglish!";
    public static String EN_language_command_successfully_set_PATH = "English_messages:Language_language_successfully_set";
    public static String EN_language_command_successfully_set_CONTENT = "§2Language successfully set!";

    /* -------------------------------------------------------------------------------------------------------------- */
}
