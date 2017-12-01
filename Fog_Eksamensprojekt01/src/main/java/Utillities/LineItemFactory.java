/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.Calculator;
import Business.LogicFacade;
import Domain.LineItem;
import Presentation.NewException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class LineItemFactory {

//    (String description, String material_name, double dimension, int amount, String unit)

    public static LineItem[] baseTree(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne

      
        LineItem[] baseTree = new LineItem[8];


        baseTree[0] = new LineItem("Understern brædder til for- og bagende", Business.LogicFacade.getMaterialeByVarenummer(1).getMaterialenavn(), width, 2, "Stk");
        baseTree[1] = new LineItem("Understernbrædder til siderne", Business.LogicFacade.getMaterialeByVarenummer(1).getMaterialenavn(), length, 2, "Stk");
        baseTree[2] = new LineItem("Oversternbrædder til forenden", Business.LogicFacade.getMaterialeByVarenummer(2).getMaterialenavn(), width, 2, "Stk");
        baseTree[3] = new LineItem("Oversternbrædder til siderne", Business.LogicFacade.getMaterialeByVarenummer(2).getMaterialenavn(), length, 2, "Stk");
        baseTree[4] = new LineItem("Spær, monteres på rem", Business.LogicFacade.getMaterialeByVarenummer(5).getMaterialenavn(), width, calculateNumberOfRafters(length), "Stk");       
        baseTree[5] = new LineItem("Stolper, nedgraves i 90 cm. jord", Business.LogicFacade.getMaterialeByVarenummer(6).getMaterialenavn(), 300, 4, "Stk");
        baseTree[6] = new LineItem("Vandbrædt på stern i sider", Business.LogicFacade.getMaterialeByVarenummer(7).getMaterialenavn(), length, 4, "Stk");
        baseTree[7] = new LineItem("Vandbrædt på stern i forenden", Business.LogicFacade.getMaterialeByVarenummer(7).getMaterialenavn(), width, 2, "Stk");

        return baseTree;

    }
    
      public static LineItem[] carportBaseMetal(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne
      
        LineItem[] baseMetal = new LineItem[5];

        baseMetal[0] = new LineItem("Skruer til tagplader", Business.LogicFacade.getMaterialeByVarenummer(13).getMaterialenavn(), 0, Calculator.numberOfBottomScrewsPackageEcolite(length, width), "Pakke");
        baseMetal[1] = new LineItem("Til vindkryds på spær", Business.LogicFacade.getMaterialeByVarenummer(14).getMaterialenavn(), 0, 2, "Rulle");
        baseMetal[2] = new LineItem("Til montering af spær på rem", Business.LogicFacade.getMaterialeByVarenummer(15).getMaterialenavn(), Calculator.numberOfRafters(length), "Stk");
        baseMetal[3] = new LineItem("Til montering af spær på rem", Business.LogicFacade.getMaterialeByVarenummer(16).getMaterialenavn(), Calculator.numberOfRafters(length), "Stk");
        baseMetal[4] = new LineItem("Til montering af stern & vandbrædt", Business.LogicFacade.getMaterialeByVarenummer(17).getMaterialenavn(), 2, "Pakke");
        return baseMetal;

    }  
    

    public static LineItem[] ecoliteRoof(double width, double length) throws NewException {
        LineItem[] ecoliteRoof = new LineItem[1];

        if (length <= 300) {
            ecoliteRoof[0] =new LineItem("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(9).getMaterialenavn(), 300, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 480) {
            ecoliteRoof[0] = new LineItem("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(), 480, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 600) {
            ecoliteRoof[0] = new LineItem("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn(), 600, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length > 600) {
            //OBS! Skal laves færdig!
            ecoliteRoof[0] = new LineItem("Ring til supporten", Business.LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(), 600, calculateNumberOfEcoliteRoof(width), "Stk");
          
        }

        return ecoliteRoof;
    }
    
    public static LineItem[] woodForShed(double skurLængde, double skurBredde) throws NewException {
        LineItem[] woodForShed = new LineItem[5];
        
        //Fast størrelse
        woodForShed[0] = new LineItem("Til z på bagside af dør", Business.LogicFacade.getMaterialeByVarenummer(3).getMaterialenavn(), 420, 1, "Stk");
        //OBS! Denne skal rettes til i forbindelse med antal!
        woodForShed[1] = new LineItem("Løsholter til skurgavle", Business.LogicFacade.getMaterialeByVarenummer(4).getMaterialenavn(), skurLængde, 4, "Stk");
        //OBS! Denne skal rettes til
        woodForShed[2] = new LineItem("Løsholter til skur sider", Business.LogicFacade.getMaterialeByVarenummer(4).getMaterialenavn(), skurBredde, 4, "Stk");
        woodForShed[3] = new LineItem("Remme i sider, sadles ned i stolper, skur-del", Business.LogicFacade.getMaterialeByVarenummer(5).getMaterialenavn(), CalculateWidthForRemmeISiderSkur(skurBredde), 4, "Stk");
        woodForShed[4] = new LineItem("Til beklædning af skur 1 på 2", Business.LogicFacade.getMaterialeByVarenummer(7).getMaterialenavn(), 210, (int) CalculateBeklædningShed(skurBredde,skurLængde), "Stk");
        
        return woodForShed;
    }
    
    public static LineItem[] screwsAndBracketShed(double skurLængde, double skurBredde) throws NewException {
        LineItem[] screwsAndBracketShed = new LineItem[3];
        
        screwsAndBracketShed[0] = new LineItem("Til lås på dør i skur", Business.LogicFacade.getMaterialeByVarenummer(23).getMaterialenavn(), 1, "Sæt");
        screwsAndBracketShed[1] = new LineItem("Til skurdør", Business.LogicFacade.getMaterialeByVarenummer(24).getMaterialenavn(), 2, "Stk");
        //OBS! Høre sammen med antal løsholter til skur. Skal udregnes på baggrund af løsholter til skur
        screwsAndBracketShed[2] = new LineItem("Til montering af løsholter i skur", Business.LogicFacade.getMaterialeByVarenummer(25).getMaterialenavn(), 32, "Stk");
        
        return screwsAndBracketShed;
    }

    
    //Regnemetoder
    private static double CalculateBeklædningShed(double skurBredde, double skurLængde) {
        return 2*skurBredde/10+2*skurLængde/10;
    }

    private static double CalculateWidthForRemmeISiderSkur(double skurBredde) {
        return skurBredde*2;
    }

    private static int calculateNumberOfEcoliteRoof(double width) {
      int numberOfRoof;
        if (width % 100 > 0 && width % 100 < 50) {
           numberOfRoof=((int) Math.round(width / 100) + 1);
        } else {
          numberOfRoof=((int) Math.round(width / 100));
        }
        return numberOfRoof;
      
}
   

    private static int calculateNumberOfRafters(double length) {
        return Business.Calculator.numberOfRafters(length);
    }

}
