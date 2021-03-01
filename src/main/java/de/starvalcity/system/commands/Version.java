package de.starvalcity.system.commands;

import de.starvalcity.system.base.Core;
import de.starvalcity.system.base.commandhandler.SubCommand;
import de.starvalcity.system.base.messages.MessagesHandler;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Version extends SubCommand {

    private Core coreInstance = Core.getCoreInstance();


    @Override
    public void onCommand(Player player, String[] strings) {
        player.sendMessage(MessagesHandler.systemMessages.get(0));
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 10, 1);
    }

    @Override
    public String name() {
        return coreInstance.commandHandler.version;
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
