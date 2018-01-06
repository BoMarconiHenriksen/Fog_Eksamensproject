package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Ordre;
import Presentation.Utillities.RendUtilOrderList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne class er en af commands'ne.
 * Bruges på på employeepage.jsp, til at navigere medarbejderen til employee_ordre_list.jsp og få fremvist alle kundernes ordre.
 * 
 */
public class OrdreList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        List<Ordre> ordreList = LogicFacade.getOrderList();
        String employee_Orderlist = RendUtilOrderList.invoiceList(ordreList);


        if (ordreList.isEmpty()) {

            request.setAttribute("admin_orderlist", "Der er ikke nogen ordrer."
                    + "Hvis der er nogen der har bestilt en ordre, vil den fremgå her på siden.");

        } else {

            request.setAttribute("employee_orderlist", employee_Orderlist);

        }
        return "employee_ordre_list";
    }
}
