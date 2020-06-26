package cl.sema.instatens.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

    /* Clase ConnectionDB para realizar la conexión a la base de datos*/
public class ConnectionDB {
    private final String server = "192.168.0.15";
    private final String user = "root";
    private final String password = "";
    private final String database = "instatens";
    private Connection connection;

    /*Metodo que retorna la conexion a la base de datos*/
    public Connection getConnection() {
        return connection;
    }

    /* Método que retorna el estado de la conexión a la base de datos */
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

    /*Metodo que desconecta la base de datos*/
    public void disconnect() {
        try {
            this.connection.close();
        } catch (Exception ex) {

        }
    }
}
