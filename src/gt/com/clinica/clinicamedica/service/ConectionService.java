

package gt.com.clinica.clinicamedica.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionService {
    private static Connection dataSource;
    private static ConectionService instance;
    /**
     * Varibales de conexión
     */
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "desarrollo";
    public String hostname = "52.186.140.66";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
    public String username = "user";
    public String password = "Aa1234567+";

    private ConectionService() {
    }

    /**
     *
     * @return Intancia de la conexión
     */
    public static ConectionService getInstance() {
        if (instance == null) {
            instance = new ConectionService();
        }
        return instance;
    }

    /**
     * Conecta con la base de datos
     * @return nueva conexion
     * @throws SQLException En caso de que la conexion falle
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);
            dataSource = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Error al conectar");
        }
        return dataSource;
    }
}