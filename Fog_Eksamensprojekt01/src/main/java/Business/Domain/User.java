/**
 * BenedikteEva
 * Fog_Eksamensprojekt01
 */
package Business.Domain;

/**
 *
 * @author BenedikteEva
 */
public class User {

    private int user_id; // just used to demo retrieval of autogen keys in UserMapper
    private int zip;
    private String email;
    private String password; // Should be hashed and all
    private String role;
    private String firstname;
    private String lastname;
    private String address;
    private int tlfnummer;

    public User(int user_id, int zip, String email, String password, String role, String firstname, String lastname, String address, int tlfnummer) {
        this.user_id = user_id;
        this.zip = zip;
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.tlfnummer = tlfnummer;
    }

    public User(String email, String password, String role, String firstname, String lastname, String address, int zip, int tlfnummer) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zip = zip;
        this.tlfnummer = tlfnummer;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email, String password, String role, String firstname) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstname = firstname;
    }
    
    public User(int user_id, String email, int tlfnummer) {
        this.user_id = user_id;
        this.email = email;
        this.tlfnummer = tlfnummer;
    }

    public int getTlfnummer() {
        return tlfnummer;
    }

    public void setTlfnummer(int tlfnummer) {
        this.tlfnummer = tlfnummer;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;

    }

    public String getPassword() {
        return password;

    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", zip=" + zip + ", email=" + email + ", password=" + password + ", role=" + role + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + '}';
    }

}
