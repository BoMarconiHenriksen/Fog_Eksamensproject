package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
import Domain.Ordre;
import Domain.User;
import Domain.Odetaljer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

        HttpSession session = request.getSession();
        String SePris = request.getParameter("basisCarport");
        String CheckUd = request.getParameter("basisCarportCheckud");

        String GemDesign = request.getParameter("CarportGemDesign");

        int count;

        Ordre order = new Ordre();

//        User user = new User();
//        session.getAttribute("user");
        int user_id = 4;
        order.setUser_id(user_id);

        String ordre_status = null;

        request.setAttribute("userNr", user_id);

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        double heightputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");
        String trevalg = request.getParameter("kundetrevalg");
        DecimalFormat df = new DecimalFormat("#0.00");

        // denne skulle gerne gøre at skuret ikke bliver for langt samt at kunden 
        //får at vide at skurlængden er rettet til
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
        Calculator calc = new Calculator();

        double carportTotaludenSkur = calc.calculateCarportSimple(lentghinput, widthinput, heightinput);
        String carportTotalDecimaledudenSkur = df.format(carportTotaludenSkur);
        request.setAttribute("carportTotaludenSkur", carportTotalDecimaledudenSkur);

        //Skuret 
        //  if (lentghinputskur != 0){
        SkurCalculator calcskur = new SkurCalculator();

        double skurTotaludenCarport = calcskur.skurPrisBeregner(lentghinputskur, widthinputskur);

        String carportTotalDecimaledmedSkur = df.format(carportTotaludenSkur + skurTotaludenCarport);
        request.setAttribute("carportTotalmedSkur", carportTotalDecimaledmedSkur);

        request.setAttribute("lentghInputSkuret", (Double) lentghinputskur);
        request.setAttribute("widthInputSkuret", (Double) widthinputskur);
        request.setAttribute("heightInputSkuret", (Double) heightputskur);
        //   }
        request.setAttribute("lentghInput", (Double) lentghinput);
        request.setAttribute("widthInput", (Double) widthinput);
        request.setAttribute("heightInput", (Double) heightinput);

        request.setAttribute("skurInput", skurellerej);

        if (CheckUd != null) {

            ordre_status = "Ny Ordre";

            LocalDate today = LocalDate.now();
            //Kalder dateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //Sætter Stringen til d.d.
            String formatDateTime = today.format(formatter);

            //Sætter datoen på ordren
            order.setReciveddate(formatDateTime);

            LogicFacade.placeAnOrder(user_id, formatDateTime);
            int or = LogicFacade.getOrderList().size();
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

            return "outprintpage";
        }

        if (GemDesign != null) {

            ordre_status = "Ordren er gemt i din Kurv.";

            Odetaljer OdG = new Odetaljer(ordre_status, lentghinput, widthinput, heightinput, lentghinputskur, widthinputskur);
            LogicFacade.saveOdetajlertoDB(user_id, OdG);

            return "index";

        }

        if (SePris != null) {
            return "bestilbasiscarportpage";

        } else {
            return "index";
        }
    }
}
