package Data;

import java.sql.ResultSet;
import Domain.User;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ejer
 */
public class UserMapper {

    public static User getUserByUserId(int user_id) {

        User u = null;
        try {

            Connection con = DBConnector.connection();

            String sql = "SELECT * FROM userlist WHERE user_id=" + user_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();
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
            throw new NewException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setUser_id(id);
                return user;
            } else {
                throw new NewException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new NewException(ex.getMessage());
        }
    }

}

 
