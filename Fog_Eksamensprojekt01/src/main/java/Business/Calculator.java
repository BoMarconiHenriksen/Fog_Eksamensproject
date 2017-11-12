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

    // her bør man være opmærksom på at base længde skal have fratrukket skuret længde på sternen ved skur
    public double addDimensionSizeToMaterial(double size, double baseSize) {
        double dimAdd = size - baseSize;
        return dimAdd;
    }

    public double priceQtyTimesMaterial(double lgd, double enhedstr, double pris, double qty) {
        double str = lgd / enhedstr;
        double prisprtype = pris * str * qty;
        return prisprtype;
    }

    public double priceTotalPriceCarportUdenSkur(List<LineItem> carport, double length, double width, double height) throws NewException {

        double priceTotalCarport = 0;
        double lgd = 0;
        for (int i = 0; i < carport.size(); i++) {

            switch (carport.get(i).getLin().getDimension()) {
                case "l":
                    lgd = length + addDimensionSizeToMaterial(length, carport.get(i).getLin().getBaselength());
                    break;
                case "b":
                    lgd = width + addDimensionSizeToMaterial(width, carport.get(i).getLin().getBaselength());
                    break;
                case "h":
                    lgd = height + addDimensionSizeToMaterial(height, carport.get(i).getLin().getBaselength());
                    break;
                case "s":
                    lgd = 0;
                    break;
                case "c":
                    lgd = addDimensionSizeToMaterial(1, carport.get(i).getLin().getBaselength());
                    break;
            }

            double enhedstr = LogicFacade.getLineItem().get(i).getMat().getMsr();
            double pris = LogicFacade.getLineItem().get(i).getMat().getEnhedspris();
            double qty = LogicFacade.getLineItem().get(i).getLin().getAntal();  
            
         
            carport.get(i).setTotalPrice(priceQtyTimesMaterial(lgd, enhedstr, pris, qty));
        
        
         priceTotalCarport = carport.get(i).getTotalPrice();
  
       
        return priceTotalCarport;
    }   return priceTotalCarport;
}

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();

       

        List<LineItem> carport = LogicFacade.getLineItem();

        System.out.println(calc.priceTotalPriceCarportUdenSkur(carport, 780, 600, 225));
    }

}
