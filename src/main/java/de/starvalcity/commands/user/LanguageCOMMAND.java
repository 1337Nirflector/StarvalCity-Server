package de.starvalcity.commands.user;

import de.starvalcity.files.messagesConfiguration;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.system.corepackage.Core;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LanguageCOMMAND implements CommandExecutor, Listener, TabCompleter {

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        FileConfiguration configuration = messagesConfiguration.getFile();
        Player player = e.getPlayer();
        UUID playerUniqueId = player.getUniqueId();
        if (configuration.get(playerUniqueId.toString()) == null) {
            LanguageHandler.setLanguage(player,  "en");
            configuration.set(playerUniqueId.toString(), "en");
            messagesConfiguration.saveFile();
            return;
        }
        String localeFileName = configuration.getString(playerUniqueId.toString());
        LanguageHandler.setLanguage(player, localeFileName.toLowerCase());
    }

    @EventHandler
    private void onLeave(PlayerQuitEvent e) {
        LanguageHandler.removePlayer(e.getPlayer());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(LanguageHandler.getMessage("en", "PlayerRelated"));
            return false;
        }
        Player p = (Player) commandSender;
        if (strings.length < 1 ) {
            p.sendMessage(LanguageHandler.getMessage(LanguageHandler.getLanguage(p), "NotEnoughArguments"));
            return false;
        }
        String fileName = strings[0];
        LanguageHandler.setLanguage(p, fileName);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> languageFiles = new ArrayList<>();
        File folder = new File(Core.getPlugin().getDataFolder() + "/languages");
        for (File file : folder.listFiles()) {
            languageFiles.add(file.getName().split(".yml")[0]);
        }
        return languageFiles;
    }
}
