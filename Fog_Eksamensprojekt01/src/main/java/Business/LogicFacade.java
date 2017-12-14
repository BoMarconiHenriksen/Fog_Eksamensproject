package Business;

import static Business.Calculator.numberOfRafters;
import static Business.Calculator.spaceBetweenRafters;
import static Business.LogicFacade.spaceBetweenRafters;
import Domain.Exception.NewException;
import Domain.LineItem;
import Domain.Materiale;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList;
import Utillities.RendUtilOrderList_Customer;
import Utillities.RendUtilUserlist_FullDiscription;
import Utillities.XXRendSvg;
import java.util.List;

/**
 *
 */
public class LogicFacade {

    ////////////////Kalder metoder i DataFacaden////////////////
    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {
        return DataFacade.getOrderByOrderId2(ordre_id);
    }

    public static Odetaljer getOdetaljerByOrderId(int ordre_id) throws NewException {
        return DataFacade.getOdetaljerByOrderId(ordre_id);
    }

    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {
        DataFacade.updateOrdreStatus(order_id, ordre_status);
    }

    public static User getUserByUserId(int user_id) throws NewException {
        return DataFacade.getUserByUserId(user_id);
    }

    public static void updateUserPassword(int user_id, String password) throws NewException {
        DataFacade.updateUserPassword(user_id, password);
    }

    public static void deleteOrderDetailsByUserId(int order_id) throws NewException {
        DataFacade.deleteOrderDetailsByUserId(order_id);
    }

    public static void deleteOrderListByUserId(int order_id) throws NewException {
        DataFacade.deleteOrderListByUserId(order_id);
    }

    public static List<Ordre> getOrderListByUserId(int user_id) throws NewException {
        return DataFacade.getOrderListByUserId(user_id);
    }
    
    public static User login( String email, String password) throws NewException {
        return DataFacade.login(email, password);
    }
    
    public static List<User> getUserList() throws NewException {
        return DataFacade.getUserList();
    }
    
    public static List<Ordre> getOrderList() throws NewException {
        return DataFacade.getOrderList();
    }
    
    public static void createUser(String email, String password, String firstname, String lastname, String address, int zipcode, int tlfnummer) throws NewException {
        DataFacade.createUser(email, password, firstname, lastname, address, zipcode, tlfnummer);
    }
    
    public static void placeAnOrder(int user_id, String receiveddate) throws NewException {
        DataFacade.placeAnOrder(user_id, receiveddate);
    }
    
    public static int getLastInvoiceId() throws NewException {
        return DataFacade.getLastInvoiceId(); 
    }
    
    public static void AddOdetailstoOrdermedSkur(int ordre_id, Odetaljer ods) throws NewException {
        DataFacade.AddOdetailstoOrdermedSkur(ordre_id, ods); 
    }
    
    public static Ordre getOrdreByOrderId(int ordre_id) throws NewException {
        return DataFacade.getOrdreByOrderId(ordre_id);
    }
    
    public static List<Materiale> getMaterial() throws NewException {
        return DataFacade.getMaterial();
    }
    
    ////////////////Kalder metoder i Domain////////////////
    public static int getUser_Id(User user) {
        return user.getUser_id();
    }
    
    ////////////////Kalder metoder i Calculator////////////////
    public static double calculateCarportSimple(double lentghinput, double widthinput, double heightinput) throws NewException {
        return Calculator.calculateCarportSimple(lentghinput, widthinput, heightinput);
    }
    
    public static double calculatePriceShed(double lentghinputskur, double widthinputskur)throws NewException {
        return Calculator.calculatePriceShed(widthinputskur, widthinputskur);
    }
    
    public static int numberOfRafters(double length) throws NewException {
        return Calculator.numberOfRafters(length);
    }
    
    public static int spaceBetweenRafters(double length) throws NewException {
        return (int) Calculator.spaceBetweenRafters(length);
    }
    
    
    ////////////////Kalder metoder i LineItemFactory////////////////
    public static LineItem[] baseWood(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne
        return LineItemFactory.baseWood(width, length);
    }
    
    public static LineItem[] ecoliteRoof(double width, double length) throws NewException {
        return LineItemFactory.ecoliteRoof(width, length);
    }
    
    public static LineItem[] screwsAndBracketShed(double skurLængde, double skurBredde) throws NewException {
        return LineItemFactory.screwsAndBracketShed(skurLængde, skurBredde);
    }
    
    public static LineItem[] woodForShed(double skurLængde, double skurBredde) throws NewException {
        return LineItemFactory.woodForShed(skurLængde, skurBredde);
    }
    
     public static LineItem[] carportBaseMetal(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne
        return LineItemFactory.carportBaseMetal(width, length);
    }
    

}
