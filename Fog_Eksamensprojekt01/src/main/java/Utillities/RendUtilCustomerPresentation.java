/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.LogicFacade;
import Domain.Materiale;
import Presentation.NewException;
import java.util.List;

/**
 *
 * @author Ticondrus
 */
public class RendUtilCustomerPresentation {
    
public static String getSkurInfo(double custumerSkurInfo) throws NewException {

    
            
        StringBuilder sb = new StringBuilder();
        
        sb.append("Carport Længde:<br>\n" +
"            <ul>\n" +
"                <select name=\"lentgchoiceSkur\">\n" +
"                    <option number=\"240\">240</option>\n" +
"                    <option number=\"270\">270</option>\n" +
"                    <option number=\"300\">300</option>\n" +
"                    <option number=\"330\">330</option>\n" +
"                    <option number=\"360\">360</option>\n" +
"                    <option number=\"390\">390</option>\n" +
"                    <option number=\"420\">420</option>\n" +
"                    <option number=\"450\">450</option>\n" +
"                    <option number=\"480\">480</option>\n" +
"                    <option number=\"510\">510</option>\n" +
"                    <option number=\"540\">540</option>\n" +
"                    <option number=\"570\">570</option>\n" +
"                    <option number=\"600\">600</option>\n" +
"                    <option number=\"630\">630</option>\n" +
"                    <option number=\"660\">660</option>\n" +
"                    <option number=\"660\">690</option>\n" +
"                    <option number=\"720\">720</option>\n" +
"                    <option number=\"750\">750</option>\n" +
"                    <option number=\"780\">780</option>\n" +
"                </select>\n" +
"            </ul>)\n");
       
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detail\">See order</button> ");
        sb.append("</form>\n");
        return sb.toString();

    }
}