package de.starvalcity.events;

import de.starvalcity.system.database.sql.SQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerSQLJoin implements Listener {

    public SQLManager mySQLData;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerSQLJoinEvent) {
        Player player = playerSQLJoinEvent.getPlayer();
        mySQLData.createPlayer(player);
    }
}
