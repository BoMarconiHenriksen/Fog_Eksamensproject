
package Presentation;


import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList_Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */

public class OrdreList_Customer extends Command {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
       List<Ordre> ordreList = LogicFacade.getOrderListByUserId(user.getUser_id());
       String customer_Orderlist = RendUtilOrderList_Customer.invoiceList_Customer(ordreList, user);
       
         if (ordreList.isEmpty()){
           request.setAttribute("customer_orderlist", "Du har ikke nogen ordre der afventer din bekræftigelse eller under behandling. Bestil en ordre, og den vil fremgå her på siden.");
       } else{
           request.setAttribute("customer_orderlist", customer_Orderlist);
       }
       
        return "ordrelist_customer";
    }
}
