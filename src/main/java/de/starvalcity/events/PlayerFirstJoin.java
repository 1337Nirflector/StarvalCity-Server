package de.starvalcity.events;

import de.starvalcity.handlers.LanguageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent playerFirstJoinEvent) {
        Player player = playerFirstJoinEvent.getPlayer();

        if(!player.hasPlayedBefore()) {
            LanguageHandler.setDefaultLanguage(player);
        }
    }
}
