/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.DataFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import Business.Utilities.RendUtilUserList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ticondrus
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