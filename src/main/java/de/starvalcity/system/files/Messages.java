package de.starvalcity.system.files;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.FileValueManager;
import de.starvalcity.system.basepackage.MessagesManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages {

    public static void selectLanguage() {
        Bukkit.getConsoleSender().sendMessage(MessagesManager.defaultPrefix + "§2Selecting language...");

        String selectedLanguage;
        String selection;

        switch (FileValueManager.language) {
            default:
                selectedLanguage = "English";
                selection = "enUK";
                break;
            case "deGER":
                selectedLanguage = "German";
                selection = "deGER";
                break;
        }
        File messagesYML = new File(Core.thisPlugin().getDataFolder().getPath(), "/languages" + selection + "_messages.yml");
        YamlConfiguration yamlConfigurationMessagesYML = YamlConfiguration.loadConfiguration(messagesYML);



    }
}
