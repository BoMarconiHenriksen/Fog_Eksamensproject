/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MaterialeMapper;

import Presentation.NewException;

/**
 *
 * @author BenedikteEva
 *
 *
 */
public class Calculator {

    MaterialeMapper mat = new MaterialeMapper();

    public double calculateCarportBasis(double length, double width, double heigth) throws NewException {

        double totalPriceSimpleCarport = 0;
        double totalPriceBase = beregnBase(length, width);
        double totalPriceScrewsAndSuch = beregnPrisScrewsAndSuch(length);
        
        totalPriceSimpleCarport = totalPriceBase + totalPriceScrewsAndSuch;

        return totalPriceSimpleCarport;

    }

    private double beregnPrisScrewsAndSuch(double length) throws NewException {
        // dimser
        double totalPriceScrewsAndSuch = 0;
        double plastmoBundPris = mat.getMaterialeByVarenummer(13).getEnhedspris();
        double hulbåndPris = mat.getMaterialeByVarenummer(14).getEnhedspris();
        double universalHøjre = mat.getMaterialeByVarenummer(15).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double universalVenstre = mat.getMaterialeByVarenummer(16).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double skruePris = mat.getMaterialeByVarenummer(17).getEnhedspris();
        double beslagSkruePris = mat.getMaterialeByVarenummer(18).getEnhedspris();
        double bræddeboltPris = mat.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = mat.getMaterialeByVarenummer(20).getEnhedspris();


        totalPriceScrewsAndSuch = 1 * plastmoBundPris + 2 * hulbåndPris + (int) Math.round(length / 0.55) * universalHøjre
                + (int) Math.round(length / 0.55) * universalVenstre + skruePris + 2 * beslagSkruePris + 6 * bræddeboltPris + 6 * firkantSkivePris;
        return totalPriceScrewsAndSuch;
    }

    private double beregnBase(double length, double width) throws NewException {
        // DecimalFormat df = new DecimalFormat("0.00");
        //træ og tag
        double brædt1pris = mat.getMaterialeByVarenummer(1).getEnhedspris();
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

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();
        MaterialeMapper mat = new MaterialeMapper();

        System.out.println(3 / 0.55);
        System.out.println(calc.calculateCarportBasis(6, 4.8, 2.25));

    }

}
        // hvis carporten 600 * 780
//        totalPriceBase = 4 * 3.6 * brædt1pris + 4 * 5.4 * brædt1pris + 2 * 3.6 * brædt1pris 
//                + 4 * 5.4 * brædt1pris + 2 * 6 * remme1pris + 1 * 4.8 * remme1pris
//                + 15 * 6 * remme1pris + 6 * 3 * stolpePris1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;
//længde 