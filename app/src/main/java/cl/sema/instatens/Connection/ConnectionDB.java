package cl.sema.instatens.Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {
    private final String server = "192.168.0.15";
    private final String user = "root";
    private final String password = "";
    private final String database = "instatens";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() {
        boolean result;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + server + ":3306/" + database;
            this.connection = DriverManager
                    .getConnection(url, user, password);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (Exception ex) {

        }
    }
}
