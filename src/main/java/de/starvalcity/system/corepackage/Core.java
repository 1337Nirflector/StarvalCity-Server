package de.starvalcity.system.corepackage;

import de.starvalcity.system.filespackage.SystemMessagesManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    public static Logger serverLogger;
    public static Core server;

    public static Core getPlugin() {
        return server;
    }

    @Override
    public void onEnable() {
        serverLogger.info(SystemMessagesManager.startupMessage);

    }

    @Override
    public void onDisable() {
        serverLogger.info(SystemMessagesManager.shutdownMessage);

    }

    private void loadEnglishMessages() {

    }

    private void loadGermanMessages() {

    }

    private void loadCommands() {

    }

    private void loadEvents() {

    }

    private void loadDependencies() {

    }

}
