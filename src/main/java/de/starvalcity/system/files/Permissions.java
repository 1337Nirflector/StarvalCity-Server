package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Permissions {

    private static File file;
    private static FileConfiguration permissions;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "permissions.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        permissions = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return permissions;
    }

    public static void saveFile() {
        try {
            permissions.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        permissions = YamlConfiguration.loadConfiguration(file);
    }
}
