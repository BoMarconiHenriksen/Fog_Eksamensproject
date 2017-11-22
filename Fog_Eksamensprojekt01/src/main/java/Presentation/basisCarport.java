
package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Domain.Ordre;
import Domain.User;
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

        Ordre order = new Ordre(1);
//        User user = new User();
//        session.getAttribute("user");

        int user_id = 1;
        order.setUser_id(user_id);

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        String skurellerej = request.getParameter("skur");
        String trevalg = request.getParameter("kundetrevalg");
        DecimalFormat df = new DecimalFormat("#0.00");

        Calculator calc = new Calculator();
        double length = Double.parseDouble(request.getParameter("lentgchoice")) / 100;
        double width = Double.parseDouble(request.getParameter("widthchoice")) / 100;
        double height = Double.parseDouble(request.getParameter("heightchoice")) / 100;
        double carportTotal = calc.calculateCarportSimple(length, width, height);
        String carportTotalDecimaled = df.format(carportTotal);
        request.setAttribute("carportTotal", carportTotalDecimaled);

        session.setAttribute("carportTotalValg", carportTotalDecimaled);

        request.setAttribute("lentghInput", lentghinput);
        request.setAttribute("widthInput", widthinput);
        request.setAttribute("heightInput", heightinput);

        session.setAttribute("lentghChosen", lentghinput);
        session.setAttribute("widthChosen", widthinput);
        session.setAttribute("heightChosen", heightinput);

        request.setAttribute("skurInput", skurellerej);
        request.setAttribute("trevalgInput", trevalg);

        //Laver timestamp af d.d.
        LocalDate today = LocalDate.now();
        //Kalder dateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //Sætter Stringen til d.d.
        String formatDateTime = today.format(formatter);

        //Sætter datoen på ordren
        order.setReciveddate(formatDateTime);

        LogicFacade.placeAnOrder(user_id, formatDateTime);

        //   List<Order> custOrderList = LogicFacade.getOrderList();
        return "bestilbasiscarportpage";
    }
}
