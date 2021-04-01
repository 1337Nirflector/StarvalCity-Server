package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class de_GER {

    private static File file;
    private static FileConfiguration germanLanguageFile;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "de_GER.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        germanLanguageFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return germanLanguageFile;
    }

    public static void saveFile() {
        try {
            germanLanguageFile.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        germanLanguageFile = YamlConfiguration.loadConfiguration(file);
    }
}
