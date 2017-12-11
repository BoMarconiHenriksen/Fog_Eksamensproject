package Presentation;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.User;
import Utillities.XXRendSvg;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */
public class Checkout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("userNr", user.getUser_id());

        int or = (int) (session.getAttribute("SessionIOD"));

        LogicFacade.getOrderByOrderId2(or);
        Odetaljer od = LogicFacade.getOdetaljerByOrderId(or);
        String status = od.getOrdreStatus();
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(od.getCarportLength(), od.getCarportWidth(), od.getLengthRedskabsrum(), od.getWidthRedskabsrum());
        request.setAttribute("carportTegning", carportTegning);

        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("price", (Double) od.getPrice());
        request.setAttribute("od", od);
        request.setAttribute("status", status);

        status = "Ny ordre";

        LogicFacade.updateOrdreStatus(or, status);

        return "customer_confirmationpage";
    }
}
