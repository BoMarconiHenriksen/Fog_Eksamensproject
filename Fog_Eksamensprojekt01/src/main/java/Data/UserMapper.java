package Data;

import java.sql.ResultSet;
import Domain.User;
import Presentation.NewException;
import java.sql.Connection;

import java.sql.SQLException;
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
//        } catch (ClassNotFoundException | SQLException ex) {
//      ex.getLocalizedMessage();
//        }return u;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    
}
