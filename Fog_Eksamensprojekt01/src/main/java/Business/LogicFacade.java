package Business;

import Data.LineItemMapper;
import Data.MaterialeMapper;
import Data.OrdreMapper;
import Data.StykLinjeMapper;
import Data.OdetaljeMapper;
import Data.UserMapper;
import Domain.LineItem;
import Domain.Materiale;
import Domain.Ordre;
import Domain.StykLinje;
import Domain.Odetaljer;
import Domain.User;
import Presentation.NewException;
import java.sql.SQLException;
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

      public static Odetaljer getOrderByOrderId(int ordre_id) throws NewException {
        return OrdreMapper.getOrderByOrderId(ordre_id);
    }
       public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {
        return OdetaljeMapper.getOrderByOrderId2(ordre_id);
    }

    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {
        String materialetype = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialetype();
        String materialenavn = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialenavn();
        double enhedspris = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhedspris();
        String enhed = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhed();
        double msr = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMsr();
        Materiale mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
        return mat;
    }

    public static List<StykLinje> getStykLinje() throws NewException {
        return StykLinjeMapper.getStykLinje();
    }

    public static List<LineItem> getLineItem() throws NewException {
        return LineItemMapper.getLineItems();
    }
    
    public static Ordre placeAnOrder(int user_id, String receiveddate) throws NewException{
        Ordre theOrdered = new Ordre(user_id, receiveddate);
        LineItemMapper.addOrdertoOrderList(theOrdered);
        return theOrdered;
        
    }
    
    public static List<Ordre> getOrderList() throws NewException{
        return OrdreMapper.getOrderList();
    }

    public static Materiale changeMaterialePris(int vareid, double enhedspris) throws NewException {
        Materiale mat = new Materiale(vareid, enhedspris);
        MaterialeMapper.changeMaterialePris(vareid, enhedspris);
        return mat;
    }
      public static void updatereOdetajlermedSkur(int ordre_id, Odetaljer ods)
       throws NewException {
        LineItemMapper.AddOdetailstoOrdermedSkur(ordre_id, ods);
    }
    
     public static User getUserByUserId(int user_id) throws NewException {
        return UserMapper.getUserByUserId(user_id);
    }

    
    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException{
        OdetaljeMapper.addOdetaljertoOdetaljeListe(ordre_id, od);
    }

    public static void main(String[] args) throws NewException, ClassNotFoundException, SQLException {

        System.out.println(LogicFacade.getOrderByOrderId(3));
        System.out.println(LogicFacade.getOrderByOrderId2(3));
//        LogicFacade.changeMaterialePris(7, 29.95);
//        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));
//
//        System.out.println(StykLinjeMapper.getStykLinje());
//
//        System.out.println(StykLinjeMapper.getStykLinjeById(2));

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
