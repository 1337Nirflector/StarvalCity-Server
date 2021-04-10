package de.starvalcity.system.generations;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.security.SecureRandom;
import java.util.UUID;

public class IDN implements Listener {

    private static final SecureRandom secureRandom = new SecureRandom();

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent playerFirstJoinEvent) {
        Player player = playerFirstJoinEvent.getPlayer();
        UUID playerUUID = player.getUniqueId();
        String playerUUIDString = player.getUniqueId().toString();
        boolean firstJoin = player.hasPlayedBefore();

        if (firstJoin) {
            createIDN();
            de.starvalcity.system.files.IDN.getFile().set(playerUUIDString, createIDN());
        }
    }

    public static String createIDN() {
        byte[] components = new byte[4];
        secureRandom.nextBytes(components);
        return String.format("%d.%d.%d.%d", components[0], components[1], components[2]);
    }
}
