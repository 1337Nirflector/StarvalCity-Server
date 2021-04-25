package de.starvalcity.system.features;

import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.files.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EconomyManager {

    static Player player;
    double money;
    static String bank_account_creation_PATH = FilePathManager.ECO_bank_account_creation_PATH;

    public static void addPlayerMoney(Player player, double money, double addedMoney) {
        Economy.getFile().set(player.getName(), money + addedMoney);
    }

    public static void removePlayerMoney(Player player, double money, double removedMoney) {
        Economy.getFile().set(player.getName(), money - removedMoney);
    }

    public static void setPlayerMoney(Player player, double money) {
        Economy.getFile().set(player.getName(), money);
    }

    public static Double getPlayerMoney(Player player) {
        return Economy.getFile().getDouble(player.getName());
    }

    public static void createBankAccount(Player player, String accountName) {
        if (!getPlayerMoney(player).equals(Economy.getFile().getDouble(bank_account_creation_PATH))) {
            player.sendMessage();
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
        } else {
            Economy.getFile().set(player.getName(), accountName);
        }
    }

}
