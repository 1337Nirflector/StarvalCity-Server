package de.starvalcity.system.base;

import de.starvalcity.system.base.commandhandler.CommandHandler;
import de.starvalcity.system.base.messages.MessagesHandler;
import de.starvalcity.system.database.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Core extends JavaPlugin {

    public static Core coreInstance;
    public CommandHandler commandHandler;
    public MySQL mySQL;
    private final ConsoleCommandSender consoleCommandSender = Bukkit.getConsoleSender();
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setCoreInstance(this);
        this.mySQL = new MySQL();
        MessagesHandler.loadErrorMessages();
        MessagesHandler.loadMySQLMessages();
        MessagesHandler.loadStaffMessages();
        MessagesHandler.loadStartupMessages();
        MessagesHandler.loadSystemMessages();
        connectDatabase();

        printStartupMessages();

        commandHandler = new CommandHandler();
        commandHandler.setCommands();
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
            consoleCommandSender.sendMessage(MessagesHandler.mySQLMessages.get(0));
        }

        if(mySQL.isConnected()) {
            consoleCommandSender.sendMessage(MessagesHandler.mySQLMessages.get(1));
        }
    }

    private void printStartupMessages() {
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(0));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(1));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(2));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(3));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(4));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(0));
        consoleCommandSender.sendMessage(MessagesHandler.startupMessages.get(1));
    }

    private void printShutdownMessages() {

    }
}
