package Business;

import Domain.LineItem;
import Domain.Exception.NewException;

/**
 * Klassen bruges til at lave styklinjerne i styklisten
 *
 */
public class LineItemFactory {

    /**
     * Metoden laver styklinerne for træ til en basis carport.
     * @param width er bredden på carporten.
     * @param length er længden på carporten.
     * @return et array, der indeholder alle styklinjerne for træ til en basiscarport.
     * @throws NewException 
     */
    public static LineItem[] baseWood(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne
//    (String description, String material_name, double dimension, int amount, String unit)

        LineItem[] baseWood = new LineItem[8];

        baseWood[0] = new LineItem("Understern brædder til for- og bagende", Business.DataFacade.getMaterialeByVarenummer(1).getMaterialenavn(), width, 2, "Stk");
        baseWood[1] = new LineItem("Understernbrædder til siderne", Business.DataFacade.getMaterialeByVarenummer(1).getMaterialenavn(), length, 2, "Stk");
        baseWood[2] = new LineItem("Oversternbrædder til forenden", Business.DataFacade.getMaterialeByVarenummer(2).getMaterialenavn(), width, 2, "Stk");
        baseWood[3] = new LineItem("Oversternbrædder til siderne", Business.DataFacade.getMaterialeByVarenummer(2).getMaterialenavn(), length, 2, "Stk");
        baseWood[4] = new LineItem("Spær, monteres på rem", Business.DataFacade.getMaterialeByVarenummer(5).getMaterialenavn(), width, Calculator.calculateNumberOfRafters(length), "Stk");
        baseWood[5] = new LineItem("Stolper, nedgraves i 90 cm. jord", Business.DataFacade.getMaterialeByVarenummer(6).getMaterialenavn(), 300, 4, "Stk");
        baseWood[6] = new LineItem("Vandbrædt på stern i sider", Business.DataFacade.getMaterialeByVarenummer(7).getMaterialenavn(), length, 4, "Stk");
        baseWood[7] = new LineItem("Vandbrædt på stern i forenden", Business.DataFacade.getMaterialeByVarenummer(7).getMaterialenavn(), width, 2, "Stk");

        return baseWood;

    }

    /**
     * Metoden laver styklinjerne til styklisten for beslag og skruer til en basis carport.
     * @param width er carportens bredde
     * @param length er carportens længde
     * @return et array, der indeholder alle styklinjerne for beslag og skruer til en basiscarport.
     * @throws NewException 
     */
    public static LineItem[] carportBaseMetal(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne

        LineItem[] baseMetal = new LineItem[5];

        baseMetal[0] = new LineItem("Skruer til tagplader", Business.DataFacade.getMaterialeByVarenummer(13).getMaterialenavn(), 0, Calculator.numberOfBottomScrewsPackageEcolite(length, width), "Pakke");
        baseMetal[1] = new LineItem("Til vindkryds på spær", Business.DataFacade.getMaterialeByVarenummer(14).getMaterialenavn(), 0, 2, "Rulle");
        baseMetal[2] = new LineItem("Til montering af spær på rem", Business.DataFacade.getMaterialeByVarenummer(15).getMaterialenavn(), Calculator.numberOfRafters(length), "Stk");
        baseMetal[3] = new LineItem("Til montering af spær på rem", Business.DataFacade.getMaterialeByVarenummer(16).getMaterialenavn(), Calculator.numberOfRafters(length), "Stk");
        baseMetal[4] = new LineItem("Til montering af stern & vandbrædt", Business.DataFacade.getMaterialeByVarenummer(17).getMaterialenavn(), 2, "Pakke");
        return baseMetal;

    }

    /**
     * Metoden laver styklinjerne til styklisten for ecolite tag til en carport med fladt tag.
     * @param width er carportens bredde.
     * @param length er carportens længde.
     * @return et array, der indeholder alle styklinjerne for ecolite tag.
     * @throws NewException 
     */
    public static LineItem[] ecoliteRoof(double width, double length) throws NewException {
        LineItem[] ecoliteRoof = new LineItem[1];

        if (length <= 300) {
            ecoliteRoof[0] = new LineItem("Tagplader monteres på spær", Business.DataFacade.getMaterialeByVarenummer(9).getMaterialenavn(), 300, Calculator.calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 480) {
            ecoliteRoof[0] = new LineItem("Tagplader monteres på spær", Business.DataFacade.getMaterialeByVarenummer(33).getMaterialenavn(), 480, Calculator.calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 600) {
            ecoliteRoof[0] = new LineItem("Tagplader monteres på spær", Business.DataFacade.getMaterialeByVarenummer(8).getMaterialenavn(), 600, Calculator.calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length > 600) {
            //OBS! Skal laves færdig!
            ecoliteRoof[0] = new LineItem("Ring til supporten", Business.DataFacade.getMaterialeByVarenummer(33).getMaterialenavn(), 600, Calculator.calculateNumberOfEcoliteRoof(width), "Stk");

        }

        return ecoliteRoof;
    }

    /**
     * Metoden laver styklinjerne til styklisten for træ til en carport med skur.
     * @param skurLængde er skurets længde.
     * @param skurBredde er skurets bredde.
     * @return et array, der indeholder alle styklinjerne for træ til en carport med skur.
     * @throws NewException 
     */
    public static LineItem[] woodForShed(double skurLængde, double skurBredde) throws NewException {
        LineItem[] woodForShed = new LineItem[5];

        //Fast størrelse
        woodForShed[0] = new LineItem("Til z på bagside af dør", Business.DataFacade.getMaterialeByVarenummer(3).getMaterialenavn(), 420, 1, "Stk");
        //OBS! Denne skal rettes til i forbindelse med antal!
        woodForShed[1] = new LineItem("Løsholter til skurgavle", Business.DataFacade.getMaterialeByVarenummer(4).getMaterialenavn(), skurLængde, 4, "Stk");
        //OBS! Denne skal rettes til
        woodForShed[2] = new LineItem("Løsholter til skur sider", Business.DataFacade.getMaterialeByVarenummer(4).getMaterialenavn(), skurBredde, 4, "Stk");
        woodForShed[3] = new LineItem("Remme i sider, sadles ned i stolper, skur-del", Business.DataFacade.getMaterialeByVarenummer(5).getMaterialenavn(), Calculator.CalculateWidthForRemmeISiderSkur(skurBredde), 4, "Stk");
        woodForShed[4] = new LineItem("Til beklædning af skur 1 på 2", Business.DataFacade.getMaterialeByVarenummer(7).getMaterialenavn(), 210, (int) Calculator.CalculateCoverWoodShed(skurBredde, skurLængde), "Stk");

        return woodForShed;
    }

    /**
     * Metoden laver styklinjerne til styklisten for beslag og skurer til en carport med skur.
     * @param skurLængde er skurets længde.
     * @param skurBredde er skurets bredde.
     * @return et array, der indeholder alle styklinjerne for beslag og skurer til en carport med skur.
     * @throws NewException 
     */
    public static LineItem[] screwsAndBracketShed(double skurLængde, double skurBredde) throws NewException {
        LineItem[] screwsAndBracketShed = new LineItem[3];

        screwsAndBracketShed[0] = new LineItem("Til lås på dør i skur", Business.DataFacade.getMaterialeByVarenummer(23).getMaterialenavn(), 1, "Sæt");
        screwsAndBracketShed[1] = new LineItem("Til skurdør", Business.DataFacade.getMaterialeByVarenummer(24).getMaterialenavn(), 2, "Stk");
        //OBS! Høre sammen med antal løsholter til skur. Skal udregnes på baggrund af løsholter til skur
        screwsAndBracketShed[2] = new LineItem("Til montering af løsholter i skur", Business.DataFacade.getMaterialeByVarenummer(25).getMaterialenavn(), 32, "Stk");

        return screwsAndBracketShed;
    }


}
