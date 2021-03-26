package de.starvalcity.system.basepackage;

import de.starvalcity.system.configuration.ConfigurationHandler;
import de.starvalcity.system.configuration.MessageHandler;
import de.starvalcity.system.languages.LanguageHandler;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static ConfigurationHandler configurationHandler;
    public static ConsoleCommandSender consoleCommandSender;
    public static PluginManager pluginManager;
    public static Core plugin;

    @Override
    public void onEnable() {
        this.printStartupMessages();
        LanguageHandler.initializeMessages();

        pluginManager.enablePlugin(this);
    }

    @Override
    public void onDisable() {
        this.printShutdownMessages();
        pluginManager.disablePlugin(this);
    }

    public static Core getPlugin() {
        return plugin;
    }

    private void printStartupMessages() {
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupAuthorsLine);
        consoleCommandSender.sendMessage(MessageHandler.startupAPIVersionLine);
        consoleCommandSender.sendMessage(MessageHandler.startupVersionLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
        consoleCommandSender.sendMessage(MessageHandler.startupLine);
    }

    private void printShutdownMessages() {
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownAuthorsLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownAPIVersionLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownVersionLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownBlankLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
        consoleCommandSender.sendMessage(MessageHandler.shutdownLine);
    }
}
