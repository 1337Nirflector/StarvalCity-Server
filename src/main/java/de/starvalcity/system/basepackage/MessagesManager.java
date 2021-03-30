package de.starvalcity.system.basepackage;

import java.util.HashMap;
import java.util.Map;

public class MessagesManager {

    static Map<String, String> englishMessages = new HashMap<>();
    static Map<String, String> germanMessages = new HashMap<>();

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String defaultPrefix = "§7[§6StarvalCity§7]§f ";

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String loading_configuration_yml = defaultPrefix + "§2Loading resource configuration.yml...";
}
