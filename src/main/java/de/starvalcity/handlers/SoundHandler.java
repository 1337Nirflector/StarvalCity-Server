package de.starvalcity.handlers;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SoundHandler {

    public static void playErrorSound(CommandSender commandSender) {
        Player player = (Player) commandSender;
        Location playerLocation = player.getLocation();
        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
    }

    public static void playSuccessSound(CommandSender commandSender) {
        Player player = (Player) commandSender;
        Location playerLocation = player.getLocation();
        player.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
    }
}
