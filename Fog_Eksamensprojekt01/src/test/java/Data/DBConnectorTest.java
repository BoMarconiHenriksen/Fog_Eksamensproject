/*
 * BenedikteEva
 * Lego Houses
 */
package Data;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ejer
 */
public class DBConnectorTest {
    
    public DBConnectorTest() {
    }
    
    
    @Test
    public void canConnect() throws Exception {
        try (Connection conn = DBConnector.connection()) {
            assertTrue(conn != null);
        }
    }
    
    @Test
    public void hasDriver() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
        assertTrue(true);
    }
    
}