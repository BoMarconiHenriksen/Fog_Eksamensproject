/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Domain.LineItem;
import Domain.Materiale;
import Domain.StykLinje;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
abstract class GetAllLineItem extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        Calculator calc = new Calculator();
        List<StykLinje> stykLinjeListe = LogicFacade.getStykLinje();
        request.setAttribute("stykLinjeListe", stykLinjeListe);
        List<Materiale> mats = LogicFacade.getMaterial();
        String mat1 = mats.get(1).getMaterialenavn();
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height= Double.parseDouble(request.getParameter("height"));
        List<LineItem> limes= LogicFacade.getLineItem();
        double carportTotal=calc.priceTotalPriceCarportUdenSkur(limes, length, width, height);
        request.setAttribute("mats", mats);
        request.setAttribute("mat1", mat1);
       request.setAttribute("carportTotal", carportTotal);
       

        return "stykListe";

    }

}
