package de.starvalcity.system.basepackage;

import me.lucko.luckperms.common.model.User;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PermissionsManager {

    static LuckPerms luckPerms;

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String idn_general = "idn.general";
    public static String idn_view = "idn.view";
    public static String idn_recreate = "idn.recreate";
    public static String language_general = "language.general";
    public static String language_info = "language.info";
    public static String language_set = "language.set";
    public static String staff_general = "staff.general";
    public static String staff_info = "staff.info";
    public static String staff_join = "staff.join";
    public static String staff_leave = "staff.leave";
    public static String staffchat_general = "staffchat.general";

    /* -------------------------------------------------------------------------------------------------------------- */

    public CompletableFuture<Boolean> isAdmin(UUID player) {
        return luckPerms.getUserManager().loadUser(player).thenApplyAsync(user -> {
            Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
            return inheritedGroups.stream().anyMatch(g -> g.getName().equals("admin"));
        });
    }

    public static boolean isPlayerInGroup(Player player, String group) {
        return player.hasPermission("group." + group);
    }

    public static String getPlayerGroup(Player player, Collection<String> possibleGroups) {
        for (String group : possibleGroups) {
            if (player.hasPermission("group." + group)) {
                return group;
            }
        }
        return null;
    }



}
