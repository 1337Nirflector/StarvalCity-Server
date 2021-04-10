package de.starvalcity.system.generations;

import de.starvalcity.system.basepackage.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.UUID;

public class IDN implements Listener {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static File file;
    private static FileConfiguration idnFile;

    public static void setupFile() {
        file = new File(Core.getPlugin().getDataFolder(), "idn.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        idnFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getFile() {
        return idnFile;
    }

    public static void saveFile() {
        try {
            idnFile.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void reloadFile() {
        idnFile = YamlConfiguration.loadConfiguration(file);
    }

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent playerFirstJoinEvent) {
        Player player = playerFirstJoinEvent.getPlayer();
        UUID playerUUID = player.getUniqueId();
        String playerUUIDString = player.getUniqueId().toString();

        if (!player.hasPlayedBefore()) {
            try {
                idnFile.set(playerUUIDString, createIDN());
                idnFile.save(file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static String createIDN() {
        byte[] components = new byte[4];
        secureRandom.nextBytes(components);
        return String.format("%d.%d.%d.%d", new Object[] { Byte.valueOf(components[0]), Byte.valueOf(components[1]),
        Byte.valueOf(components[2]), Byte.valueOf(components[3])});
    }

    public static String getIDN(UUID playerUUID) {
        return idnFile.getString(playerUUID.toString());
    }

}
