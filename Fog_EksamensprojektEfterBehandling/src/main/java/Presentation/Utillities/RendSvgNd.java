package Presentation.Utillities;

import Business.Exception.NewException;
import Business.LogicFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ticondrus
 */
public class RendSvgNd {
    
    StringBuilder sb = new StringBuilder();
    
    public String simpelCarportSide(double length, double width, double skurlength, double skurwidth) throws NewException {

        StringBuilder sb = new StringBuilder();

        sb.append(setSvgCanvas(length));
        sb.append(rammen(length, width));
        sb.append(remme(length, width, skurwidth));
        sb.append(roofPosts(length, width, skurwidth));
        
        if (skurlength != 0){
         int posX = (int) ( length - skurwidth - 15);
        for (int i = 0; i < skurwidth / 10; i++) {
     
            sb.append(skurBrædder(posX + i * 10));
        }
        }else{
        }
         

        sb.append(stolper(length, width, skurwidth));
        sb.append(pileOgTekst(length, width));
//        sb.append(markerMellemSpær(length, width));
        return sb.toString();
    }
    
     public String setSvgCanvas(double length) {
        sb.append(" <SVG width=\"75%\"  \n"
                + "\n"
                + "            <svg x=\"200\" y=\"200\" width=\"" + length * 4 + "\" height=\"" + 225 * 4 + "\" \n"
                + "             viewBox=\"0 0 " + (length + 200) + " " + (225 + 200) + "\"\n"
                + "        viewBox=\"0 0 " + length + " " + 225 + "\">\n"
                + "\n"
                + "        <svg x=\"200\" y=\"0\" width=\"" + length + "\" height=\"" + 225 + "\"\n"
                + "             viewBox=\"0 0 " + (length + 1) + " " + (225 + 1) + "\">\n");
        return sb.toString();
    }

     /**
      * Metoden tegner et skur i form af brædder, hvis ordren indeholdet et skur.
      * @param posX
      * @return 
      */
  private String skurBrædder(int posX) {
        String boards = " <rect x=\"" + (posX) + "\" y=\"15\" height=\""
               + 210 + "\" width=\"10\"\n  style=\"stroke:#000000; fill: #ffffff\"/>";
        return boards;
    }

    /**
     * Metoden tegener et streg rundt om canvaset.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en streg rundt om canvaset.
     */
    private String rammen(double length, double width) {
        String ramme = " <rect x=\"0\" y=\"0\" height=\"" + width + "\" width=\"" + length + "\"\n"
                + "style=\"stroke:#000000; fill: #ffffff\"/>";
        return ramme;

    }

    /**
     * Metoden tegner remmene på tegningen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return remmene på tegningen.
     */
    private String remme(double length, double width, double skurwidth) {
        String lægter = (" <rect x=\"0\" y=\"15\" height=\"9.7\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                +" <rect x=\"0\" y=\"20\" height=\"9.7\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n");
        return lægter;
    }
    
    private String roofPosts(double length, double width, double skurwidth){
        
        String roofPost = ( "<polygon points=\"2, 2," + (length - 3) + ", 3," + (length - 3) + ", 15.5, 1, 12.5\"" + "\"\n"
                + "style=\"fill:khaki;stroke:darkgoldenrod;stroke-width:1\"/>\n");
                
      return roofPost;
        
    }

    /**
     * Metoden tegner stoplerne på carporten.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurwidth er skurets bredde.
     * @return stolperne på carporten.
     */
    private String stolper(double length, double width, double skurwidth) throws NewException {
        String stolper = " <rect x=\"" + (1 * LogicFacade.spaceBetweenRafters(length) - 5) + "\" y=\"13\" height=\"215\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.4\"/>\n"
                + "        <rect x=\"" + (length - 5 - 2 * LogicFacade.spaceBetweenRafters(length) - (skurwidth - LogicFacade.spaceBetweenRafters(length))) + "\" y=\"13\" height=\"215\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.4\"/>\n"
                + "        </svg>";
        return stolper;
    }

    /**
     * Metoden tegner pile og teksten til tegningen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return pile og tekst til tegningen.
     */
    private String pileOgTekst(double length, double width) {
        String pileOgTekst = " <defs>\n"
                + "    <marker id=\"beginArrow\" \n"
                + "            markerWidth=\"18\" markerHeight=\"18\" \n"
                + "            refX=\"0\" refY=\"9\" \n"
                + "            orient=\"auto\">\n"
                + "        <path d=\"M0,9 L16,0 L16,16 L0,9\" style=\"fill: #000000;\" />\n"
                + "        \n"
                + "    </marker>\n"
                + "    <marker id=\"endArrow\" \n"
                + "            markerWidth=\"18\" markerHeight=\"18\" \n"
                + "            refX=\"18\" refY=\"9\" \n"
                + "            orient=\"auto\">\n"
                + "        <path d=\"M0,0 L16,9 L0,16 L0,0\" style=\"fill: #000000;\" />\n"
                + "    </marker>\n"
                + "    </defs>\n"
                + "\n"
                + "         <!-- Vertical line -->\n"
                + "            <line x1=\"100\"  y1=\"0\" x2=\"100\" y2=\"" + 225 + "\" \n"
                + "                style=\"stroke:#006600;\n"
                + "                       marker-start: url(#beginArrow);\n"
                + "                       marker-end: url(#endArrow);\"/>\n"
                + "            <text x=\"140\" y=\"" + 225 / 2 + "\"\n"
                + "                  font-size=\"30px\"\n"
                + "                  text-anchor=\"middle\"\n"
                + "                  style=\"writing-mode: tb;\">Højde: " + 225 + "</text>\n"
                + "            <!-- Horizontal line %-->\n"
                + "            <line x1=\"200\"  y1=\"" + (225 + 100) + "\" x2=\"" + (length + 200) + "\"   y2=\"" + (225 + 100) + "\" \n"
                + "                style=\"stroke:#006600;\n"
                + "                       marker-start: url(#beginArrow);\n"
                + "                       marker-end: url(#endArrow);\"/>\n"
                + "            <text x=\"" + (length / 2 + 200) + "\" y=\"" + (225 + 80) + "\"\n"
                + "                  font-size=\"30px\"\n"
                + "                  text-anchor=\"middle\">Længde: " + (length) + "</text>\n"
                + "</svg>\n"
                + "</SVG>\n"
                + "";
        return pileOgTekst;
    }

    /**
     * Metoden bruges til test.
     * @param args
     * @throws NewException 
     */
    public static void main(String[] args) throws NewException {
        int length = 600;
        RendSvg rsvg = new RendSvg();
        int spærAntalCirka = (int) Math.round(length / 55);
        int restSpærAntal = (int) length % spærAntalCirka;
        int rigtigSpærAntal = (int) length - restSpærAntal;
        double afstandMellemSpær = (((int) Math.round(length / (spærAntalCirka))) - ((int) length % spærAntalCirka) / (spærAntalCirka));
        int spærAntal = (int) Math.round(length / (afstandMellemSpær));
        System.out.println(rsvg.simpelCarport(480,300, 270,150));
//        System.out.println(rsvg.simpelCarport(480, 300, 210, 150));

    }

}