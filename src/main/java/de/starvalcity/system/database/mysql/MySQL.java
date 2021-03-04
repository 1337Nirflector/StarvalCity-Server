package de.starvalcity.system.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection connection;

    private String host = "localhost";
    private String port = "3306"; //3308
    private String database = "serverplugins";
    private String username = "root";
    private String password = "";

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" +
                    database + "?useSSL=false", username, password);
        }
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
        } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

