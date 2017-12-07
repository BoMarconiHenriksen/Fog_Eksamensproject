///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Data;
//
//import Presentation.NewException;
//import Domain.User;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Before;
//
//public class UserMapperTest {
////    Test date in the UsersTest table
////    INSERT INTO `UsersTest` VALUES 
////    (1,'jens@somewhere.com','jensen','customer'),
////    (2,'ken@somewhere.com','kensen','customer'),
////    (3,'robin@somewhere.com','batman','employee'),
////    (4,'someone@nowhere.com','sesam','customer');
//
//    private static Connection testConnection;
//    private static String USER = "testuser";
//    private static String USERPW = "password123";
//    private static String DBNAME = "useradminTest";
//    private static String HOST = "46.101.179.58";
//
//    @Before
//    public void setUp() {
//        try {
//            // awoid making a new connection for each test
//            if ( testConnection == null ) {
//                String url = String.format( "\"jdbc:mysql://46.101.179.58:3306/fog", HOST, DBNAME );
//                Class.forName( "com.mysql.jdbc.Driver" );
//
//                testConnection = DriverManager.getConnection( url, USER, USERPW );
//                // Make mappers use test 
//                DBConnector.setConnection( testConnection );
//            }
//            // reset test database
//            try ( Statement stmt = testConnection.createStatement() ) {
//                stmt.execute( "drop table if exists userlist" );
//                stmt.execute( "create table userlist like userlistTest" );
//                stmt.execute( "insert into userlist select * from userlistTest" );
//            }
//
//        } catch ( ClassNotFoundException | SQLException ex ) {
//            testConnection = null;
//            System.out.println( "Could not open connection to database: " + ex.getMessage() );
//        }
//    }
//
//    @Test
//    public void testSetUpOK() {
//        // Just check that we have a connection.
//        assertNotNull( testConnection );
//    }
//
//    @Test
//    public void testLogin01() throws NewException {
//        // Can we log in
//        User user = UserMapper.login( "one@nohere.com", "qwerty" );
//        assertTrue( user != null );
//    }
//
//    @Test( expected = NewException.class )
//    public void testLogin02() throws NewException {
//        // We should get an exception if we use the wrong password
//        User user = UserMapper.login( "sowing@nowhere.com", "Sawsdon01" );
//    }
//
//    @Test
//    public void testLogin03() throws NewException {
//        // Jens is supposed to be a customer
//        User user = UserMapper.login( "someodfwne@nowhere.com", "kejnonfcss" );
//        assertEquals( "Kunde", user.getRole() );
//    }
//
//    @Test
//    public void testCreateUser01() throws NewException {
//        // Can we create a new user - Notice, if login fails, this will fail
//        // but so would login01, so this is OK
//        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
//        UserMapper.createUser( original );
//        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
//        assertEquals( "Kunde", retrieved.getRole() );
//    }
//}