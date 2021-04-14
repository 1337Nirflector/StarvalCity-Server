package de.starvalcity.system.api;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.SystemMessagesManager;
import me.arcaniax.hdb.api.DatabaseLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class HeadDatabaseAPI implements Listener {

    @EventHandler
    public void onHeadDatabaseLoad(DatabaseLoadEvent databaseLoadEvent) {
        me.arcaniax.hdb.api.HeadDatabaseAPI headDatabaseAPI = new me.arcaniax.hdb.api.HeadDatabaseAPI();
        try {
            ItemStack item = headDatabaseAPI.getItemHead("7129");
            Core.getPlugin().getLogger().info(headDatabaseAPI.getItemID(item));
        } catch (NullPointerException nullPointerException) {
            Core.getPlugin().getLogger().info(SystemMessagesManager.head_database_error);
        }
    }
}
