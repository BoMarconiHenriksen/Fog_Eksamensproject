/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Presentation.Command;
import Presentation.NewException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */

public class Checkout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
            HttpSession session = request.getSession();
            
        session.getAttribute("carportTotal");
        
        session.getAttribute("lentghChosen");
        session.getAttribute("widthChosen");
        session.getAttribute("heightChosen");
            
            
            
            return "outprintpage";
        }
}

    
