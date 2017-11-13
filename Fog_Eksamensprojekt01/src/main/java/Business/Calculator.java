/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.LineItemMapper;
import Data.MaterialeMapper;
import Domain.LineItem;
import Presentation.NewException;
import java.util.List;

/**
 *
 * @author BenedikteEva
 *
 *
 */
public class Calculator {

    LineItemMapper lim = new LineItemMapper();

    public double calculateCarportBasis(double length, double width, double heigth) throws NewException {
        double totalPriceBase;
        double totalPriceScrewsAndSuch;
        double totalPriceSimpleCarport;

        //træ og tag
        double brædt1pris = lim.getLineItems().get(0).getMat().getEnhedspris();
        double brædt2pris = lim.getLineItems().get(1).getMat().getEnhedspris();
        double remme1pris = lim.getLineItems().get(4).getMat().getEnhedspris();
        double stolpePris1 = lim.getLineItems().get(5).getMat().getEnhedspris();
        double brædt3Pris = lim.getLineItems().get(6).getMat().getEnhedspris();
        double plastmoTag1pris = lim.getLineItems().get(7).getMat().getEnhedspris();
        double plastmoTag2pris = lim.getLineItems().get(8).getMat().getEnhedspris();
        
        // dimser
        
        double plastmoBundPris= lim.getLineItems().get(12).getMat().getEnhedspris();
        double hulbåndPris = lim.getLineItems().get(13).getMat().getEnhedspris();
        double universalHøjre= lim.getLineItems().get(14).getMat().getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double universalVenstre= lim.getLineItems().get(15).getMat().getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double skruePris = lim.getLineItems().get(16).getMat().getEnhedspris();
        double beslagSkruePris = lim.getLineItems().get(17).getMat().getEnhedspris();
        double bræddeboltPris=lim.getLineItems().get(18).getMat().getEnhedspris(); //6 stk uden skur og enkelt
        double firkantSkivePris = lim.getLineItems().get(19).getMat().getEnhedspris();
        
        // hvis carporten 600 * 780
        
//        totalPriceBase = 4 * 3.6 * brædt1pris + 4 * 5.4 * brædt1pris + 2 * 3.6 * brædt1pris 
//                + 4 * 5.4 * brædt1pris + 2 * 6 * remme1pris + 1 * 4.8 * remme1pris
//                + 15 * 6 * remme1pris + 6 * 3 * stolpePris1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;

//længde 
        totalPriceBase = 2 * width* brædt1pris + 2 * length * brædt1pris + 1 * width * brædt2pris 
                + 2 * length * brædt2pris + 2 * (length+60) * remme1pris 
                +  ( int ) Math.round(length/0.55) * width * remme1pris + 4 * width * stolpePris1 + 2 * length * brædt3Pris 
                + 1 * length * brædt3Pris + width * plastmoTag2pris;
        
       totalPriceScrewsAndSuch = 1*plastmoBundPris+2*hulbåndPris+( int ) Math.round(length/0.55)*universalHøjre
               +( int ) Math.round(length/0.55)*universalVenstre+skruePris+2*beslagSkruePris+6*bræddeboltPris+6*firkantSkivePris;
        
        totalPriceSimpleCarport=totalPriceBase+totalPriceScrewsAndSuch;

        return totalPriceSimpleCarport;

    }
    
    // her bør man være opmærksom på at base længde skal have fratrukket skuret længde på sternen ved skur
    public double addDimensionSizeToMaterial(double size, double baseSize) {
        double dimAdd = size - baseSize;
        return dimAdd;
    }

    public double priceQtyTimesMaterial(double lgd, double enhedstr, double pris, double qty) {
        double str = lgd / enhedstr;
        double prisprtype = pris * str * qty;
        return prisprtype;
    }

   

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();

        List<LineItem> carport = LogicFacade.getLineItem();
    LineItemMapper lim = new LineItemMapper();
        System.out.println(3/0.55);
        System.out.println( calc.calculateCarportBasis(4.8, 3.0, 2.25));
    }

}
