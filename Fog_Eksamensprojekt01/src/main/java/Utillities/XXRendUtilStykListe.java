package Utillities;

import Domain.LineItem;
import Presentation.NewException;

/**
 * Klassen bruges til at lave et udprint af styklisten
 *
 * @author Ticondrus
 */
public class XXRendUtilStykListe {
    
    /**
     * Metoden laver en stykliste for den carport som er købt/designet.
     * @param sb bruges til at lave en tabel.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurLength er skurets længde.
     * @param skurWidth er skurets bredde.
     * @return carportens stykliste, som så kan printes.
     * @throws NewException 
     */
    public static String createLineItemList(StringBuilder sb, double length, double width, double skurLength, double skurWidth) throws NewException {

        headLinesStykListe(sb);

        createLineItemListTree(sb, length, width);
        if (skurLength > 0) {
            lineItemWoodForShed(sb, skurLength, skurWidth);
        }
        createLineItemListMetal(sb, length, width);
        if (skurLength > 0) {
            lineItemMetalForShed(sb, skurLength, skurWidth);
        }
        lineItemEcoliteRoof(sb, length, width);
        return sb.toString();

    }

    /**
     * Metoden laver en tabel med basis information om træ til en carport.
     * @param sb laver tabellen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException 
     */
    public static String createLineItemListTree(StringBuilder sb, double length, double width) throws NewException {
        LineItem[] limes = LineItemFactory.baseTree(width, length);
        sb.append("<br><tr><th>Træ</th></tr>\n");
        return forLoopLineItem(limes, sb);
    }

    /**
     * Metoden laver en tabel med basis information om Ecolite tag til en carport med fladt tag.
     * @param sb laver tabellen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException 
     */
    public static String lineItemEcoliteRoof(StringBuilder sb, double length, double width) throws NewException {
        LineItem[] limes = LineItemFactory.ecoliteRoof(width, length);
        sb.append("<br><tr><th>Tag</th></tr>\n");
        return forLoopLineItem(limes, sb);
    }

    /**
     * Metoden laver en tabel om beslag og skruer til carportens skur.
     * @param sb laver tabellen.
     * @param skurlength er carportens længde.
     * @param skurwidth er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException 
     */
    public static String lineItemMetalForShed(StringBuilder sb, double skurlength, double skurwidth) throws NewException {
        LineItem[] limes = LineItemFactory.screwsAndBracketShed(skurwidth, skurlength);
        return forLoopLineItem(limes, sb);
    }

    /**
     * Metoden laver en tabel med information om træ til carportens skur.
     * @param sb laver tabellen.
     * @param skurlength er carportens længde.
     * @param skurwidth er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException 
     */
    public static String lineItemWoodForShed(StringBuilder sb, double skurlength, double skurwidth) throws NewException {
        LineItem[] limes = LineItemFactory.woodForShed(skurwidth, skurlength);
        return forLoopLineItem(limes, sb);
    }

    /**
     * Metoden laver en stykliste tabel med information om træ til carportens skur.
     * @param sb laver tabellen.
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException 
     */
    public static String createLineItemListMetal(StringBuilder sb, double length, double width) throws NewException {
        sb.append("<br><tr><th>Beslag og Skruer</th></tr>\n");
        LineItem[] limes = LineItemFactory.carportBaseMetal(width, length);
        return forLoopLineItem(limes, sb);
    }

    /**
     * Metoden laver kolonne overskrifterne til tabellen.
     * @param sb laver tabellen.
     */
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

    /**
     * Metoden laver en stykliste
     * @param limes er et array af LineItems
     * @param sb stringbuilder, der laver tabellen.
     * @return en tabel, der indeholder styklisten.
     */
    private static String forLoopLineItem(LineItem[] limes, StringBuilder sb) {
        for (LineItem lim : limes) {

            sb.append("<tr><td>" + lim.getMaterial_name() + "</td>");
            removeNumberFromLengthForBrackets(lim, sb);
            sb.append("<td>" + lim.getAmount() + "</td>");
            sb.append("<td>" + lim.getUnit() + "</td>");
            sb.append("<td>" + lim.getDescription() + "</td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * Metoden fjerner 0.0 de steder i tabellen, hvor der står 0.0, da feltet skal være tomt.
     * @param lim er en liste af LineItems
     * @param sb er stringbuilderen
     */
    private static void removeNumberFromLengthForBrackets(LineItem lim, StringBuilder sb) {
        if (lim.getDimension() == 0.0) {
            sb.append("<td>" + "" + "</td>");
        } else {
            sb.append("<td>" + lim.getDimension() + "</td>");
        }
    }

    /**
     * Bruges til test.
     * @param args
     * @throws NewException 
     */
    public static void main(String[] args) throws NewException {
        StringBuilder sb = new StringBuilder();
        LineItem[] limes = LineItemFactory.baseTree(480, 300);

    }

}
