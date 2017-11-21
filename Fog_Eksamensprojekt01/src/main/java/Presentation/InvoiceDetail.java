package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bo
 */
public class InvoiceDetail extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
        //case invoice_detail
        
        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);
        
        List<Odetaljer> oDetaljerList = LogicFacade.getOrdersByOrderId(orderid);
        request.setAttribute("oDetaljerList", oDetaljerList);
        
        return "invoice_detail";
    }
}
