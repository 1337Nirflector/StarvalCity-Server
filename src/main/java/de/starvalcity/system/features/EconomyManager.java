package de.starvalcity.system.features;

import de.starvalcity.system.basepackage.FilePathManager;
import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.files.Economy;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class EconomyManager {

    double money;
    static String bank_account_creation_PATH = FilePathManager.ECO_bank_account_creation_PATH;
    static String ENG_not_enough_money_PATH = FilePathManager.ENG_economy_messages_not_enough_money_PATH;
    static String GER_not_enough_money_PATH = FilePathManager.GER_economy_messages_not_enough_money_PATH;
    static String ENG_bank_account_creation_PATH = FilePathManager.ENG_economy_messages_bank_account_creation_PATH;
    static String GER_bank_account_creation_PATH = FilePathManager.GER_economy_messages_bank_account_creation_PATH;

    public static void addPlayerMoney(Player player, double money, double addedMoney) {
        Economy.getFile().set(player.getName(), money + addedMoney);
    }

    public static void removePlayerMoney(Player player, double money, double removedMoney) {
        Economy.getFile().set(player.getName(), money - removedMoney);
    }

    public static void setPlayerMoney(Player player, double money) {
        Economy.getFile().set(player.getName(), money);
    }

    public static void setNewbieMoney(Player player, double money) {
        Economy.getFile().set(player.getName(), money);
    }

    public static Double getPlayerMoney(Player player) {
        return Economy.getFile().getDouble(player.getName());
    }

    public static void createBankAccount(Player player, String accountName) {
        if (!getPlayerMoney(player).equals(Economy.getFile().getDouble(bank_account_creation_PATH))) {
            if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                player.sendMessage(ENG_not_enough_money_PATH);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
            } else if (LanguageManager.germanPlayers.contains(player.getUniqueId())) {
                player.sendMessage(GER_not_enough_money_PATH);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
            }
        } else {
            if (LanguageManager.englishPlayers.contains(player.getUniqueId())) {
                player.sendMessage(ENG_bank_account_creation_PATH);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                Economy.getFile().set(player.getName(), accountName);
            } else if (LanguageManager.germanPlayers.contains(player.getUniqueId())) {
                player.sendMessage(GER_bank_account_creation_PATH);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 1);
                Economy.getFile().set(player.getName(), accountName);
            }
        }
    }

}
