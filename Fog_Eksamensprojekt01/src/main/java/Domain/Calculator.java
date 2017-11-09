/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author BenedikteEva
 *
 */
public class Calculator {

    
    public double priceQtyTimesMaterial(double lgd, double enhedstr, double pris, double qty){
      double  str= lgd/enhedstr;
      double  prisprtype = pris*str;
        return prisprtype;
    }
    
 public static void main(String[] args) {
     Calculator calc = new Calculator();
    
    double total = calc.priceQtyTimesMaterial(380, 100, 12.56, 4 );
     System.out.println(total);
 }

   
}


