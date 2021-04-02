package de.starvalcity.system.basepackage;

import de.starvalcity.system.commands.COMMAND_language;
import de.starvalcity.system.files.Configuration;
import de.starvalcity.system.files.de_GER;
import de.starvalcity.system.files.en_ENG;
import org.bukkit.World;
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

    public void loadEnglishMessages() {
        en_ENG.setupFile();
        Core.getPlugin().getLogger().severe(MessagesManager.loading_enUK_yml);
        en_ENG.getFile().addDefault(FileStringManager.EN_prefix_PATH, FileStringManager.EN_prefix_CONTENT);
        en_ENG.getFile().addDefault(FileStringManager.EN_insufficient_permissions_PATH, FileStringManager.EN_insufficient_permissions_CONTENT);
        en_ENG.getFile().addDefault(FileStringManager.EN_something_went_wrong_PATH, FileStringManager.EN_something_went_wrong_CONTENT);
        en_ENG.getFile().addDefault(FileStringManager.EN_language_command_usage_PATH, FileStringManager.EN_language_command_usage_CONTENT);
        en_ENG.getFile().addDefault(FileStringManager.EN_language_command_info_PATH, FileStringManager.EN_language_command_info_CONTENT);
        en_ENG.getFile().addDefault(FileStringManager.EN_language_command_set_already_set_PATH, FileStringManager.EN_language_command_set_already_set_CONTENT);
        en_ENG.getFile().options().copyDefaults(true);
        en_ENG.saveFile();
    }

    public void loadGermanMessages() {
        de_GER.setupFile();
        Core.getPlugin().getLogger().severe(MessagesManager.loading_deGER_yml);
        de_GER.getFile().addDefault(FileStringManager.DE_prefix_PATH, FileStringManager.DE_prefix_CONTENT);
        de_GER.getFile().addDefault(FileStringManager.DE_insufficient_permissions_PATH, FileStringManager.DE_insufficient_permissions_CONTENT);
        de_GER.getFile().addDefault(FileStringManager.DE_something_went_wrong_PATH, FileStringManager.DE_something_went_wrong_CONTENT);
        de_GER.getFile().addDefault(FileStringManager.DE_language_command_usage_PATH, FileStringManager.DE_language_command_usage_CONTENT);
        de_GER.getFile().addDefault(FileStringManager.DE_language_command_info_PATH, FileStringManager.DE_language_command_info_CONTENT);
        de_GER.getFile().addDefault(FileStringManager.DE_language_command_set_already_set_PATH, FileStringManager.DE_language_command_set_already_set_CONTENT);
        de_GER.getFile().options().copyDefaults(true);
        de_GER.saveFile();
    }

    private void loadCommands() {
        Core.getPlugin().getLogger().severe(MessagesManager.loading_commands);
        Objects.requireNonNull(this.getCommand("language")).setExecutor(new COMMAND_language());
    }

    private void loadEvents() {
        Core.getPlugin().getLogger().severe(MessagesManager.loading_events);
    }

}
