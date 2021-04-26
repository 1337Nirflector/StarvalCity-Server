package de.starvalcity.system.basepackage;

import de.starvalcity.system.files.Permissions;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class PermissionsManager {

    static LuckPerms luckPerms;

    public static List<String> adminPermissions = new ArrayList<>();
    public static List<String> developerPermissions = new ArrayList<>();
    public static List<String> seniorModeratorPermissions = new ArrayList<>();
    public static List<String> moderatorPermissions = new ArrayList<>();
    public static List<String> supporterPlusPermissions = new ArrayList<>();
    public static List<String> supporterPermissions = new ArrayList<>();
    public static List<String> testSupporterPermissions = new ArrayList<>();

    /* -------------------------------------------------------------------------------------------------------------- */

    public static String economy_client_money = "economy.client.money";
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

    public void informIfAdmin(CommandSender commandSender, UUID player) {
        isAdmin(player).thenAcceptAsync(result -> {
            if (result) {
                commandSender.sendMessage("This player is an admin!");
            } else {
                commandSender.sendMessage("This player is not an admin!");
            }
        });
    }

    public void addPermission(User user, String permission) {
        user.data().add(Node.builder(permission).build());
        Permissions.getFile().set(user.getUsername(), permission);
        luckPerms.getUserManager().saveUser(user);
    }

    public boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }

    public static List<String> getTestSupporterPermissions() {
        return testSupporterPermissions;
    }

    public static List<String> getSupporterPermissions() {
        return supporterPermissions;
    }

    public static List<String> getSupporterPlusPermissions() {
        return supporterPlusPermissions;
    }

    public static List<String> getModeratorPermissions() {
        return moderatorPermissions;
    }

    public static List<String> getSeniorModeratorPermissions() {
        return seniorModeratorPermissions;
    }

    public static List<String> getDeveloperPermissions() {
        return developerPermissions;
    }

    public static List<String> getAdminPermissions() {
        return adminPermissions;
    }
}
