package de.starvalcity.system.events;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.LanguageManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;

import java.util.Collection;

public class UserPromotionEvent {

    private final Core plugin;

    public UserPromotionEvent (Core plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        EventBus eventBus = luckPerms.getEventBus();
        eventBus.subscribe(this.plugin, UserPromoteEvent.class, this::onUserPromotion);
    }

    private void onUserPromotion(UserPromoteEvent userPromotionEvent) {
        User promotedUser = userPromotionEvent.getUser();
        Collection<Player> onlineEngPlayers = LanguageManager.engPlayers;
        Collection<Player> onlineGerPlayers = LanguageManager.gerPlayers;

        for (Player onlineEnglishPlayer : onlineEngPlayers) {
            onlineEnglishPlayer.sendMessage();
        }

        for (Player onlineGermanPlayer : onlineGerPlayers) {
            onlineGermanPlayer.sendMessage();
        }
    }

}
