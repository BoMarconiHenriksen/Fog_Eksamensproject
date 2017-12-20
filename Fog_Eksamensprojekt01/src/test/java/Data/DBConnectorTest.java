
package Data;

import Business.Exception.NewException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * tester forbindelsen til databasen inden programmet køres hvergang
 */
public class DBConnectorTest {
     
    public DBConnectorTest() {
    }
    
    
    @Test
    public void canConnect() throws NewException {
        try (Connection conn = DBConnector.connection()) {
            assertTrue(conn != null);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void hasDriver() throws NewException  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            assertTrue(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}