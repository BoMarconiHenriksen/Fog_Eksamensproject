package Utillities;

import Presentation.NewException;

/**
 *
 * @author BenedikteEva
 */
public class XXRendSvg {

    StringBuilder sb = new StringBuilder();

    public String simpelCarport(double length, double width, double skurlength, double skurwidth) {

        StringBuilder sb = new StringBuilder();
        int spærAntal = (int) Math.round(length / 55);

        sb.append(setSvgCanvas(length, width));
        sb.append(rammen(length, width));
        sb.append(remme(length, width));

//        sb.append(ydreSpær(width, length));
        for (int i = 0; i <= spærAntal; i++) {

            sb.append(spærX(width, i));
        }

        sb.append(stolper(length, width));
        sb.append(hulBånd(length, width));
        sb.append(skur(length, width, skurlength, skurwidth));
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

    private String spærX(double width, double posX) {
        String spær = " <rect x=\"" + (posX) * 55 + "\" y=\"0\" height=\""
                + width + "\" width=\"2.5\"\n  style=\"stroke:#000000; fill: #ffffff\"/>";
        return spær;
    }

    private String rammen(double length, double width) {
        String ramme = " <rect x=\"0\" y=\"0\" height=\"" + width + "\" width=\"" + length + "\"\n"
                + "style=\"stroke:#000000; fill: #ffffff\"/>";
        return ramme;

    }

    private String ydreSpær(double length, double width) {
        String ydreSpær = (" <rect x=\"0\" y=\"0\" height=\"" + width + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                + "        <rect x=\"" + (length - 4) + "\" y=\"0\" height=\"" + width + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>");
        return ydreSpær;

    }

    private String remme(double length, double width) {
        String lægter = (" <rect x=\"0\" y=\"30\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>\n"
                + "        <rect x=\"0\" y=\"" + (width - 30) + "\" height=\"2.5\" width=\"" + length + "\"\n"
                + "              style=\"stroke:#000000; fill: #ffffff\"/>");
        return lægter;
    }

    private String stolper(double length, double width) {
        String stolper = " <rect x=\"105\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (length - 55) + "\" y=\"28\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"105\" y=\"" + (width - 30) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n"
                + "        <rect x=\"" + (length - 55) + "\" y=\"" + (width - 30) + "\" height=\"9.7\" width=\"9.7\"\n"
                + "              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";
        return stolper;
    }

    private String hulBånd(double length, double width) {
        String hulbaand = " <line x1=\"53\"x2=\"" + (length - 30) + "\" y1=\"30\" y2=\"" + (width - 30) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\"56\"x2=\"" + (length - 30) + "\" y1=\"" + (width - 30) + "\" y2=\"30\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>  \n"
                + "\n"
                + "        <line x1=\"53\"x2=\"" + (length - 30) + "\" y1=\"" + (width - 30) + "\" y2=\"30\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000; opacity: 0.6 \"/>\n"
                + "\n"
                + "        <line x1=\"56\"x2=\"" + (length - 30) + "\" y1=\"30\" y2=\"" + (width - 30) + "\" width=\"10\"\n"
                + "              stroke-dasharray=\"10,10\"\n"
                + "              style=\"stroke:#000000;   opacity: 0.6 \"/>\n"
                + "        </svg>";
        return hulbaand;
    }

    private String skur(double length, double width, double skurlength, double skurwidth) {

        String skurFlade = "<rect x=\"" + (length - 30 - skurwidth) + "\" y=\"30\" height=\"" + skurlength + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #gg0000;  opacity: 0.2\"/>\n"
                + "        <rect x=\"" + (length - 30 - skurwidth) + "\" y=\"30\" height=\"" + skurlength + "\" width=\"" + skurwidth + "\"\n"
                + "              style=\"stroke:#000000; fill: #gg0000;  opacity: 0.2\"/>\n"
                + "        <rect x=\"" + (length - 30) + "\" y=\"30\" height=\"" + skurlength + "\" width=\"2.5\"\n"
                + "              style=\"stroke:#000000; fill: #gg0000;  opacity: 0.2\"/>";
//        String skurStolper="<rect x=\"550\" y=\"568\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"745\" y=\"568\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"550\" y=\"28\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>\n" +
//"        <rect x=\"745\" y=\"28\" height=\"9.7\" width=\"9.7\"\n" +
//"              style=\"stroke:#000000; fill: #000000;  opacity: 0.6\"/>";

        return skurFlade;

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
                + "                  font-size=\"40px\"\n"
                + "                  text-anchor=\"middle\"\n"
                + "                  style=\"writing-mode: tb;\">Height:" + width + "</text>\n"
                + "            <!-- Horizontal line %-->\n"
                + "            <line x1=\"200\"  y1=\"" + (width + 100) + "\" x2=\"" + (length + 200) + "\"   y2=\"" + (width + 100) + "\" \n"
                + "                style=\"stroke:#006600;\n"
                + "                       marker-start: url(#beginArrow);\n"
                + "                       marker-end: url(#endArrow);\"/>\n"
                + "            <text x=\"" + (length / 2 + 200) + "\" y=\"" + (width + 80) + "\"\n"
                + "                  font-size=\"40px\"\n"
                + "                  text-anchor=\"middle\">Width: " + (length) + "</text>\n"
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
    public static String dobbelCarportMskur(double length, double width, double skurLength, double skurWidth) {

        return null;

    }

    public static void main(String[] args) throws NewException {

        XXRendSvg rsvg = new XXRendSvg();
        System.out.println(rsvg.simpelCarport(480, 300, 210, 150));

    }

}
