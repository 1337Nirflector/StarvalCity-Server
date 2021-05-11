package de.starvalcity.system.corepackage;

import de.starvalcity.system.filespackage.SystemMessagesManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class Core extends JavaPlugin {

    public static Core instance;
    public static Logger system;

    @Override
    public void onEnable() {
        system.info(SystemMessagesManager.startupMessage);

    }

    @Override
    public void onDisable() {
        system.info(SystemMessagesManager.shutdownMessage);

    }

    public Core getInstance() {
        return instance;
    }

}
