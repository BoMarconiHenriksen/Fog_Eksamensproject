package Data;

import java.sql.ResultSet;
import Domain.User;
import Domain.Exception.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class UserMapper {
    
    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());

    public static User getUserByUserId(int user_id) {

        User u = null;
        try {

//            Connection con = DBConnector.connection();

            String sql = "SELECT * FROM userlist WHERE user_id=" + user_id;
            ResultSet rs = DBConnector.connection().prepareStatement(sql).executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                int zipcode = rs.getInt("zipcode");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int tlfnummer=rs.getInt("tlfnummer");
                u = new User(userId, zipcode, email, password, role,
                        firstname, lastname,
                        address, tlfnummer);

                return u;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getUserByUserId", ex);
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public static void createUser( User user ) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO userlist (email, password, role, firstname, lastname, address, zipcode, tlfnummer) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole());
            ps.setString( 4, user.getFirstname());
            ps.setString( 5, user.getLastname());
            ps.setString( 6, user.getAddress());
            ps.setInt( 7, user.getZip());
            ps.setInt( 8, user.getTlfnummer());
            ps.executeUpdate();
            
        } catch ( SQLException | ClassNotFoundException ex ) {
            logger.log(Level.SEVERE, "Fejl i createUser", ex);
            throw new NewException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws NewException {
        try {
            User user;
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM userlist "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "user_id" );
                String username = rs.getString( "firstname" );
                String usernameNd = rs.getString( "lastname" );
                String useradress = rs.getString( "address" );
                int zipcode = rs.getInt( "zipcode" );
                int phoneNr = rs.getInt( "tlfnummer" );
                user = new User( email, password, role, username, usernameNd, useradress, zipcode, phoneNr );
                user.setUser_id(id);
                return user;
            } else {
                throw new NewException( "Fejl ved login!!! Prøv igen." );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            logger.log(Level.SEVERE, "Fejl i login", ex);
            throw new NewException(ex.getMessage());
        }
    }
    
    public static void updateUserPassword(int user_id, String password) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update userlist set password=? where user_id=" + user_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, password);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i updateUserPassword", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    public static void updateWholeUserbutID(int user_id, int zip, String email, String password, 
            String role, String firstname, String lastname, String address, int tlfnummer) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update userlist set zipcode=?, email=?, password=?, role=?, firstname=?, lastname=?, address=?, tlfnummer=? where user_id=" + user_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, zip);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setString(4, firstname);
            ps.setString(5, lastname);
            ps.setString(6, address);
            ps.setInt(7, tlfnummer);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i updateUserPassword", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    public static List<User> getUserList() throws NewException {
        List<User> userList = new ArrayList<>();

        try {

            User u;

            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM userlist";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int zip = rs.getInt("zipcode");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                int tlfnummer = rs.getInt("tlfnummer");
                if (user_id != lastId) {

                    u = new User(user_id, zip, email, password, role, firstname, lastname, address, tlfnummer);

                    userList.add(u);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getUserList", ex);
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

}

 
