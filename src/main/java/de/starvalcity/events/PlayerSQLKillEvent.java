package de.starvalcity.events;

import de.starvalcity.system.database.sql.SQLManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;

public class PlayerSQLKillEvent implements Listener {

    public SQLManager mySQLData;

    @EventHandler
    public void onMobKill(EntityDeathEvent entityDeathEvent) {
        if (entityDeathEvent.getEntity().getKiller() != null) {
            Player player = (Player) entityDeathEvent.getEntity().getKiller();
            UUID playerUniqueId = player.getUniqueId();
            mySQLData.addPoints(playerUniqueId, 1);
            player.sendMessage("Point added!");
        }
    }
}
