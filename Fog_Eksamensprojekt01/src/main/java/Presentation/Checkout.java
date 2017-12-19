package Presentation;

import Business.Exception.NewException;
import Business.DataFacade;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Presentation.Utillities.XXRendSvg;
import Presentation.Utillities.XXRendUtilStykListe;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class Checkout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("userNr", user.getUser_id());
        int or;
        if (request.getParameter("basisCarport") != null) {
            or = (int) (session.getAttribute("SessionIOD"));
        } else {
            or = Integer.parseInt(request.getParameter("id"));
        }

        LogicFacade.getOrderByOrderId2(or);
        Odetaljer od = LogicFacade.getOdetaljerByOrderId(or);
        String status = od.getOrdreStatus();
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(od.getCarportLength(), od.getCarportWidth(), od.getLengthRedskabsrum(), od.getWidthRedskabsrum());
        request.setAttribute("carportTegning", carportTegning);

        XXRendUtilStykListe styk = new XXRendUtilStykListe();

        String stykListe = styk.createLineItemList(od.getCarportLength(), od.getCarportWidth(), od.getLengthRedskabsrum(), od.getWidthRedskabsrum());
        request.setAttribute("stykListe", stykListe);
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
