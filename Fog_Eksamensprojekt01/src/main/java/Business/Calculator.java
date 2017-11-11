/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MaterialeMapper;
import Data.StykLinjeMapper;
import Domain.LineItem;
import Presentation.NewException;
import java.util.ArrayList;
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
          priceTotalCarport = carport.get(i).getTotalPrice();
      }

        return priceTotalCarport;
    }

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();

        double totalPriceLine = calc.priceQtyTimesMaterial(330, 100, 12.56, 4);
        double height = calc.addDimensionSizeToMaterial(270,240);
        List<LineItem> carport = null;
        
        System.out.println(calc.priceTotalPriceCarport(carport));
    }

}
