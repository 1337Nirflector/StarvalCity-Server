package de.starvalcity.system.languages;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.configuration.ConfigurationHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

public class LanguageHandler {

    private static Map<Player, String> countrySettings = new HashMap<>();
    private static Map<String, Map<String, String>> messages = new HashMap<>();
    public static List<String> files = new ArrayList<>();

    public static ConsoleCommandSender consoleCommandSender;

    public static String getMessage(String country, String messageName) {
        return messages.getOrDefault(country, messages.get("en")).getOrDefault(messageName, "Message " +
                messageName + " not set!");
    }

    public static String getCountry(Player player) {
        return countrySettings.get(player);
    }

    public static void setCountry(Player player, String text) {
        countrySettings.remove(player);
        if (!files.contains(text)) {
            player.sendMessage(LanguageHandler.getMessage(LanguageHandler.getCountry(player), "CountryDoesNotExist"));
        } else {
            countrySettings.put(player, text);
            player.sendMessage(LanguageHandler.getMessage(LanguageHandler.getCountry(player), "CountrySet"));
            Core.getPlugin().getConfig().set(player.getUniqueId().toString(), text);
            Core.getPlugin().saveConfig();
        }
    }

    public static void removePlayer(Player player) {
        countrySettings.remove(player);
    }

    public static void initializeMessages() {
        File languageFolder = new File(Core.getPlugin().getDataFolder() + "Languages");
        if (!languageFolder.exists()) {
            languageFolder.mkdir();
        }
        File englishFile = new File(languageFolder, "enUK.yml");
        try {
            if (!englishFile.exists()) {
                InputStream inputStream = Core.getPlugin().getResource("enUK.yml");
                Files.copy(inputStream, englishFile.toPath());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for (File file : languageFolder.listFiles()) {
            Map<String, String> countryMessages = new HashMap<>();
            FileConfiguration language = YamlConfiguration.loadConfiguration(file);
            for (String key : language.getKeys(false)) {
                for (String messageName : language.getConfigurationSection(key).getKeys(false)) {
                    String message = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(language.getString(key + "." +
                            messageName)));
                    countryMessages.put(messageName, message);
                }
            }
            String fileName = file.getName().split(".yml")[0];
            messages.put(fileName, countryMessages);
            files.add(fileName);
            consoleCommandSender.sendMessage(file.getName() + "loaded successfully!");
        }
    }
}
