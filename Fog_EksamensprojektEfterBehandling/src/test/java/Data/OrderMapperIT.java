
package Data;

import Business.Exception.NewException;
import Business.Domain.Ordre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *klassen integrationstester OrderMapper
 */
public class OrderMapperIT {

    private static Connection testConnection;
    private static String USER = "transformer";
    private static String USERPW = "tryl";
    private static String DBNAME = "fogTest";
    private static String HOST = "165.227.132.189";

    @BeforeClass
    public static void setUp() {
        try {
            // Vi bruger singular pattern så vi er sikre på at vi kun åbner 1 connection, lige som i UserMapperIT.
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test 
                DBConnector.setConnection(testConnection);
            }
            // resetter test databasen
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists userlist");
                stmt.execute("create table userlist like userlistTest");
                stmt.execute("insert into userlist select * from userlistTest");

                stmt.execute("drop table if exists zipcodelist");
                stmt.execute("create table zipcodelist like zipcodelistTest");
                stmt.execute("insert into zipcodelist select * from zipcodelistTest");

                stmt.execute("drop table if exists ordreliste");
                stmt.execute("create table ordreliste like ordrelisteTest");
                stmt.execute("insert into ordreliste select * from ordrelisteTest");

                stmt.execute("drop table if exists odetaljer");
                stmt.execute("create table odetaljer like odetaljerTest");
                stmt.execute("insert into odetaljer select * from odetaljerTest");

                stmt.execute("drop table if exists materialeliste");
                stmt.execute("create table materialeliste like materialelisteTest");
                stmt.execute("insert into materialeliste select * from materialelisteTest");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Kunne ikke åbne forbindelsen til databasen: " + ex.getMessage());
        }
    }

    /**
     * Test at vi har en forbindelse.
     */
    @Test
    public void testSetUpOK() {
        assertNotNull(testConnection);
    }

    @Test
    public void testAddOrderToOrderList() throws NewException {
        Ordre ordre = new Ordre(3, "2017-10-10", 4);
        OrdreMapper.addOrdertoOrderList(ordre);
        List<Ordre> retrieved = OrdreMapper.getOrderListByUserID(4);
        String date = retrieved.get(0).getReciveddate(); 
        assertEquals( "2017-10-10", date );
    }
    
    @Test
    public void testGetLastInvoiceId() throws NewException {
        Ordre ordre = new Ordre(3, "2017-10-12", 5);
        OrdreMapper.addOrdertoOrderList(ordre);
        int retrieved = OrdreMapper.getLastInvoiceId();
        assertEquals( 3, retrieved );
    }
    
    @Test
    public void testDeleteOrderListByOrderId() throws NewException {
        Ordre ordre = new Ordre(4, "2017-10-11", 6);
        OrdreMapper.addOrdertoOrderList(ordre);
        
        OrdreMapper.deleteOrderListByOrderID(4);
        List<Ordre> retrieved = OrdreMapper.getOrderListByUserID(6);
        
        assertTrue(retrieved.isEmpty());
    }
    
}
