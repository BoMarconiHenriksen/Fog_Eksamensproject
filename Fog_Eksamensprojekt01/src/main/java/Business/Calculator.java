/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

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

  MaterialeMapper mam = new MaterialeMapper();
    // her bør man være opmærksom på at base længde skal have fratrukket skuret længde på sternen
   public double addDimensionSizeToMaterial(int dim, int baseDim) {
        double dimAdd = dim-baseDim;
        return dimAdd;
    }
   
    public double priceQtyTimesMaterial(double lgd, double enhedstr, double pris, double qty) {
        double str = lgd / enhedstr;
        double prisprtype = pris * str * qty;
        return prisprtype;
    }

 

    public double priceTotalPriceCarport(List<LineItem> carport) throws NewException {
       
        double priceTotalCarport = 0;
       
        for (int i=0; i<carport.size();i++){
             double lgd = 240;
             double enhedstr = LogicFacade.getLineItem().get(i).getMat().getMsr();
             double pris = LogicFacade.getLineItem().get(i).getMat().getEnhedspris();
             double qty = LogicFacade.getLineItem().get(i).getLin().getAntal();
              
            carport.get(i).setTotalPrice(priceQtyTimesMaterial(lgd, enhedstr, pris, qty));
        }
            for (int j=1;j<carport.size();j++){
         priceTotalCarport = carport.get(j).getTotalPrice();
      }
       
        return priceTotalCarport;
    }

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();

        double totalPriceLine = calc.priceQtyTimesMaterial(330, 100, 12.56, 4);
        double height = calc.addDimensionSizeToMaterial(270,240);
        List<LineItem> carport = LogicFacade.getLineItem();
        
        System.out.println(calc.priceTotalPriceCarport(carport));
    }

}
