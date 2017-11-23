package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
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

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);
        Odetaljer od = LogicFacade.getOrderByOrderId2(orderid);
//        List<Odetaljer> oDetaljerList = LogicFacade.getOrdersByOrderId2(orderid);
//        request.setAttribute("oDetaljerList", oDetaljerList);
        

        request.setAttribute("length", (Double)od.getCarportLength());
        request.setAttribute("width", (Double)od.getCarportWidth());
        request.setAttribute("height", (Double)od.getCarportHeight());
        request.setAttribute("od", od);
        return "invoice_detail";
    }
}
