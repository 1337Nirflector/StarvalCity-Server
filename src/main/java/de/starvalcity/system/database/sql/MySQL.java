package de.starvalcity.system.database.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private String host = "localhost";
    private String port = "3306";
    private String database = "plugins";
    private String username = "root";
    private String password = "";

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database +
                "?useSSL=false", username, password);
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
