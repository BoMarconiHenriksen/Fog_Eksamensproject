/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.Materiale;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class GetAllMaterialss extends GetAllLineItem {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        List<Materiale> mats = LogicFacade.getMaterial();

        String mat1 = mats.get(1).getMaterialenavn();

        request.setAttribute("mats", mats);
        request.setAttribute("mat1", mat1);
        return "stykListe";

    }

}
