package Business;


import Data.MaterialeMapper;
import Data.OrdreMapper;
import Data.OdetaljeMapper;
import Data.UserMapper;
import Domain.Materiale;
import Domain.Ordre;
import Domain.Odetaljer;
import Domain.User;
import Domain.Exception.NewException;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * Author @ BenedikteEva
 */
public class LogicFacade {

//////////////////////////////OrdreMapperMetoder////////////////////////////////////////

    public static Ordre placeAnOrder(int user_id, String receiveddate) throws NewException {
        Ordre theOrdered = new Ordre(user_id, receiveddate);
        OrdreMapper.addOrdertoOrderList(theOrdered);
        return theOrdered;
    }

    public static List<Ordre> getOrderList() throws NewException {
        return OrdreMapper.getOrderList();
    }

    public static Ordre getOrdreByOrderId(int ordre_id) throws NewException {
        return OrdreMapper.getOrdreByOrdreId(ordre_id);
    }

    public static int getLastInvoiceId() throws NewException {
        return OrdreMapper.getLastInvoiceId();
    }
  
   public static List<Ordre> getOrderListByUserId(int user_id) throws NewException {
        return OrdreMapper.getOrderListByUserID(user_id);
    }

    public static void deleteOrderListByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderListByOrderID(order_id);
    }

    public static void deleteOrderDetailsByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderDetailsByOrderID(order_id);
    }


    //////////////////////////////OdetaljeMapperMetoder////////////////////////////////////////   
    public static void updatereOdetajlermedSkur(int ordre_id, Odetaljer ods)
            throws NewException {
        OdetaljeMapper.AddOdetailstoOrdermedSkur(ordre_id, ods);
    }

    public static void saveOdetajlertoDB(int user_id, Odetaljer OdG)  throws NewException {
        OdetaljeMapper.saveOdetaljertoDesignGemning(user_id, OdG);
    }

    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {
        OdetaljeMapper.addOdetaljertoOdetaljeListe(ordre_id, od);
    }

    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {

        OdetaljeMapper.updateOrdreStatus(order_id, ordre_status);
    }
       public static Odetaljer getOdetaljerByOrderId(int ordre_id) throws NewException {
        return OdetaljeMapper.getOdetailsByOrderId(ordre_id);
    }

    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {
        return OdetaljeMapper.getOrderByOrderId2(ordre_id);
    }

    public static User login( String email, String password) throws NewException {
        return UserMapper.login( email, password );
    } 

    public static User createUser(String email, String password, String firstname, String lastname, String address, int zipcode, int tlfnummer) throws NewException {
        User user = new User(email, password, "Kunde", firstname, lastname, address, zipcode, tlfnummer);
        UserMapper.createUser( user );
        return user;
    }
 
 
      //////////////////////////////MaterialeMapperMetoder////////////////////////////////////////  


   
    public static Materiale changeMaterialePris(int vareid, double enhedspris) throws NewException {
        Materiale mat = new Materiale(vareid, enhedspris);
        MaterialeMapper.changeMaterialePris(vareid, enhedspris);
        return mat;
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
      public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();

    }
 
     
       //////////////////////////////UserMapperMetoder////////////////////////////////////////  

    public static User getUserByUserId(int user_id) throws NewException {
        return UserMapper.getUserByUserId(user_id);
    }
       
   

    
   


    public static void main(String[] args) throws NewException{

        System.out.println(LogicFacade.getOdetaljerByOrderId(3));
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
