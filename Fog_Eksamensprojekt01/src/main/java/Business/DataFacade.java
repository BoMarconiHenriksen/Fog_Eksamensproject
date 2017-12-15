package Business;

import Data.MaterialeMapper;
import Data.OrdreMapper;
import Data.OdetaljeMapper;
import Data.UserMapper;
import Business.Domain.Materiale;
import Business.Domain.Ordre;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Business.Exception.NewException;
import java.util.List;

/**
 * Formålet med DataFacade er at lave en enkel klasse hvorigennem man kan tilgå 
 * de forskellige datamppereres metode, og skabe et ekstra lag af sikkerhed i 
 * systemet. For at se beskrivelsen af hver enkel metode se i den pågældende
 * mapper. 
 * Den er en facade mellem business/logik lag og datalaget
 *
 */
public class DataFacade {

//////////////////////////////OrdreMapperMetoder////////////////////////////////////////

    /**
     *
     * @param user_id
     * @param receiveddate
     * @throws NewException
     */
    public static void placeAnOrder(int user_id, String receiveddate) throws NewException {
        Ordre theOrdered = new Ordre(user_id, receiveddate);
        OrdreMapper.addOrdertoOrderList(theOrdered);
    }

    /**
     *
     * @return
     * @throws NewException
     */
    public static List<Ordre> getOrderList() throws NewException {
        return OrdreMapper.getOrderList();
    }

    /**
     *
     * @return
     * @throws NewException
     */
    public static List<User> getUserList() throws NewException {
        return UserMapper.getUserList();
    }

    /**
     *
     * @param ordre_id
     * @return
     * @throws NewException
     */
    public static Ordre getOrdreByOrderId(int ordre_id) throws NewException {
        return OrdreMapper.getOrdreByOrdreId(ordre_id);
    }

    /**
     *
     * @return
     * @throws NewException
     */
    public static int getLastInvoiceId() throws NewException {
        return OrdreMapper.getLastInvoiceId();
    }

    /**
     *
     * @param user_id
     * @return
     * @throws NewException
     */
    public static List<Ordre> getOrderListByUserId(int user_id) throws NewException {
        return OrdreMapper.getOrderListByUserID(user_id);
    }

    /**
     *
     * @param order_id
     * @throws NewException
     */
    public static void deleteOrderListByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderListByOrderID(order_id);
    }

    /**
     *
     * @param order_id
     * @throws NewException
     */
    public static void deleteOrderDetailsByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderDetailsByOrderID(order_id);
    }

    //////////////////////////////OdetaljeMapperMetoder////////////////////////////////////////   

    /**
     *
     * @param ordre_id
     * @param ods
     * @throws NewException
     */
    public static void AddOdetailstoOrdermedSkur(int ordre_id, Odetaljer ods) throws NewException {
        OdetaljeMapper.AddOdetailstoOrdermedSkur(ordre_id, ods);
    }

    /**
     *
     * @param user_id
     * @param OdG
     * @throws NewException
     */
    public static void saveOdetajlertoDB(int user_id, Odetaljer OdG) throws NewException {
        OdetaljeMapper.saveOdetaljertoDesignGemning(user_id, OdG);
    }

    /**
     *
     * @param ordre_id
     * @param od
     * @throws NewException
     */
    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {
        OdetaljeMapper.addOdetaljertoOdetaljeListe(ordre_id, od);
    }

    /**
     *
     * @param order_id
     * @param ordre_status
     * @throws NewException
     */
    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {
        OdetaljeMapper.updateOrdreStatus(order_id, ordre_status);
    }

    /**
     *
     * @param user_id
     * @param password
     * @throws NewException
     */
    public static void updateUserPassword(int user_id, String password) throws NewException {
        UserMapper.updateUserPassword(user_id, password);
    }

    /**
     *
     * @param user_id
     * @param zip
     * @param email
     * @param password
     * @param role
     * @param firstname
     * @param lastname
     * @param address
     * @param tlfnummer
     * @throws NewException
     */
    public static void updateWholeUserButID(int user_id, int zip, String email, String password,
            String role, String firstname, String lastname, String address, int tlfnummer) throws NewException {

        UserMapper.updateWholeUserbutID(user_id, zip, email, password, role, firstname, lastname, address, tlfnummer);
    }

    /**
     *
     * @param ordre_id
     * @return
     * @throws NewException
     */
    public static Odetaljer getOdetaljerByOrderId(int ordre_id) throws NewException {
        return OdetaljeMapper.getOdetailsByOrderId(ordre_id);
    }

    /**
     *
     * @param ordre_id
     * @return
     * @throws NewException
     */
    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {
        return OdetaljeMapper.getOrderByOrderId2(ordre_id);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws NewException
     */
    public static User login(String email, String password) throws NewException {
        return UserMapper.login(email, password);
    }

    /**
     *
     * @param email
     * @param password
     * @param role
     * @param firstname
     * @param lastname
     * @param address
     * @param zipcode
     * @param tlfnummer
     * @return
     * @throws NewException
     */
    public static User createUser(String email, String password, String role,String firstname, String lastname, String address, int zipcode, int tlfnummer) throws NewException {
        User user = new User(email, password, role, firstname, lastname, address, zipcode, tlfnummer);
        UserMapper.createUser(user);
        return user;
    }

    //////////////////////////////MaterialeMapperMetoder////////////////////////////////////////  

    /**
     *
     * @param vareid
     * @param enhedspris
     * @return
     * @throws NewException
     */
    public static Materiale changeMaterialePris(int vareid, double enhedspris) throws NewException {
        Materiale mat = new Materiale(vareid, enhedspris);
        MaterialeMapper.changeMaterialePris(vareid, enhedspris);
        return mat;
    }

    /**
     *
     * @param varenummer
     * @return
     * @throws NewException
     */
    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {
        String materialetype = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialetype();
        String materialenavn = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialenavn();
        double enhedspris = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhedspris();
        String enhed = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhed();
        double msr = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMsr();
        Materiale mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
        return mat;
    }

    /**
     *
     * @return
     * @throws NewException
     */
    public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();
    }

    //////////////////////////////UserMapperMetoder////////////////////////////////////////  

    /**
     *
     * @param user_id
     * @return
     * @throws NewException
     */
    public static User getUserByUserId(int user_id) throws NewException {
        return UserMapper.getUserByUserId(user_id);
    }

    /**
     *
     * @param args
     * @throws NewException
     */
    public static void main(String[] args) throws NewException {

        System.out.println(DataFacade.getOdetaljerByOrderId(3));
        System.out.println(DataFacade.getOrderByOrderId2(3));
//        DataFacade.changeMaterialePris(7, 29.95);
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
