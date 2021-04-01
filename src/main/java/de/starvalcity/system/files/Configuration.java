package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.FileStringManager;
import de.starvalcity.system.basepackage.MessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configuration {

    public static void loadConfiguration() throws InterruptedException {

        String creationPath = FileStringManager.configuration_creation_PATH;
        String creationPathContent = FileStringManager.configuration_creation_CONTENT;
        String authorPath = FileStringManager.configuration_author_PATH;
        String authorPathContent = FileStringManager.configuration_author_CONTENT;
        String discordPath = FileStringManager.configuration_discordURL_PATH;
        String discordPathContent = FileStringManager.configuration_discordURL_CONTENT;
        String spigotPath = FileStringManager.configuration_spigotURL_PATH;
        String spigotPathContent = FileStringManager.configuration_spigotURL_CONTENT;
        String versionPath = FileStringManager.configuration_version_PATH;
        String versionPathContent = FileStringManager.configuration_version_CONTENT;

        String languagePath = FileStringManager.configuration_language_PATH;

        File configurationYML = new File(Core.thisPlugin().getDataFolder().getPath(), "configuration.yml");
        YamlConfiguration yamlConfigurationConfigurationYML = YamlConfiguration.loadConfiguration(configurationYML);
        Bukkit.getConsoleSender().sendMessage(MessagesManager.loading_configuration_yml);

        if (!yamlConfigurationConfigurationYML.contains(creationPath)) {
            yamlConfigurationConfigurationYML.set(creationPath, creationPathContent);
        }
        yamlConfigurationConfigurationYML.set(authorPath, authorPathContent);
        yamlConfigurationConfigurationYML.set(discordPath, discordPathContent);
        yamlConfigurationConfigurationYML.set(spigotPath, spigotPathContent);
        yamlConfigurationConfigurationYML.set(versionPath, versionPathContent);

        try {
            yamlConfigurationConfigurationYML.save(configurationYML);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
