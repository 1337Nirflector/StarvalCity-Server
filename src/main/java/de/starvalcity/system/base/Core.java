package de.starvalcity.system.base;

import de.starvalcity.system.base.commandhandler.CommandHandler;
import de.starvalcity.system.base.messages.MessagesHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    public static Core coreInstance;
    public CommandHandler commandHandler;
    private final ConsoleCommandSender consoleCommandSender = Bukkit.getConsoleSender();
    private final PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setCoreInstance(this);
        MessagesHandler.loadErrorMessages();
        MessagesHandler.loadStaffMessages();
        MessagesHandler.loadStartupMessages();
        MessagesHandler.loadSystemMessages();

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
