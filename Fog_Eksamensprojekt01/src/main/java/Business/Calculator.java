/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MaterialeMapper;

import Presentation.NewException;
import Utillities.RendUtilGetMaterials;

/**
 *
 * @author BenedikteEva
 *
 * Calculator class.
 * Udfører beregninger på priser og materialer ud fra kundens ønsket størrelse
 */
public class Calculator {
    

    LogicFacade mat = new LogicFacade();
    
    /**
     *  Beregner en samlet total pris på den øsnkede carport med alle grundelementer samt alle ekstra ting m.m.
     * @param length længden af carporten
     * @param width bredden af carporten
     * @param heigth højden af carporten
     * @return totalPriceSimpleCarport
     * @throws NewException 
     */

    public double calculateCarportSimple(double length, double width, double heigth) throws NewException {
        

        double totalPriceSimpleCarport = 0;
        double totalPriceBase = beregnBase(length, width);
        double totalPriceScrewsAndSuch = calculatePriceScrewsAndSuch(length);
       
        totalPriceSimpleCarport = totalPriceBase + totalPriceScrewsAndSuch;

        return totalPriceSimpleCarport;

    }
    
    /**
     * Beregner prisen på de skruer og andre småting som den ønsket carport skal bruge.
     * @param length længden af den ønskede carport
     * @return totalPriceScrewsAndSuch
     * @throws NewException 
     */

    private double calculatePriceScrewsAndSuch(double length) throws NewException {
        
        
        // dimser
        double totalPriceScrewsAndSuch = 0;
        double plastmoBundSkruePris = mat.getMaterialeByVarenummer(13).getEnhedspris();
        double hulbåndPris = mat.getMaterialeByVarenummer(14).getEnhedspris();
        double universalHøjre = mat.getMaterialeByVarenummer(15).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double universalVenstre = mat.getMaterialeByVarenummer(16).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double skruePris = mat.getMaterialeByVarenummer(17).getEnhedspris();
        double beslagSkruePris = mat.getMaterialeByVarenummer(18).getEnhedspris();
        double bræddeboltPris = mat.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = mat.getMaterialeByVarenummer(20).getEnhedspris();


        totalPriceScrewsAndSuch = 1 * plastmoBundSkruePris + 2 * hulbåndPris + (int) Math.round(length / 0.55) * universalHøjre
                + (int) Math.round(length / 0.55) * universalVenstre + skruePris + 2 * beslagSkruePris + 6 * bræddeboltPris + 6 * firkantSkivePris;
        return totalPriceScrewsAndSuch;
    }

/**
 * Bergner en samlet pris på den ønskede carports grundelementer i form af træ, stolper m.m.
 * @param length længden af den ønskede carport
 * @param width bredden af carporten
 * @return totalPriceBase
 * @throws NewException 
 */
    
    private double beregnBase(double length, double width) throws NewException {
        

        
        // DecimalFormat df = new DecimalFormat("0.00");
        //træ og tag
        double brædt1pris = LogicFacade.getMaterialeByVarenummer(1).getEnhedspris();
        double brædt2pris = mat.getMaterialeByVarenummer(2).getEnhedspris();
        double remme1pris = mat.getMaterialeByVarenummer(3).getEnhedspris();
        double stolpePris1 = mat.getMaterialeByVarenummer(6).getEnhedspris();
        double brædt3Pris = mat.getMaterialeByVarenummer(7).getEnhedspris();
        // vær opmærsom på at tagets pris varierer alt efter længden det skal have et if statement
        double plastmoTagpris = 0;
        double totalPriceBase = 0;
        if (length == 3.00) {

            plastmoTagpris = mat.getMaterialeByVarenummer(9).getEnhedspris(); //300 cm
        } else if (length == 4.80) {

            plastmoTagpris = mat.getMaterialeByVarenummer(33).getEnhedspris(); //480 cm
        } else if (length == 6.00) {

            plastmoTagpris = mat.getMaterialeByVarenummer(8).getEnhedspris();// 600 cm

        }
        totalPriceBase = 2 * width * brædt1pris + 2 * length * brædt1pris + 1 * width * brædt2pris
                + 2 * length * brædt2pris + 2 * (length + 0.6) * remme1pris
                + (int) Math.round(length / 0.55) * width * remme1pris + 4 * stolpePris1 + 2 * length * brædt3Pris
                + 1 * length * brædt3Pris + width * plastmoTagpris;
        return totalPriceBase;
    }
    
    /**
     * Er denne classes main metode. Som er lavet til at man nemt og hurtigt at kunne teste beregninernes virkegrad.
     * @param args
     * @throws NewException 
     */
    
    
  // bemærk at målene på skuret skal være mindst 30 cm mindre end målenee på carporten grundet tagudhæng. 
   

    public static void main(String[] args) throws NewException {
        
        
        Calculator calc = new Calculator();
       LogicFacade mat = new LogicFacade();
        RendUtilGetMaterials rugmat= new RendUtilGetMaterials();

        System.out.println(calc.calculateCarportSimple(4.80, 3.00, 2.25));
        System.out.println(mat.getMaterialeByVarenummer(1));

    }

}
        // hvis carporten 600 * 780
//        totalPriceBase = 4 * 3.6 * brædt1pris + 4 * 5.4 * brædt1pris + 2 * 3.6 * brædt1pris 
//                + 4 * 5.4 * brædt1pris + 2 * 6 * remme1pris + 1 * 4.8 * remme1pris
//                + 15 * 6 * remme1pris + 6 * 3 * stolpePris1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;
//længde 
