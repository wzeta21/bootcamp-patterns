package singletonWilderZapata;

import java.sql.*;

public class SqlOperations {
    private SqliteDBClient client = null;

    public SqlOperations(SqliteDBClient client) {
        this.client = client;
    }

    public void createDatabase() {
        try {

            if (client != null) {
                DatabaseMetaData meta = client.sqliteClient.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void createTestTable() {

        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real\n"
                + ");";
        try {
            Statement stmt = client.sqliteClient.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void insert(String name, double capacity) {
        String sql = "INSERT INTO employees(name, capacity) VALUES(?,?)";

        try {

            PreparedStatement pstmt = client.sqliteClient.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void selectAll() {
        String sql = "SELECT * FROM employees";

        try {
            Statement stmt = client.sqliteClient.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
