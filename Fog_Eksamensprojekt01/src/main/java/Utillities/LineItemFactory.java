/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.Calculator;
import Business.LogicFacade;
import Domain.LineItem2;
import Presentation.NewException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class LineItemFactory {

//    (String description, String material_name, double dimension, int amount, String unit)

    public static LineItem2[] baseTree(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne

      
        LineItem2[] baseTree = new LineItem2[8];


        baseTree[0] = new LineItem2("Understern brædder til for- og bagende", Business.LogicFacade.getMaterialeByVarenummer(1).getMaterialenavn(), width, 2, "Stk");
        baseTree[1] = new LineItem2("Understernbrædder til siderne", Business.LogicFacade.getMaterialeByVarenummer(1).getMaterialenavn(), length, 2, "Stk");
        baseTree[2] = new LineItem2("Oversternbrædder til forenden", Business.LogicFacade.getMaterialeByVarenummer(2).getMaterialenavn(), width, 2, "Stk");
        baseTree[3] = new LineItem2("Oversternbrædder til siderne", Business.LogicFacade.getMaterialeByVarenummer(2).getMaterialenavn(), length, 2, "Stk");
        baseTree[4] = new LineItem2("Spær, monteres på rem", Business.LogicFacade.getMaterialeByVarenummer(5).getMaterialenavn(), width, calculateNumberOfRafters(length), "Stk");
        baseTree[5] = new LineItem2("Stolper, nedgraves i 90 cm. jord", Business.LogicFacade.getMaterialeByVarenummer(6).getMaterialenavn(), 300, 11, "Stk");
        baseTree[6] = new LineItem2("Vandbrædt på stern i sider", Business.LogicFacade.getMaterialeByVarenummer(7).getMaterialenavn(), length, 4, "Stk");
        baseTree[7] = new LineItem2("Vandbrædt på stern i forenden", Business.LogicFacade.getMaterialeByVarenummer(7).getMaterialenavn(), width, 2, "Stk");

        return baseTree;

    }
    
      public static LineItem2[] carportBaseMetal(double width, double length) throws NewException {   // denne carport skal være mindre end 540 på ledderne
      
        LineItem2[] baseMetal = new LineItem2[8];

        baseMetal[0] = new LineItem2("Skuer til tagplader", Business.LogicFacade.getMaterialeByVarenummer(13).getMaterialenavn(), 0, Calculator.numberOfBottomScrewsPackageEcolite(length, width), "Pakke");
        baseMetal[1] = new LineItem2("Til vindkryds på spær", Business.LogicFacade.getMaterialeByVarenummer(14).getMaterialenavn(), 0, 2, "Stk");
        baseMetal[2] = new LineItem2("Til montering af spær på rem", Business.LogicFacade.getMaterialeByVarenummer(15).getMaterialenavn(), length, Calculator.numberOfRafters(length), "Rulle");
        baseMetal[3] = new LineItem2("Til montering af spær på rem", Business.LogicFacade.getMaterialeByVarenummer(16).getMaterialenavn(), length, 2, "Stk");
        baseMetal[4] = new LineItem2("Til montering af stern & vandbrædt", Business.LogicFacade.getMaterialeByVarenummer(17).getMaterialenavn(), length, 2, "Stk");
        return baseMetal;

    }  
    

    public static LineItem2[] ecoliteRoof(double width, double length) throws NewException {
        LineItem2[] ecoliteRoof = new LineItem2[1];

        if (length <= 300) {
            ecoliteRoof[0] =new LineItem2("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(9).getMaterialenavn(), length, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 480) {
            ecoliteRoof[0] = new LineItem2("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(), length, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length <= 600) {
            ecoliteRoof[0] = new LineItem2("Tagplader monteres på spær", Business.LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn(), length, calculateNumberOfEcoliteRoof(width), "Stk");
        } else if (length > 600) {
            //OBS! Skal laves færdig!
            ecoliteRoof[0] = new LineItem2("Ring til supporten", Business.LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(), length, calculateNumberOfEcoliteRoof(width), "Stk");
          
        }

        return ecoliteRoof;
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
