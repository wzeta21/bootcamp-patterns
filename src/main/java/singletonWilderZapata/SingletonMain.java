package singletonWilderZapata;

public class SingletonMain {
    public static void main(String[] args) {
        SqliteDBClient sqliteDBClient = SqliteDBClient.getClient();

        SqlOperations operations = new SqlOperations(sqliteDBClient);

        operations.createDatabase();

        operations.createTestTable();

        operations.insert("Wilder", 4325);
        operations.insert("Jose", 653);
        operations.insert("Marcos", 876);
        operations.insert("Liliana", 9876);

        operations.selectAll();
    }
}
