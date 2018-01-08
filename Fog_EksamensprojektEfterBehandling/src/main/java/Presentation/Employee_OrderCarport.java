package Presentation;

import Business.Calculator;
import Business.DataFacade;
import Business.Exception.NewException;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import Presentation.Utillities.RendUtilUserList;
import Presentation.Utillities.RendSvg;
import Presentation.Utillities.RendUtilStykListe;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne class er en af commands'ne. Bruges på employee_ordercarportpage.jsp til
 * at tage imod en carport bestiling for en bestemt kunde og lægge ordren i
 * databasen samt - navigere medarbejderen hen til
 * employee_orderconfirmationpage.jsp
 *
 */
public class Employee_OrderCarport extends Command {

    /**
     * execute: Behandler den input fra employee_ordercarportpage.jsp som
     * brugeren intaster og vælger, og sender brugeren videre til
     * employee_orderconfirmationpage.jsp. på employee_orderconfirmationpage.jsp
     * udskrives så en bekræftigelse samt beregnede oplysninger på den valgte
     * carport og den valgte bruger som carporten er bestilt til.
     *
     * @param request
     * @param response
     * @return employee_ordercarportpage.jsp
     * @throws NewException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();

        String SePris = request.getParameter("Employee_OrderCarport");
        String CheckUd = request.getParameter("Employee_OrderCarportPlaceOrder");

        Ordre order = new Ordre();

        int user_id = Integer.parseInt(request.getParameter("kunde_id"));
        String ordre_status = null;

        // Nedenstående session metoder bliver ikke brugt og er slet ikke nødvendig. Ovenstående request fra RendUtilUserList -
        // er der hvor id'et hentes.
        order.setUser_id(user_id);
        session.setAttribute("userNr", user_id);
        request.setAttribute("kunde_ided", user_id);

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        double heightputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");

        double totalPrice = calculatePriceSetAttrubtes(request, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, skurellerej);

        if (CheckUd != null) {

            ordre_status = "Bestilt";

            placeOrderOdetailsSetAttributes(request, session, order, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, skurellerej, totalPrice);

            return "employee_orderconfirmationpage";
        }

        if (SePris != null) {

            calculatePriceSetAttrubtes(request, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, skurellerej);

            List<User> userList = DataFacade.getUserList();
            String userLists = RendUtilUserList.invoiceUserList(userList);
            request.setAttribute("userLists", userLists);

            return "employee_ordercarportpage";

        } else {
            return "employeepage";
        }
    }

    /**
     * This method makes sure the shed can be placed under the carport roof with
     * regards to shed length and carportwidth. it also uses the calculator and
     * skurcalculator to se a price for the carport with shed.
     *
     * @param lentghinputskur chosen length of shed
     * @param widthinput chosen width of carport
     * @param request servlet request to get the input
     * @param lentghinput chosen length of carport
     * @param heightinput heigth of carport (not a choice)
     * @param df decimalformatter
     * @param widthinputskur chosen width of shed
     * @param heightputskur height of shed (not a choice)
     * @param skurellerej shed orderId no shed
     * @param ditSkurErForLangt returns a message to the customer that the shed
     * length has been set to 30 cm lesser than the width of the carport
     * @return lengthinput shed. If the shed is to big for the carport then a
     * new shed length is set
     * @throws NewException an exception thrown back in the mappers. we will
     * deal with it in the FrontController servlet
     */
    private double calculatePriceSetAttrubtes(HttpServletRequest request, double lentghinput, double widthinput, double heightinput, double lentghinputskur, double widthinputskur, double heightputskur, String skurellerej) throws NewException {

        int count;
        // denne skulle gerne gÃ¸re at skuret ikke bliver for langt samt at kunden
        //fÃ¥r at vide at skurlÃ¦ngden er rettet til
        if (lentghinputskur > widthinput - 30) {
            count = 1;

            String ditSkurErForLangt = "Det valgte redskabsrum er for langt i forhold til carporten."
                    + "Vi har sat længden af Deres redskabsrum til at være 30 cm mindre end den valgte carport."
                    + "hvis De ønsker en speciel carport bedes De venligst kontakte os på tlf nr. xxxxxx";
            request.setAttribute("ditSkurErForLangt", ditSkurErForLangt);
            lentghinputskur = widthinput - 30;

        } else {
            count = 0;
        }
        request.setAttribute("count", count);

        DecimalFormat df = new DecimalFormat("#0.00");
        Calculator calc = new Calculator();
        double carportNoShed = calc.calculateCarportSimple(lentghinput, widthinput, heightinput);
        String carportTotalDecimaledudenSkur = df.format(carportNoShed);
        request.setAttribute("carportTotaludenSkur", carportTotalDecimaledudenSkur);
        double totalPrice;
        //Skuret 
        if (heightputskur != 0.00) {
            double skurTotaludenCarport = calc.calculatePriceShed(lentghinputskur, widthinputskur);
            totalPrice = carportNoShed + skurTotaludenCarport;

        } else {
            totalPrice = carportNoShed;
        }

        String totalPriceDF = df.format(totalPrice);
        request.setAttribute("carportTotal", (String) totalPriceDF);
        request.setAttribute("lentghInputSkuret", (Double) lentghinputskur);
        request.setAttribute("widthInputSkuret", (Double) widthinputskur);
        request.setAttribute("heightInputSkuret", (Double) heightputskur);
        request.setAttribute("lentghInput", (Double) lentghinput);
        request.setAttribute("widthInput", (Double) widthinput);
        request.setAttribute("heightInput", (Double) heightinput);
        request.setAttribute("skurInput", (String) skurellerej);

        RendSvg svag = new RendSvg();
        String carportTegning = svag.simpelCarport(lentghinput, widthinput, lentghinputskur, widthinputskur);
        request.setAttribute("carportTegning", carportTegning);

        RendUtilStykListe styk = new RendUtilStykListe();
        String stykListe = styk.createLineItemList(lentghinput, widthinput, lentghinputskur, widthinputskur);
        request.setAttribute("stykListe", stykListe);
        return totalPrice;
    }

    /**
     * This method places an order and orderdetails in the database and set som
     * attributes
     *
     * @param order make an instance of an order object
     * @param user_id the unique id of the user who is currently logged in
     * @param ordre_status the status of the order
     * @param lentghinput parameter from the userinterface requested in the
     * method 'execute'
     * @param widthinput parameter from the userinterface requested in the
     * method 'execute'
     * @param heightinput parameter from the userinterface requested in the
     * method 'execute'
     * @param lentghinputskur parameter from the userinterface requested in the
     * method 'execute'
     * @param widthinputskur parameter from the userinterface requested in the
     * method 'execute'
     * @param request to call parameters and set attributes in http.servlet
     * request and response
     * @param session to call parameters like 'user' that are stored in session
     * in login
     * @throws NewException Ved fejl.
     */
    private void placeOrderOdetailsSetAttributes(HttpServletRequest request, HttpSession session, Ordre order, int user_id, String ordre_status, double lentghinput, double widthinput, double heightinput, double lentghinputskur, double widthinputskur, double heightputskur, String skurellerej, double totalPrice) throws NewException {

        LocalDate today = LocalDate.now();
        //Kalder dateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //Sætter Stringen til d.d.
        String formatDateTime = today.format(formatter);

        //Sætter datoen på ordren
        order.setReciveddate(formatDateTime);
        double priceTotal = totalPrice;
        DataFacade.placeAnOrder(user_id, formatDateTime);
        int orderId = DataFacade.getLastInvoiceId();
        
        // Total ubruglig session gemning, da medarbejder bestilling ikke foregår over flere sidder, lige som når kunden bestiller.
        request.setAttribute("KundensOID", orderId);
        session.setAttribute("SessionIOD", orderId);
        Odetaljer oDetaljer = new Odetaljer(orderId, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, priceTotal);
        DataFacade.AddOdetailstoOrdermedSkur(orderId, oDetaljer);
        DataFacade.getOdetaljerByOrderId(orderId);

        oDetaljer = DataFacade.getOdetaljerByOrderId(orderId);
        request.setAttribute("length", (Double) oDetaljer.getCarportLength());
        request.setAttribute("width", (Double) oDetaljer.getCarportWidth());
        request.setAttribute("height", (Double) oDetaljer.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) oDetaljer.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) oDetaljer.getWidthRedskabsrum());
        request.setAttribute("od", oDetaljer);

    }

}
