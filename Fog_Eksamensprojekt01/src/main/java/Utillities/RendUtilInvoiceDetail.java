package Utillities;

import Business.LogicFacade;
import Domain.Odetaljer;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilInvoiceDetail {
    
    public static String invoiceTabelCustomer(List<Odetaljer> allDetaljer) {
//        allDetaljer = LogicFacade.getOrderList();
        
    StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Invoices</th><th></th><th></th></tr>\n"
         + "<tr><th>Order Id</th><th>Date</th><th>Cupcake Name</th><th>Quantity</th><th>Price</th><th>Total Price</th></tr>\n");
        for (Odetaljer o : allDetaljer) {
   
            sb.append("<tr><form name=\"invoice_detail\" action=\"InvoiceHistoryCustomerServlet\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
//            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
//            sb.append("<td>").append("" + o.getOrder_id()).append("</td>");
//            sb.append("<td>").append("" + o.getReceived()).append("</td>");
//            sb.append("<td>").append("" + o.getCcname()).append("</td>");
//            sb.append("<td>").append("" + o.getQuantity()).append("</td>");
//            sb.append("<td>").append("" + o.getPriceprcc()).append("</td>");
//            sb.append("<td>").append("" + o.getTotalprice()).append("</td>");
            //sb.append("<td>\n <input type=\"radio\" name=\" orderid\" value=\""+o.getOrder_id()+"\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n"); 
//        sb.append("<button type=\"submit\" value=\"action\" name=invoice_detail\">Back</button> " );
        sb.append("</form>\n");
        return sb.toString();

    }
    
}
