package de.starvalcity.files;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class loggerMessages {

    private static File file;
    private static FileConfiguration loggerMessagesFile;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "loggerMessages.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        loggerMessagesFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return loggerMessagesFile;
    }

    public static void saveFile() {
        try {
            loggerMessagesFile.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        loggerMessagesFile = YamlConfiguration.loadConfiguration(file);
    }

}
