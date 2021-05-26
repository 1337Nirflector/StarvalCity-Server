package de.starvalcity.system.corepackage;

import de.starvalcity.commands.staff.StaffModeCOMMAND;
import de.starvalcity.events.PlayerJoin;
import de.starvalcity.events.PlayerVanish;
import de.starvalcity.files.deGER;
import de.starvalcity.system.database.sql.MySQL;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.filespackage.FileValueManager;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Core extends JavaPlugin {

    public static Core plugin;
    public static Plugin pl;
    public static MySQL mySQL;

    public ConsoleCommandSender consoleCommandSender = getServer().getConsoleSender();
    public PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        plugin = this;
        pl = this;
        mySQL = new MySQL("localhost", "starvalcity", "root", "", 3306);
        consoleCommandSender.sendMessage(SystemMessagesManager.startupMessage);
        initializeFiles();
        registerEvents();
        getCommand("staff").setExecutor((CommandExecutor) new StaffModeCOMMAND());
    }

    @Override
    public void onDisable() {
        consoleCommandSender.sendMessage(SystemMessagesManager.shutdownMessage);
    }

    public static Core getPlugin() {
        return plugin;
    }

    private void initializeFiles() {
        deGER.setupFile();
        String GER_insufficient_permissions_PATH = FilePathManager.GER_insufficient_permissions_PATH;
        String GER_insufficient_permissions_VALUE = FileValueManager.GER_insufficient_permissions_VALUE;
        deGER.getFile().addDefault(GER_insufficient_permissions_PATH, GER_insufficient_permissions_VALUE);
        deGER.getFile().options().copyDefaults(true);
        deGER.saveFile();
    }

    private void registerEvents() {
        pluginManager.registerEvents(new PlayerJoin(), this);
        pluginManager.registerEvents(new PlayerVanish(), this);
    }

}
