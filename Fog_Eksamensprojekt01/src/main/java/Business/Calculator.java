package Business;

import Business.Exception.NewException;

/**
 *
 * Calculator class. Udfører beregninger på priser og materialer ud fra kundens
 * ønskede størrelse
 */
public class Calculator {

    /**
     * Beregner en samlet total pris på den øsnkede carport med alle
     * grundelementer samt alle ekstra ting m.m. Den må kun bruges hvis skuret
     * er med
     *
     * @param length længden af carporten
     * @param width bredden af carporten
     * @param heigth højden af carporten
     * @return totalPriceSimpleCarport
     * @throws NewException
     */
    public static  double calculateCarportSimple(double length, double width, double heigth) throws NewException {
        double totalPriceSimpleCarport = 0;
        if (length == 0.00) {
            totalPriceSimpleCarport = 0;
        } else {
            double totalPriceBase = calculateBaseCarport(length, width);
            double totalPriceScrewsAndSuch = calculatePriceScrewsAndSuch(length, width);

            totalPriceSimpleCarport = totalPriceBase + totalPriceScrewsAndSuch;
        }
        return totalPriceSimpleCarport;

    }

    /**
     * Beregner prisen på de skruer og andre småting som den ønsket carport skal
     * bruge.
     *
     * @param length længden af den ønskede carport
     * @param width
     * @return totalPriceScrewsAndSuch
     * @throws NewException
     */
    public static double calculatePriceScrewsAndSuch(double length, double width) throws NewException {

        // dimser
        double totalPriceScrewsAndSuch = 0;
        double plastmoBundSkruePris = DataFacade.getMaterialeByVarenummer(13).getEnhedspris();
        double hulbåndPris = DataFacade.getMaterialeByVarenummer(14).getEnhedspris();
        double universalHøjre = DataFacade.getMaterialeByVarenummer(15).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double universalVenstre = DataFacade.getMaterialeByVarenummer(16).getEnhedspris();// antal = antal spær ( int ) Math.round(length/0.55)
        double skruePris = DataFacade.getMaterialeByVarenummer(17).getEnhedspris();
        double beslagSkruePris = DataFacade.getMaterialeByVarenummer(18).getEnhedspris();
        double bræddeboltPris = DataFacade.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = DataFacade.getMaterialeByVarenummer(20).getEnhedspris();

        totalPriceScrewsAndSuch = numberOfBottomScrewsPackageEcolite(length, width) * plastmoBundSkruePris + 2 * hulbåndPris + numberOfRafters(length) * (universalHøjre
                + universalVenstre) + skruePris + 2 * beslagSkruePris + 6 * bræddeboltPris + 6 * firkantSkivePris;
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
    public static double calculateBaseCarport(double length, double width) throws NewException {

        //træ og tag
        double plank1Price = DataFacade.getMaterialeByVarenummer(1).getEnhedspris();
        double plank2Price = DataFacade.getMaterialeByVarenummer(2).getEnhedspris();
        double RaftsAndStrapsPrice = DataFacade.getMaterialeByVarenummer(3).getEnhedspris();
        double postPrice1 = DataFacade.getMaterialeByVarenummer(6).getEnhedspris();
        double plank3Price = DataFacade.getMaterialeByVarenummer(7).getEnhedspris();//waterboard
        // vær opmærsom på at tagets pris varierer alt efter længden det skal have et if statement
        double plastmoRoofPrice = 0;
        double totalPriceBase = 0;
        if (length <= 300) {

            plastmoRoofPrice = DataFacade.getMaterialeByVarenummer(9).getEnhedspris(); //300 cm
        } else if (length <= 480) {

            plastmoRoofPrice = DataFacade.getMaterialeByVarenummer(33).getEnhedspris(); //480 cm
        } else if (length <= 600) {

            plastmoRoofPrice = DataFacade.getMaterialeByVarenummer(8).getEnhedspris();// 600 cm

        } else if (length > 600) {

            plastmoRoofPrice = DataFacade.getMaterialeByVarenummer(9).getEnhedspris() + DataFacade.getMaterialeByVarenummer(33).getEnhedspris();// 600 cm

        }
        totalPriceBase = 2 * width / 100 * plank1Price + 2 * length / 100 * plank1Price + 1 * width / 100 * plank2Price
                + 2 * length / 100 * plank2Price + 2 * (length / 100) * RaftsAndStrapsPrice
                + numberOfRafters(length) * width / 100 * RaftsAndStrapsPrice + 4 * postPrice1 + 2 * length / 100 * plank3Price
                + 1 * length / 100 * plank3Price + Math.ceil(width / 100) * plastmoRoofPrice;
        return totalPriceBase;
    }

    /**
     *
     * @param length
     * @return
     */
    public static int numberOfRafters(double length) {
        int approxNumberOfRafts = (int) Math.round(length / 57);
        return approxNumberOfRafts;
    }

    /**
     *
     * @param length
     * @return
     */
    public static int spaceBetweenRafters(double length) {

        double spaceBetweenRafters = ((int) Math.round(length / (numberOfRafters(length)))) - ((int) length % numberOfRafters(length)) / (numberOfRafters(length));
        return (int) spaceBetweenRafters;
    }

    /**
     *
     * @param length
     * @param width
     * @return
     */
    public static int numberOfBottomScrewsPackageEcolite(double length, double width) {
        int numberOfScrews = (int) (((numberOfRafters(length) * (width / 100)) + (100 / 12 * (length / 100)) + 100 / 12 * length / 12));
        int numberOfPckScrews = (int) Math.ceil(numberOfScrews / 200);
        if (length == 240 && width == 240) {
            numberOfPckScrews = 1;
        }
        return numberOfPckScrews;
    }

    /**
     * Beregner en samlet pris på skuret, med alle grundelementer samt alle
     * skurger m.m Prisen lægges så sammen med prisen på Carporten, som bliver
     * beregnet i Calcualtor.java.
     *
     * @param shedLength lægnden af skuret
     * @param shedWidth bredden af skuret
     * @return totalPrisSkur
     * @throws NewException
     */
    public static double calculatePriceShed(double shedLength, double shedWidth) throws NewException {

        double LægteTilZ = DataFacade.getMaterialeByVarenummer(3).getEnhedspris();
        double LøsholterSkurGavl = DataFacade.getMaterialeByVarenummer(4).getEnhedspris();
        double LøsholterSkurSider = DataFacade.getMaterialeByVarenummer(4).getEnhedspris();
        double BrædtSkurBeklædning = DataFacade.getMaterialeByVarenummer(7).getEnhedspris();
        double SkruerYdersteBeklædning = DataFacade.getMaterialeByVarenummer(21).getEnhedspris();
        double SkruerIndersteBeklædning = DataFacade.getMaterialeByVarenummer(22).getEnhedspris();

        // ekstra Stolper:
        double stolpePris1 = DataFacade.getMaterialeByVarenummer(6).getEnhedspris();
        double bræddeboltPris = DataFacade.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = DataFacade.getMaterialeByVarenummer(20).getEnhedspris();
        double tilEkstraStolper = 4 * (firkantSkivePris + bræddeboltPris);
        //Ting der bruges til døren udover beklædningsbrædder:
        double StaldørsGreb = DataFacade.getMaterialeByVarenummer(23).getEnhedspris();
        double THængselSkur = DataFacade.getMaterialeByVarenummer(24).getEnhedspris();
        double VinkelBeslagSkur = DataFacade.getMaterialeByVarenummer(25).getEnhedspris();
        double dørTilbehørPris = LægteTilZ + StaldørsGreb + THængselSkur;
        // Her lægges alle skurdelene sammen 
        double totalPrisSkur = 12 * shedLength / 100 * LøsholterSkurSider + 4 * shedWidth / 100 * LøsholterSkurGavl
                + 4 * stolpePris1 + ((2 * shedLength + 2 * shedWidth) / 10) * BrædtSkurBeklædning + VinkelBeslagSkur
                + +2 * SkruerYdersteBeklædning + 2 * SkruerIndersteBeklædning + dørTilbehørPris + tilEkstraStolper;

        return totalPrisSkur;

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

        System.out.println(calc.calculateBaseCarport(480, 300));

    }

    /**
     * Metoden udregner antallet af spær, der skal bruges til carporten.
     *
     * @param length er carportens længde.
     * @return antallet af spær, der skal bruges til carporten.
     */
    public static int calculateNumberOfRafters(double length) {
        return Calculator.numberOfRafters(length);
    }

    /**
     * Udregner den sammenlagte bredde for skurets rem.
     *
     * @param skurBredde er skuret bredde.
     * @return den sammenlagte bredde for skurets rem.
     */
    public static double CalculateWidthForRemmeISiderSkur(double skurBredde) {
        return skurBredde * 2;
    }

    /**
     * Metoden udregner, antallet af Ecolite tagplast, der skal bruges.
     *
     * @param width er carportens bredde.
     * @return antallet af Ecolite tagplast, der skal bruges.
     */
    public static int calculateNumberOfEcoliteRoof(double width) {
        int numberOfRoof;
        if (width % 100 > 0 && width % 100 < 50) {
            numberOfRoof = ((int) Math.round(width / 100) + 1);
        } else {
            numberOfRoof = ((int) Math.round(width / 100));
        }
        return numberOfRoof;
    }

    /**
     * Metoden udregner, hvor mange beklædningsbrædder der skal bruges til et
     * skur.
     *
     * @param skurBredde er skurets bredde.
     * @param skurLængde er skurets længde.
     * @return antal beklædningsbrædder, som skal bruges til et skur.
     */
    public static double CalculateCoverWoodShed(double skurBredde, double skurLængde) {
        return 2 * skurBredde / 10 + 2 * skurLængde / 10;
    }
}

// hvis carporten 600 * 780
//        totalPriceBase = 4 * 3.6 * plank1Price + 4 * 5.4 * plank1Price + 2 * 3.6 * plank1Price 
//                + 4 * 5.4 * plank1Price + 2 * 6 * RaftsAndStrapsPrice + 1 * 4.8 * RaftsAndStrapsPrice
//                + 15 * 6 * RaftsAndStrapsPrice + 6 * 3 * postPrice1 + 4 * 5.4 * brædt2Pris 
//                + 2 * 3.6 * brædt2Pris + 6 * plastmoTag1pris + 6  * plastmoTag2pris;
//længde 
