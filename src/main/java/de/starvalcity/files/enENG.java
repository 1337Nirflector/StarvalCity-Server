package de.starvalcity.files;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class enENG {

    private static File file;
    private static FileConfiguration englishLanguageFile;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "enENG.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        englishLanguageFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return englishLanguageFile;
    }

    public static void saveFile() {
        try {
            englishLanguageFile.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        englishLanguageFile = YamlConfiguration.loadConfiguration(file);
    }
}
