package de.starvalcity.system.generations;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class IDN implements Listener {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String createIDN(UUID player) {
        byte components[] = new byte[4];
        secureRandom.nextBytes(components);
        return String.format("%d.%d.%d.%d", new Object[] { Byte.valueOf(components[0]), Byte.valueOf(components[1]), Byte.valueOf(components[2]) });
    }
}
