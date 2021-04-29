package de.starvalcity.system.basepackage;

import de.starvalcity.system.api.HeadDatabaseAPI;
import de.starvalcity.system.api.LuckPermsAPI;
import de.starvalcity.system.events.PlayerFirstJoinEvent;
import de.starvalcity.system.features.EconomyManager;
import de.starvalcity.system.files.*;
import de.starvalcity.system.generations.IDN;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core instance;
    public static Core plugin;
    public static Plugin pl;
    public static PermissionsManager permissionsManager;
    public static EconomyManager economyManager;

    @Override
    public void onEnable() {
        plugin = this;
        pl = this;
        this.getLogger().info("Enabling StarvalCity system...");
        this.loadClientLanguages();
        this.loadEnglishMessages();
        this.loadGermanMessages();
        this.loadCommands();
        this.loadEvents();
        this.loadAPIs();
        this.loadEconomy();
        this.loadPermissions();

    }

    @Override
    public void onDisable() {
        this.getLogger().info("§4Disabling StarvalCity System...");
    }

    public static Core getInstance() {
        return instance;
    }

    public static Core getPlugin() {
        return plugin;
    }

    public static Plugin thisPlugin() {
        return plugin;
    }

    private void loadClientLanguages() {
        ClientLanguages.setupFile();
        this.getLogger().info(SystemMessagesManager.loading_client_languages);
        ClientLanguages.saveFile();
    }

    private void loadEnglishMessages() {
        String default_prefix_PATH = FilePathManager.ENG_prefixes_default_PATH;
        String default_prefix_CONTENT = FileStringManager.ENG_prefixes_default_CONTENT;
        String staff_prefix_PATH = FilePathManager.ENG_prefixes_staff_PATH;
        String staff_prefix_CONTENT = FileStringManager.ENG_prefixes_staff_CONTENT;
        String insufficient_permissions_PATH = FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH;
        String insufficient_permissions_CONTENT = FileStringManager.ENG_frequent_messages_insufficient_permissions_CONTENT;
        String requested_targetplayer_PATH = FilePathManager.ENG_frequent_messages_requested_targetplayer_PATH;
        String requested_targetplayer_CONTENT = FileStringManager.ENG_frequent_messages_requested_targetplayer_CONTENT;
        String requested_targetplayer_null_PATH = FilePathManager.ENG_frequent_messages_requested_targetplayer_null_PATH;
        String requested_targetplayer_null_CONTENT = FileStringManager.ENG_frequent_messages_requested_targetplayer_null_CONTENT;
        String something_went_wrong_PATH = FilePathManager.ENG_frequent_messages_something_went_wrong_PATH;
        String something_went_wrong_CONTENT = FileStringManager.ENG_frequent_messages_something_went_wrong_CONTENT;
        String too_many_arguments_PATH = FilePathManager.ENG_frequent_messages_too_many_arguments_PATH;
        String too_many_arguments_CONTENT = FileStringManager.ENG_frequent_messages_too_many_arguments_CONTENT;
        String economy_money_PATH = FilePathManager.ENG_command_messages_money_command_PATH;
        String economy_money_CONTENT = FileStringManager.ENG_command_messages_money_command_CONTENT;
        String idn_command_usage_PATH = FilePathManager.ENG_command_messages_idn_command_usage_PATH;
        String idn_command_usage_CONTENT = FileStringManager.ENG_command_messages_idn_command_usage_CONTENT;
        String idn_command_view_PATH = FilePathManager.ENG_command_messages_idn_command_view_PATH;
        String idn_command_view_CONTENT = FileStringManager.ENG_command_messages_idn_command_view_CONTENT;
        String idn_command_recreate_PATH = FilePathManager.ENG_command_messages_idn_command_recreate_PATH;
        String idn_command_recreate_CONTENT = FileStringManager.ENG_command_messages_idn_command_recreate_CONTENT;
        String language_command_usage_PATH = FilePathManager.ENG_command_messages_language_command_usage_PATH;
        String language_command_usage_CONTENT = FileStringManager.ENG_command_messages_language_command_usage_CONTENT;
        String language_command_info_PATH = FilePathManager.ENG_command_messages_language_command_info_PATH;
        String language_command_info_CONTENT = FileStringManager.ENG_command_messages_language_command_info_CONTENT;
        String language_command_set_PATH = FilePathManager.ENG_command_messages_language_command_set_PATH;
        String language_command_set_CONTENT = FileStringManager.ENG_command_messages_language_command_set_CONTENT;
        String language_already_set_PATH = FilePathManager.ENG_command_messages_language_already_set_PATH;
        String language_already_set_CONTENT = FileStringManager.ENG_command_messages_language_already_set_CONTENT;
        String staffchat_usage_PATH = FilePathManager.ENG_command_messages_staffchat_usage_PATH;
        String staffchat_usage_CONTENT = FileStringManager.ENG_command_messages_staffchat_usage_CONTENT;
        String uuid_usage_PATH = FilePathManager.ENG_command_messages_uuid_usage_PATH;
        String uuid_usage_CONTENT = FileStringManager.ENG_command_messages_uuid_usage_CONTENT;
        String uuid_command_PATH = FilePathManager.ENG_command_messages_uuid_command_PATH;
        String uuid_command_CONTENT = FileStringManager.ENG_command_messages_uuid_CONTENT;
        String economy_not_enough_money_PATH = FilePathManager.ENG_economy_messages_not_enough_money_PATH;
        String economy_not_enough_money_CONTENT = FileStringManager.ENG_economy_messages_not_enough_money_CONTENT;
        String economy_bank_account_creation_PATH = FilePathManager.ENG_economy_messages_bank_account_creation_PATH;
        String economy_bank_account_creation_CONTENT = FileStringManager.ENG_economy_messages_bank_account_creation_CONTENT;
        enENG.setupFile();
        this.getLogger().info(SystemMessagesManager.loading_enUK_yml);
        enENG.getFile().addDefault(default_prefix_PATH, default_prefix_CONTENT);
        enENG.getFile().addDefault(staff_prefix_PATH, staff_prefix_CONTENT);
        enENG.getFile().addDefault(insufficient_permissions_PATH, insufficient_permissions_CONTENT);
        enENG.getFile().addDefault(requested_targetplayer_PATH, requested_targetplayer_CONTENT);
        enENG.getFile().addDefault(requested_targetplayer_null_PATH, requested_targetplayer_null_CONTENT);
        enENG.getFile().addDefault(something_went_wrong_PATH, something_went_wrong_CONTENT);
        enENG.getFile().addDefault(too_many_arguments_PATH, too_many_arguments_CONTENT);
        enENG.getFile().addDefault(economy_money_PATH, economy_money_CONTENT);
        enENG.getFile().addDefault(idn_command_usage_PATH, idn_command_usage_CONTENT);
        enENG.getFile().addDefault(idn_command_view_PATH, idn_command_view_CONTENT);
        enENG.getFile().addDefault(idn_command_recreate_PATH, idn_command_recreate_CONTENT);
        enENG.getFile().addDefault(language_command_usage_PATH, language_command_usage_CONTENT);
        enENG.getFile().addDefault(language_command_info_PATH, language_command_info_CONTENT);
        enENG.getFile().addDefault(language_command_set_PATH, language_command_set_CONTENT);
        enENG.getFile().addDefault(language_already_set_PATH, language_already_set_CONTENT);
        enENG.getFile().addDefault(staffchat_usage_PATH, staffchat_usage_CONTENT);
        enENG.getFile().addDefault(uuid_usage_PATH, uuid_usage_CONTENT);
        enENG.getFile().addDefault(uuid_command_PATH, uuid_command_CONTENT);
        enENG.getFile().addDefault(economy_not_enough_money_PATH, economy_not_enough_money_CONTENT);
        enENG.getFile().addDefault(economy_bank_account_creation_PATH, economy_bank_account_creation_CONTENT);
        enENG.getFile().options().copyDefaults(true);
        enENG.saveFile();
    }

    private void loadGermanMessages() {
        String default_prefix_PATH = FilePathManager.GER_prefixes_default_PATH;
        String default_prefix_CONTENT = FileStringManager.GER_prefixes_default_CONTENT;
        String staff_prefix_PATH = FilePathManager.GER_prefixes_staff_PATH;
        String staff_prefix_CONTENT = FileStringManager.GER_prefixes_staff_CONTENT;
        String insufficient_permissions_PATH = FilePathManager.GER_frequent_messages_insufficient_permissions_PATH;
        String insufficient_permissions_CONTENT = FileStringManager.GER_frequent_messages_insufficient_permissions_CONTENT;
        String requested_targetplayer_PATH = FilePathManager.GER_frequent_messages_requested_targetplayer_PATH;
        String requested_targetplayer_CONTENT = FileStringManager.GER_frequent_messages_requested_targetplayer_CONTENT;
        String requested_targetplayer_null_PATH = FilePathManager.GER_frequent_messages_requested_targetplayer_null_PATH;
        String requested_targetplayer_null_CONTENT = FileStringManager.GER_frequent_messages_requested_targetplayer_null_CONTENT;
        String something_went_wrong_PATH = FilePathManager.GER_frequent_messages_something_went_wrong_PATH;
        String something_went_wrong_CONTENT = FileStringManager.GER_frequent_messages_something_went_wrong_CONTENT;
        String too_many_arguments_PATH = FilePathManager.GER_frequent_messages_too_many_arguments_PATH;
        String too_many_arguments_CONTENT = FileStringManager.GER_frequent_messages_too_many_arguments_CONTENT;
        String economy_money_PATH = FilePathManager.GER_command_messages_money_command_PATH;
        String economy_money_CONTENT = FileStringManager.GER_command_messages_money_command_CONTENT;
        String idn_command_usage_PATH = FilePathManager.GER_command_messages_idn_command_usage_PATH;
        String idn_command_usage_CONTENT = FileStringManager.GER_command_messages_idn_command_usage_CONTENT;
        String idn_command_view_PATH = FilePathManager.GER_command_messages_idn_command_view_PATH;
        String idn_command_view_CONTENT = FileStringManager.GER_command_messages_idn_command_view_CONTENT;
        String idn_command_recreate_PATH = FilePathManager.GER_command_messages_idn_command_recreate_PATH;
        String idn_command_recreate_CONTENT = FileStringManager.GER_command_messages_idn_command_recreate_CONTENT;
        String language_command_usage_PATH = FilePathManager.GER_command_messages_language_command_usage_PATH;
        String language_command_usage_CONTENT = FileStringManager.GER_command_messages_language_command_usage_CONTENT;
        String language_command_info_PATH = FilePathManager.GER_command_messages_language_command_info_PATH;
        String language_command_info_CONTENT = FileStringManager.GER_command_messages_language_command_info_CONTENT;
        String language_command_set_PATH = FilePathManager.GER_command_messages_language_command_set_PATH;
        String language_command_set_CONTENT = FileStringManager.GER_command_messages_language_command_set_CONTENT;
        String language_already_set_PATH = FilePathManager.GER_command_messages_language_already_set_PATH;
        String language_already_set_CONTENT = FileStringManager.GER_command_messages_language_already_set_CONTENT;
        String teamchat_usage_PATH = FilePathManager.GER_command_messages_staffchat_usage_PATH;
        String teamchat_usage_CONTENT = FileStringManager.GER_command_messages_staffchat_usage_CONTENT;
        String uuid_usage_PATH = FilePathManager.GER_command_messages_uuid_usage_PATH;
        String uuid_usage_CONTENT = FileStringManager.GER_command_messages_uuid_usage_CONTENT;
        String uuid_command_PATH = FilePathManager.GER_command_messages_uuid_command_PATH;
        String uuid_command_CONTENT = FileStringManager.GER_command_messages_uuid_CONTENT;
        String economy_not_enough_money_PATH = FilePathManager.GER_economy_messages_not_enough_money_PATH;
        String economy_not_enough_money_CONTENT = FileStringManager.GER_economy_messages_not_enough_money_CONTENT;
        String economy_bank_account_creation_PATH = FilePathManager.GER_economy_messages_bank_account_creation_PATH;
        String economy_bank_account_creation_CONTENT = FileStringManager.GER_economy_messages_bank_account_creation_CONTENT;
        deGER.setupFile();
        this.getLogger().info(SystemMessagesManager.loading_deGER_yml);
        deGER.getFile().options().header(FileHeaderManager.DE_header);
        deGER.getFile().addDefault(default_prefix_PATH, default_prefix_CONTENT);
        deGER.getFile().addDefault(staff_prefix_PATH, staff_prefix_CONTENT);
        deGER.getFile().addDefault(insufficient_permissions_PATH, insufficient_permissions_CONTENT);
        deGER.getFile().addDefault(requested_targetplayer_PATH, requested_targetplayer_CONTENT);
        deGER.getFile().addDefault(requested_targetplayer_null_PATH, requested_targetplayer_null_CONTENT);
        deGER.getFile().addDefault(something_went_wrong_PATH, something_went_wrong_CONTENT);
        deGER.getFile().addDefault(too_many_arguments_PATH, too_many_arguments_CONTENT);
        deGER.getFile().addDefault(economy_money_PATH, economy_money_CONTENT);
        deGER.getFile().addDefault(idn_command_usage_PATH, idn_command_usage_CONTENT);
        deGER.getFile().addDefault(idn_command_view_PATH, idn_command_view_CONTENT);
        deGER.getFile().addDefault(idn_command_recreate_PATH, idn_command_recreate_CONTENT);
        deGER.getFile().addDefault(language_command_usage_PATH, language_command_usage_CONTENT);
        deGER.getFile().addDefault(language_command_info_PATH, language_command_info_CONTENT);
        deGER.getFile().addDefault(language_command_set_PATH, language_command_set_CONTENT);
        deGER.getFile().addDefault(language_already_set_PATH, language_already_set_CONTENT);
        deGER.getFile().addDefault(teamchat_usage_PATH, teamchat_usage_CONTENT);
        deGER.getFile().addDefault(uuid_usage_PATH, uuid_usage_CONTENT);
        deGER.getFile().addDefault(uuid_command_PATH, uuid_command_CONTENT);
        deGER.getFile().addDefault(economy_not_enough_money_PATH, economy_not_enough_money_CONTENT);
        deGER.getFile().addDefault(economy_bank_account_creation_PATH, economy_bank_account_creation_CONTENT);
        deGER.getFile().options().copyDefaults(true);
        deGER.saveFile();
    }

    private void loadCommands() {
        this.getLogger().info(SystemMessagesManager.loading_commands);
    }

    private void loadEvents() {
        this.getLogger().info(SystemMessagesManager.loading_events);
        Bukkit.getPluginManager().registerEvents(new IDN(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFirstJoinEvent(), this);
    }

    private void loadAPIs() {
        this.getLogger().info(SystemMessagesManager.loading_apis);
        Bukkit.getPluginManager().registerEvents(new HeadDatabaseAPI(), this);
        LuckPermsAPI.loadLuckPermsAPI();
    }

    private void loadEconomy() {
        String ECO_bank_account_creation_PATH = FilePathManager.ECO_bank_account_creation_PATH;
        Double ECO_bank_account_creation_CONTENT = FileStringManager.ECO_bank_creation_price_CONTENT;
        Economy.setupFile();
        this.getLogger().info(SystemMessagesManager.loading_economy);
        Economy.getFile().set(ECO_bank_account_creation_PATH, ECO_bank_account_creation_CONTENT);
        Economy.saveFile();
    }

    private void loadPermissions() {
        Permissions.setupFile();
        this.getLogger().info(SystemMessagesManager.loading_permissions);
        Permissions.saveFile();
    }

}
