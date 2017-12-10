package Presentation;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Ordre;
import Utillities.RendUtilOrderList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bo
 */
public class OrdreList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
            
        List<Ordre> invoiceList = LogicFacade.getOrderList();
        
        RendUtilOrderList.invoiceList(invoiceList);
        
        
        request.setAttribute("invoiceList", invoiceList);
        
         List<Ordre> ordreList = LogicFacade.getOrderList();
       String admin_Orderlist = RendUtilOrderList.invoiceList(ordreList);

         if (ordreList.isEmpty()){

           request.setAttribute("admin_orderlist", "Der er ikke nogen ordre."
                   + "Hvis der er nogen der har bestilt en ordre, vil den fremgå her på siden.");      
 
       } else{

           request.setAttribute("admin_orderlist", admin_Orderlist);
        
        return "ordre_liste";

    }
        return "ordre_liste";
 }
}
