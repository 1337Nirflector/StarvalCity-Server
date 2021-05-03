package de.starvalcity.system.basepackage;

public class FileStringManager {

    //----------------------------------------------------------------------------------------------------------------//
    /* File: de_GER.yml */

    // Leere Zeilen
    public static String GER_blank_line_CONTENT = "";

    // Prefixes
    public static String GER_prefixes_default_CONTENT = "§7[§6StarvalCity§7] ";
    public static String GER_prefixes_promotion_CONTENT = "§7[§aBeförderung§7 ]";
    public static String GER_prefixes_staff_CONTENT = "§7[§9Team§7] ";

    // Vielmalige Nachrichten
    public static String GER_frequent_messages_insufficient_permissions_CONTENT = "§4Das darfst Du nicht!";
    public static String GER_frequent_messages_requested_targetplayer_CONTENT = "§7Angegebener Spieler:§e ";
    public static String GER_frequent_messages_requested_targetplayer_null_CONTENT = "§4Der angegebene Spieler existiert nicht!";
    public static String GER_frequent_messages_something_went_wrong_CONTENT = "§4Kritischer Systemfehler! Bitte " +
            "kontaktiere einen §bDeveloper§4 oder einen §cAdministrator§4!";
    public static String GER_frequent_messages_too_many_arguments_CONTENT = "§4Zu viele Befehlsargumente!";

    // Befehlsnachrichten
    public static String GER_command_messages_money_command_CONTENT = "§2Dein Bargeld§7:§f ";
    public static String GER_command_messages_idn_command_usage_CONTENT = "§4Nutzung: §7/idn <view; recreate>";
    public static String GER_command_messages_idn_command_view_CONTENT = "§2Deine IDN lautet:§e ";
    public static String GER_command_messages_idn_command_recreate_CONTENT = "§2Deine IDN wurde §aerfolgreich §2neu erstellt!";
    public static String GER_command_messages_language_command_usage_CONTENT = "§4Nutzung: §7/language <info; set>";
    public static String GER_command_messages_language_command_info_CONTENT = "§2Aktuelles Sprachpaket:§e German";
    public static String GER_command_messages_language_command_set_CONTENT = "§2Sprachpaket erfolgreich gesetzt!";
    public static String GER_command_messages_language_already_set_CONTENT = "§4Sprachpaket bereits gesetzt!";
    public static String GER_command_messages_staff_usage_CONTENT = "§4Nutzung: §7/staff <join; quit>";
    public static String GER_command_messages_staff_already_CONTENT = "§4Du bist bereits im §eTeam-Modus!";
    public static String GER_command_messages_uuid_usage_CONTENT = "§4Nutzung: §7/uuid <Spielername>";
    public static String GER_command_messages_uuid_CONTENT = "§2Die §eUniqueID§2 ist:§e ";

    // Wirtschaftsnachrichten
    public static String GER_economy_messages_not_enough_money_CONTENT = "§4Du hast nicht genug Geld um dies zu tun!";
    public static String GER_economy_messages_bank_account_creation_CONTENT = "§2Konto erfolgreich erstellt!";

    //----------------------------------------------------------------------------------------------------------------//
    /* File: en_ENG.yml */

    // Empty lines
    public static String ENG_blank_line_CONTENT = "";

    // Prefixes
    public static String ENG_prefixes_default_CONTENT = "§7[§6StarvalCity§7] ";
    public static String ENG_prefixes_promotion_CONTENT = "§7[§aPromotion§7] ";
    public static String ENG_prefixes_staff_CONTENT = "§7[§9Staff§7] ";

    // Frequent messages
    public static String ENG_frequent_messages_insufficient_permissions_CONTENT = "§4You are not allowed to do that!";
    public static String ENG_frequent_messages_requested_targetplayer_CONTENT = "§7Requested target player:§e ";
    public static String ENG_frequent_messages_requested_targetplayer_null_CONTENT = "§4The requested target player does not exist!";
    public static String ENG_frequent_messages_something_went_wrong_CONTENT = "§4Critical error! Please report this " +
            "error to a §bDeveloper§4 or an §cAdministrator§4!";
    public static String ENG_frequent_messages_too_many_arguments_CONTENT = "§4Too many command arguments!";

    // Command messages
    public static String ENG_command_messages_money_command_CONTENT = "§2Your balance§7:§f ";
    public static String ENG_command_messages_idn_command_usage_CONTENT = "§4Usage: §7/idn <view; recreate>";
    public static String ENG_command_messages_idn_command_view_CONTENT = "§2Your IDN is:§e ";
    public static String ENG_command_messages_idn_command_recreate_CONTENT = "§2Your IDN has been §asuccessfully§2 recreated!";
    public static String ENG_command_messages_language_command_usage_CONTENT = "§4Usage: §7/language <info; set>";
    public static String ENG_command_messages_language_command_info_CONTENT = "§2Current language:§e English";
    public static String ENG_command_messages_language_command_set_CONTENT = "§2Language successfully set!";
    public static String ENG_command_messages_language_already_set_CONTENT = "§4Language already set!";
    public static String ENG_command_messages_staff_already_CONTENT = "§4You are already in §eStaff Mode!";
    public static String ENG_command_messages_staff_usage_CONTENT = "§4Usage: §7/staff <join; quit>";

    public static String ENG_command_messages_uuid_usage_CONTENT = "§4Usage: §7/uuid <Player name>";
    public static String ENG_command_messages_uuid_CONTENT = "§2The §eUniqueID§2 is:§e ";

    // Economy messages
    public static String ENG_economy_messages_not_enough_money_CONTENT = "§4You do not have enough money to do that!";
    public static String ENG_economy_messages_bank_account_creation_CONTENT = "§2Bank account successfully created!";

    //----------------------------------------------------------------------------------------------------------------//
    /* File: economy.yml */

    // Default values
    public static Double ECO_bank_creation_price_CONTENT = 100.00;

}
