
package Presentation;

import Business.Domain.Ordre;
import Business.Exception.NewException;
import Business.LogicFacade;
import Presentation.Utillities.RendUtilOrderList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne command kommer man hen til når man vælger en ordrestatus på ordre_liste.jsp
 * og trykker på "sæt ordre Status". Den gør det at den kalder DataFacade metoden 
 * updateOrdreStatus(OrdreId, status) som ændrer ordrestatusen i databasen for 
 * det specifikke ordreid.
 */
public class InvoiceSetStatus extends Command{
   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
        String status=request.getParameter("status");
        
        int ordreId =Integer.parseInt(request.getParameter("id"));
        
        LogicFacade.updateOrdreStatus(ordreId, status);
        
          List<Ordre> ordreList = LogicFacade.getOrderList();
        String employee_Orderlist = RendUtilOrderList.invoiceList(ordreList);


        if (ordreList.isEmpty()) {

            request.setAttribute("admin_orderlist", "Der er ikke nogen ordre."
                    + "Hvis der er nogen der har bestilt en ordre, vil den fremgå her på siden.");

        } else {

            request.setAttribute("employee_orderlist", employee_Orderlist);

        }
        
        return "employee_ordre_list";
       
    }
    
}
