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
        double totalPriceBase = beregnBase(length/100, width/100);
        double totalPriceScrewsAndSuch = calculatePriceScrewsAndSuch(length/100);

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

        totalPriceScrewsAndSuch = 1 * plastmoBundSkruePris + 2 * hulbåndPris + (int) Math.round(length / 0.55) * universalHøjre
                + (int) Math.round(length / 0.55) * universalVenstre + skruePris + 2 * beslagSkruePris + 6 * bræddeboltPris + 6 * firkantSkivePris;
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
    private double beregnBase(double length, double width) throws NewException {

        // DecimalFormat df = new DecimalFormat("0.00");
        //træ og tag
        double brædt1pris = LogicFacade.getMaterialeByVarenummer(1).getEnhedspris();
        double brædt2pris = LogicFacade.getMaterialeByVarenummer(2).getEnhedspris();
        double remme1pris = LogicFacade.getMaterialeByVarenummer(3).getEnhedspris();
        double stolpePris1 = LogicFacade.getMaterialeByVarenummer(6).getEnhedspris();
        double brædt3Pris = LogicFacade.getMaterialeByVarenummer(7).getEnhedspris();
        // vær opmærsom på at tagets pris varierer alt efter længden det skal have et if statement
        double plastmoTagpris = 0;
        double totalPriceBase = 0;
        if (length <= 3.00) {

            plastmoTagpris = LogicFacade.getMaterialeByVarenummer(9).getEnhedspris(); //300 cm
        } else if (length <= 4.80) {

            plastmoTagpris = LogicFacade.getMaterialeByVarenummer(33).getEnhedspris(); //480 cm
        } else if (length <= 6.00) {

            plastmoTagpris = LogicFacade.getMaterialeByVarenummer(8).getEnhedspris();// 600 cm

        }
        totalPriceBase = 2 * width * brædt1pris + 2 * length * brædt1pris + 1 * width * brædt2pris
                + 2 * length * brædt2pris + 2 * (length + 0.6) * remme1pris
                + (int) Math.round(length / 0.55) * width * remme1pris + 4 * stolpePris1 + 2 * length * brædt3Pris
                + 1 * length * brædt3Pris + width * plastmoTagpris;
        return totalPriceBase;
    }
    
    public static int antalSpær(double length) {
        int spærAntalCirka = (int) Math.round(length / 57);
        return spærAntalCirka;
    }

    public static int afstandMellemSpær(double length) {
        int spærAntalCirka = antalSpær(length);
        double afstandMellemSpær = ((int) Math.round(length / (spærAntalCirka))) - ((int) length % spærAntalCirka) / (spærAntalCirka);
        return (int) afstandMellemSpær;
    }
    
//    private double beregnSkurEnkelt(double skurLength, double skurWidth) throws NewException{
//        double ekstraStolpePris= 4*LogicFacade.getMaterialeByVarenummer(6).getEnhedspris();
//        double løsHolterSkurGavl=4*skurLength*LogicFacade.getMaterialeByVarenummer(4).getEnhedspris();
//        double LøsHolterSkurSider=4*skurWidth*LogicFacade.getMaterialeByVarenummer(4).getEnhedspris();
//        double remmeSiderSkurdel= 2*skurWidth*LogicFacade.ge
//        
//    }
    

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
        System.out.println(calc.afstandMellemSpær(240));
        System.out.println(calc.afstandMellemSpær(300));
        System.out.println(calc.afstandMellemSpær(330));
        System.out.println(calc.afstandMellemSpær(360));
        System.out.println(calc.afstandMellemSpær(390));
        System.out.println(calc.afstandMellemSpær(420));
        System.out.println(calc.afstandMellemSpær(450));
        System.out.println(calc.afstandMellemSpær(480));
        System.out.println(calc.afstandMellemSpær(510));
        System.out.println(calc.afstandMellemSpær(540));
        System.out.println(calc.afstandMellemSpær(570));
        System.out.println(calc.afstandMellemSpær(600));
        System.out.println(calc.afstandMellemSpær(630));
        System.out.println(calc.afstandMellemSpær(660));
        System.out.println(calc.afstandMellemSpær(690));
        System.out.println(calc.afstandMellemSpær(720));
        System.out.println(calc.afstandMellemSpær(750));
         System.out.println(calc.afstandMellemSpær(780));
    }

}
// hvis carporten 600 * 780
//        totalPriceBase = 4 * 3.6 * brædt1pris + 4 * 5.4 * brædt1pris + 2 * 3.6 * brædt1pris 
//                + 4 * 5.4 * brædt1pris + 2 * 6 * remme1pris + 1 * 4.8 * remme1pris
//                + 15 * 6 * remme1pris + 6 * 3 * stolpePris1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;
//længde 
