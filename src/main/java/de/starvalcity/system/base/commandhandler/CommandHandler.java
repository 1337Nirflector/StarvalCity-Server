package de.starvalcity.system.base.commandhandler;

import de.starvalcity.system.base.Core;
import de.starvalcity.system.base.messages.MessagesHandler;
import de.starvalcity.system.commands.Version;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommandHandler implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
    private Core pluginInstance = Core.getCoreInstance();

    public CommandHandler() {

    }

    public String plugin = "plugin";
    public String version = "version";

    public void setCommands() {
        pluginInstance.getCommand(version).setExecutor(this);

        this.commands.add(new Version());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] arguments) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(MessagesHandler.errorMessages.get(1));
            return true;
        }
        Player player = (Player) commandSender;
        Location playerLocation = player.getLocation();
        Sound errorSound = Sound.BLOCK_NOTE_BLOCK_BASS;
        Sound successSound = Sound.BLOCK_NOTE_BLOCK_PLING;

        if(command.getName().equalsIgnoreCase(plugin)) {
            if(arguments.length == 0) {
                player.sendMessage(MessagesHandler.errorMessages.get(2));
                player.playSound(playerLocation, errorSound, 10, 1 );
                return true;
            }

            SubCommand target = this.getSubCommand(arguments[0]);

            if(target == null) {
                player.sendMessage(MessagesHandler.errorMessages.get(3));
                player.playSound(playerLocation, errorSound, 10, 1 );
                return true;
            }

            ArrayList<String> commandArguments = new ArrayList<String>();
            commandArguments.addAll(Arrays.asList(arguments));
            commandArguments.remove(0);

            try {
                target.onCommand(player, arguments);
            } catch (Exception exception) {
                player.sendMessage(MessagesHandler.errorMessages.get(0));
                player.playSound(playerLocation, errorSound, 10, 1);
                exception.printStackTrace();
            }

        }
        return true;
    }

    private SubCommand getSubCommand(String name) {
        Iterator<SubCommand> subCommands = this.commands.iterator();

        while(subCommands.hasNext()) {
            SubCommand subCommand = (SubCommand) subCommands.next();

            if(subCommand.name().equalsIgnoreCase(name)) {
                return subCommand;
            }

            String[] aliases;
            int length = (aliases = subCommand.aliases()).length;

            for(int variable5 = 0; variable5 < length; ++variable5) {
                String alias = aliases[variable5];
                if(name.equalsIgnoreCase(alias)) {
                    return subCommand;
                }
            }
        }
        return null;
    }
}
