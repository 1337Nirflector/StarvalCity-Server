package de.starvalcity.system.basepackage;

import de.starvalcity.system.commands.COMMAND_language;
import de.starvalcity.system.commands.COMMAND_staff;
import de.starvalcity.system.files.ClientLanguages;
import de.starvalcity.system.files.Configuration;
import de.starvalcity.system.files.de_GER;
import de.starvalcity.system.files.en_ENG;
import de.starvalcity.system.generations.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class Core extends JavaPlugin {

    private static Core instance;
    public static Core plugin;
    public static Plugin pl;
    private Timer timer;


    @Override
    public void onEnable() {
        Logger system = getLogger();
        plugin = this;
        pl = this;
        timer = new Timer();
        loadConfiguration();
        loadClientLanguages();
        loadEnglishMessages();
        loadGermanMessages();
        loadCommands();
        loadEvents();

    }

    @Override
    public void onDisable() {
        timer.saveTimer();
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

    public void loadConfiguration() {
        try {
            Configuration.loadConfiguration();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadClientLanguages() {
        ClientLanguages.setupFile();
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_client_languages);
        ClientLanguages.saveFile();
    }

    public void loadEnglishMessages() {
        String default_prefix_PATH = "";
        en_ENG.setupFile();
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_enUK_yml);
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
        String language_command_usage_PATH = FilePathManager.GER_command_messages_language_command_usage_PATH;
        String language_command_usage_CONTENT = FileStringManager.GER_command_messages_language_command_usage_CONTENT;
        String language_command_info_PATH = FilePathManager.GER_command_messages_language_command_info_PATH;
        String language_command_info_CONTENT = FileStringManager.GER_command_messages_language_command_info_CONTENT;
        String language_command_set_PATH = FilePathManager.GER_command_messages_language_command_set_PATH;
        String language_command_set_CONTENT = FileStringManager.GER_command_messages_language_command_set_CONTENT;
        String language_already_set_PATH = FilePathManager.GER_command_messages_language_already_set_PATH;
        String language_already_set_CONTENT = FileStringManager.GER_command_messages_language_already_set_CONTENT;
        de_GER.setupFile();
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_deGER_yml);
        de_GER.getFile().options().header(FileHeaderManager.DE_header);
        de_GER.getFile().addDefault(default_prefix_PATH, default_prefix_CONTENT);
        de_GER.getFile().addDefault(staff_prefix_PATH, staff_prefix_CONTENT);
        de_GER.getFile().addDefault(insufficient_permissions_PATH, insufficient_permissions_CONTENT);
        de_GER.getFile().addDefault(something_went_wrong_PATH, something_went_wrong_CONTENT);
        de_GER.getFile().addDefault(language_command_usage_PATH, language_command_usage_CONTENT);
        de_GER.getFile().addDefault(language_command_info_PATH, language_command_info_CONTENT);
        de_GER.getFile().addDefault(language_command_set_PATH, language_command_set_CONTENT);
        de_GER.getFile().addDefault(language_already_set_PATH, language_already_set_CONTENT);
        de_GER.getFile().options().copyDefaults(true);
        de_GER.saveFile();
    }

    private void loadCommands() {
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_commands);
        Objects.requireNonNull(this.getCommand("language")).setExecutor(new COMMAND_language());
        Objects.requireNonNull(this.getCommand("staff")).setExecutor(new COMMAND_staff());
    }

    private void loadEvents() {
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_events);
    }

    public Timer getTimer() {
        return timer;
    }

}
