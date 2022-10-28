package singletonWilderZapata;

import java.sql.*;

public class SqliteDBClient {
    public static SqliteDBClient client = null;
    public Connection sqliteClient;
    private final String URL = "jdbc:sqlite:./singletonTest.db";

    private SqliteDBClient() {
        try {
            sqliteClient = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public static SqliteDBClient getClient() {
        if (client == null)
            client = new SqliteDBClient();
        return client;
    }

}
