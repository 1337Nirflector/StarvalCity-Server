package de.starvalcity.system.database.mysql.mysqlhandler;

import de.starvalcity.system.base.Core;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQLHandler {

    private Core plugin;

    public MySQLHandler(Core plugin) {
        this.plugin = plugin;
    }

    public void createTable() {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = plugin.mySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS " +
                    "playerpoints (NAME VARCHAR(100),UUID VARCHAR(100),POINTS INT(100), PRIMARY KEY (NAME))");
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();
            if(!exists(uuid)) {
                PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("INSERT " +
                        "IGNORE INFO playerpoints (NAME,UUID) VALUES (?,?)");
                preparedStatement.setString(1, player.getName());
                preparedStatement.setString(2, uuid.toString());
                preparedStatement.executeUpdate();

                return;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("SELECT * FROM " +
                    "playerpoints WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                // Player has been found
                return true;
            }
            // Player has not been found
            return false;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    public void addPoints(UUID uuid, int points) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("UPDATE " +
                    "playerpoints SET POINTS =? WHERE UUID=?");
            preparedStatement.setInt(1, getPoints(uuid) + points);
            preparedStatement.setString(2, uuid.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public int getPoints(UUID uuid) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("SELECT " +
                    "POINTS FROM playerpoints WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            int points = 0;
            if(resultSet.next()) {
                points = resultSet.getInt("POINTS");
                return points;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }

    public void emptyTable() {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("TRUNCATE " +
                    "playerpoints");
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void removePlayer(UUID uuid) {
        try {
            PreparedStatement preparedStatement = plugin.mySQL.getConnection().prepareStatement("DELETE FROM " +
                    "playerpoints WHERE UUID=?");
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
