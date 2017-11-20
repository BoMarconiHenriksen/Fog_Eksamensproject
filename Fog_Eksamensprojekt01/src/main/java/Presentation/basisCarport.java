/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Domain.Order;
import Domain.User;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
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

                HttpSession session = request.getSession();
        Order order = new Order();
        int ordre_id = 1;
        int user_id = 1;
        String recivedate = "20. november 2017";

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


        Domain.Order theOrdered = LogicFacade.placeAnOrder(ordre_id, user_id, recivedate );

        session.setAttribute("order_id", theOrdered);
        session.setAttribute("user_id", theOrdered);
        session.setAttribute("reciveDate", theOrdered);

        return "bestilbasiscarportpage";
    }

}
