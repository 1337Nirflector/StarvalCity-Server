package de.starvalcity.concepts.fractions.police;

import de.starvalcity.concepts.fractions.FractionsHandler;
import de.starvalcity.handlers.LanguageHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class DutyCOMMAND implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(LanguageHandler.getMessage("en", "PlayerRelated"));
        }
        Player player = (Player) commandSender;
        UUID playerUniqueId = player.getUniqueId();
        if (strings.length == 0) {
            if (FractionsHandler.getPoliceMembers().contains(playerUniqueId)) {
                FractionsHandler.removePoliceMember(player);
            } else {
                FractionsHandler.setPoliceMember(player);
            }
        }
        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        return null;
    }
}
