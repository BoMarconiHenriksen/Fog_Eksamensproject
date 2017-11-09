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
public class Materiale {

private int materiale_id;
private String materialetype;
private String materialenavn;
private double priceprpsc;

    public Materiale(int materiale_id, String materialetype, String materialenavn, double priceprpsc) {
        this.materiale_id = materiale_id;
        this.materialetype = materialetype;
        this.materialenavn = materialenavn;
        this.priceprpsc = priceprpsc;
    }

    public int getMateriale_id() {
        return materiale_id;
    }

    public void setMateriale_id(int materiale_id) {
        this.materiale_id = materiale_id;
    }

    public String getMaterialetype() {
        return materialetype;
    }

    public void setMaterialetype(String materialetype) {
        this.materialetype = materialetype;
    }

    public String getMaterialenavn() {
        return materialenavn;
    }

    public void setMaterialenavn(String materialenavn) {
        this.materialenavn = materialenavn;
    }

    public double getPriceprpsc() {
        return priceprpsc;
    }

    public void setPriceprpsc(double priceprpsc) {
        this.priceprpsc = priceprpsc;
    }
    
    





    
    
    
}
