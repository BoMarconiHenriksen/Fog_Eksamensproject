package Data;

import Business.Exception.NewException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klassen laver en connector til vores databsen.
 * 
 */
public class DBConnector {

 
    private final static String URL = "jdbc:mysql://46.101.179.58:3306/fog";
    private final static String USER = "testuser";
    private final static String PASSWORD = "password123";
    private static Connection singleton;
    
    //Bruges til test
    public static void setConnection( Connection con ) {
        singleton = con;
}

/**
 * Metoden laver en forbindelse til databasen. Vi bruger singular pattern, så vi er sikre på kun at åbne en forbindelse.
 * @return en forbindelse til databasen.
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public static Connection connection() throws NewException {
        if (singleton == null) {
            try {
                Class.forName( "com.mysql.jdbc.Driver");
                singleton = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return singleton;
    }

}
