package Business;



import Data.MaterialeMapper;
import Domain.Materiale;
import Presentation.NewException;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * Author @ BenedikteEva 
 */
public class LogicFacade {
    
    
    public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();
    }
            
            

//    public static User login(String username, String email, String password) throws BenedikteEvasNewException {
//        return UserMapper.login(email, password);
//    }
//
//    public static User createUser(String username, String email, String password) throws BenedikteEvasNewException {
//        User user = new User(username, email, password);
//        UserMapper.createUser(user);
//        return user;
//    }
//
//    public static List<User> getAllUsers() throws BenedikteEvasNewException {
//        return UserMapper.getAllUsers();
//    }

  
}
