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

    MaterialeMapper mat = new MaterialeMapper();

    private double skurPrisBeregner(double skurLængde, double skurBredde) throws NewException {

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
        double totalPrisSkur = 12 * skurLængde * LøsholterSkurSider + 4 * skurBredde * LøsholterSkurGavl
                + 4 * stolpePris1 + ((2 * skurLængde + 2 * skurBredde) * 10) * BrædtSkurBeklædning
                + 2 * SkruerYdersteBeklædning + 2 * SkruerIndersteBeklædning + dørTilbehørPris + tilEkstraStolper;
        
       
        
        return totalPrisSkur;

    }

    public static void main(String[] args) throws NewException {

        SkurCalculator calc = new SkurCalculator();
        MaterialeMapper mat = new MaterialeMapper();

        System.out.println(calc.skurPrisBeregner(3.20, 2.20));
        System.out.println(mat.getMaterialeByVarenummer(3).getMaterialenavn());

    }

}
