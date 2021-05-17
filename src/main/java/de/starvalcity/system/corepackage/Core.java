package de.starvalcity.system.corepackage;

import de.starvalcity.system.filespackage.SystemMessagesManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    public static Logger serverLogger;
    public static Core plugin;
    public static PermissionsManager permissionsManager;

    public static Core getPlugin() {
        return plugin;
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
