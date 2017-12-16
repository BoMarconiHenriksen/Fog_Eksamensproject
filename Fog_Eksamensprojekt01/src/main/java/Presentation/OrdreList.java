package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Ordre;
import Business.Domain.User;
import Presentation.Utillities.RendUtilOrderList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class OrdreList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

      
        
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
