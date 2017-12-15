/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.Exception.NewException;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ticondrus
 */
public class OrderMapperIT {

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "tryALot";
    private static String DBNAME = "fogTest";
    private static String HOST = "46.101.179.58";

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
    public void testAddOrder() throws NewException {
        Ordre or = new Ordre();
        OrdreMapper.addOrdertoOrderList(or);
        assertTrue(or != null);
    }
    @Test
    public void testAddOdetailstoOrderwhenOrderisAdded() throws NewException {
        Ordre or = new Ordre();
        Odetaljer od = new Odetaljer();
        OrdreMapper.addOrdertoOrderList(or);
        OdetaljeMapper.AddOdetailstoOrdermedSkur(or.getOrdre_id(), od);
        
        assertTrue(or != null);
        assertEquals( or, or.getOrdre_id() );
    }
    
    @Test( expected = NewException.class )
    public void testOrdernotAdded() throws NewException {
        Ordre or = new Ordre();
        OrdreMapper.addOrdertoOrderList(or);
        assertTrue(or == null);
    }

   

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
