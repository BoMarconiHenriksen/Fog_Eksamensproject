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
public class StykLinje {

    private int linjeliste_id;
    private String materialetype;
    private String dimension;
    private int baselength;
    private int antal;
    private String beskrivelse;

    public StykLinje(int linjeliste_id, String materialetype, String dimension, int baselength, int antal, String beskrivelse) {
        this.linjeliste_id = linjeliste_id;
        this.materialetype = materialetype;
        this.dimension = dimension;
        this.baselength = baselength;
        this.antal = antal;
        this.beskrivelse = beskrivelse;
    }

    public int getLinjeliste_id() {
        return linjeliste_id;
    }

    public void setLinjeliste_id(int linjeliste_id) {
        this.linjeliste_id = linjeliste_id;
    }

    public String getMaterialetype() {
        return materialetype;
    }

    public void setMaterialetype(String materialetype) {
        this.materialetype = materialetype;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getBaselength() {
        return baselength;
    }

    public void setBaselength(int baselength) {
        this.baselength = baselength;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Override
    public String toString() {
        return "StykLinje{" + "linjeliste_id=" + linjeliste_id + ", materialetype=" + materialetype + ", dimension=" + dimension + ", baselength=" + baselength + ", antal=" + antal + ", beskrivelse=" + beskrivelse + '}';
    }

}
