package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Presentation.Utillities.RendSvg;
import Presentation.Utillities.RendUtilStykListe;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne class er en af commands'ne.
 * Bruges på customer_shopping_cart.jsp, hvor kunden skal bekræfte om ordren
 * skal bestiles. Når kunden trykker "Bestil ordren of afvent svar snarest", så
 * ændres ordre statusen på kundens ordre til "Ny ordre".
 *
 */
public class Checkout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("userNr", user.getUser_id());
        int ordreId;
        if (request.getParameter("basisCarport") != null) {
            ordreId = (int) (session.getAttribute("SessionIOD"));
        } else {
            ordreId = Integer.parseInt(request.getParameter("id"));
        }

        LogicFacade.getOrdreByOrderId(ordreId);
        Odetaljer oDetaljer = LogicFacade.getOdetaljerByOrderId(ordreId);
        String status = oDetaljer.getOrdreStatus();
        RendSvg svag = new RendSvg();
        String carportTegning = svag.simpelCarport(oDetaljer.getCarportLength(), oDetaljer.getCarportWidth(), oDetaljer.getLengthRedskabsrum(), oDetaljer.getWidthRedskabsrum());
        request.setAttribute("carportTegning", carportTegning);

        RendUtilStykListe styk = new RendUtilStykListe();

        String stykListe = styk.createLineItemList(oDetaljer.getCarportLength(), oDetaljer.getCarportWidth(), oDetaljer.getLengthRedskabsrum(), oDetaljer.getWidthRedskabsrum());
        request.setAttribute("stykListe", stykListe);
        request.setAttribute("length", (Double) oDetaljer.getCarportLength());
        request.setAttribute("width", (Double) oDetaljer.getCarportWidth());
        request.setAttribute("height", (Double) oDetaljer.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) oDetaljer.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) oDetaljer.getWidthRedskabsrum());
        request.setAttribute("price", (Double) oDetaljer.getPrice());
        request.setAttribute("od", oDetaljer);
        request.setAttribute("status", status);

        status = "Ny ordre";

        LogicFacade.updateOrdreStatus(ordreId, status);

        return "customer_confirmationpage";
    }
}
