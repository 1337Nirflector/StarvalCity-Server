package de.starvalcity.system.corepackage;

import de.starvalcity.system.database.sql.MySQL;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    public static Logger serverLogger;
    public static Core plugin;
    public MySQL mySQL;
    public static PermissionsManager permissionsManager;

    public static Core getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        serverLogger.info(SystemMessagesManager.startupMessage);
        this.mySQL = new MySQL();
        this.loadMySQLDatabase();
        this.loadEnglishMessages();
        this.loadGermanMessages();;
        this.loadCommands();
        this.loadEvents();
        this.loadDependencies();
        this.loadLogger();
    }

    @Override
    public void onDisable() {
        serverLogger.info(SystemMessagesManager.shutdownMessage);

    }

    private void loadMySQLDatabase() {
        try {
            mySQL.connect();
        } catch (ClassNotFoundException | SQLException sqlException) {
            sqlException.printStackTrace();
        }
        if (mySQL.isConnected()) {

        }
    }

    private void loadEnglishMessages() {
        serverLogger.info(SystemMessagesManager.loadingEnglishMessages);

    }

    private void loadGermanMessages() {
        serverLogger.info(SystemMessagesManager.loadingGermanMessages);

    }

    private void loadCommands() {
        serverLogger.info(SystemMessagesManager.loadingCommands);

    }

    private void loadEvents() {
        serverLogger.info(SystemMessagesManager.loadingEvents);

    }

    private void loadDependencies() {
        serverLogger.info(SystemMessagesManager.loadingDependencies);

    }

    private void loadLogger() {
        serverLogger.info(SystemMessagesManager.loadingLogger);
    }

}
