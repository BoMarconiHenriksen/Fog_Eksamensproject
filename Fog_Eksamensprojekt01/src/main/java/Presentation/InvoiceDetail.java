package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
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
        Calculator calc = new Calculator();
        SkurCalculator scalc = new SkurCalculator();
        Odetaljer od = LogicFacade.getOdetaljerByOrderId(orderid);
        double length = (Double) od.getCarportLength();
        double width = (Double) od.getCarportWidth();
        double heigth = (Double) od.getCarportHeight();
        double skurlength = (Double) od.getLengthRedskabsrum();
        double skurWidth = (Double) od.getWidthRedskabsrum();
        DecimalFormat df = new DecimalFormat("#0.00");
        double pris = ((Double) calc.calculateCarportSimple(length, width, heigth) + (Double) scalc.skurPrisBeregner(skurlength, skurWidth));
        request.setAttribute("pris", pris);
        XXRendUtilStykListe rusl = new XXRendUtilStykListe();

        StringBuilder sb = new StringBuilder();

        String LineItemsList = rusl.createLineItemList(sb, length, width, skurlength, skurWidth);
        request.setAttribute("LineItemsList", LineItemsList);

        XXRendSvg svag = new XXRendSvg();

        String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);
        request.setAttribute("carportTegning", carportTegning);
//
//       
//        String status = od.getOrdreStatus();
//      
//        request.setAttribute("length", (Double) od.getCarportLength());
//        request.setAttribute("width", (Double) od.getCarportWidth());
//        request.setAttribute("height", (Double) od.getCarportHeight());
//        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
//        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);
//        request.setAttribute("status", status);
        return "invoice_detail";
    }
}
