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
        int length = Integer.parseInt(request.getParameter("length"));
        int width =Integer.parseInt(request.getParameter("width"));
        int height= Integer.parseInt(request.getParameter("height"));
        List<LineItem> limes= LogicFacade.getLineItem();
        double carportTotal=calc.calculateCarportBasis(length, width, height);
        request.setAttribute("mats", mats);
        request.setAttribute("mat1", mat1);
       request.setAttribute("carportTotal", carportTotal);
       

        return "stykListe";

    }

}
