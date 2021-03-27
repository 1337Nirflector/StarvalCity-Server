package de.starvalcity.system.commands;

import de.starvalcity.system.basepackage.Core;
import de.starvalcity.system.languages.LanguageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Language implements CommandExecutor, Listener, TabCompleter {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        FileConfiguration fileConfiguration = Core.getPlugin().getConfig();
        Player player = playerJoinEvent.getPlayer();
        UUID uuid = player.getUniqueId();
        if (fileConfiguration.get(uuid.toString()) == null) {
            LanguageHandler.setCountry(player, "enUK");
            fileConfiguration.set(uuid.toString(), "enUK");
            Core.getPlugin().saveConfig();
            return;
        }
        String countryFileName = fileConfiguration.getString(uuid.toString());
        LanguageHandler.setCountry(player, countryFileName.toLowerCase());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent playerQuitEvent) {
        LanguageHandler.removePlayer(playerQuitEvent.getPlayer());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(LanguageHandler.getMessage("enUK", "PlayerRelatedCommand"));
            return false;
        }
        Player player = (Player) commandSender;
        if (strings.length < 1) {
            player.sendMessage(LanguageHandler.getMessage(LanguageHandler.getCountry(player), "InvalidUsage"));
            return false;
        }
        String fileName = strings[0];
        LanguageHandler.setCountry(player, fileName);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> languageFiles = new ArrayList<>();
        File folder = new File(Core.getPlugin().getDataFolder() + "/Languages");
        for (File file : folder.listFiles()) {
            languageFiles.add(file.getName().split(".yml")[0]);
        }
        return languageFiles;
    }
}
