/*
 * BenedikteEva
 * Fog_Eksamensprojekt01
 */
package Domain;

/**
 *
 * @author BenedikteEva
 */
public class User {

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", email=" + email + ", username=" + username + '}';
    }

  
    public User() {
    
    }

    User(int user_id) {
          this.user_id = user_id;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private int user_id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and all
    private String adminStatus;
    private String username;

    public User(String username, String email, String password, String adminStatus) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.adminStatus = adminStatus;
    }

    public User(int user_id, String email, String username) {
        this.user_id = user_id;
        this.email = email;
        this.username = username;
    }

    public User(String username, String email, String password) {
      this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;

    }

    public String getPassword() {
        return password;

    }

 

  

}
