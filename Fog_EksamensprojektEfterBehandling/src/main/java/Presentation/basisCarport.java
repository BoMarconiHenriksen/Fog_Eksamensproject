package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Ordre;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Presentation.Utillities.RendSvg;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Denne klasse er en af commands'ne. Bruges på customer_order_carport.jsp, når
 * brugeren skal tjekke en pris på en carport, og trykker se pris. Brugeren
 * bliver henvist til samme jsp side igen, men med pris og tegning af den
 * carport som brugeren vil tjekke. Den bruges også når kunden skal gemme eller
 * bestile en carport. I det tilfælde bliver de oplysninger som kunden har
 * intastet behanldet lige som når man skal se en pris, men samtidigt sættes
 * nogle af oplysningerne også ned i databasen. og afhængig af om kunden vælger
 * at gemme eller bestile, så bliver vedkommende navigeret enten til
 * customerpage.jsp igen eller til customer_shopping_cart.jsp.
 */
public class basisCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String seePrice = request.getParameter("price");
        String checkOut = request.getParameter("order");
        String saveDesign = request.getParameter("save");
        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));
        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        double heightputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));
        String shedOrNoShed = request.getParameter("skur");

        Ordre order = new Ordre();
        String ordre_status = null;

        int user_id = user.getUser_id();
        order.setUser_id(user_id);

        session.setAttribute("userNr", user_id);
        double totalPrice = 0;

        if (checkOut != null) {

            ordre_status = "Gemt Design";
            totalPrice = calculatePriceSetAttrubtes(request, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, shedOrNoShed);
            placeOrderOdetailsSetAttributes(request, session, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, shedOrNoShed, totalPrice);

            return "customer_shopping_cart";
        }

        if (saveDesign != null) {

            ordre_status = "Gemt Design";
            totalPrice = calculatePriceSetAttrubtes(request, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, shedOrNoShed);
            placeOrderOdetailsSetAttributes(request, session, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, shedOrNoShed, totalPrice);

            return "customerpage";

        }

        if (seePrice != null) {

            calculatePriceSetAttrubtes(request, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, heightputskur, shedOrNoShed);

            return "customer_order_carport";

        } else {
            return "customerpage";
        }
    }

    /**
     * This method makes sure the shed can be placed under the carport roof with
     * regards to shed length and carportwidth. it also uses the calculator and
     * skurcalculator to set a price for the carport with shed.
     *
     * @param lentghinputskur chosen length of shed
     * @param widthinput chosen width of carport
     * @param request servlet request to get the input
     * @param lentghinput chosen length of carport
     * @param heightinput heigth of carport (not a choice)
     * @param df decimalformatter
     * @param widthinputskur chosen width of shed
     * @param heightputskur height of shed (not a choice)
     * @param skurellerej shed or no shed
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

            String yourShedsToBig = "Det valgte redskabsrum er for langt i forhold til carporten."
                    + "Vi har sat længden af Deres redskabsrum til at være 30 cm mindre end den valgte carport."
                    + "hvis De ønsker en speciel carport bedes De venligst kontakte os på tlf nr. xxxxxx";
            request.setAttribute("yourShedsToBig", yourShedsToBig);
            lentghinputskur = widthinput - 30;

        } else {
            count = 0;
        }
        request.setAttribute("count", count);

        DecimalFormat df = new DecimalFormat("#0.00");
        double carportNoShed = LogicFacade.calculateCarportSimple(lentghinput, widthinput, heightinput);
        String carportTotalDecimaledudenSkur = df.format(carportNoShed);
        request.setAttribute("carportTotaludenSkur", carportTotalDecimaledudenSkur);
        double totalPrice;
        //Skuret 
        if (heightputskur != 0.00) {
            double skurTotaludenCarport = LogicFacade.calculatePriceShed(lentghinputskur, widthinputskur);
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
        makeDrawingOfCarport(lentghinput, widthinput, lentghinputskur, widthinputskur, request);
        return totalPrice;
    }

    private void makeDrawingOfCarport(double lentghinput, double widthinput, double lentghinputskur, double widthinputskur, HttpServletRequest request) throws NewException {
        RendSvg RendSvg = new RendSvg();
        String carportTegning = RendSvg.simpelCarport(lentghinput, widthinput, lentghinputskur, widthinputskur);
        request.setAttribute("carportTegning", carportTegning);
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
     * @throws NewException
     */
    private void placeOrderOdetailsSetAttributes(HttpServletRequest request, HttpSession session, int user_id, String ordre_status, double lentghinput, double widthinput, double heightinput, double lentghinputskur, double widthinputskur, double heightputskur, String skurellerej, double totalPrice) throws NewException {

        LocalDate today = LocalDate.now();
        //Kalder dateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //SÃ¦tter Stringen til d.d.
        String formatDateTime = today.format(formatter);

        //Saetter datoen paa ordren
//        order.setReciveddate(formatDateTime);
        double priceTotal = totalPrice;
        LogicFacade.placeAnOrder(user_id, formatDateTime);
        int or = LogicFacade.getLastInvoiceId();
        request.setAttribute("KundensOID", or);
        session.setAttribute("SessionIOD", or);
        Odetaljer ods = new Odetaljer(or, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, priceTotal);
        LogicFacade.AddOdetailstoOrdermedSkur(or, ods);
        ods = LogicFacade.getOdetaljerByOrderId(or);

        request.setAttribute("length", (Double) ods.getCarportLength());
        request.setAttribute("width", (Double) ods.getCarportWidth());
        request.setAttribute("height", (Double) ods.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) ods.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) ods.getWidthRedskabsrum());
        request.setAttribute("od", ods);

    }

}
