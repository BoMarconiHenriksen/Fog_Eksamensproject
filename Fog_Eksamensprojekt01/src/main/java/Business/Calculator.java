/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Presentation.NewException;

/**
 *
 * @author BenedikteEva
 *
 * Calculator class. Udfører beregninger på priser og materialer ud fra kundens
 * ønsket størrelse
 */
public class Calculator {

    

//    LogicFacade mat = new LogicFacade();
    /**
     * Beregner en samlet total pris på den øsnkede carport med alle
     * grundelementer samt alle ekstra ting m.m.
     *
     * @param length længden af carporten
     * @param width bredden af carporten
     * @param heigth højden af carporten
     * @return totalPriceSimpleCarport
     * @throws NewException
     */
    public double calculateCarportSimple(double length, double width, double heigth) throws NewException {

        double totalPriceSimpleCarport = 0;
        double totalPriceBase = calculateBaseCarport(length, width);
        double totalPriceScrewsAndSuch = calculatePriceScrewsAndSuch(length);

        totalPriceSimpleCarport = totalPriceBase + totalPriceScrewsAndSuch;

        return totalPriceSimpleCarport;

    }

    /**
     * Beregner prisen på de skruer og andre småting som den ønsket carport skal
     * bruge.
     *
     * @param length længden af den ønskede carport
     * @return totalPriceScrewsAndSuch
     * @throws NewException
     */
    private double calculatePriceScrewsAndSuch(double length) throws NewException {

        // dimser
        double totalPriceScrewsAndSuch = 0;
        double plastmoBundSkruePris = LogicFacade.getMaterialeByVarenummer(13).getEnhedspris();
        double hulbåndPris = LogicFacade.getMaterialeByVarenummer(14).getEnhedspris();
        double universalHøjre = LogicFacade.getMaterialeByVarenummer(15).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double universalVenstre = LogicFacade.getMaterialeByVarenummer(16).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double skruePris = LogicFacade.getMaterialeByVarenummer(17).getEnhedspris();
        double beslagSkruePris = LogicFacade.getMaterialeByVarenummer(18).getEnhedspris();
        double bræddeboltPris = LogicFacade.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = LogicFacade.getMaterialeByVarenummer(20).getEnhedspris();

        totalPriceScrewsAndSuch = 1 * plastmoBundSkruePris + 2 * hulbåndPris + numberOfRafters(length) * universalHøjre
                + numberOfRafters(length) * universalVenstre + skruePris + 2 * beslagSkruePris + 6 * bræddeboltPris + 6 * firkantSkivePris;
        return totalPriceScrewsAndSuch;
    }

    /**
     * Bergner en samlet pris på den ønskede carports grundelementer i form af
     * træ, stolper m.m.
     *
     * @param length længden af den ønskede carport
     * @param width bredden af carporten
     * @return totalPriceBase
     * @throws NewException
     */
    private double calculateBaseCarport(double length, double width) throws NewException {

        // DecimalFormat df = new DecimalFormat("0.00");
        //træ og tag
        double plank1Price = LogicFacade.getMaterialeByVarenummer(1).getEnhedspris();
        double plank2Price = LogicFacade.getMaterialeByVarenummer(2).getEnhedspris();
        double strapsToCarryRoofPrice = LogicFacade.getMaterialeByVarenummer(3).getEnhedspris();
        double postPrice1 = LogicFacade.getMaterialeByVarenummer(6).getEnhedspris();
        double plank3Price = LogicFacade.getMaterialeByVarenummer(7).getEnhedspris();
        // vær opmærsom på at tagets pris varierer alt efter længden det skal have et if statement
        double plastmoRoofPrice = 0;
        double totalPriceBase = 0;
        if (length <= 3.00) {

            plastmoRoofPrice = LogicFacade.getMaterialeByVarenummer(9).getEnhedspris(); //300 cm
        } else if (length <= 4.80) {

            plastmoRoofPrice = LogicFacade.getMaterialeByVarenummer(33).getEnhedspris(); //480 cm
        } else if (length <= 6.00) {

            plastmoRoofPrice = LogicFacade.getMaterialeByVarenummer(8).getEnhedspris();// 600 cm

        }
        totalPriceBase = 2 * width/100 * plank1Price + 2 * length/100 * plank1Price + 1 * width/100 * plank2Price
                + 2 * length/100 * plank2Price + 2 * (length/100 + 0.6) * strapsToCarryRoofPrice
                + numberOfRafters(length) * width/100 * strapsToCarryRoofPrice + 4 * postPrice1 + 2 * length/100 * plank3Price
                + 1 * length/100 * plank3Price + width/100 * plastmoRoofPrice;
        return totalPriceBase;
    }
    
    public static int numberOfRafters(double length) {
        int approxNumberOfRafts = (int) Math.round(length / 57);
        return approxNumberOfRafts;
    }

    public static int spaceBetweenRafters(double length) {
      
        double spaceBetweenRafters = ((int) Math.round(length / (numberOfRafters(length)))) - ((int) length % numberOfRafters(length)) / (numberOfRafters(length));
        return (int) spaceBetweenRafters;
    }
    
    

    /**
     * Er denne classes main metode. Som er lavet til at man nemt og hurtigt at
     * kunne teste beregninernes virkegrad.
     *
     * @param args
     * @throws NewException
     */
    // bemærk at målene på skuret skal være mindst 30 cm mindre end målenee på carporten grundet tagudhæng. 
    public static void main(String[] args) throws NewException {

        Calculator calc = new Calculator();

        System.out.println(calc.calculateCarportSimple(480, 300, 225));
      
    }

}
// hvis carporten 600 * 780
//        totalPriceBase = 4 * 3.6 * plank1Price + 4 * 5.4 * plank1Price + 2 * 3.6 * plank1Price 
//                + 4 * 5.4 * plank1Price + 2 * 6 * strapsToCarryRoofPrice + 1 * 4.8 * strapsToCarryRoofPrice
//                + 15 * 6 * strapsToCarryRoofPrice + 6 * 3 * postPrice1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;
//længde 
