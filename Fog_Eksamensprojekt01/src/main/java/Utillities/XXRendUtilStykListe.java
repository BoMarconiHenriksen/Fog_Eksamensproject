package Utillities;

import Business.LogicFacade;
import Domain.LineItem;
import Domain.Materiale;
import Domain.StykLinje;
import Presentation.NewException;
import java.util.List;

/**
 * Klassen bruges til at lave et udprint af styklisten
 *
 * @author Ticondrus
 */
public class XXRendUtilStykListe {

    public static String getStykListeBasis(double length, double width) throws NewException {
        List<LineItem> lim = LogicFacade.getLineItem();
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Stykliste</h2>\n"
                + "<table border=4>"
                + "<tr><th>Materiale</th>"
                + "<th>Længde</th>"
                + "<th>Antal</th>"
                + "<th>Enhed</th>"
                + "<th>Beskrivelse</th>");
        sb.append("</tr>");

        for (int i = 0; i < lim.size(); i++) {
            switch (lim.get(i).getLin().getDimension()) {
                case "w":

                    sb.append("<tr><td>" + lim.get(i).getMat().getMaterialenavn() + "</td>");
                    sb.append("<td>" + width * 100 + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getAntal() + "</td>");
                    sb.append("<td>" + lim.get(i).getMat().getEnhed() + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getBeskrivelse() + "</td>");
                    sb.append("</tr>");

                    break;
                case "l":
                    String plastmoTag = null;
                    String plastmoTagEnhed = null;
                    if (length == 3.00) {

                        plastmoTag = LogicFacade.getMaterialeByVarenummer(9).getMaterialenavn(); //300 cm
                        plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(9).getEnhed();
                    } else if (length == 4.80) {

                        plastmoTag = LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(); //480 cm
                        plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(33).getEnhed();
                    } else if (length == 6.00) {

                        plastmoTag = LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn();// 600 cm
                        plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(8).getEnhed();
                    }
                    sb.append("<tr><td>" + plastmoTag + "</td>");
                    sb.append("<td>" + length * 100 + "</td>");
                    sb.append("<td>" + (int) Math.round(width) + "</td>");
                    sb.append("<td>" + plastmoTagEnhed + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getBeskrivelse() + "</td>");
                    sb.append("</tr>");

                    break;

                case "h":
                    sb.append("<tr><td>" + lim.get(i).getMat().getMaterialenavn() + "</td>");
                    sb.append("<td>" + 300 + "</td>");
                    sb.append("<td>" + 4 + "</td>");
                    sb.append("<td>" + lim.get(i).getMat().getEnhed() + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getBeskrivelse() + "</td>");
                    sb.append("</tr>");
                    break;
                case "b":
                    sb.append("<tr><td>" + lim.get(i).getMat().getMaterialenavn() + "</td>");
                    sb.append("<td>" + "" + "</td>");
                    sb.append("<td>" + 4 + "</td>");
                    sb.append("<td>" + lim.get(i).getMat().getEnhed() + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getBeskrivelse() + "</td>");
                    sb.append("</tr>");
                    break;
                    
                     case "c":
                    sb.append("<tr><td>" + lim.get(i).getMat().getMaterialenavn() + "</td>");
                    sb.append("<td>" + "" + "</td>");
                    sb.append("<td>" + 4 + "</td>");
                    sb.append("<td>" + lim.get(i).getMat().getEnhed() + "</td>");
                    sb.append("<td>" + lim.get(i).getLin().getBeskrivelse() + "</td>");
                    sb.append("</tr>");
                    break;


            }
            sb.append("</table></ui>");
            return sb.toString();
        }
        return sb.toString();
    }

    public static String getStykListeBaseSimpel(double length, double width) throws NewException {
        List<LineItem> lim;
        lim = LogicFacade.getLineItem();
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Stykliste</h2>\n"
                + "<table border=4>"
                + "<tr><th>Materiale</th>"
                + "<th>Længde</th>"
                + "<th>Antal</th>"
                + "<th>Enhed</th>"
                + "<th>Beskrivelse</th>");
        sb.append("</tr>");

        sb.append(" \"<tr><th>Træ</th></tr>\n");
        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width  + "</td>");
        sb.append("<td>" + lim.get(0).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(0).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(1).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length  + "</td>");
        sb.append("<td>" + lim.get(1).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(1).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width  + "</td>");
        sb.append("<td>" + lim.get(2).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(2).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length  + "</td>");
        sb.append("<td>" + lim.get(3).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(3).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(4).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length + "</td>");
        sb.append("<td>" + lim.get(7).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(4).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(7).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
//          sb.append("<tr><td>" + lim.get(4).getMat().getMaterialenavn() + "</td>");
//        sb.append("<td>" + width* 100 + "</td>");
//        sb.append("<td>" + lim.get(8).getLin().getAntal() + "</td>");
//        sb.append("<td>" + lim.get(4).getMat().getEnhed() + "</td>");
//        sb.append("<td>" + lim.get(8).getLin().getBeskrivelse() + "</td>");
//        sb.append("</tr>");
        sb.append("<tr><td>" + lim.get(4).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length  + "</td>");
        sb.append("<td>" + (int) Math.round(length / 55) + "</td>");
        sb.append("<td>" + lim.get(4).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(9).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(5).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + 300 + "</td>");
        sb.append("<td>" + 4 + "</td>");
        sb.append("<td>" + lim.get(4).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(10).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(6).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length  + "</td>");
        sb.append("<td>" + lim.get(12).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(6).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(12).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(6).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width+ "</td>");
        sb.append("<td>" + lim.get(13).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(6).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(13).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append(" \"<br><tr><th>Tag</th></tr>\n");
        String plastmoTag = null;
        String plastmoTagEnhed = null;

        if (length == 300) {

            plastmoTag = LogicFacade.getMaterialeByVarenummer(9).getMaterialenavn(); //300 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(9).getEnhed();
        } else if (length == 480) {

            plastmoTag = LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(); //480 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(33).getEnhed();
        } else if (length == 600) {

            plastmoTag = LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn();// 600 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(8).getEnhed();
        }

        sb.append("<tr><td>" + plastmoTag + "</td>");
        sb.append("<td>" + length  + "</td>");
        sb.append("<td>" + lim.get(14).getLin().getAntal() + "</td>");
        sb.append("<td>" + plastmoTagEnhed + "</td>");
        sb.append("<td>" + lim.get(14).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append(" \"<br><tr><th>Beslag & Skruer</th></tr>\n");
        sb.append("<tr><td>" + lim.get(12).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 1 + "</td>");
        sb.append("<td>" + lim.get(12).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(16).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(13).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 2 + "</td>");
        sb.append("<td>" + lim.get(13).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(17).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(14).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + (int) Math.round(length / 55) + "</td>");
        sb.append("<td>" + lim.get(14).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(18).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(15).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + (int) Math.round(length / 55) + "</td>");
        sb.append("<td>" + lim.get(15).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(19).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(16).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 1 + "</td>");
        sb.append("<td>" + lim.get(16).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(20).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(17).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 3 + "</td>");
        sb.append("<td>" + lim.get(17).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(21).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(18).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 6 + "</td>");
        sb.append("<td>" + lim.get(18).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(22).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("<tr><td>" + lim.get(19).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + 6 + "</td>");
        sb.append("<td>" + lim.get(19).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(23).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");

        sb.append("</table></ui>");

        return sb.toString();

    }
    
    
}
