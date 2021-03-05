package de.starvalcity.system.base;

import de.starvalcity.system.database.mysql.MySQL;
import de.starvalcity.system.database.mysql.mysqlhandler.MySQLHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Core extends JavaPlugin implements Listener {

    public static Core coreInstance;
    public MySQL mySQL;
    public MySQLHandler mySQLHandler;
    private final ConsoleCommandSender consoleCommandSender = Bukkit.getConsoleSender();
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setCoreInstance(this);
        this.mySQL = new MySQL();
        this.mySQLHandler = new MySQLHandler(this);
        connectDatabase();

        printStartupMessages();

        pluginManager.enablePlugin(this);
    }

    @Override
    public void onDisable() {

        printShutdownMessages();

        pluginManager.disablePlugin(this);
    }

    public static Core getCoreInstance() {
        return coreInstance;
    }

    private static void setCoreInstance(Core coreInstance) {
        Core.coreInstance = coreInstance;
    }

    private void connectDatabase() {
        try {
            mySQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
            // Login info is incorrect or no database is used
        }

        if(mySQL.isConnected()) {
            mySQLHandler.createTable();
        }
    }

    private void printStartupMessages() {
    }

    private void printShutdownMessages() {

    }

    private void registerEvents() {
        pluginManager.registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        mySQLHandler.createPlayer(player);
    }

    @EventHandler
    public void onEntityKill(EntityDeathEvent entityDeathEvent) {
        if(entityDeathEvent.getEntity().getKiller() != null) {
            Player player = (Player) entityDeathEvent.getEntity().getKiller();
            mySQLHandler.addPoints(player.getUniqueId(), 1);
            player.sendMessage("Neuer Punkt!");
        }
    }
}
