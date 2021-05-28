package de.starvalcity.handlers;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LanguageHandler {

    public static List<UUID> englishPlayers = new ArrayList<>();
    public static List<UUID> germanPlayers = new ArrayList<>();

    public static List<UUID> getEnglishPlayers() {
        return englishPlayers;
    }

    public static void setDefaultLanguage(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        germanPlayers.add(playerUniqueId);
    }

    public static void setEnglishPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        englishPlayers.add(playerUniqueId);
    }

    public static void removeEnglishPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        englishPlayers.remove(playerUniqueId);
    }

    public static List<UUID> getGermanPlayers() {
        return germanPlayers;
    }

    public static void setGermanPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        germanPlayers.add(playerUniqueId);
    }

    public static void removeGermanPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        germanPlayers.remove(playerUniqueId);
    }
}
