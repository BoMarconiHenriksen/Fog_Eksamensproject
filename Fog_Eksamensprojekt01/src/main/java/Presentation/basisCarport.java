/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Calculator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class basisCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));

        String skurellerej = request.getParameter("skur");
        String trevalg = request.getParameter("kundetrevalg");
        DecimalFormat df = new DecimalFormat("#0.00"); 

        Calculator calc = new Calculator();
        double length = Double.parseDouble(request.getParameter("lentgchoice")) / 100;
        double width = Double.parseDouble(request.getParameter("widthchoice")) / 100;
        double height = Double.parseDouble(request.getParameter("heightchoice")) / 100;
        double carportTotal = calc.calculateCarportSimple(length, width, height);
        String carportTotalDecimaled = df.format(carportTotal);
        request.setAttribute("carportTotal", carportTotalDecimaled);

        request.setAttribute("lentghInput", lentghinput);
        request.setAttribute("widthInput", widthinput);
        request.setAttribute("heightInput", heightinput);
        
        request.setAttribute("skurInput", skurellerej);
        request.setAttribute("trevalgInput", trevalg);

        return "index";
    }

}
