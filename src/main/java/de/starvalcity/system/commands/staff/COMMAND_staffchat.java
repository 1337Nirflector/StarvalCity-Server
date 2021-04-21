package de.starvalcity.system.commands.staff;

import de.starvalcity.system.basepackage.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

public class COMMAND_staffchat implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.DE_player_related_command);
            Bukkit.getConsoleSender().sendMessage(SystemMessagesManager.EN_player_related_command);
        }
        return true;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        Player player = asyncPlayerChatEvent.getPlayer();

        String chatMessage = asyncPlayerChatEvent.getMessage();
        chatMessage.replace("%", "Prozent");
    }
}
