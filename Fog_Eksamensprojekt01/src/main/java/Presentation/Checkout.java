package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Presentation.Utillities.RendSvg;
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
        Odetaljer oDetaljer = LogicFacade.getOdetaljerByOrderId(or);
        String status = oDetaljer.getOrdreStatus();
        RendSvg svag = new RendSvg();
        String carportTegning = svag.simpelCarport(oDetaljer.getCarportLength(), oDetaljer.getCarportWidth(), oDetaljer.getLengthRedskabsrum(), oDetaljer.getWidthRedskabsrum());
        request.setAttribute("carportTegning", carportTegning);

        request.setAttribute("length", (Double) oDetaljer.getCarportLength());
        request.setAttribute("width", (Double) oDetaljer.getCarportWidth());
        request.setAttribute("height", (Double) oDetaljer.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) oDetaljer.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) oDetaljer.getWidthRedskabsrum());
        request.setAttribute("price", (Double) oDetaljer.getPrice());
        request.setAttribute("od", oDetaljer);
        request.setAttribute("status", status);

        status = "Ny ordre";

        LogicFacade.updateOrdreStatus(or, status);

        return "customer_confirmationpage";
    }
}
