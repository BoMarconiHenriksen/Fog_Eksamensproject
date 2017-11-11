/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Ejer
 */
public class LineItem {
    private Materiale mat;
    private StykLinje lin;
    private double totalPrice;

    public LineItem(Materiale mat, StykLinje lin, double totalPrice) {
        this.mat = mat;
        this.lin = lin;
        this.totalPrice = totalPrice;
    }

    public Materiale getMat() {
        return mat;
    }

    public void setMat(Materiale mat) {
        this.mat = mat;
    }

    public StykLinje getLin() {
        return lin;
    }

    public void setLin(StykLinje lin) {
        this.lin = lin;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
   

   
  

    
}
