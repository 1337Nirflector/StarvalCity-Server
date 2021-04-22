package de.starvalcity.system.events;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.basepackage.LanguageManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.event.EventBus;
import net.luckperms.api.event.user.track.UserPromoteEvent;
import net.luckperms.api.model.user.User;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collection;

public class UserPromotionEvent {

    private final Core plugin;

    public UserPromotionEvent (Core plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        EventBus eventBus = luckPerms.getEventBus();
        eventBus.subscribe(this.plugin, UserPromoteEvent.class, this::onUserPromotion);
    }

    public void onUserPromotion(UserPromoteEvent userPromotionEvent) {
        User promotedUser = userPromotionEvent.getUser();
        Collection<Player> onlineEngPlayers = LanguageManager.engPlayers;
        Collection<Player> onlineGerPlayers = LanguageManager.gerPlayers;

        for (Player onlineEnglishPlayer : onlineEngPlayers) {
            onlineEnglishPlayer.sendMessage(FilePathManager.ENG_prefixes_promotion_PATH + "§7The user§e " +
                    promotedUser.getUsername() + "§7 has been §apromoted§7!");
            onlineEnglishPlayer.playSound(onlineEnglishPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        }

        for (Player onlineGermanPlayer : onlineGerPlayers) {
            onlineGermanPlayer.sendMessage(FilePathManager.GER_prefixes_promotion_PATH + "§7Der Spieler§e " +
                    promotedUser.getUsername() + "§7 wurde §abefördert§7!");
            onlineGermanPlayer.playSound(onlineGermanPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        }
    }

}
