package de.starvalcity.system.basepackage;

import de.starvalcity.system.api.HeadDatabaseAPI;
import de.starvalcity.system.api.LuckPermsAPI;
import de.starvalcity.system.commands.economy.COMMAND_money;
import de.starvalcity.system.commands.player.COMMAND_idn;
import de.starvalcity.system.commands.player.COMMAND_language;
import de.starvalcity.system.commands.staff.COMMAND_staff;
import de.starvalcity.system.commands.staff.COMMAND_staffchat;
import de.starvalcity.system.events.PlayerFirstJoinEvent;
import de.starvalcity.system.features.EconomyManager;
import de.starvalcity.system.files.*;
import de.starvalcity.system.generations.IDN;
import de.starvalcity.system.generations.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class Core extends JavaPlugin {

    private static Core instance;
    private static Logger system;
    public static Core plugin;
    public static Plugin pl;
    public static PermissionsManager permissionsManager;
    public static EconomyManager economyManager;
    private Timer timer;

    @Override
    public void onEnable() {
        plugin = this;
        pl = this;
        timer = new Timer();
        system.info("§2Enabling StarvalCity System...");
        loadClientLanguages();
        loadEnglishMessages();
        loadGermanMessages();
        loadCommands();
        loadEvents();
        loadAPIs();
        loadEconomy();
        loadPermissions();

    }

    @Override
    public void onDisable() {
        timer.saveTimer();
        system.info("§4Disabling StarvalCity System...");
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

    public void loadClientLanguages() {
        ClientLanguages.setupFile();
        system.info(SystemMessagesManager.loading_client_languages);
        ClientLanguages.saveFile();
    }

    public void loadEnglishMessages() {
        String default_prefix_PATH = FilePathManager.ENG_prefixes_default_PATH;
        String default_prefix_CONTENT = FileStringManager.ENG_prefixes_default_CONTENT;
        String staff_prefix_PATH = FilePathManager.ENG_prefixes_staff_PATH;
        String staff_prefix_CONTENT = FileStringManager.ENG_prefixes_staff_CONTENT;
        String insufficient_permissions_PATH = FilePathManager.ENG_frequent_messages_insufficient_permissions_PATH;
        String insufficient_permissions_CONTENT = FileStringManager.ENG_frequent_messages_insufficient_permissions_CONTENT;
        String something_went_wrong_PATH = FilePathManager.ENG_frequent_messages_something_went_wrong_PATH;
        String something_went_wrong_CONTENT = FileStringManager.ENG_frequent_messages_something_went_wrong_CONTENT;
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
        String economy_not_enough_money_PATH = FilePathManager.ENG_economy_messages_not_enough_money_PATH;
        String economy_not_enough_money_CONTENT = FileStringManager.ENG_economy_messages_not_enough_money_CONTENT;
        String economy_bank_account_creation_PATH = FilePathManager.ENG_economy_messages_bank_account_creation_PATH;
        String economy_bank_account_creation_CONTENT = FileStringManager.ENG_economy_messages_bank_account_creation_CONTENT;
        en_ENG.getFile().addDefault(default_prefix_PATH, default_prefix_CONTENT);
        en_ENG.getFile().addDefault(staff_prefix_PATH, staff_prefix_CONTENT);
        en_ENG.getFile().addDefault(insufficient_permissions_PATH, insufficient_permissions_CONTENT);
        en_ENG.getFile().addDefault(something_went_wrong_PATH, something_went_wrong_CONTENT);
        en_ENG.getFile().addDefault(economy_money_PATH, economy_money_CONTENT);
        en_ENG.getFile().addDefault(idn_command_usage_PATH, idn_command_usage_CONTENT);
        en_ENG.getFile().addDefault(idn_command_view_PATH, idn_command_view_CONTENT);
        en_ENG.getFile().addDefault(idn_command_recreate_PATH, idn_command_recreate_CONTENT);
        en_ENG.getFile().addDefault(language_command_usage_PATH, language_command_usage_CONTENT);
        en_ENG.getFile().addDefault(language_command_info_PATH, language_command_info_CONTENT);
        en_ENG.getFile().addDefault(language_command_set_PATH, language_command_set_CONTENT);
        en_ENG.getFile().addDefault(language_already_set_PATH, language_already_set_CONTENT);
        en_ENG.getFile().addDefault(staffchat_usage_PATH, staffchat_usage_CONTENT);
        en_ENG.getFile().addDefault(economy_not_enough_money_PATH, economy_not_enough_money_CONTENT);
        en_ENG.getFile().addDefault(economy_bank_account_creation_PATH, economy_bank_account_creation_CONTENT);
        en_ENG.setupFile();
        system.info(SystemMessagesManager.loading_enUK_yml);
        en_ENG.getFile().options().copyDefaults(true);
        en_ENG.saveFile();
    }

    public void loadGermanMessages() {
        String default_prefix_PATH = FilePathManager.GER_prefixes_default_PATH;
        String default_prefix_CONTENT = FileStringManager.GER_prefixes_default_CONTENT;
        String staff_prefix_PATH = FilePathManager.GER_prefixes_staff_PATH;
        String staff_prefix_CONTENT = FileStringManager.GER_prefixes_staff_CONTENT;
        String insufficient_permissions_PATH = FilePathManager.GER_frequent_messages_insufficient_permissions_PATH;
        String insufficient_permissions_CONTENT = FileStringManager.GER_frequent_messages_insufficient_permissions_CONTENT;
        String something_went_wrong_PATH = FilePathManager.GER_frequent_messages_something_went_wrong_PATH;
        String something_went_wrong_CONTENT = FileStringManager.GER_frequent_messages_something_went_wrong_CONTENT;
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
        String economy_not_enough_money_PATH = FilePathManager.GER_economy_messages_not_enough_money_PATH;
        String economy_not_enough_money_CONTENT = FileStringManager.GER_economy_messages_not_enough_money_CONTENT;
        String economy_bank_account_creation_PATH = FilePathManager.GER_economy_messages_bank_account_creation_PATH;
        String economy_bank_account_creation_CONTENT = FileStringManager.GER_economy_messages_bank_account_creation_CONTENT;
        de_GER.setupFile();
        system.info(SystemMessagesManager.loading_deGER_yml);
        de_GER.getFile().options().header(FileHeaderManager.DE_header);
        de_GER.getFile().addDefault(default_prefix_PATH, default_prefix_CONTENT);
        de_GER.getFile().addDefault(staff_prefix_PATH, staff_prefix_CONTENT);
        de_GER.getFile().addDefault(insufficient_permissions_PATH, insufficient_permissions_CONTENT);
        de_GER.getFile().addDefault(something_went_wrong_PATH, something_went_wrong_CONTENT);
        de_GER.getFile().addDefault(economy_money_PATH, economy_money_CONTENT);
        de_GER.getFile().addDefault(idn_command_usage_PATH, idn_command_usage_CONTENT);
        de_GER.getFile().addDefault(idn_command_view_PATH, idn_command_view_CONTENT);
        de_GER.getFile().addDefault(idn_command_recreate_PATH, idn_command_recreate_CONTENT);
        de_GER.getFile().addDefault(language_command_usage_PATH, language_command_usage_CONTENT);
        de_GER.getFile().addDefault(language_command_info_PATH, language_command_info_CONTENT);
        de_GER.getFile().addDefault(language_command_set_PATH, language_command_set_CONTENT);
        de_GER.getFile().addDefault(language_already_set_PATH, language_already_set_CONTENT);
        de_GER.getFile().addDefault(teamchat_usage_PATH, teamchat_usage_CONTENT);
        de_GER.getFile().addDefault(economy_not_enough_money_PATH, economy_not_enough_money_CONTENT);
        de_GER.getFile().addDefault(economy_bank_account_creation_PATH, economy_bank_account_creation_CONTENT);
        de_GER.getFile().options().copyDefaults(true);
        de_GER.saveFile();
    }

    private void loadCommands() {
        system.info(SystemMessagesManager.loading_commands);
        Objects.requireNonNull(this.getCommand("idn")).setExecutor(new COMMAND_idn());
        Objects.requireNonNull(this.getCommand("language")).setExecutor(new COMMAND_language());
        Objects.requireNonNull(this.getCommand("staff")).setExecutor(new COMMAND_staff());
        Objects.requireNonNull(this.getCommand("staffchat")).setExecutor(new COMMAND_staffchat());

        Objects.requireNonNull(this.getCommand("money")).setExecutor(new COMMAND_money());
    }

    private void loadEvents() {
        system.info(SystemMessagesManager.loading_events);
        Bukkit.getPluginManager().registerEvents(new IDN(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFirstJoinEvent(), this);
    }

    private void loadAPIs() {
        system.info(SystemMessagesManager.loading_apis);
        Bukkit.getPluginManager().registerEvents(new HeadDatabaseAPI(), this);
        LuckPermsAPI.loadLuckPermsAPI();
    }

    private void loadEconomy() {
        String ECO_bank_account_creation_PATH = FilePathManager.ECO_bank_account_creation_PATH;
        Double ECO_bank_account_creation_CONTENT = FileStringManager.ECO_bank_creation_price_CONTENT;
        Economy.setupFile();
        system.info(SystemMessagesManager.loading_economy);
        Economy.getFile().addDefault(ECO_bank_account_creation_PATH, ECO_bank_account_creation_CONTENT);
        Economy.saveFile();
    }

    private void loadPermissions() {
        Permissions.setupFile();
        system.info(SystemMessagesManager.loading_permissions);
        Permissions.saveFile();
    }

    public Timer getTimer() {
        return timer;
    }

}
