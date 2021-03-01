package de.starvalcity.system.base.messages;

import de.starvalcity.system.base.Core;

import java.util.HashMap;

public class MessagesHandler {

    public static HashMap<Integer, String> errorMessages = new HashMap<>();
    public static HashMap<Integer, String> systemMessages = new HashMap<>();

    String basicPrefix = PrefixesHandler.prefixes.get(0);
    String staffPrefix = PrefixesHandler.prefixes.get(1);

    public void loadErrorMessages() {
        errorMessages.put(0, basicPrefix + "§4An internal error has occured. Please watch the console!");
        errorMessages.put(1, basicPrefix + "§4Only players are able to execute this command!");
        errorMessages.put(2, basicPrefix + "§4Too few arguments! Please use §e/plugin help §4in order to get help!");
        errorMessages.put(3, basicPrefix + "§4Invalid argument or command parameters!");
    }

    public void loadStaffMessages() {
    }

    public void loadSystemMessages() {
        systemMessages.put(0, basicPrefix + "§2Current plugin version: §e" + Core.getCoreInstance().getDescription().getVersion());
    }
}
