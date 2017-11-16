/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Calculator;
import Business.SkurCalculator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Presentation.Command;

/**
 *
 * @author Ejer
 */
public class basisCarportMedSkur extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();

        String command = request.getParameter("command");
        String checkprice = request.getParameter("basisCarportmedSkur");


        double lentghinput = Double.parseDouble(request.getParameter("lentgchoice"));
        double widthinput = Double.parseDouble(request.getParameter("widthchoice"));
        double heightinput = Double.parseDouble(request.getParameter("heightchoice"));
        
       double lentghinputskur = Double.parseDouble(request.getParameter("lentgchoiceskur"));
        double widthinputskur = Double.parseDouble(request.getParameter("widthchoiceskur"));
      //  double heightinputskur = Double.parseDouble(request.getParameter("heightchoiceskur"));

        String skurellerej = request.getParameter("skur");
        String trevalg = request.getParameter("kundetrevalg");
        DecimalFormat df = new DecimalFormat("#0.00");

        //Caroporten
        Calculator calc = new Calculator();
        double length = Double.parseDouble(request.getParameter("lentgchoice")) / 100;
        double width = Double.parseDouble(request.getParameter("widthchoice")) / 100;
        double height = Double.parseDouble(request.getParameter("heightchoice")) / 100;
        double carportTotaludenSkur = calc.calculateCarportSimple(length, width, height);
        
       //Skuret 
       SkurCalculator calcskur = new SkurCalculator();
         
       double lengthskur = Double.parseDouble(request.getParameter("lentgchoice")) / 100;
       double widthskur = Double.parseDouble(request.getParameter("widthchoice")) / 100;
       double skurTotaludenCarport = calcskur.skurPrisBeregner(length, width);
         
        
        String carportTotalDecimaled = df.format(carportTotaludenSkur + skurTotaludenCarport);
        request.setAttribute("carportTotal", carportTotalDecimaled);

        session.setAttribute("carportTotalValg", carportTotalDecimaled);

        //Carporten
        request.setAttribute("lentghInput", lentghinput);
        request.setAttribute("widthInput", widthinput);
        request.setAttribute("heightInput", heightinput);

        //Skuret
        request.setAttribute("lentghInputSkur", lentghinputskur);
        request.setAttribute("widthInputSkur", widthinputskur);
        
        
        request.setAttribute("trevalgInput", trevalg);

        if (checkprice != null) {
            return "basiscarportmedskurpage";
        }

        if (checkprice == null) {
            return "outprintpage";
        } else
        return null;
    }
}
