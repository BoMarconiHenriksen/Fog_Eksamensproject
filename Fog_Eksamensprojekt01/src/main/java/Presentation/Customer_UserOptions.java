/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Domain.Exception.NewException;

/**
 *
 * @author Ticondrus
 */
public class Customer_UserOptions extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws  Domain.Exception.NewException {

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
        
        if (UpdateUserPassword != null && PresentPassword.equals(user.getPassword())){
            
           String password = request.getParameter("passwordNew");
            LogicFacade.updateUserPassword(user.getUser_id(), password);
            presentpasswordiscorrect = 1;
        request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
            return "kunde_useroptionspage";
        } else if (UpdateUserPassword != null){
            presentpasswordiscorrect = 0;
            request.setAttribute("outprintpasswordchangestatus", presentpasswordiscorrect);
             return "kunde_useroptionspage";
        } else{

        return "kunde_useroptionspage";
    }
    }
}
