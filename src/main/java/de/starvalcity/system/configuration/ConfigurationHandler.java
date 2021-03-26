package de.starvalcity.system.configuration;

import de.starvalcity.system.basepackage.FileWriter;

public class ConfigurationHandler {

    private final FileWriter configurationFile;

    public ConfigurationHandler(String configurationFileName) {
        configurationFile = new FileWriter("plugins//StarvalCity//Configuration",configurationFileName + ".yml");
        configurationFile.saveFile();
        configurationFileName = "Configuration";
    }

    public boolean exist() {
        return configurationFile.exist();
    }

    public void writeDefaults() {
        if (!configurationFile.containsString("D"))
    }
}
