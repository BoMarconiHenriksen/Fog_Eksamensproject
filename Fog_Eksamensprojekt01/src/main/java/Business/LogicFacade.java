package Business;

import Business.Exception.NewException;
import Business.Domain.LineItem;
import Business.Domain.Materiale;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import java.util.List;

/**
 *Formålet med LogicFacade er at skabe en facade mellem presentationslaget
 * og business/logic laget for at samle alle de metoder der bliver kaldt fra
 * præsentationslaget i en grænseflade. Javadoc for de enkelte metoder er beskrevet
 * nærmere i de klasser de kommer fra. 
 */
public class LogicFacade {

    ////////////////Kalder metoder i DataFacaden////////////////


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
    
    public static void updateWholeUserButID(int user_id, int zip, String email, String password,
            String role, String firstname, String lastname, String address, int tlfnummer) throws NewException {

        DataFacade.updateWholeUserButID(user_id, zip, email, password, role, firstname, lastname, address, tlfnummer);
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
    
    public static void createUser(String email, String password,  String role, String firstname, String lastname, String address, int zipcode, int tlfnummer) throws NewException {
        DataFacade.createUser(email, password, role, firstname, lastname, address, zipcode, tlfnummer);
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
    
    //Bruges ikke pt, men skal bruges ved optimering af getMaterialByVarenummer()
    public static List<Materiale> getMaterial() throws NewException {
        return DataFacade.getMaterial();
    }
    
    ////////////////Kalder metoder i Domain////////////////

    public static int getUser_Id(User user) {
        return user.getUser_id();
    }
    
    public static void updateWholeUserButID(int userId, int zipcode, String email, String password, String firstname, String lastname, String address, int phone) throws NewException {
    DataFacade.updateWholeUserButID(userId, zipcode, email, password, email, firstname, lastname, address, phone);
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
