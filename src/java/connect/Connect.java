package connect;
import java.sql.*;
/**
 *
 * @author Mirado
 */
public class Connect {
    public Connect(){
    }
    public Connection getConnectionPsql()throws Exception{
        Connection connection;
        //étape 1: charger la classe de driver
        Class.forName("org.postgresql.Driver");
        //étape 2: créer l'objet de connexion
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/meuble","postgres","motmirado");
        return connection;
    } 
}
