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
 */
public class SkurCalculator {
    
    

  LogicFacade mat = new LogicFacade();
  
  /**
   * Beregner en samlet pris på skuret, med alle grundelementer samt alle skurger m.m
   * Prisen lægges så sammen med prisen på Carporten, som bliver beregnet i Calcualtor.java.
   * 
   * @param skurLængde lægnden af skuret
   * @param skurBredde bredden af skuret
   * @return totalPrisSkur
   * @throws NewException 
   */

    public double skurPrisBeregner(double skurLængde, double skurBredde) throws NewException {

        double LægteTilZ = mat.getMaterialeByVarenummer(3).getEnhedspris();
        double LøsholterSkurGavl = mat.getMaterialeByVarenummer(4).getEnhedspris();
        double LøsholterSkurSider = mat.getMaterialeByVarenummer(4).getEnhedspris();
        double BrædtSkurBeklædning = mat.getMaterialeByVarenummer(7).getEnhedspris();
        double SkruerYdersteBeklædning = mat.getMaterialeByVarenummer(21).getEnhedspris();
        double SkruerIndersteBeklædning = mat.getMaterialeByVarenummer(22).getEnhedspris();

        // ekstra Stolper:
        double stolpePris1 = mat.getMaterialeByVarenummer(6).getEnhedspris();
        double bræddeboltPris = mat.getMaterialeByVarenummer(19).getEnhedspris();//6 stk uden skur og enkelt
        double firkantSkivePris = mat.getMaterialeByVarenummer(20).getEnhedspris();
        double tilEkstraStolper = 4 * (firkantSkivePris + bræddeboltPris);
        //Ting der bruges til døren udover beklædningsbrædder:
        double StaldørsGreb = mat.getMaterialeByVarenummer(23).getEnhedspris();
        double THængselSkur = mat.getMaterialeByVarenummer(24).getEnhedspris();
        double VinkelBeslagSkur = mat.getMaterialeByVarenummer(25).getEnhedspris();
        double dørTilbehørPris = LægteTilZ + StaldørsGreb + THængselSkur;
        // Her lægges alle skurdelene sammen 
        double totalPrisSkur = 12 * skurLængde/100 * LøsholterSkurSider + 4 * skurBredde/100* LøsholterSkurGavl
                + 4 * stolpePris1 + ((2 * skurLængde + 2 * skurBredde) / 10) * BrædtSkurBeklædning+VinkelBeslagSkur+
                + 2 * SkruerYdersteBeklædning + 2 * SkruerIndersteBeklædning + dørTilbehørPris + tilEkstraStolper;
        
       
        
        return totalPrisSkur;

    }
    
    /**
     *  Main metoden er kun brugt til tests i forbindelse med beregnerens udarbejdning.
     * @param args
     * @throws NewException 
     */

    public static void main(String[] args) throws NewException {

        SkurCalculator calc = new SkurCalculator();
         LogicFacade mat = new LogicFacade();

        System.out.println(calc.skurPrisBeregner(300, 300));
//        System.out.println(mat.getMaterialeByVarenummer(3).getMaterialenavn());

    }

}
