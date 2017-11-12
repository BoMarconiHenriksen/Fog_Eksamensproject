package Business;



import Data.LineItemMapper;
import Data.MaterialeMapper;
import Data.StykLinjeMapper;
import Domain.LineItem;
import Domain.Materiale;
import Domain.StykLinje;
import Presentation.NewException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of LogicFacade is to...
 *
 * Author @ BenedikteEva 
 */
public class LogicFacade {
    
    
    public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();
        
    }
        
    
     public static List<StykLinje> getStykLinje() throws NewException {
         return StykLinjeMapper.getStykLinje();
    }
     
      public static List<LineItem> getLineItem() throws NewException {
         return LineItemMapper.getLineItems();
    }
     
     
     
     
         public static void main(String[] args) throws NewException, ClassNotFoundException, SQLException {

    
            System.out.println(StykLinjeMapper.getStykLinje());
            
            System.out.println(StykLinjeMapper.getStykLinjeById(2));
             System.out.println(LineItemMapper.getLineItems());
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
