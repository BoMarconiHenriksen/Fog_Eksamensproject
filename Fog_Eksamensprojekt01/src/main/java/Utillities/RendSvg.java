/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Presentation.NewException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BenedikteEva
 */
public class RendSvg {

    StringBuilder sb = new StringBuilder();

    
    
    
    
    public String simpelCarport(double length, double width) {

        StringBuilder sb = new StringBuilder();
        int spærAntal = (int) Math.round(length / 55);

        
        for (int i = 0; i < spærAntal; i++) { 
            
            sb.append(rammen(length,width));
            sb.append(ydreSpær(width, length));
            sb.append(spærX(width, i));
        }
        
        
        return sb.toString();
    }

    private String spærX(double width, double posX) {
        String spær = " <rect x=\"" + (posX) * 55 + "\" y=\"0\" height=\""
                + width + "\" width=\"2.5\"\n  style=\"stroke:#000000; fill: #ffffff\"/>";
        return spær;
    }
    
    private String rammen(double length, double width){
      
        String ramme=  (" <rect x=\"0\" y=\"0\" height=\""+width+"\" width=\""+length+"\"\n" +
"              style=\"stroke:#000000; fill: #ffffff\"/>");
        return ramme;
    
    }
    
    private String ydreSpær(double width, double length){
        
        
   
        String ydreSpær = (" <rect x=\"0\" y=\"0\" height=\""+width+"\" width=\"2.5\"\n" +
"              style=\"stroke:#000000; fill: #ffffff\"/>\n" +
"        <rect x=\""+(length-4)+"\" y=\"0\" height=\""+width+"\" width=\"2.5\"\n" +
"              style=\"stroke:#000000; fill: #ffffff\"/>");
        return ydreSpær;
        
    }
    
    
    public static String dobbelCarportMskur(double length, double width, double skurLength, double skurWidth) {

        return null;

    }

    public static void main(String[] args) throws NewException {

        RendSvg rsvg = new RendSvg();
        System.out.println(rsvg.simpelCarport(480, 300));

    }

}
