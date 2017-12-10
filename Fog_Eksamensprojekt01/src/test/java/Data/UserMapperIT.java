//package Data;
//
//import Domain.Exception.NewException;
//import Domain.User;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
//public class UserMapperIT {
//
//    private static Connection testConnection;
//    private static String USER = "testinguser";
//    private static String USERPW = "tryALot";
//    private static String DBNAME = "fogTest";
//    private static String HOST = "46.101.179.58";
//    
//    /**
//     * @Before kører før test metoden. Vi bruger det til at resette database tabellerne før hver test.
//     */
//    @Before
//    public void setUp() {
//        try {
//            // Vi bruger singular pattern så vi er sikre på at vi kun åbner 1 connection.
//            if ( testConnection == null ) {
//                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
//                Class.forName( "com.mysql.jdbc.Driver" );
//
//                testConnection = DriverManager.getConnection( url, USER, USERPW );
//                // Make mappers use test 
//                DBConnector.setConnection( testConnection );
//            }
//            // resetter test databasen
//            try ( Statement stmt = testConnection.createStatement() ) {
//                stmt.execute( "drop table if exists userlist" );
//                stmt.execute( "create table userlist like userlistTest" );
//                stmt.execute( "insert into userlist select * from userlistTest" );
//                
//                stmt.execute( "drop table if exists zipcodelist" );
//                stmt.execute( "create table zipcodelist like zipcodelistTest" );
//                stmt.execute( "insert into zipcodelist select * from zipcodelistTest" );
//                
//                stmt.execute( "drop table if exists ordreliste" );
//                stmt.execute( "create table ordreliste like ordrelisteTest" );
//                stmt.execute( "insert into ordreliste select * from ordrelisteTest" );
//                
//                stmt.execute( "drop table if exists odetaljer" );
//                stmt.execute( "create table odetaljer like odetaljerTest" );
//                stmt.execute( "insert into odetaljer select * from odetaljerTest" );
//                
//                stmt.execute( "drop table if exists materialeliste" );
//                stmt.execute( "create table materialeliste like materialelisteTest" );
//                stmt.execute( "insert into materialeliste select * from materialelisteTest" );
//            }
//
//        } catch ( ClassNotFoundException | SQLException ex ) {
//            testConnection = null;
//            System.out.println( "Kunne ikke åbne forbindelsen til databasen: " + ex.getMessage() );
//        }
//    }
//
//    /**
//     * Test at vi har en forbindelse.
//     */
//    @Test
//    public void testSetUpOK() {
//        assertNotNull( testConnection );
//    }
//
//    /**
//     * Tester at vi kan logge ind.
//     * @throws NewException 
//     */
//    @Test
//    public void testLogin() throws NewException {
//        User user = UserMapper.login( "ansat@ansat.dk", "a" );
//        assertTrue( user != null );
//    }
//
//    /**
//     * Tester om vi får en exception, hvis vi bruger forkert password
//     * @throws NewException 
//     */
//    @Test( expected = NewException.class )
//    public void testLoginWrongPassword() throws NewException {
//        User user = UserMapper.login( "ansat@ansat.dk", "Sawsdon01" );
//    }
//
//    /**
//     * Vi forventer at Winnie er kunde
//     * @throws NewException 
//     */
//    @Test
//    public void testIsRoleCustomer() throws NewException {
//        User user = UserMapper.login( "kunde@kunde.dk", "b" );
//        assertEquals( "customer", user.getRole() );
//    }
//
//    /**
//     * Metoden tester om vi kan lave en ny bruger. Hvis login fejler, fejler denne her også. 
//     * @throws NewException 
//     */
//    @Test
//    public void testCreateUser() throws NewException {
//        User original = new User( "king@kong.com", "uhahvorhemmeligt", "customer", "Kongen", "Over Dem Alle", "Junglen 10", 1000, 99999999 );
//        UserMapper.createUser( original );
//        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
//        assertEquals( "customer", retrieved.getRole() );
//    }
//}
