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
    private double størrelse;
    private double totalPrice;
    private String beskrivelse;

    public LineItem(Materiale mat, double størrelse, double totalPrice, String beskrivelse) {
        this.mat = mat;
        this.størrelse = størrelse;
        this.totalPrice = totalPrice;
        this.beskrivelse = beskrivelse;
    }

    public Materiale getMat() {
        return mat;
    }

    public void setMat(Materiale mat) {
        this.mat = mat;
    }

    public double getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(double størrelse) {
        this.størrelse = størrelse;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return "LineItem{" + "mat=" + mat + ", st\u00f8rrelse=" + størrelse + ", totalPrice=" + totalPrice + ", beskrivelse=" + beskrivelse + '}';
    }
    
   
}
