package de.starvalcity.system.api;

import de.starvalcity.system.basepackage.SystemMessagesManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;

public class LuckPermsAPI {

    public static void loadLuckPermsAPI() {

        try {
            LuckPerms luckPermsAPI = LuckPermsProvider.get();
        } catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.luckperms_api_error);
        }

    }
}
