package Data;

import java.sql.ResultSet;
import Business.Domain.User;
import Business.Exception.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UserMapper: Håntere alle metoder til og fra databasen vedr en user.
 *
 */
public class UserMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());

    /**
     * Metoden henter lt data tilknyttet en bestem bruger, ud fra et specifikt
     * user_id.
     *
     * @param user_id er brugerens id.
     * @return user som er en bruger.
     */
    public static User getUserByUserId(int user_id) throws NewException {

        User user = null;
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
                int tlfnummer = rs.getInt("tlfnummer");
                user = new User(userId, zipcode, email, password, role,
                        firstname, lastname,
                        address, tlfnummer);

                return user;
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getUserByUserId", ex);
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    /**
     * opretter en bruger med email, tlf, addresse, password m.m i
     * databasen.
     *
     * @param user er brugeren.
     * @throws NewException ved fejl.
     */
    public static void createUser(User user) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO userlist (email, password, role, firstname, lastname, address, zipcode, tlfnummer) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getFirstname());
            ps.setString(5, user.getLastname());
            ps.setString(6, user.getAddress());
            ps.setInt(7, user.getZip());
            ps.setInt(8, user.getTlfnummer());
            ps.executeUpdate();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i createUser", ex);
            throw new NewException(ex.getMessage());
        }
    }

    /**
     * Giver en forspørgsmål på en bruger, om brugerens email og password
     * kan matches, og hvis de gør, retueneres resten af brugerens oplysninger.
     *
     * @param email er brugerns email.
     * @param password er brugerens password.
     * @return user er brugeren
     * @throws NewException ved fejl.
     */
    public static User login(String email, String password) throws NewException {
        try {
            User user;
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM userlist "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("user_id");
                String username = rs.getString("firstname");
                String usernameNd = rs.getString("lastname");
                String useradress = rs.getString("address");
                int zipcode = rs.getInt("zipcode");
                int phoneNr = rs.getInt("tlfnummer");
                user = new User(email, password, role, username, usernameNd, useradress, zipcode, phoneNr);
                user.setUser_id(id);
                return user;
            } else {
                throw new NewException("Fejl ved login!!! Prøv igen.");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i login", ex);
            throw new NewException(ex.getMessage());
        }
    }

    /**
     * Metoden overskrider en brugers tidligere password med
     * et nyt et.
     *
     * @param user_id er brugerens id.
     * @param password er brugerens password.
     * @throws NewException ved fejl.
     */
    public static void updateUserPassword(int user_id, String password) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update userlist set password=? where user_id=" + user_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, password);

            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i updateUserPassword", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Metoden overskrider alle brugerens data i databasen
     * med nyt (eller samme data), bortset fra brugerens unike id.
     * @param user_id er brugerens id.
     * @param zip er brugerens postnummer.
     * @param email er brugerens email.
     * @param password er brugerens password.
     * @param role er brugerens rolle.
     * @param firstname er brugerens fornavn.
     * @param lastname er brugerens efternavn.
     * @param address er brugerens adresse.
     * @param tlfnummer er brugerens telefonnummer
     * @throws NewException ved fejl.
     */
    public static void updateWholeUserbutID(int user_id, int zip, String email, String password,
            String role, String firstname, String lastname, String address, int tlfnummer) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update userlist set zipcode=?, email=?, password=?, role=?, firstname=?, lastname=?, address=?, tlfnummer=? where user_id=" + user_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, zip);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.setString(5, firstname);
            ps.setString(6, lastname);
            ps.setString(7, address);
            ps.setInt(8, tlfnummer);

            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i updateUser", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Metoden henter opretter en liste og indsætter den, med alle
     * databasens brugere.
     *
     * @return userList som er en liste over alle brugerne.
     * @throws NewException ved fejl.
     */
    public static List<User> getUserList() throws NewException {
        List<User> userList = new ArrayList<>();

        try {

            User user;

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

                    user = new User(user_id, zip, email, password, role, firstname, lastname, address, tlfnummer);

                    userList.add(user);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getUserList", ex);
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

}
