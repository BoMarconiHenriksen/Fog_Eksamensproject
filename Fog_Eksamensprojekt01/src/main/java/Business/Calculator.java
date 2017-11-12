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
        for (int i = 1; i < carport.size(); i++) {

            if (carport.get(i).getLin().getDimension().equalsIgnoreCase("l")) {

                lgd = length + addDimensionSizeToMaterial(length, carport.get(i).getLin().getBaselength());

            } else if (carport.get(i).getLin().getDimension().equalsIgnoreCase("b")) {

                lgd = width + addDimensionSizeToMaterial(width, carport.get(i).getLin().getBaselength());

            } else if (carport.get(i).getLin().getDimension().equalsIgnoreCase("h")) {

                lgd = height + addDimensionSizeToMaterial(height, carport.get(i).getLin().getBaselength());

            } else if (carport.get(i).getLin().getDimension().equalsIgnoreCase("s")) {

                lgd = 0;

            } else if (carport.get(i).getLin().getDimension().equalsIgnoreCase("c")) {

                lgd = carport.get(i).getLin().getBaselength();

            }

            double enhedstr = LogicFacade.getLineItem().get(i).getMat().getMsr();
            double pris = LogicFacade.getLineItem().get(i).getMat().getEnhedspris();
            double qty = LogicFacade.getLineItem().get(i).getLin().getAntal();

            carport.get(i).setTotalPrice(priceQtyTimesMaterial(lgd, enhedstr, pris, qty));
            for (int j = 0; j < carport.size(); j++) {
                priceTotalCarport += carport.get(i).getTotalPrice();
            }

            return priceTotalCarport;
        }
        return priceTotalCarport;
    }

    public static void main(String[] args) throws NewException {
        Calculator calc = new Calculator();

        List<LineItem> carport = LogicFacade.getLineItem();

        System.out.println(calc.priceTotalPriceCarportUdenSkur(carport, 600, 420, 225));
    }

}
