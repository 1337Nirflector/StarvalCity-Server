package de.starvalcity.system.commands.staff;

import de.starvalcity.system.basepackage.PermissionsManager;
import de.starvalcity.system.basepackage.SystemLogger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class COMMAND_staffgui implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            SystemLogger.logPlayerRelatedCommand();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                if (player.hasPermission(PermissionsManager.staff_gui)) {

                }
            }
        }
        return true;
    }

    private void openEnglishStaffGUI(Player player) {
        Inventory englishStaffGUI = Bukkit.createInventory(player, 45, "§2Staff Commands");

        ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta placeholderMeta = placeholder.getItemMeta();
        placeholderMeta.setDisplayName("");
        placeholder.setItemMeta(placeholderMeta);

        ItemStack air = new ItemStack(Material.AIR);

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ItemMeta barrierMeta = barrier.getItemMeta();
        barrierMeta.setDisplayName("§4Leave");
        ArrayList<String> barrierLore = new ArrayList<>();
        barrierLore.add("§fClick to leave");
        barrierMeta.setLore(barrierLore);
        barrier.setItemMeta(barrierMeta);

        ItemStack info = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta infoMeta = info.getItemMeta();
        infoMeta.setDisplayName("§eCurrent staff");
        ArrayList<String> infoLore = new ArrayList<>();
        infoLore.add("§fClick to view");
        infoMeta.setLore(infoLore);
        info.setItemMeta(infoMeta);

        ItemStack[] englishStaffGUIContents = {};
        englishStaffGUI.setContents(englishStaffGUIContents);
        player.openInventory(englishStaffGUI);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();
        if (player.getOpenInventory().getTitle().equalsIgnoreCase("§2Staff Commands")) {
            switch (inventoryClickEvent.getCurrentItem().getType()) {
                case BLACK_STAINED_GLASS_PANE:
                    inventoryClickEvent.setCancelled(true);
                    break;
                case BARRIER:
                    player.closeInventory();
                    inventoryClickEvent.setCancelled(true);
            }
            inventoryClickEvent.setCancelled(true);
        }
    }
}
