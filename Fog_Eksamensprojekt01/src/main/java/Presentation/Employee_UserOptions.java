package Presentation;

import Business.DataFacade;
import Business.Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Business.Exception.NewException;

/**
 * Klassen bruges til opdatering af brugerens information.
 */
public class Employee_UserOptions extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        DataFacade.getUserByUserId(user.getUser_id());

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
            DataFacade.updateUserPassword(user.getUser_id(), password);
            presentpasswordiscorrect = 1;
            request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
            return "employee_useroptionspage";
        } else if (UpdateUserPassword != null) {
            presentpasswordiscorrect = 0;
            request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
            return "emplyoee_useroptionspage";
        } else {

            return "employee_useroptionspage";
        }
    }
}
