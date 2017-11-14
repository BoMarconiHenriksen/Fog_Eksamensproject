/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;


import Business.Calculator;
import Business.LogicFacade;
import Domain.StykLinje;
import Domain.User;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BenedikteEva
 */
public class GetAllStykLinje extends GetAllLineItem {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        HttpSession session = request.getSession();

       User user = (User) session.getAttribute("user");
       List<StykLinje> stykLinjeListe= LogicFacade.getStykLinje();
       request.setAttribute("stykLinjeListe", stykLinjeListe);
        
        
        
        
        return "outprintpage";
    }

}
