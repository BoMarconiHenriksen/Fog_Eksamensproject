/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Utillities.RendSvg;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class TegningSimpel extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        
        
        RendSvg svag = new RendSvg();
        String carportTegning = svag.simpelCarport(480, 300);
        request.setAttribute("carportTegning",carportTegning);
        
        return "stykListe";
        
    
}}
