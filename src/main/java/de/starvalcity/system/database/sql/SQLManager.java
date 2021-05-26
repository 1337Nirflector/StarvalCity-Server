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

    public void createTable() {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = plugin.mySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    " playerpoints (NAME VARCHAR(100),UUID VARCHAR(100),POINTS INT(100),PRIMARY KEY (NAME))");
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void createPlayer(Player player) {
        try {
            UUID playerUniqueId = player.getUniqueId();
            if (!exists(playerUniqueId)) {
                PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("INSERT IGNORE " +
                        "INFO playerpoints (NAME,UUID) VALUES (?,?)");
                preparedStatement.setString(1, player.getName());
                preparedStatement.setString(2, playerUniqueId.toString());
                preparedStatement.executeUpdate();
                return;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void addPoints(UUID uniqueId, int points) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement()
        }
    }

    public boolean exists(UUID uniqueId) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("SELECT * FROM " +
                    "playerpoints WHERE UUID=?");
            preparedStatement.setString(1, uniqueId.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true; // player has been found
            }
            return false;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();;
        }
        return false;
    }
}
