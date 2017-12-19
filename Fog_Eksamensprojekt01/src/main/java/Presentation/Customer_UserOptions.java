package Presentation;

import Business.LogicFacade;
import Business.Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Business.Exception.NewException;

/**
 * Denne class er en af commands'ne.
 * Bruges på customerpage.jsp til at navigere kunden hen til
 * customer_useroptions.jsp og fremvise alle kunden s oplysninger samt tage imod
 * og ændre kundens password hvis kunden vælger et nyt password på siden.
 */
public class Customer_UserOptions extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        LogicFacade.getUserByUserId(user.getUser_id());

        request.setAttribute("yourFirstname", user.getFirstname());
        request.setAttribute("yourLastname", user.getLastname());
        request.setAttribute("yourEmail", user.getEmail());
        request.setAttribute("yourAddress", user.getAddress());
        request.setAttribute("yourZipcode", (Integer) user.getZip());
        request.setAttribute("yourPhoneNr", (Integer) user.getTlfnummer());
        request.setAttribute("yourPassword", user.getPassword());

        String UpdateUserPassword = request.getParameter("Customer_UserOptionsPasswordChange");
        String PresentPassword = request.getParameter("passwordOld");
        int presentpasswordiscorrect = 2;
        request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);

        if (UpdateUserPassword != null && PresentPassword.equals(user.getPassword())) {

            String password = request.getParameter("passwordNew");
            LogicFacade.updateUserPassword(user.getUser_id(), password);
            presentpasswordiscorrect = 1;
            request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
            return "customer_useroptions";
        } else if (UpdateUserPassword != null) {
            presentpasswordiscorrect = 0;
            request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
            return "customer_useroptions";
        } else {

            return "customer_useroptions";
        }
    }
}
