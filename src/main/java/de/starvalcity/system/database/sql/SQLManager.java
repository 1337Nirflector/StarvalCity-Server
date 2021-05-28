package de.starvalcity.system.database.sql;

import de.starvalcity.system.corepackage.Core;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLManager {

    private Core plugin;

    public SQLManager(Core plugin) {
        this.plugin = plugin;
    }
}
