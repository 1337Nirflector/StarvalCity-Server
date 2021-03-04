package de.starvalcity.system.base.messages;

import de.starvalcity.system.base.Core;

import java.util.HashMap;

public class MessagesHandler {

    public static HashMap<Integer, String> errorMessages = new HashMap<>();
    public static HashMap<Integer, String> mySQLMessages = new HashMap<>();
    public static HashMap<Integer, String> startupMessages = new HashMap<>();
    public static HashMap<Integer, String> systemMessages = new HashMap<>();

    public static void loadStartupMessages() {
        String basicPrefix = PrefixesHandler.prefixes.get(0);
        String staffPrefix = PrefixesHandler.prefixes.get(1);
        startupMessages.put(0, basicPrefix + "------------------------------------------------------------");
        startupMessages.put(1, basicPrefix + "                                                            ");
        startupMessages.put(2, basicPrefix + "§2Loading StarvalCity-Server! Running on version: §e" + Core.getCoreInstance().getDescription().getVersion());
        startupMessages.put(3, basicPrefix + "§2API-Version:§e " + Core.getCoreInstance().getDescription().getAPIVersion());
        startupMessages.put(4, basicPrefix + "§2Authors: §e" + Core.getCoreInstance().getDescription().getAuthors());
    }

    public static void loadMySQLMessages() {
        String basicPrefix = PrefixesHandler.prefixes.get(0);
        String staffPrefix = PrefixesHandler.prefixes.get(1);
        mySQLMessages.put(0, basicPrefix + "§4MySQL Error! Database is not connected: Login info is incorrect or" +
                "no database is used!");
        mySQLMessages.put(1, basicPrefix + "§2MySQL Success! Database successfully connected!");
    }

    public static void loadErrorMessages() {
        String basicPrefix = PrefixesHandler.prefixes.get(0);
        String staffPrefix = PrefixesHandler.prefixes.get(1);
        errorMessages.put(0, basicPrefix + "§4An internal error has occured. Please watch the console!");
        errorMessages.put(1, basicPrefix + "§4Only players are able to execute this command!");
        errorMessages.put(2, basicPrefix + "§4Too few arguments! Please use §e/plugin help §4in order to get help!");
        errorMessages.put(3, basicPrefix + "§4Invalid argument or command parameters!");
    }

    public static void loadStaffMessages() {
    }

    public static void loadSystemMessages() {
        String basicPrefix = PrefixesHandler.prefixes.get(0);
        String staffPrefix = PrefixesHandler.prefixes.get(1);
        systemMessages.put(0, basicPrefix + "§2Current plugin version: §e" + Core.getCoreInstance().getDescription().getVersion());
    }
}
