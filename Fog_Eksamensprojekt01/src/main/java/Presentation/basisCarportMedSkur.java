/*
 
 */
package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
import Domain.LineItem;
import Utillities.RendUtilStykListe;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 **  Denne klasse som er en extension af command klassen henter brugerens valgte 
 * carport og skurmål fra basiscarportmedskurpage.jsp og sender disse mål
 *  gennem en calculator der returnerer en totalPris for carport og skur
 * hvis der er en pris sendes man tilbage til der hvor parameterene kom fra ellers 
 * til en side der hedder outprinpage.jsp hvor man får en liste af materialer. 
 */
public class basisCarportMedSkur extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();

        String checkprice = request.getParameter("basisCarportmedSkur");

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
        //  double heightinputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");
        String trevalg = request.getParameter("kundetrevalg");
        DecimalFormat df = new DecimalFormat("#0.00");

        //Carporten
        Calculator calc = new Calculator();
        double length = lentghinput / 100;
        double width = widthinput / 100;
        double height = heightinput / 100;
        double carportTotaludenSkur = calc.calculateCarportSimple(length, width, height);

        //Skuret 
        SkurCalculator calcskur = new SkurCalculator();

        double lengthskur = lentghinputskur / 100;
        double widthskur = widthinputskur / 100;
        double skurTotaludenCarport = calcskur.skurPrisBeregner(lengthskur, widthskur);

        String carportTotalDecimaled = df.format(carportTotaludenSkur + skurTotaludenCarport);
        request.setAttribute("carportTotal", carportTotalDecimaled);

        session.setAttribute("carportTotalValg", carportTotalDecimaled);

        //Carporten
        request.setAttribute("lentghInput", lentghinput);
        request.setAttribute("widthInput", widthinput);
        request.setAttribute("heightInput", heightinput);

        //Skuret
        request.setAttribute("lentghInputSkur", lentghinputskur);
        request.setAttribute("widthInputSkur", widthinputskur);

        request.setAttribute("trevalgInput", trevalg);

        //Her er starten på en stykliste
        List<LineItem> stykLinjeListe = LogicFacade.getLineItem();
        RendUtilStykListe rusl = new RendUtilStykListe();
        String tjavs = rusl.getStykListeUdenSkur(stykLinjeListe, length, width);
        request.setAttribute("tjavs", tjavs);

        if (checkprice != null) {
            return "basiscarportmedskurpage";
        }

        if (checkprice == null) {
            return "outprintpage";

        } else {

            return null;
        }

    }
}
