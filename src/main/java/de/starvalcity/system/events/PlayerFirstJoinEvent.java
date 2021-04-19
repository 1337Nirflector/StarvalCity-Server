package de.starvalcity.system.events;

import de.starvalcity.system.basepackage.LanguageManager;
import de.starvalcity.system.files.ClientLanguages;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerFirstJoinEvent implements Listener {

    public static HeadDatabaseAPI headDatabaseAPI = new HeadDatabaseAPI();

    @EventHandler
    public void onFirstJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        if (!player.hasPlayedBefore()) {
            openNewbieGUI(player);
        }
    }

    private void openNewbieGUI(Player player) {
        Inventory newbieGUI = Bukkit.createInventory(null, 27, "§2Please select your language");

        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta01 = placeholder.getItemMeta();
        meta01.setDisplayName("");
        ArrayList<String> lore00 = new ArrayList<>();
        lore00.add("");
        meta01.setLore(lore00);
        meta01.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        placeholder.setItemMeta(meta01);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack enENG = headDatabaseAPI.getItemHead("18553");
        ItemMeta meta02 = enENG.getItemMeta();
        meta02.setDisplayName("§9English");
        ArrayList<String> lore01 = new ArrayList<>();
        lore01.add("§eClick to set language");
        meta02.setLore(lore01);
        enENG.setItemMeta(meta02);

        ItemStack deGER = headDatabaseAPI.getItemHead("522");
        ItemMeta meta03 = deGER.getItemMeta();
        meta03.setDisplayName("§2Deutsch");
        ArrayList<String> lore02 = new ArrayList<>();
        lore02.add("§eKlicken, um Sprache zu setzen");
        meta03.setLore(lore02);
        deGER.setItemMeta(meta03);

        ItemStack[] guiContents = {placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder,
        placeholder, placeholder, placeholder, air, deGER, air, air, air, enENG, air, placeholder, placeholder, placeholder,
        placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder};
        newbieGUI.setContents(guiContents);
        player.openInventory(newbieGUI);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();

        if (player.getOpenInventory().getTitle().equalsIgnoreCase("§2Please select your language")) {
            ArrayList<String> placeholderLore = new ArrayList<>();
            ArrayList<String> enENGLore = new ArrayList<>();
            ArrayList<String> deGERLore = new ArrayList<>();
            if (placeholderLore.get(0).equals("")) {
                inventoryClickEvent.setCancelled(true);
            }
            if  (enENGLore.get(0).equals("§eClick to set language")) {
                inventoryClickEvent.setCancelled(true);
                ClientLanguages.getFile().set(player.getUniqueId().toString(), "enENG");
                ClientLanguages.saveFile();
                LanguageManager.englishPlayers.add(player.getUniqueId());
                player.closeInventory();
            }
            if (deGERLore.get(0).equals("§eKlicken, um Sprache zu setzen")) {
                inventoryClickEvent.setCancelled(true);
                ClientLanguages.getFile().set(player.getUniqueId().toString(), "deGER");
                ClientLanguages.saveFile();
                LanguageManager.germanPlayers.add(player.getUniqueId());
                player.closeInventory();
            }
        }
        inventoryClickEvent.setCancelled(true);
    }
}
