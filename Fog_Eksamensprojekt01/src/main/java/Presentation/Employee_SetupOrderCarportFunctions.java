package Presentation;

import Business.DataFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import Presentation.Utillities.RendUtilUserList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne class er en af commands'ne. Bruges på employeepage.jsp til at navigere
 * medarbejderen hen til employee_order_carport.jsp og fremvise en liste af de
 * kunder som er oprettet, - så medarbejderen kan vælge en kunde at bestile en
 * ordre til.
 *
 */
public class Employee_SetupOrderCarportFunctions extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        List<User> userList = DataFacade.getUserList();
        String userLists = RendUtilUserList.invoiceUserList(userList);
        request.setAttribute("userLists", userLists);

        return "employee_ordercarportpage";
    }
}
