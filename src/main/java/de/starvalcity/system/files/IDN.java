package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class IDN {

    private static File file;
    private static FileConfiguration idnFile;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "idn.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        idnFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return idnFile;
    }

    public static void saveFile() {
        try {
            idnFile.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        idnFile = YamlConfiguration.loadConfiguration(file);
    }
}
