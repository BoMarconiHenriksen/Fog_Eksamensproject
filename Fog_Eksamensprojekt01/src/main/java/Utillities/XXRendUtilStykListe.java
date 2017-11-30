package Utillities;

import Business.Calculator;
import Business.LogicFacade;
import Domain.LineItem;
import Domain.LineItem2;
import Presentation.NewException;
import java.util.List;

/**
 * Klassen bruges til at lave et udprint af styklisten
 *
 * @author Ticondrus
 */
public class XXRendUtilStykListe {

    public static String createLineItemList(StringBuilder sb, double length, double width, double skurLength, double skurWidth) throws NewException {
        LineItem2[] limes = LineItemFactory.baseTree(length, width);
        headLinesStykListe(sb);

        createLineItemListTree(sb, length, width);
        if(skurLength>0){
        lineItemWoodForShed(sb, skurLength, skurWidth);
        }
        
        createLineItemListMetal(sb, length, width);
        if (skurLength>0){
        lineItemMetalForShed(sb, skurLength, skurWidth);
        }
        lineItemEcoliteRoof(sb, length, width);

        return sb.toString();

    }

    public static String createLineItemListTree(StringBuilder sb, double length, double width) throws NewException {
        LineItem2[] limes = LineItemFactory.baseTree(width, length);
        sb.append("<br><tr><th>Træ</th></tr>\n");
        return forLoopLineItem(limes, sb);
    }

    public static String lineItemEcoliteRoof(StringBuilder sb, double length, double width) throws NewException {
        LineItem2[] limes = LineItemFactory.ecoliteRoof(width, length);
        sb.append("<br><tr><th>Tag</th></tr>\n");
        return forLoopLineItem(limes, sb);
    }
    
     public static String lineItemMetalForShed(StringBuilder sb, double skurlength, double skurwidth) throws NewException {
        LineItem2[] limes = LineItemFactory.screwsAndBracketShed(skurwidth, skurlength);
        return forLoopLineItem(limes, sb);
    }

    public static String lineItemWoodForShed(StringBuilder sb, double skurlength, double skurwidth) throws NewException {
        LineItem2[] limes = LineItemFactory.woodForShed(skurwidth, skurlength);
        return forLoopLineItem(limes, sb);
    }

    public static void main(String[] args) throws NewException {
        StringBuilder sb = new StringBuilder();
        LineItem2[] limes = LineItemFactory.baseTree(480, 300);

    }

    private static void headLinesStykListe(StringBuilder sb) {
        sb.append("<h2>Stykliste</h2>\n"
                + "<table border=4>"
                + "<tr><th>Materiale</th>"
                + "<th>Længde</th>"
                + "<th>Antal</th>"
                + "<th>Enhed</th>"
                + "<th>Beskrivelse</th>");
        sb.append("</tr>");
    }

    public static String createLineItemListMetal(StringBuilder sb, double length, double width) throws NewException {
        sb.append("<br><tr><th>Beslag og Skruer</th></tr>\n");

        LineItem2[] limes = LineItemFactory.carportBaseMetal(width, length);
       
        return forLoopLineItem(limes, sb);
    }

    private static String forLoopLineItem(LineItem2[] limes, StringBuilder sb) {
        for (LineItem2 lim : limes) {
            
            sb.append("<tr><td>" + lim.getMaterial_name() + "</td>");
            sb.append("<td>" + lim.getDimension() + "</td>");
            sb.append("<td>" + lim.getAmount() + "</td>");
            sb.append("<td>" + lim.getUnit() + "</td>");
            sb.append("<td>" + lim.getDescription() + "</td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }

   

}
