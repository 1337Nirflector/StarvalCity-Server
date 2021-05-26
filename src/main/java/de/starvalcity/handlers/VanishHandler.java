package de.starvalcity.handlers;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishHandler {

    public static List<UUID> vanishedPlayers = new ArrayList<>();

    public void setVanishedPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        vanishedPlayers.add(playerUniqueId);
    }

    public void removeVanishedPlayer(Player player) {
        UUID playerUniqueId = player.getUniqueId();
        vanishedPlayers.remove(playerUniqueId);
    }

    public static List<UUID> getVanishedPlayers() {
        return vanishedPlayers;
    }
}
