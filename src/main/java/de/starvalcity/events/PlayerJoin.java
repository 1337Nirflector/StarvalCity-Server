package de.starvalcity.events;

import de.starvalcity.handlers.StaffHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        StaffHandler.removeStaffMember(player);

        if (player.isOp()) {
            StaffHandler.setStaffMember(player);
        } else {
            StaffHandler.removeStaffMember(player);
        }
    }
}
