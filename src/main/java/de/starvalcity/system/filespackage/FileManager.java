package de.starvalcity.system.filespackage;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {

    public static List<String> files = new ArrayList<>();
    private static Map<String, String> fileMessagesHashMap = new HashMap<>();
    private static Map<String, Map<String, String>> messages = new HashMap<>();

    public static void initializeFiles() {
        /*------------------------------------------------------------------------------------------------------------*/
        String ENG_insufficient_permissions_PATH = FilePathManager.ENG_insufficient_permissions_PATH;
        String ENG_insufficient_permissions_VALUE = FileValueManager.ENG_insufficient_permissions_VALUE;
        String ENG_requested_targetplayer_PATH = FilePathManager.ENG_requested_targetplayer_PATH;
        String ENG_requested_targetplayer_VALUE = FileValueManager.ENG_requested_targetplayer_VALUE;
        String ENG_requested_targetplayer_null_PATH = FilePathManager.ENG_requested_targetplayer_null_PATH;
        String ENG_requested_targetplayer_null_VALUE = FileValueManager.ENG_requested_targetplayer_null_VALUE;
        String ENG_ip_usage_PATH = FilePathManager.ENG_ip_usage_PATH;
        String ENG_ip_usage_VALUE = FileValueManager.ENG_ip_usage_VALUE;
        String ENG_ip_own_PATH = FilePathManager.ENG_ip_own_PATH;
        String ENG_ip_own_VALUE = FileValueManager.ENG_ip_own_VALUE;
        String ENG_ip_other_PATH = FilePathManager.ENG_ip_other_PATH;
        String ENG_ip_other_VALUE = FileValueManager.ENG_ip_other_VALUE;
        String ENG_language_usage_PATH = FilePathManager.ENG_language_usage_PATH;
        String ENG_language_usage_VALUE = FileValueManager.ENG_language_usage_VALUE;
        String ENG_language_set_PATH = FilePathManager.ENG_language_set_PATH;
        String ENG_language_set_VALUE = FileValueManager.ENG_language_set_VALUE;
        String ENG_onlineplayers_usage_PATH = FilePathManager.ENG_onlineplayers_usage_PATH;
        String ENG_onlineplayers_usage_VALUE = FileValueManager.ENG_onlineplayers_usage_VALUE;
        String ENG_onlineplayers_command_PATH = FilePathManager.ENG_onlineplayers_command_PATH;
        String ENG_onlineplayers_command_VALUE = FileValueManager.ENG_onlineplayers_command_VALUE;
        String ENG_staff_mode_usage_PATH = FilePathManager.ENG_staff_mode_usage_PATH;
        String ENG_staff_mode_usage_VALUE = FileValueManager.ENG_staff_mode_usage_VALUE;
        String ENG_joined_staff_mode_PATH = FilePathManager.ENG_joined_staff_mode_PATH;
        String ENG_joined_staff_mode_VALUE = FileValueManager.ENG_joined_staff_mode_VALUE;
        String ENG_left_staff_mode_PATH = FilePathManager.ENG_left_staff_mode_PATH;
        String ENG_left_staff_mode_VALUE = FileValueManager.ENG_left_staff_mode_VALUE;
        /*------------------------------------------------------------------------------------------------------------*/
        String GER_insufficient_permissions_PATH = FilePathManager.GER_insufficient_permissions_PATH;
        String GER_insufficient_permissions_VALUE = FileValueManager.GER_insufficient_permissions_VALUE;
        String GER_requested_targetplayer_PATH = FilePathManager.GER_requested_targetplayer_PATH;
        String GER_requested_targetplayer_VALUE = FileValueManager.GER_requested_targetplayer_VALUE;
        String GER_requested_targetplayer_null_PATH = FilePathManager.GER_requested_targetplayer_null_PATH;
        String GER_requested_targetplayer_null_VALUE = FileValueManager.GER_requested_targetplayer_null_VALUE;
        String GER_ip_usage_PATH = FilePathManager.GER_ip_usage_PATH;
        String GER_ip_usage_VALUE = FileValueManager.GER_ip_usage_VALUE;
        String GER_ip_own_PATH = FilePathManager.GER_ip_own_PATH;
        String GER_ip_own_VALUE = FileValueManager.GER_ip_own_VALUE;
        String GER_ip_other_PATH = FilePathManager.GER_ip_other_PATH;
        String GER_ip_other_VALUE = FileValueManager.GER_ip_other_VALUE;
        String GER_language_usage_PATH = FilePathManager.GER_language_usage_PATH;
        String GER_language_usage_VALUE = FileValueManager.GER_language_usage_VALUE;
        String GER_language_set_PATH = FilePathManager.GER_language_set_PATH;
        String GER_language_set_VALUE = FileValueManager.GER_language_set_VALUE;
        String GER_onlineplayers_usage_PATH = FilePathManager.GER_onlineplayers_usage_PATH;
        String GER_onlineplayers_usage_VALUE = FileValueManager.GER_onlineplayers_usage_VALUE;
        String GER_onlineplayers_command_PATH = FilePathManager.GER_onlineplayers_usage_PATH;
        String GER_onlineplayers_command_VALUE = FileValueManager.GER_onlineplayers_command_VALUE;
        String GER_staff_mode_usage_PATH = FilePathManager.GER_staff_mode_usage_PATH;
        String GER_staff_mode_usage_VALUE = FileValueManager.GER_staff_mode_usage_VALUE;
        String GER_joined_staff_mode_PATH = FilePathManager.GER_joined_staff_mode_PATH;
        String GER_joined_staff_mode_VALUE = FileValueManager.GER_joined_staff_mode_VALUE;
        String GER_left_staff_mode_PATH = FilePathManager.GER_left_staff_mode_PATH;
        String GER_left_staff_mode_VALUE = FileValueManager.GER_left_staff_mode_VALUE;
        /*------------------------------------------------------------------------------------------------------------*/
        loadLanguageFiles();
    }

    public static void loadLanguageFiles() {
        File folder = new File(Core.getPlugin().getDataFolder() + "/languages");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File deFile = new File(folder, "de.yml");
        File enFile = new File(folder, "en.yml");
        try {
            if (!deFile.exists()) {
                InputStream deFileReader = Core.getPlugin().getResource("de.yml");
                Files.copy(deFileReader, deFile.toPath());
            }
            if (!enFile.exists()) {
                InputStream enFileReader = Core.getPlugin().getResource("en.yml");
                Files.copy(enFileReader, enFile.toPath());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        for (File file : folder.listFiles()) {
            FileConfiguration language = YamlConfiguration.loadConfiguration(file);

            for (String key : language.getKeys(false)) {
                for (String messagePath : language.getConfigurationSection(key).getKeys(false )) {
                    String message = ChatColor.translateAlternateColorCodes('&', language.getString(key + "." + messagePath));
                    fileMessagesHashMap.put(messagePath, message);
                }
            }
            String fileName = file.getName().split(".yml")[0];
            messages.put(fileName, fileMessagesHashMap);
            files.add(fileName);
            System.out.println(file.getName() + " loaded successfully!");
        }
    }
}
