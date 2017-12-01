package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
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
        
        int or = (int) (session.getAttribute("SessionIOD"));
        
        LogicFacade.getOrderByOrderId2(or);
        Odetaljer od = LogicFacade.getOdetaljerByOrderId(or);
        String status = od.getOrdreStatus();
      
        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);
        request.setAttribute("status", status);
        
        status = "Bestilt. Afventer Behandling.";
        
        
        LogicFacade.updateOrdreStatus(or, status);

        

        return "customer_confirmationpage";
    }
}
