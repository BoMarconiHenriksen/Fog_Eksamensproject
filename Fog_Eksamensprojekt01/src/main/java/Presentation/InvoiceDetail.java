package Presentation;

import Domain.Exception.NewException;
import Business.Calculator;
import Business.LogicFacade;
import Domain.Odetaljer;
import Utillities.XXRendSvg;
import Utillities.XXRendUtilStykListe;
import java.text.DecimalFormat;
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

        Odetaljer od = LogicFacade.getOdetaljerByOrderId(orderid);
        request.setAttribute("od", od);

        double length = (Double) od.getCarportLength();
        double width = (Double) od.getCarportWidth();
        double skurlength = (Double) od.getLengthRedskabsrum();
        double skurWidth = (Double) od.getWidthRedskabsrum();

        double price = od.getPrice();
        request.setAttribute("priceTwoDecimal", price);
        XXRendUtilStykListe XXStykListe =new  XXRendUtilStykListe();
        String LineItemsList;
        LineItemsList = XXStykListe.createLineItemList(length, width, skurlength, skurWidth);
        request.setAttribute("LineItemsList", LineItemsList);

        XXRendSvg svag = new XXRendSvg();

        String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);
        request.setAttribute("carportTegning", carportTegning);

        return "invoice_detail";
    }
}
