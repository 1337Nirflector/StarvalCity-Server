package de.starvalcity.system.basepackage;

import de.starvalcity.system.commands.COMMAND_language;
import de.starvalcity.system.commands.COMMAND_staff;
import de.starvalcity.system.files.ClientLanguages;
import de.starvalcity.system.files.Configuration;
import de.starvalcity.system.files.de_GER;
import de.starvalcity.system.files.en_ENG;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class Core extends JavaPlugin {

    private static Core instance;
    public static Core plugin;
    public static Plugin pl;

    @Override
    public void onEnable() {
        Logger system = getLogger();
        plugin = this;
        pl = this;
        loadConfiguration();
        loadClientLanguages();
        loadEnglishMessages();
        loadGermanMessages();
        loadCommands();
        loadEvents();

    }

    @Override
    public void onDisable() {

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
        en_ENG.setupFile();
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_enUK_yml);
        en_ENG.getFile().options().copyDefaults(true);
        en_ENG.saveFile();
    }

    public void loadGermanMessages() {
        de_GER.setupFile();
        Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.loading_deGER_yml);
        de_GER.getFile().options().header(FileHeaderManager.DE_header);
        de_GER.getFile().addDefault(FilePathManager.GER_prefixes_default_PATH, FileStringManager.GER_prefixes_default_CONTENT);
        de_GER.getFile().addDefault(FilePathManager.GER_prefixes_staff_PATH, FileStringManager.GER_prefixes_staff_CONTENT);
        de_GER.getFile().addDefault(FilePathManager.GER_frequent_messages_insufficient_permissions_PATH, FileStringManager.GER_frequent_messages_insufficient_permissions_CONTENT);
        de_GER.getFile().addDefault(FilePathManager.GER_frequent_messages_something_went_wrong_PATH, FileStringManager.GER_frequent_messages_something_went_wrong_CONTENT);
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

}
