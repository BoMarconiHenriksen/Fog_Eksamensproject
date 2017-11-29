
package Presentation;

import Business.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class InvoiceSetStatus extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
        String status=request.getParameter("status");
//        
        int ordreId =Integer.parseInt(request.getParameter("id"));
        
        LogicFacade.updateOrdreStatus(ordreId, status);
//      request.setAttribute("Ny status", status);
        
        return "ordre_liste";
       
    }
    
}
