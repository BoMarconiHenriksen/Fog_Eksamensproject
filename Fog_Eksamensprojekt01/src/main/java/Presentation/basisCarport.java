package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
import Domain.Ordre;
import Domain.Odetaljer;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class basisCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession(); //Skal bruges til user senere
        String SePris = request.getParameter("basisCarport");
        String CheckUd = request.getParameter("basisCarportCheckud");

        String GemDesign = request.getParameter("CarportGemDesign");

        int count;

        Ordre order = new Ordre();

//        User user = new User();
//        session.getAttribute("user");

        int user_id = 2;

        order.setUser_id(user_id);

        String ordre_status = null;

        request.setAttribute("userNr", user_id);
        
        double lentghinput = Double.parseDouble(request.getParameter("lentgChoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        double heightputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");
        DecimalFormat df = new DecimalFormat("#0.00");

        lentghinputskur = calculatePriceSetAttrubtes(lentghinputskur, widthinput, request, lentghinput, heightinput, df, widthinputskur, heightputskur, skurellerej);

        if (CheckUd != null) {

            ordre_status = "Ny ordre";

            placeOrderOdetailsSetAttributes(order, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, request, session);
   
            return "outprintpage";
        }

        if (GemDesign != null) {

            ordre_status = "Gemt Design";

            placeOrderOdetailsSetAttributes(order, user_id, ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur, request, session);

            return "index";

        }

        if (SePris != null) {
            return "bestilbasiscarportpage";

        } else {
            return "index";
        }
    }
/**
 * 
 * @param lentghinputskur
 * @param widthinput
 * @param request
 * @param lentghinput
 * @param heightinput
 * @param df
 * @param widthinputskur
 * @param heightputskur
 * @param skurellerej
 * @return
 * @throws NewException 
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
 * 
 * @param order
 * @param user_id
 * @param ordre_status
 * @param lentghinput
 * @param widthinput
 * @param heightinput
 * @param lentghinputskur
 * @param widthinputskur
 * @param request
 * @param session
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
