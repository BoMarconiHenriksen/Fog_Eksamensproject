package Business.Utilities;
import Business.LogicFacade;
import Business.Domain.LineItem;
import Business.Exception.NewException;

/**
 * Klassen bruges til at lave et udprint af styklisten
 *
 */
public class XXRendUtilStykListe {

    StringBuilder sb = new StringBuilder();

    /**
     * Metoden laver en stykliste for den carport som er købt/designet.
     *
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @param skurLength er skurets længde.
     * @param skurWidth er skurets bredde.
     * @return carportens stykliste, som så kan printes.
     * @throws NewException
     */
    public String createLineItemList(double length, double width, double skurLength, double skurWidth) throws NewException {

        headLinesStykListe();

        createLineItemListWood(length, width);
        if (skurLength > 0) {
            lineItemWoodForShed(skurLength, skurWidth);
        }
        createLineItemListMetal(length, width);
        if (skurLength > 0) {
            lineItemMetalForShed(skurLength, skurWidth);
        }
        lineItemEcoliteRoof(length, width);
        return sb.toString();

    }

    /**
     * Metoden laver en tabel med basis information om træ til en carport.
     *
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException
     */
    public String createLineItemListWood(double length, double width) throws NewException {
        LineItem[] limes = LogicFacade.baseWood(width, length);
        sb.append("<br><tr><th>Træ</th></tr>\n");
        return forLoopLineItem(limes);
    }

    /**
     * Metoden laver en tabel med basis information om Ecolite tag til en
     * carport med fladt tag.
     *
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException
     */
    public String lineItemEcoliteRoof(double length, double width) throws NewException {
        LineItem[] limes = LogicFacade.ecoliteRoof(width, length);
        sb.append("<br><tr><th>Tag</th></tr>\n");
        return forLoopLineItem(limes);
    }

    /**
     * Metoden laver en tabel om beslag og skruer til carportens skur.
     *
     * @param skurlength er carportens længde.
     * @param skurwidth er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException
     */
    public String lineItemMetalForShed(double skurlength, double skurwidth) throws NewException {
        LineItem[] limes = LogicFacade.screwsAndBracketShed(skurlength, skurwidth);
        return forLoopLineItem(limes);
    }

    /**
     * Metoden laver en tabel med information om træ til carportens skur.
     *
     * @param skurlength er carportens længde.
     * @param skurwidth er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException
     */
    public String lineItemWoodForShed(double skurlength, double skurwidth) throws NewException {
        LineItem[] limes = LogicFacade.woodForShed(skurlength, skurwidth);
        return forLoopLineItem(limes);
    }

    /**
     * Metoden laver en stykliste tabel med information om træ til carportens
     * skur.
     *
     * @param length er carportens længde.
     * @param width er carportens bredde.
     * @return en stykliste i en tabelform, der kan printes ud på en side.
     * @throws NewException
     */
    public String createLineItemListMetal(double length, double width) throws NewException {
        sb.append("<br><tr><th>Beslag og Skruer</th></tr>\n");
        LineItem[] limes = LogicFacade.carportBaseMetal(width, length);
        return forLoopLineItem(limes);
    }

    /**
     * Metoden laver kolonne overskrifterne til tabellen.
     *
     * @param sb laver tabellen.
     */
    private void headLinesStykListe() {
        sb.append( "<table border=4>"
                + "<tr><th>Materiale</th>"
                + "<th>Længde</th>"
                + "<th>Antal</th>"
                + "<th>Enhed</th>"
                + "<th>Beskrivelse</th>");
        sb.append("</tr>");
    }

    /**
     * Metoden laver en stykliste
     *
     * @param limes er et array af LineItems
     * @param sb stringbuilder, der laver tabellen.
     * @return en tabel, der indeholder styklisten.
     */
    private String forLoopLineItem(LineItem[] limes) {
        for (LineItem lim : limes) {

            sb.append("<tr><td>" + lim.getMaterial_name() + "</td>");
            removeNumberFromLengthForBrackets(lim);
            sb.append("<td>" + lim.getAmount() + "</td>");
            sb.append("<td>" + lim.getUnit() + "</td>");
            sb.append("<td>" + lim.getDescription() + "</td>");
            sb.append("</tr>");
        }
        return sb.toString();
    }

    /**
     * Metoden fjerner 0.0 de steder i tabellen, hvor der står 0.0, da feltet
     * skal være tomt.
     *
     * @param lim er en liste af LineItems
     * @param sb er stringbuilderen
     */
    private void removeNumberFromLengthForBrackets(LineItem lim) {
        if (lim.getDimension() == 0.0) {
            sb.append("<td>" + "" + "</td>");
        } else {
            sb.append("<td>" + lim.getDimension() + "</td>");
        }
    }

    /**
     * Bruges til test.
     *
     * @param args
     * @throws NewException
     */
    public static void main(String[] args) throws NewException {

        LineItem[] limes = LogicFacade.baseWood(480, 300);

    }

}
