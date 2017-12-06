/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author BenedikteEva
 */
public class Dimensioner {
    
    /**
     * Domænet indeholde variable i form af længde, højde og bredde, til brug af beregning for en gieven carport med eller uden de ønskede combinationer.
     */
    
    private int length;
    private int width;
    private int height;

    public Dimensioner(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
