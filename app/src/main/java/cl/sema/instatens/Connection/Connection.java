package cl.sema.instatens.Connection;

import java.sql.DriverManager;

public class Connection {
    private final String server = "localhost:3306";
    private final String user = "root";
    private final String password = "";
    private final String database = "test";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() {
        boolean result;
        try {
            Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://" + server + database;
                this.connection = (Connection) DriverManager.getConnection(url, user, password);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public void disconnect() {
        try {
            this.connection.clone();
        } catch (Exception ex) {

        }
    }
}
