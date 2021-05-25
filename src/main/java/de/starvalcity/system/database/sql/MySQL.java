package de.starvalcity.system.database.sql;

import de.starvalcity.system.corepackage.Core;
import de.starvalcity.system.filespackage.SystemMessagesManager;

import java.sql.*;

public class MySQL {

    private String HOST;
    private String DATABASE;
    private String USER;
    private String PASSWORD;
    private int PORT;

    private Connection connection;

    public MySQL(String host, String database, String user, String password, int port) {
        this.HOST = host;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;
        this.PORT = port;
        connect();
        update("CREATE TABLE IF NOT EXISTS player_permissions(ID INT , UUID VARCHAR(100) , PERMISSION VARCHAR(100));");
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                    HOST +
                    ":" +
                    PORT +
                    "/" +
                    DATABASE +
                    "?autoReconnect=true", USER, PASSWORD);
            Core.getPlugin().getServer().getConsoleSender().sendMessage(SystemMessagesManager.loadingMySQLDatabase);
            Core.getPlugin().getServer().getConsoleSender().sendMessage(SystemMessagesManager.mySQLDatabaseLoadingSuccess);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            Core.getPlugin().getServer().getConsoleSender().sendMessage(SystemMessagesManager.mySQLDatabaseLoadingError +
                    sqlException.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                Core.getPlugin().getServer().getConsoleSender().sendMessage(SystemMessagesManager.mySQLDatabaseDisconnectSuccess);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            Core.getPlugin().getServer().getConsoleSender().sendMessage(SystemMessagesManager.mySQLDatabaseLoadingError +
                    sqlException.getMessage());
        }
    }

    public void update(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException sqlException) {
            connect();
            Core.getPlugin().getServer().getConsoleSender().sendMessage(sqlException.getMessage());
        }
    }

    public ResultSet query(String query) {
        ResultSet resultSet = null;

        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            connect();
            Core.getPlugin().getServer().getConsoleSender().sendMessage(sqlException.getMessage());
        }
        return resultSet;
    }
}
