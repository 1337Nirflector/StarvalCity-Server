package de.starvalcity.events;

import de.starvalcity.handlers.VanishHandler;
import de.starvalcity.system.corepackage.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerVanish implements Listener {

    @EventHandler
    public void onPlayerVanish(PlayerJoinEvent playerVanishEvent) {
        Player player = playerVanishEvent.getPlayer();
        UUID playerUniqueId = player.getUniqueId();


    }
}
