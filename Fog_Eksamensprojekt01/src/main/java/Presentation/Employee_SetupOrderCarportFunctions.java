/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.Exception.NewException;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList_Customer;
import Utillities.RendUtilUserList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ticondrus
 */

public class Employee_SetupOrderCarportFunctions extends Command {

   
     @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
        
        List<User> userList = LogicFacade.getUserList();
       String userLists = RendUtilUserList.invoiceUserList(userList);
       request.setAttribute("userLists", userLists);
        
        return "employee_ordercarportpage";
    }
}