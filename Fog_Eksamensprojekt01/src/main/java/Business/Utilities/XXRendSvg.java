package Business.Utilities;

import Business.LogicFacade;
import Business.Exception.NewException;

/**
 * Klassen tegner en carport og en carport med skur.
 *
 */
public class XXRendSvg {

    StringBuilder sb = new StringBuilder();

    /**
     * Metoden kører de metoder, der skal til for at tegne en carport.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurlength er skurets længde.
     * @param skurwidth er skurets bredde.
     * @return en tegning af en carport.
     * @throws Business.Exception.NewException
     */
    public String simpelCarport(double length, double width, double skurlength, double skurwidth) throws NewException {

        StringBuilder sb = new StringBuilder();

        sb.append(setSvgCanvas(length, width));
        sb.append(rammen(length, width));
        sb.append(remme(length, width));

        sb.append(ydreSpær(width, length));
        for (int i = 0; i <= LogicFacade.numberOfRafters(length); i++) {

            sb.append(spærX(width, i, (int) LogicFacade.spaceBetweenRafters(length)));
        }

        sb.append(stolper(length, width, skurwidth));
        sb.append(skur(length, width, skurlength, skurwidth));
        sb.append(hulBånd(length, width, skurwidth));
        sb.append(pileOgTekst(length, width));
//        sb.append(markerMellemSpær(length, width));
        return sb.toString();
    }

    /**
     * Metoden laver et canvas og en viewport.
     * @param length er skurets længde.
     * @param width er skurets bredde.
     * @return et canvas med viewport.
     */
    public String setSvgCanvas(double length, double width) {
        sb.append(" <SVG width=\"75%\"  \n"
                + "\n"
                + "            <svg x=\"200\" y=\"200\" width=\"" + length * 2 + "\" height=\"" + width * 2 + "\" \n"
                + "             viewBox=\"0 0 " + (length + 200) + " " + (width + 200) + "\"\n"
                + "        viewBox=\"0 0 " + length + " " + width + "\">\n"
                + "\n"
                + "        <svg x=\"200\" y=\"0\" width=\"" + length + "\" height=\"" + width + "\"\n"
                + "             viewBox=\"0 0 " + (length + 1) + " " + (width + 1) + "\">\n");
        return sb.toString();
    }

    /**
     * Metoden tegner spær på tegningen med den rigtige afstand.
     * @param width er carportens bredde.
     * @param posX er afstanden fra et spær til der, hvor det næste spær skal placeres.
     * @param afstandMellemSpær er afstanden mellem spær.
     * @return spærende på tegningen. 
     */
    private String spærX(double width, double posX, int afstandMellemSpær) {
        String spær = " <rect x=\"" + (posX) * afstandMellemSpær + "\" y=\"0\" height=\""
                + width + "\" width=\"2.5\"\n  style=\"stroke:#000000; fill: #ffffff\"/>";
        return spær;
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
     * Metoden tegner de ydre spær.
     * @param width er carportens længde.
     * @param length er carportens bredde.
     * @return de ydre spær på tegningen.
     */
    private String ydreSpær(double width, double length) {
        String ydreSpær = (" <rect x=\"0\" y=\"0\" height=\"" + width + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                + "        <rect x=\"" + (length - 2.5) + "\" y=\"0\" height=\"" + width + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>");
        return ydreSpær;

    }

//     <rect x="0" y="0" height="300" width="2.5"
//          style="stroke:#000000; fill: #ffffff"/>
//  
//          <rect x="477" y="0" height="300" width="2.5"
//          style="stroke:#000000; fill: #ffffff"/>
    /**
     * Metoden tegner remmene på tegningen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return remmene på tegningen.
     */
    private String remme(double length, double width) {
        String lægter = (" <rect x=\"0\" y=\"15\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                + "        <rect x=\"0\" y=\"" + (width - 15) + "\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>");
        return lægter;
    }

    /**
     * Metoden tegner stoplerne på carporten.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurwidth er skurets bredde.
     * @return stolperne på carporten.
     */
    private String stolper(double length, double width, double skurwidth) throws NewException {
        String stolper = " <rect x=\"" + (1 * LogicFacade.spaceBetweenRafters(length) - 5) + "\" y=\"13\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (length - 5 - 2 * LogicFacade.spaceBetweenRafters(length) - (skurwidth - LogicFacade.spaceBetweenRafters(length))) + "\" y=\"13\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (length - 5 - 2 * LogicFacade.spaceBetweenRafters(length) - (skurwidth - LogicFacade.spaceBetweenRafters(length))) + "\" y=\"" + (width - 17) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (1 * LogicFacade.spaceBetweenRafters(length) - 5) + "\" y=\"" + (width - 17) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";
        return stolper;
    }

    /**
     * Metoden tegner et skur.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurlength er skurets længde.
     * @param skurwidth er skurets bredde.
     * @return et skur, der bliver tegnet på carporte tegningen.
     */
    private String skur(double length, double width, double skurlength, double skurwidth) {

        String skurFlade = "     <rect x=\"" + (length - 15 - skurwidth) + "\" y=\"15\" height=\"" + ((skurlength)) + "\" width=\"" + (skurwidth) + "\"\n"
                + "              style=\"stroke:#000000; fill: #gg0000;  opacity: 0.2\"/>";
        String skurStolper = "<rect x=\"" + (length - skurwidth - 0.3) + "\" y=\"30\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"745\" y=\"568\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (length - skurwidth - 0.3) + "\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"745\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";

        return skurFlade;
    }

    /**
     * Metoden tegner hulbånd(krydset med dobbelt streger).
     * @param length er carportens længde.
     * @param width er skurets bredde.
     * @param skurwidth er skurets bredde.
     * @return en dobbelt streg med huller i placeret som et kryds.
     */
    private String hulBånd(double length, double width, double skurwidth) throws NewException {
        String hulbaand = " <line x1=\"" + (LogicFacade.spaceBetweenRafters(length) - 2) + "\"x2=\"" + (length - skurwidth - 15) + "\" y1=\"15\" y2=\"" + (width - 15) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\"" + (LogicFacade.spaceBetweenRafters(length) + 2) + "\"x2=\"" + (length - skurwidth - 15) + "\" y1=\"" + (width - 15) + "\" y2=\"15\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>  \n"
                + "\n"
                + "        <line x1=\"" + (LogicFacade.spaceBetweenRafters(length) - 2) + "\"x2=\"" + (length - skurwidth - 15) + "\" y1=\"" + (width - 15) + "\" y2=\"15\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\"" + (LogicFacade.spaceBetweenRafters(length) + 2) + "\"x2=\"" + (length - skurwidth - 15) + "\" y1=\"15\" y2=\"" + (width - 15) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "        </svg>";
        return hulbaand;
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
                + "            <line x1=\"100\"  y1=\"0\" x2=\"100\" y2=\"" + width + "\" \n"
                + "                style=\"stroke:#006600;\n"
                + "                       marker-start: url(#beginArrow);\n"
                + "                       marker-end: url(#endArrow);\"/>\n"
                + "            <text x=\"140\" y=\"" + width / 2 + "\"\n"
                + "                  font-size=\"30px\"\n"
                + "                  text-anchor=\"middle\"\n"
                + "                  style=\"writing-mode: tb;\">Bredde: " + width + "</text>\n"
                + "            <!-- Horizontal line %-->\n"
                + "            <line x1=\"200\"  y1=\"" + (width + 100) + "\" x2=\"" + (length + 200) + "\"   y2=\"" + (width + 100) + "\" \n"
                + "                style=\"stroke:#006600;\n"
                + "                       marker-start: url(#beginArrow);\n"
                + "                       marker-end: url(#endArrow);\"/>\n"
                + "            <text x=\"" + (length / 2 + 200) + "\" y=\"" + (width + 80) + "\"\n"
                + "                  font-size=\"30px\"\n"
                + "                  text-anchor=\"middle\">Længde: " + (length) + "</text>\n"
                + "</svg>\n"
                + "</SVG>\n"
                + "";
        return pileOgTekst;
    }

//    private String markerMellemSpær(double length, double width) {
//        String markerMellemSpær = " <defs>\n"
//                + "    <marker id=\"beginLine\" \n"
//                + "            markerWidth=\"18\" markerHeight=\"18\" \n"
//                + "            refX=\"0\" refY=\"9\" \n"
//                + "            orient=\"auto\">\n"
//                + "        <path d=\"M0,9  L0,9\" style=\"fill: #000000;\" />\n"
//                + "        \n"
//                + "    </marker>\n"
//                + "    <marker id=\"endLine\" \n"
//                + "            markerWidth=\"18\" markerHeight=\"18\" \n"
//                + "            refX=\"18\" refY=\"9\" \n"
//                + "            orient=\"auto\">\n"
//                + "        <path d=\"M0,0  L0,0\" style=\"fill: #000000;\" />\n"
//                + "    </marker>\n"
//                + "    </defs>\n"
//                + "\n"
//                + "            <!-- Horizontal line %-->\n"
//                + "            <line x1=\"0\"  y1=\"10\" x2=\"" + 55 + "\"   y2=\"10\" \n"
//                + "                style=\"stroke:#006600;\n"
//                + "                       marker-start: url(#beginLine);\n"
//                + "                       marker-end: url(#endLine);\"/>\n"
//                + "            <text x=\"" + (10) + "\" y=\"" + (width + 80) + "\"\n"
//                + "                  font-size=\"40px\"\n"
//                + "                  text-anchor=\"middle\">55</text>\n"
//                + "</svg>\n"
//                + "";
//        return markerMellemSpær;
    
    /**
     * Metoden bruges til test.
     * @param args
     * @throws NewException 
     */
    public static void main(String[] args) throws NewException {
        int length = 600;
        XXRendSvg rsvg = new XXRendSvg();
        int spærAntalCirka = (int) Math.round(length / 55);
        int restSpærAntal = (int) length % spærAntalCirka;
        int rigtigSpærAntal = (int) length - restSpærAntal;
        double afstandMellemSpær = (((int) Math.round(length / (spærAntalCirka))) - ((int) length % spærAntalCirka) / (spærAntalCirka));
        int spærAntal = (int) Math.round(length / (afstandMellemSpær));
        System.out.println(rsvg.simpelCarport(480,300, 270,150));
//        System.out.println(rsvg.simpelCarport(480, 300, 210, 150));

    }

}
