package de.starvalcity.system.corepackage;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Core extends JavaPlugin {

    public static Core instance;
    public static Logger system;

    @Override
    public void onEnable() {



    }

    @Override
    public void onDisable() {



    }

    public Core getInstance() {
        return instance;
    }
}
