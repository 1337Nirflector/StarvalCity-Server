package de.starvalcity.system.corepackage;

import de.starvalcity.commands.user.LanguageCOMMAND;
import de.starvalcity.events.PlayerJoin;
import de.starvalcity.files.deGER;
import de.starvalcity.files.enENG;
import de.starvalcity.files.messagesConfiguration;
import de.starvalcity.files.permissions;
import de.starvalcity.handlers.LanguageHandler;
import de.starvalcity.system.database.sql.MySQL;
import de.starvalcity.system.database.sql.SQLManager;
import de.starvalcity.system.filespackage.FilePathManager;
import de.starvalcity.system.filespackage.FileValueManager;
import de.starvalcity.system.filespackage.SystemMessagesManager;
import de.starvalcity.system.permissionspackage.PermissionsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.UUID;

public final class Core extends JavaPlugin {

    public static Core plugin;
    public static Plugin pl;
    public MySQL mySQL;

    public ConsoleCommandSender consoleCommandSender = getServer().getConsoleSender();
    public SQLManager mySQLData;
    public PluginManager pluginManager = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        plugin = this;
        pl = this;
        this.mySQL = new MySQL();
        this.mySQLData = new SQLManager(this);
        consoleCommandSender.sendMessage(SystemMessagesManager.startupMessage);
        messagesConfiguration.setupFile();
        LanguageHandler.loadMessages();
        initializeFiles();
        registerEvents();
        loadDatabase();
        consoleCommandSender.sendMessage(SystemMessagesManager.loadingCommands);
        getCommand("language").setExecutor((CommandExecutor) new LanguageCOMMAND());
    }

    @Override
    public void onDisable() {
        consoleCommandSender.sendMessage(SystemMessagesManager.shutdownMessage);
        mySQL.disconnect();
        consoleCommandSender.sendMessage(SystemMessagesManager.mySQLDatabaseDisconnectSuccess);
    }

    public static Core getPlugin() {
        return plugin;
    }

    private void initializeFiles() {
        consoleCommandSender.sendMessage(SystemMessagesManager.loadingEnglishMessages);
        consoleCommandSender.sendMessage(SystemMessagesManager.loadingGermanMessages);
        deGER.setupFile();
        enENG.setupFile();
        /*------------------------------------------------------------------------------------------------------------*/
        String GER_insufficient_permissions_PATH = FilePathManager.GER_insufficient_permissions_PATH;
        String GER_insufficient_permissions_VALUE = FileValueManager.GER_insufficient_permissions_VALUE;
        String GER_requested_targetplayer_PATH = FilePathManager.GER_requested_targetplayer_PATH;
        String GER_requested_targetplayer_VALUE = FileValueManager.GER_requested_targetplayer_VALUE;
        String GER_requested_targetplayer_null_PATH = FilePathManager.GER_requested_targetplayer_null_PATH;
        String GER_requested_targetplayer_null_VALUE = FileValueManager.GER_requested_targetplayer_null_VALUE;
        String GER_ip_usage_PATH = FilePathManager.GER_ip_usage_PATH;
        String GER_ip_usage_VALUE = FileValueManager.GER_ip_usage_VALUE;
        String GER_ip_own_PATH = FilePathManager.GER_ip_own_PATH;
        String GER_ip_own_VALUE = FileValueManager.GER_ip_own_VALUE;
        String GER_ip_other_PATH = FilePathManager.GER_ip_other_PATH;
        String GER_ip_other_VALUE = FileValueManager.GER_ip_other_VALUE;
        String GER_language_usage_PATH = FilePathManager.GER_language_usage_PATH;
        String GER_language_usage_VALUE = FileValueManager.GER_language_usage_VALUE;
        String GER_language_set_PATH = FilePathManager.GER_language_set_PATH;
        String GER_language_set_VALUE = FileValueManager.GER_language_set_VALUE;
        String GER_onlineplayers_usage_PATH = FilePathManager.GER_onlineplayers_usage_PATH;
        String GER_onlineplayers_usage_VALUE = FileValueManager.GER_onlineplayers_usage_VALUE;
        String GER_onlineplayers_command_PATH = FilePathManager.GER_onlineplayers_usage_PATH;
        String GER_onlineplayers_command_VALUE = FileValueManager.GER_onlineplayers_command_VALUE;
        String GER_staff_mode_usage_PATH = FilePathManager.GER_staff_mode_usage_PATH;
        String GER_staff_mode_usage_VALUE = FileValueManager.GER_staff_mode_usage_VALUE;
        String GER_joined_staff_mode_PATH = FilePathManager.GER_joined_staff_mode_PATH;
        String GER_joined_staff_mode_VALUE = FileValueManager.GER_joined_staff_mode_VALUE;
        String GER_left_staff_mode_PATH = FilePathManager.GER_left_staff_mode_PATH;
        String GER_left_staff_mode_VALUE = FileValueManager.GER_left_staff_mode_VALUE;
        /*------------------------------------------------------------------------------------------------------------*/
        String ENG_insufficient_permissions_PATH = FilePathManager.ENG_insufficient_permissions_PATH;
        String ENG_insufficient_permissions_VALUE = FileValueManager.ENG_insufficient_permissions_VALUE;
        String ENG_requested_targetplayer_PATH = FilePathManager.ENG_requested_targetplayer_PATH;
        String ENG_requested_targetplayer_VALUE = FileValueManager.ENG_requested_targetplayer_VALUE;
        String ENG_requested_targetplayer_null_PATH = FilePathManager.ENG_requested_targetplayer_null_PATH;
        String ENG_requested_targetplayer_null_VALUE = FileValueManager.ENG_requested_targetplayer_null_VALUE;
        String ENG_ip_usage_PATH = FilePathManager.ENG_ip_usage_PATH;
        String ENG_ip_usage_VALUE = FileValueManager.ENG_ip_usage_VALUE;
        String ENG_ip_own_PATH = FilePathManager.ENG_ip_own_PATH;
        String ENG_ip_own_VALUE = FileValueManager.ENG_ip_own_VALUE;
        String ENG_ip_other_PATH = FilePathManager.ENG_ip_other_PATH;
        String ENG_ip_other_VALUE = FileValueManager.ENG_ip_other_VALUE;
        String ENG_language_usage_PATH = FilePathManager.ENG_language_usage_PATH;
        String ENG_language_usage_VALUE = FileValueManager.ENG_language_usage_VALUE;
        String ENG_language_set_PATH = FilePathManager.ENG_language_set_PATH;
        String ENG_language_set_VALUE = FileValueManager.ENG_language_set_VALUE;
        String ENG_onlineplayers_usage_PATH = FilePathManager.ENG_onlineplayers_usage_PATH;
        String ENG_onlineplayers_usage_VALUE = FileValueManager.ENG_onlineplayers_usage_VALUE;
        String ENG_onlineplayers_command_PATH = FilePathManager.ENG_onlineplayers_command_PATH;
        String ENG_onlineplayers_command_VALUE = FileValueManager.ENG_onlineplayers_command_VALUE;
        String ENG_staff_mode_usage_PATH = FilePathManager.ENG_staff_mode_usage_PATH;
        String ENG_staff_mode_usage_VALUE = FileValueManager.ENG_staff_mode_usage_VALUE;
        String ENG_joined_staff_mode_PATH = FilePathManager.ENG_joined_staff_mode_PATH;
        String ENG_joined_staff_mode_VALUE = FileValueManager.ENG_joined_staff_mode_VALUE;
        String ENG_left_staff_mode_PATH = FilePathManager.ENG_left_staff_mode_PATH;
        String ENG_left_staff_mode_VALUE = FileValueManager.ENG_left_staff_mode_VALUE;
        /*------------------------------------------------------------------------------------------------------------*/
        deGER.getFile().addDefault(GER_insufficient_permissions_PATH, GER_insufficient_permissions_VALUE);
        deGER.getFile().addDefault(GER_requested_targetplayer_PATH, GER_requested_targetplayer_VALUE);
        deGER.getFile().addDefault(GER_requested_targetplayer_null_PATH, GER_requested_targetplayer_null_VALUE);
        deGER.getFile().addDefault(GER_ip_usage_PATH, GER_ip_usage_VALUE);
        deGER.getFile().addDefault(GER_ip_own_PATH, GER_ip_own_VALUE);
        deGER.getFile().addDefault(GER_ip_other_PATH, GER_ip_other_VALUE);
        deGER.getFile().addDefault(GER_language_usage_PATH, GER_language_usage_VALUE);
        deGER.getFile().addDefault(GER_language_set_PATH, GER_language_set_VALUE);
        deGER.getFile().addDefault(GER_onlineplayers_usage_PATH, GER_onlineplayers_usage_VALUE);
        deGER.getFile().addDefault(GER_onlineplayers_command_PATH, GER_onlineplayers_command_VALUE);
        deGER.getFile().addDefault(GER_staff_mode_usage_PATH, GER_staff_mode_usage_VALUE);
        deGER.getFile().addDefault(GER_joined_staff_mode_PATH, GER_joined_staff_mode_VALUE);
        deGER.getFile().addDefault(GER_left_staff_mode_PATH, GER_left_staff_mode_VALUE);
        /*------------------------------------------------------------------------------------------------------------*/
        enENG.getFile().addDefault(ENG_insufficient_permissions_PATH, ENG_insufficient_permissions_VALUE);
        enENG.getFile().addDefault(ENG_requested_targetplayer_PATH, ENG_requested_targetplayer_VALUE);
        enENG.getFile().addDefault(ENG_requested_targetplayer_null_PATH, ENG_requested_targetplayer_null_VALUE);
        enENG.getFile().addDefault(ENG_ip_usage_PATH, ENG_ip_usage_VALUE);
        enENG.getFile().addDefault(ENG_ip_own_PATH, ENG_ip_own_VALUE);
        enENG.getFile().addDefault(ENG_ip_other_PATH, ENG_ip_other_VALUE);
        enENG.getFile().addDefault(ENG_language_usage_PATH, ENG_language_usage_VALUE);
        enENG.getFile().addDefault(ENG_language_set_PATH, ENG_language_set_VALUE);
        enENG.getFile().addDefault(ENG_onlineplayers_usage_PATH, ENG_onlineplayers_usage_VALUE);
        enENG.getFile().addDefault(ENG_onlineplayers_command_PATH, ENG_onlineplayers_command_VALUE);
        enENG.getFile().addDefault(ENG_staff_mode_usage_PATH, ENG_staff_mode_usage_VALUE);
        enENG.getFile().addDefault(ENG_joined_staff_mode_PATH, ENG_joined_staff_mode_VALUE);
        enENG.getFile().addDefault(ENG_left_staff_mode_PATH, ENG_left_staff_mode_VALUE);
        /*------------------------------------------------------------------------------------------------------------*/
        deGER.getFile().options().copyDefaults(true);
        enENG.getFile().options().copyDefaults(true);
        messagesConfiguration.getFile().options().copyDefaults(false);
        deGER.saveFile();
        enENG.saveFile();
        messagesConfiguration.saveFile();
    }

    private void registerEvents() {
        consoleCommandSender.sendMessage(SystemMessagesManager.loadingEvents);
        pluginManager.registerEvents(new LanguageCOMMAND(), this);
        pluginManager.registerEvents(new PlayerJoin(), this);
    }

    private void loadDatabase() {
        consoleCommandSender.sendMessage(SystemMessagesManager.loadingMySQLDatabase);
        try {
            mySQL.connect();
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
            consoleCommandSender.sendMessage(SystemMessagesManager.mySQLDatabaseLoadingError);
        }
        if (mySQL.isConnected()) {
            consoleCommandSender.sendMessage(SystemMessagesManager.mySQLDatabaseLoadingSuccess);
        }
    }

    public void setupPermissions(Player player) {
        PermissionAttachment permissionAttachment = player.addAttachment(this);
        UUID playerUniqueId = player.getUniqueId();
        PermissionsManager.userPermissions.put(playerUniqueId, permissionAttachment);
    }

    private void setPermission(UUID uniqueId) {
        PermissionAttachment permissionAttachment = PermissionsManager.userPermissions.get(uniqueId);

        for (String groups : permissions.getFile().getConfigurationSection("Groups").getKeys(false)) {
            for (String permissions : permissions.getFile().getStringList("Groups." + groups + ".permissions")) {
                permissionAttachment.setPermission(permissions, true);
            }
        }
    }

}
