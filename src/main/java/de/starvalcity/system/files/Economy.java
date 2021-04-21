package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Economy {

    private static File file;
    private static FileConfiguration economy;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "economy.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        economy = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return economy;
    }

    public static void saveFile() {
        try {
            economy.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static void reloadFile() {
        economy = YamlConfiguration.loadConfiguration(file);
    }
}