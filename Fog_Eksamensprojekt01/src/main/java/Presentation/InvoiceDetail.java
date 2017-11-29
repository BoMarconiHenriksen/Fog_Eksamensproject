package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOdetaljerMedArbejder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bo
 */
public class InvoiceDetail extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);
        
        Ordre odr = LogicFacade.getOrderList().get(orderid);
        Odetaljer od = LogicFacade.getOrderByOrderId(orderid);
        String status = od.getOrdreStatus();
        String visOrdre=RendUtilOdetaljerMedArbejder.odetailsForOrder(od, odr);
        String showCust = RendUtilOdetaljerMedArbejder.customerDetailsForOrder(od, odr);
        request.setAttribute("visOrdre", visOrdre);
        request.setAttribute("showCust", showCust);

        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);
        request.setAttribute("status", status);
        return "invoice_detail";
    }
}
