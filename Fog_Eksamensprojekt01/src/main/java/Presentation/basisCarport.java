/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Calculator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class basisCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
      
         Calculator calc = new Calculator();
        double length = Double.parseDouble(request.getParameter("length"))/100;
        double width = Double.parseDouble(request.getParameter("width"))/100;
        double height=  Double.parseDouble(request.getParameter("height"))/100;
          double carportTotal=calc.calculateCarportBasis(length, width, height);
           request.setAttribute("carportTotal", carportTotal);
          
        return "index";
    }
    
}
