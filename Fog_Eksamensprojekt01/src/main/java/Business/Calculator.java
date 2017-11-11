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
 *
 *
 */
public class Calculator {

    MaterialeMapper mam = new MaterialeMapper();
    // det metoden gør at    

    public double priceQtyTimesMaterial(double lgd, double enhedstr, double pris, double qty) {
        double str = lgd / enhedstr;
        double prisprtype = pris * str * qty;
        return prisprtype;
    }

    public double dimensionDependency(double length, double height, double width) throws NewException {
       
        
        
        
        
       return 0;
}

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        double total = calc.priceQtyTimesMaterial(330, 100, 12.56, 4);
        System.out.println(total);
    }

}
