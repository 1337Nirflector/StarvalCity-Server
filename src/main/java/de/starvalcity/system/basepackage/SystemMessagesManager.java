package de.starvalcity.system.basepackage;

public class SystemMessagesManager {

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String defaultPrefix = "§7[§6StarvalCity§7]§f ";

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String loading_configuration_yml = defaultPrefix + "§2Loading resource §econfiguration.yml§2...";
    public static String loading_client_languages = defaultPrefix + "§2Loading resource §eclientLanguages.yml§2...";
    public static String loading_enUK_yml = defaultPrefix + "§2Loading resource §eenUK.yml§2...";
    public static String loading_deGER_yml = defaultPrefix + "§2Loading resource §edeGER.yml§2...";
    public static String loading_commands = defaultPrefix + "§2Loading §ecommands§2...";
    public static String loading_events = defaultPrefix + "§2Loading §eevents §2and §elisteners§2...";
    public static String loading_apis = defaultPrefix + "§2Loading §eAPIs §2and similar §edependencies§2...";
    public static String loading_economy = defaultPrefix + "§2Loading §eeconomy system§2...";
    public static String loading_permissions = defaultPrefix + "§2Loading §epermissions§2...";

    public static String head_database_error = defaultPrefix + "§4Could not find the head you were looking for!";
    public static String luckperms_api_error = defaultPrefix + "§4Something went wrong while connecting to the " +
            "LuckPerms API dependency!";

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String EN_player_related_command = "§7[§6StarvalCity§7]§4 This command can only be executed by a player!";

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String DE_player_related_command = "§7[§6StarvalCity§7]§4 Dieser Befehl kann nur von einem Spieler " +
            "ausgeführt werden!";

    /* -------------------------------------------------------------------------------------------------------------- */
}
