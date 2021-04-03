package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ClientLanguages {

    private static File file;
    private static FileConfiguration clientLanguages;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "clientLanguages.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        clientLanguages = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return clientLanguages;
    }

    public static void saveFile() {
        try {
            clientLanguages.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void reloadFile() {
        clientLanguages = YamlConfiguration.loadConfiguration(file);
    }
}