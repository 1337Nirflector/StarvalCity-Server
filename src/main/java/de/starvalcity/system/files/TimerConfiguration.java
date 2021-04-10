package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class TimerConfiguration {

    private static File file;
    private static FileConfiguration timerConfiguration;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "timerConfiguration.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        timerConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return timerConfiguration;
    }

    public static void saveFile() {
        try {
            timerConfiguration.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        timerConfiguration = YamlConfiguration.loadConfiguration(file);
    }

}
