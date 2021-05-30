package de.starvalcity.handlers;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.entity.Player;

import java.util.*;

public class LanguageHandler {

    private static Map<Player, String> languageSettings = new HashMap<>();
    private static Map<String, Map<String, String>> messages = new HashMap<>();
    public static List<String> files = new ArrayList<>();

    public static String getMessage(String language, String messageName) {
        return messages.getOrDefault(language, messages.get("en")).getOrDefault(messageName, "Message " + messageName + " not set!");
    }

    public static String getLanguage(Player p) {
        return languageSettings.get(p);
    }

    public static void setLanguage(Player p, String string) {
        languageSettings.remove(p);
        if (!files.contains(string)) {
            p.sendMessage(LanguageHandler.getMessage(LanguageHandler.getLanguage(p), "LanguageNotFound"));
        } else {
            languageSettings.put(p, string);
            p.sendMessage(LanguageHandler.getMessage(LanguageHandler.getLanguage(p), "LanguageSet"));
            Core.getPlugin().getConfig().set(p.getUniqueId().toString(), string);
            Core.getPlugin().saveConfig();
        }
    }

    public static void removePlayer(Player p) {
        languageSettings.remove(p);
    }
}
