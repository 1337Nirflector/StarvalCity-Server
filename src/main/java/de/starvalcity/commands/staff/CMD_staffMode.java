package de.starvalcity.commands.staff;

import de.starvalcity.files.deGER;
import de.starvalcity.files.enENG;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.handlers.SoundHandler;
import de.starvalcity.handlers.StaffHandler;
import de.starvalcity.system.corepackage.Core;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.filespackage.FileValueManager;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CMD_staffMode implements CommandExecutor, Listener {
    private final Core server;

    private final String generalPermission = PermissionsManager.staff_mode_use;
    private final String ENG_defaultPrefix = enENG.getFile().getString(FilePathManager.ENG_defaultPrefix_PATH);
    private final String GER_defaultPrefix = deGER.getFile().getString(FilePathManager.GER_defaultPrefix_PATH);
    private final String ENG_already_in_staff_mode = enENG.getFile().getString(ENG_defaultPrefix + FilePathManager.ENG_already_in_staff_mode_PATH);
    private final String GER_already_in_staff_mode = deGER.getFile().getString(GER_defaultPrefix + FilePathManager.GER_already_in_staff_mode_PATH);
    private final String ENG_joined_staff_mode = enENG.getFile().getString()

    public CMD_staffMode(Core server) {
        this.server = server;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            this.sendPlayerRelatedToLogger();
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            UUID playerUniqueId = player.getUniqueId();
            if (strings.length == 0) {
                if (player.hasPermission(generalPermission)) {
                    if (StaffHandler.staffMembers.contains(playerUniqueId)) {
                        if (LanguageHandler.englishPlayers.contains(playerUniqueId)) {
                            SoundHandler.playErrorSound(player);
                            player.sendMessage(ENG_already_in_staff_mode);
                        } else if (LanguageHandler.germanPlayers.contains(playerUniqueId)) {
                            SoundHandler.playErrorSound(player);
                            player.sendMessage(GER_already_in_staff_mode);
                        }
                    } else {
                        if (LanguageHandler.englishPlayers.contains(playerUniqueId)) {
                            StaffHandler.staffMembers.add(playerUniqueId);
                            SoundHandler.playSuccessSound(player);
                        } else if (LanguageHandler.germanPlayers.contains(playerUniqueId)) {
                            StaffHandler.staffMembers.add(playerUniqueId);
                            SoundHandler.playSuccessSound(player);
                        }
                    }
                }
            }
        }
        return true;
    }

    private void sendPlayerRelatedToLogger() {
        server.getLogger().severe(SystemMessagesManager.playerRelatedCommand);
    }
}
