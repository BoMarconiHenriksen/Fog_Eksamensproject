package Data;

import Domain.Exception.NewException;
import Domain.Materiale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Klassen tester MaterialeMapper metoderne.
 * 
 */
public class MaterialeMapperIT {
    
    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "tryALot";
    private static String DBNAME = "fogTest";
    private static String HOST = "46.101.179.58";
    
    public MaterialeMapperIT() {
    }
    
       
    /**
     * @Before kører før test metoden. Vi bruger det til at resette database tabellerne før hver test.
     */
    @Before
    public void setUp() {
        try {
            // Vi bruger singular pattern så vi er sikre på at vi kun åbner 1 connection.
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                DBConnector.setConnection( testConnection );
            }
            // resetter test databasen
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists userlist" );
                stmt.execute( "create table userlist like userlistTest" );
                stmt.execute( "insert into userlist select * from userlistTest" );
                
                stmt.execute( "drop table if exists zipcodelist" );
                stmt.execute( "create table zipcodelist like zipcodelistTest" );
                stmt.execute( "insert into zipcodelist select * from zipcodelistTest" );
                
                stmt.execute( "drop table if exists ordreliste" );
                stmt.execute( "create table ordreliste like ordrelisteTest" );
                stmt.execute( "insert into ordreliste select * from ordrelisteTest" );
                
                stmt.execute( "drop table if exists odetaljer" );
                stmt.execute( "create table odetaljer like odetaljerTest" );
                stmt.execute( "insert into odetaljer select * from odetaljerTest" );
                
                stmt.execute( "drop table if exists materialeliste" );
                stmt.execute( "create table materialeliste like materialelisteTest" );
                stmt.execute( "insert into materialeliste select * from materialelisteTest" );
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Kunne ikke åbne forbindelsen til databasen: " + ex.getMessage() );
        }
    }

    /**
     * Test at vi har en forbindelse.
     */
    @Test
    public void testSetUpOK() {
        assertNotNull( testConnection );
    }
    
    /**
     * Test of getMaterial method, of class MaterialeMapper.
     * @throws Domain.Exception.NewException
     */
    @Test
    public void testGetMaterial() throws NewException {
        System.out.println("getMaterial");
        List<Materiale> expResult = null;
        List<Materiale> result = MaterialeMapper.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Metoden tester om vi får det rigtige varenavn for materiale nummer 1
     * @throws Domain.Exception.NewException
     */
    @Test
    public void testGetMaterialeByVarenummer() throws NewException {
        String expResult = "25x200 mm. trykimp. Brædt";
        String result = MaterialeMapper.getMaterialeByVarenummer(1).getMaterialenavn();
        assertEquals(expResult, result);
    }

    /**
     * Prisen på varen med id nummer 7 er 6.95. Vi tester om vi kan ændre prisen til 14.95.
     * @throws Domain.Exception.NewException
     */
    @Test
    public void testChangeMaterialePris() throws NewException {
        int vareid = 7;
        double expResult = 14.95;
        MaterialeMapper.changeMaterialePris(vareid, expResult);
        double result = MaterialeMapper.getMaterialeByVarenummer(7).getEnhedspris();
        assertEquals(expResult, result, 0.0);
    }

}
