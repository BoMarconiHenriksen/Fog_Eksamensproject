package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
import Domain.Ordre;
import Domain.Odetaljer;
import Domain.User;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author The DataBuilders
 * This class is one of the commands. The execute method takes a bunch of parameters from 
 * the viewpage 'bestilbasiscarportpage' and then put them though various methods 
 * a calculator that calculates the price. The parameters is also used to place an order
 * and some odetails in the database. 
 */
public class basisCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        String SePris = request.getParameter("basisCarport");
        String CheckUd = request.getParameter("basisCarportCheckud");

        String GemDesign = request.getParameter("CarportGemDesign");

        Ordre order = new Ordre();

//        User user = new User();
//        session.getAttribute("user");

        int user_id = user.getUser_id();

        order.setUser_id(user_id);
        session.setAttribute("userNr", user_id);

        String ordre_status = null;


      //  request.setAttribute("userNr", user_id);

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));

        request.setAttribute("userNr", user_id);

        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        double heightputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");
        DecimalFormat df = new DecimalFormat("#0.00");

        lentghinputskur = calculatePriceSetAttrubtes(lentghinputskur, widthinput, request, lentghinput, heightinput, df, widthinputskur, heightputskur, skurellerej);

        if (CheckUd != null) {

            ordre_status = "Ordren afventer k-bekræftigelse";

            placeOrderOdetailsSetAttributes(order, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, request, session);
   
            return "outprintpage";
        }

        if (GemDesign != null) {

            ordre_status = "Gemt Design";

            placeOrderOdetailsSetAttributes(order, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, request, session);

            return "Kundepage";

        }

        if (SePris != null) {
            return "bestilbasiscarportpage";

        } else {
            return "index";
        }
    }
/**
 * This method makes sure the shed can be placed under the carport roof with regards
 * to shed length and carportwidth.  it also uses the calculator and skurcalculator to 
 * se a price for the carport with shed. 
 * @param lentghinputskur chosen length of shed
 * @param widthinput chosen width of carport
 * @param request servlet request to get the input
 * @param lentghinput chosen length of carport
 * @param heightinput heigth of carport (not a choice)
 * @param df decimalformatter
 * @param widthinputskur chosen width of shed
 * @param heightputskur height of shed (not a choice)
 * @param skurellerej shed or no shed
 * @param ditSkurErForLangt returns a message to the customer that the shed length 
 * has been set to 30 cm lesser than the width of the carport
 * @return lengthinput shed. If the shed is to big for the carport then a new shed length is set
 * @throws NewException an exception thrown back in the mappers. we will deal 
 * with it in the FrontController servlet
 */
    private double calculatePriceSetAttrubtes(double lentghinputskur, double widthinput, HttpServletRequest request, double lentghinput, double heightinput, DecimalFormat df, double widthinputskur, double heightputskur, String skurellerej) throws NewException {
        int count;
        // denne skulle gerne gÃ¸re at skuret ikke bliver for langt samt at kunden
        //fÃ¥r at vide at skurlÃ¦ngden er rettet til
        if (lentghinputskur > widthinput - 30) {
            count = 1;

            String ditSkurErForLangt = "Det valgte redskabsrum er for langt i forhold til carporten."
                    + "Vi har sat lÃ¦ngden af Deres redskabsrum til at vÃ¦re 30 cm mindre end den valgte carport."
                    + "hvis De Ã¸nsker en speciel carport bedes De venligst kontakte os pÃ¥ tlf nr. xxxxxx";
            request.setAttribute("ditSkurErForLangt", ditSkurErForLangt);
            lentghinputskur = widthinput - 30;

        } else {
            count = 0;
        }
        request.setAttribute("count", count);
        Calculator calc = new Calculator();
        double carportTotaludenSkur = calc.calculateCarportSimple(lentghinput, widthinput, heightinput);
        String carportTotalDecimaledudenSkur = df.format(carportTotaludenSkur);
        request.setAttribute("carportTotaludenSkur", carportTotalDecimaledudenSkur);
        //Skuret 
        SkurCalculator calcskur = new SkurCalculator();
        double skurTotaludenCarport = calcskur.skurPrisBeregner(lentghinputskur, widthinputskur);
        String carportTotalDecimaledmedSkur = df.format(carportTotaludenSkur + skurTotaludenCarport);
        request.setAttribute("carportTotalmedSkur", carportTotalDecimaledmedSkur);
        request.setAttribute("lentghInputSkuret", (Double) lentghinputskur);
        request.setAttribute("widthInputSkuret", (Double) widthinputskur);
        request.setAttribute("heightInputSkuret", (Double) heightputskur);
        request.setAttribute("lentghInput", (Double) lentghinput);
        request.setAttribute("widthInput", (Double) widthinput);
        request.setAttribute("heightInput", (Double) heightinput);
        request.setAttribute("skurInput", skurellerej);
        return lentghinputskur;
    }
/**
 * This method places an order and orderdetails in the database and set som attributes
 * @param order make an instance of an order object
 * @param user_id the unique id of the user who is currently logged in 
 * @param ordre_status the status of the order
 * @param lentghinput parameter from the userinterface requested in the method 'execute'
 * @param widthinput parameter from the userinterface requested in the method 'execute'
 * @param heightinput parameter from the userinterface requested in the method 'execute'
 * @param lentghinputskur  parameter from the userinterface requested in the method 'execute'
 * @param widthinputskur parameter from the userinterface requested in the method 'execute'
 * @param request  to call parameters and set attributes in http.servlet request and response
 * @param session to call parameters like 'user' that are stored in session in login
 * @throws NewException 
 */
    private void placeOrderOdetailsSetAttributes(Ordre order, int user_id, String ordre_status, double lentghinput, double widthinput, double heightinput, double lentghinputskur, double widthinputskur, HttpServletRequest request, HttpSession session) throws NewException {
        LocalDate today = LocalDate.now();
        //Kalder dateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //SÃ¦tter Stringen til d.d.
        String formatDateTime = today.format(formatter);
        
        //SÃ¦tter datoen pÃ¥ ordren
        order.setReciveddate(formatDateTime);
        
        LogicFacade.placeAnOrder(user_id, formatDateTime);
        int or = LogicFacade.getLastInvoiceId();
        Odetaljer ods = new Odetaljer(or, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur);
        LogicFacade.updatereOdetajlermedSkur(or, ods);
        LogicFacade.getOrderByOrderId2(or);
        
        request.setAttribute("length", (Double) ods.getCarportLength());
        request.setAttribute("width", (Double) ods.getCarportWidth());
        request.setAttribute("height", (Double) ods.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) ods.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) ods.getWidthRedskabsrum());
        request.setAttribute("od", ods);
        
        request.setAttribute("KundensOID", or);
        session.setAttribute("SessionIOD", or);
    }
}
