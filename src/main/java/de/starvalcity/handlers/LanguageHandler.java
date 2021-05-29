package de.starvalcity.handlers;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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

    public static void loadMessages() {
        File languageFolder = new File(Core.getPlugin().getDataFolder() + "/languages");
        if (!languageFolder.exists()) {
            languageFolder.mkdir();
        }
        File enFile = new File(languageFolder, "en.yml");
        File deFile = new File(languageFolder, "de.yml");
        try {
            if (!enFile.exists()) {
                InputStream in = Core.getPlugin().getResource("en.yml");
                Files.copy(in, enFile.toPath());
            }
            if (!deFile.exists()) {
                InputStream in2 = Core.getPlugin().getResource("de.yml");
                Files.copy(in2, deFile.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (File file : languageFolder.listFiles()) {
            Map<String, String> languageMessages = new HashMap<>();

            FileConfiguration language = YamlConfiguration.loadConfiguration(file);
            for (String key : language.getKeys(false)) {
                for (String messageName : language.getConfigurationSection(key).getKeys(false )) {
                    String message = ChatColor.translateAlternateColorCodes('&', language.getString(key + "." + messageName));
                    languageMessages.put(messageName, message);
                }
            }
            String fileName = file.getName().split(".yml")[0];
            messages.put(fileName, languageMessages);
            files.add(fileName);
            System.out.println(file.getName() + " loaded successfully!");
        }
    }
}
