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
        en_ENG.getFile().addDefault(FileStringManager.EN_insufficient_permissions_PATH, FileStringManager.EN_insufficient_permissions_CONTENT);
        en_ENG.getFile().options().copyDefaults(true);
        en_ENG.saveFile();
    }

    public void loadGermanMessages() {
        de_GER.setupFile();
        de_GER.getFile().addDefault(FileStringManager.DE_insufficient_permissions_PATH, FileStringManager.DE_insufficient_permissions_CONTENT);
        de_GER.getFile().options().copyDefaults(true);
        de_GER.saveFile();
    }

    private void loadCommands() {
        Objects.requireNonNull(this.getCommand("language")).setExecutor(new COMMAND_language());
    }

}
