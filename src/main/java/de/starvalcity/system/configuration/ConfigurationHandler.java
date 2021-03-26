package de.starvalcity.system.configuration;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigurationHandler extends FileStringHandler {

    private final Core plugin;
    private FileConfiguration mainConfiguration = null;
    private File mainConfigurationFile = null;

    public ConfigurationHandler(Core plugin) {
        this.plugin = plugin;
        saveDefaultConfiguration();
    }

    public void reloadConfiguration() {
        if (this.mainConfigurationFile == null)
            this.mainConfigurationFile = new File(this.plugin.getDataFolder(), "configuration.yml");
            this.mainConfiguration = YamlConfiguration.loadConfiguration(this.mainConfigurationFile);
            InputStream inputStream = this.plugin.getResource("data.yml");
            if (inputStream != null) {
                YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
                this.mainConfiguration.setDefaults(defaultConfiguration);
            }
    }

    public FileConfiguration getMainConfiguration() {
        if (this.mainConfiguration == null)
            reloadConfiguration();
            return this.mainConfiguration;
        }

    public void saveConfiguration() {
        if (this.mainConfiguration == null || this.mainConfigurationFile == null)
            return;

        try {
            this.getMainConfiguration().save(this.mainConfigurationFile);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void saveDefaultConfiguration() {
        if (this.mainConfigurationFile == null)
            this.mainConfigurationFile = new File(Core.getPlugin().getDataFolder(), "data.yml");
        if (!this.mainConfigurationFile.exists()) {
            this.plugin.saveResource("data.yml", false);
        }
    }
}
