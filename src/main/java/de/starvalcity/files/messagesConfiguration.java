package de.starvalcity.files;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class messagesConfiguration {

    private static File file;
    private static FileConfiguration messages;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "messages.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        messages = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return messages;
    }

    public static void saveFile() {
        try {
            messages.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        messages = YamlConfiguration.loadConfiguration(file);
    }
}
