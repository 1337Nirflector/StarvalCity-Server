package de.starvalcity.system.events;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import org.bukkit.event.Listener;

public class UserPromotionEvent implements Listener {

    LuckPerms luckPerms;
    EventBus eventBus = luckPerms.getEventBus();
    

}
