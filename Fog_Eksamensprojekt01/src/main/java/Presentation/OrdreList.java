package Presentation;

import Business.LogicFacade;
import Domain.Ordre;
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
        request.setAttribute("invoiceList", invoiceList);
        
        return "ordre_liste";

    }
 }
