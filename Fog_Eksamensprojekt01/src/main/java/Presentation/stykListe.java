/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;


import Business.Calculator;
import Domain.User;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class stykListe extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        HttpSession session = request.getSession();

       User user = (User) session.getAttribute("user");
       
        Calculator calc = new Calculator();
        
        return user.getAdminStatus() + "page";
    }

}
