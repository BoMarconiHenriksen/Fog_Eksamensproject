package Utillities;

import Business.Calculator;
import Business.LogicFacade;
import Business.SkurCalculator;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Presentation.NewException;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilOrderList {

    public static String invoiceList(List<Ordre> ordreList) throws NewException {
        Odetaljer od = null;
        Calculator calc = new Calculator();
        SkurCalculator scalc = new SkurCalculator();

        ordreList = LogicFacade.getOrderList();

        StringBuilder sb = new StringBuilder();

        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Ordre Id</th><th>Dato</th><th>Pris</th><th>Kundens fornavn</th><th>Telefon nr</th><th>Status</th></tr>\n");
        for (Ordre o : ordreList) {
            String carportTotal = deciamalFormattedPriceForShow(o, calc, scalc);
            sb.append("<tr><form name=\"InvoiceDetail\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail\">");
            sb.append("<td>").append("" + (o.getOrdre_id())).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>").append("" + (carportTotal)).append("</td>");
//            sb.append("<td>").append("" + (df.format(carportTotal))).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getUserByUserId((o.getUser_id())).getFirstname()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getUserByUserId((o.getUser_id())).getTlfnummer()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getOdetaljerByOrderId((o.getOrdre_id())).getOrdreStatus()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + o.getOrdre_id() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=InvoiceDetail\">See order</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }

    private static String deciamalFormattedPriceForShow(Ordre o, Calculator calc, SkurCalculator scalc) throws NewException {
        DecimalFormat df = new DecimalFormat("#0.00");
        Odetaljer od;
        od = LogicFacade.getOdetaljerByOrderId(o.getOrdre_id());
        double length = LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getCarportLength();
        double width = LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getCarportWidth();
        double height = LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getCarportHeight();
        double skurlength = LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getLengthRedskabsrum();
        double skurwidth = LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getWidthRedskabsrum();
       double carportTotal=calc.calculateCarportSimple(length, width, height) + scalc.skurPrisBeregner(skurlength, skurwidth);
       String carportTotalTwoDecimals=df.format(carportTotal);
       return carportTotalTwoDecimals;
    }
}
