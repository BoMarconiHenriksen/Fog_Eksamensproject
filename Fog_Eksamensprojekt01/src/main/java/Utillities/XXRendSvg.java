package Utillities;

import Business.Calculator;
import Presentation.NewException;

/**
 *
 * @author BenedikteEva
 */
public class XXRendSvg {

    StringBuilder sb = new StringBuilder();

    public String simpelCarport(double length, double width, double skurlength, double skurwidth) {

        StringBuilder sb = new StringBuilder();

        sb.append(setSvgCanvas(length, width));
        sb.append(rammen(length, width));
        sb.append(remme(length, width));

        sb.append(ydreSpær(width, length));
        for (int i = 0; i <= Calculator.antalSpær(length); i++) {

            sb.append(spærX(width, i, (int) Calculator.afstandMellemSpær(length)));
        }

        sb.append(stolper(length, width, skurwidth));
        sb.append(skur(length, width, skurlength, skurwidth));
        sb.append(hulBånd(length, width));
        sb.append(pileOgTekst(length, width));
//        sb.append(markerMellemSpær(length, width));
        return sb.toString();
    }

    public String setSvgCanvas(double length, double width) {
        sb.append(" <SVG width=\"75%\"  \n"
                + "\n"
                + "             <svg x=\"200\" y=\"200\" width=\"" + length * 2 + "\" height=\"" + width * 2 + "\" \n"
                + "             viewBox=\"0 0 " + (length + 200) + " " + (width + 200) + "\"\n"
                + "        viewBox=\"0 0 " + length + " " + width + "\">\n"
                + "\n"
                + "        <svg x=\"200\" y=\"0\" width=\"" + length + "\" height=\"" + width + "\"\n"
                + "             viewBox=\"0 0 " + (length + 1) + " " + (width + 1) + "\">\n");
        return sb.toString();
    }

    private String spærX(double width, double posX, int afstandMellemSpær) {
        String spær = " <rect x=\"" + (posX) * afstandMellemSpær + "\" y=\"0\" height=\""
                + width + "\" width=\"2.5\"\n  style=\"stroke:#000000; fill: #ffffff\"/>";
        return spær;
    }

    private String rammen(double length, double width) {
        String ramme = " <rect x=\"0\" y=\"0\" height=\"" + width + "\" width=\"" + length + "\"\n"
                + "style=\"stroke:#000000; fill: #ffffff\"/>";
        return ramme;

    }

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
    private String remme(double length, double width) {
        String lægter = (" <rect x=\"0\" y=\"30\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                + "        <rect x=\"0\" y=\"" + (width - 30) + "\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>");
        return lægter;
    }

    private String stolper(double length, double width, double skurwidth) {
        String stolper = " <rect x=\""+(1*Calculator.afstandMellemSpær(length)-5)+"\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\""+(length-5-2*Calculator.afstandMellemSpær(length))+"\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\""+(length-5-2*Calculator.afstandMellemSpær(length))+"\" y=\"" + (width - 35) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\""+(1*Calculator.afstandMellemSpær(length)-5)+"\" y=\"" + (width - 35) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";
        return stolper;
    }

    private String skur(double length, double width, double skurlength, double skurwidth) {

        String skurFlade = "     <rect x=\"" + (length - 30 - skurwidth * 100) + "\" y=\"30\" height=\"" + ((skurlength * 100)) + "\" width=\"" + (skurwidth * 100) + "\"\n"
                + "              style=\"stroke:#000000; fill: #gg0000;  opacity: 0.2\"/>";
//        String skurStolper="<rect x=\"" + (length - skurwidth-0.3) + "\" y=\"30\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"745\" y=\"568\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"" + (length - skurwidth-0.3) + "\" y=\"28\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"745\" y=\"28\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";

        return skurFlade;
    }
   

    private String hulBånd(double length, double width) {
        String hulbaand = " <line x1=\""+(Calculator.afstandMellemSpær(length)-2)+"\"x2=\"" + (length - (Calculator.afstandMellemSpær(length))) + "\" y1=\"30\" y2=\"" + (width - 30) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\""+(Calculator.afstandMellemSpær(length)+2)+"\"x2=\"" + (length - (Calculator.afstandMellemSpær(length))) + "\" y1=\"" + (width - 30) + "\" y2=\"30\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>  \n"
                + "\n"
                + "        <line x1=\""+(Calculator.afstandMellemSpær(length)-2)+"\"x2=\"" + (length - (Calculator.afstandMellemSpær(length))) + "\" y1=\"" + (width - 30) + "\" y2=\"30\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\""+(Calculator.afstandMellemSpær(length)+2)+"\"x2=\"" + (length - (Calculator.afstandMellemSpær(length))) + "\" y1=\"30\" y2=\"" + (width - 30) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "        </svg>";
        return hulbaand;
    }

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




    public static void main(String[] args) throws NewException {
        int length = 600;
        XXRendSvg rsvg = new XXRendSvg();
        int spærAntalCirka = (int) Math.round(length / 55);
        int restSpærAntal = (int) length % spærAntalCirka;
        int rigtigSpærAntal = (int) length - restSpærAntal;
        double afstandMellemSpær = (((int) Math.round(length / (spærAntalCirka))) - ((int) length % spærAntalCirka) / (spærAntalCirka));
        int spærAntal = (int) Math.round(length / (afstandMellemSpær));
        System.out.println(afstandMellemSpær);
//        System.out.println(rsvg.simpelCarport(480, 300, 210, 150));

    }

}
