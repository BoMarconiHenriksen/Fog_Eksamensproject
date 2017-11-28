package Utillities;

import Business.LogicFacade;
import Domain.LineItem;
import Presentation.NewException;
import java.util.List;

/**
 * Klassen bruges til at lave et udprint af styklisten
 *
 * @author Ticondrus
 */
public class XXRendUtilStykListe {

    public static String getStykListeBaseSimpel(double length, double width, double skurlength, double skurwidth) throws NewException {
        List<LineItem> lim;
        lim = LogicFacade.getLineItem();
        StringBuilder sb = new StringBuilder();
        headLinesStykListe(sb);
        stykListeTræ(sb, lim, width, length);
        if (skurlength!=0){
        stykListeTræSkur(sb,lim,skurlength, skurwidth);
        }
        stykListeFladtTag(sb, length, width, lim);
        stykListeBeslagOgSkruer(sb, lim, length);
          if (skurwidth!=0){
        stykListeBeslagOgSkruerSkur( sb,  lim,   skurlength,  skurwidth);
          }
        sb.append("</table></ui>");
        return sb.toString();

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

    private static void stykListeBeslagOgSkruer(StringBuilder sb, List<LineItem> lim, double length) {
        sb.append("<br><tr><th>Beslag & Skruer</th></tr>\n");
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
    }

    private static void stykListeTræ(StringBuilder sb, List<LineItem> lim, double width, double length) {
        sb.append("<tr><th>Træ</th></tr>\n");
        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width + "</td>");
        sb.append("<td>" + lim.get(0).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(0).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(1).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length + "</td>");
        sb.append("<td>" + lim.get(1).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(1).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width + "</td>");
        sb.append("<td>" + lim.get(2).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(0).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(2).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(0).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length + "</td>");
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
        
        sb.append("<tr><td>" + lim.get(4).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + length + "</td>");
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
        sb.append("<td>" + length + "</td>");
        sb.append("<td>" + lim.get(12).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(6).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(12).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(6).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + width + "</td>");
        sb.append("<td>" + lim.get(13).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(6).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(13).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
    }

    private static void stykListeFladtTag(StringBuilder sb, double length, double width, List<LineItem> lim) throws NewException {
        sb.append("<br><tr><th>Tag</th></tr>\n");
        String plastmoTag = null;
        String plastmoTagEnhed = null;
        
        if (length <= 300) {
            
            plastmoTag = LogicFacade.getMaterialeByVarenummer(9).getMaterialenavn(); //300 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(9).getEnhed();
        } else if (length <= 480) {
            
            plastmoTag = LogicFacade.getMaterialeByVarenummer(33).getMaterialenavn(); //480 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(33).getEnhed();
        } else if (length <= 600) {
            
            plastmoTag = LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn();// 600 cm
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(8).getEnhed();
        } else if (length > 600) {
            
            plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(8).getEnhed();
            plastmoTag = LogicFacade.getMaterialeByVarenummer(8).getMaterialenavn();// skal ændres så der kommer 2 tagplader istedet             plastmoTagEnhed = LogicFacade.getMaterialeByVarenummer(8).getEnhed();
        }
        
        sb.append("<tr><td>" + plastmoTag + "</td>");
        sb.append("<td>" + length + "</td>");
        if (width % 100>0 && width%100<50) {
            sb.append("<td>" + ((int) Math.round(width / 100) + 1) + "</td>");
        } else {
            sb.append("<td>" + ((int) Math.round(width / 100)) + "</td>");
        }
        sb.append("<td>" + plastmoTagEnhed + "</td>");
        sb.append("<td>" + lim.get(14).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
    }
    
  private static void stykListeTræSkur(StringBuilder sb, List<LineItem> lim,  double skurlength, double skurwidth) {
 
        sb.append("<tr><td>" + lim.get(4).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + lim.get(4).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(4).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(4).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(5).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + skurlength + "</td>");
        sb.append("<td>" + lim.get(5).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(5).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(5).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(6).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + skurwidth + "</td>");
        sb.append("<td>" + lim.get(6).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(6).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(6).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
      
    }

  
  
  private static void stykListeBeslagOgSkruerSkur(StringBuilder sb, List<LineItem> lim,  double skurlength, double skurwidth) {

        sb.append("<tr><td>" + lim.get(24).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + lim.get(24).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(24).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(24).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(25).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + lim.get(25).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(25).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(25).getLin().getBeskrivelse() + "</td>");
        sb.append("</tr>");
        
        sb.append("<tr><td>" + lim.get(26).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "" + "</td>");
        sb.append("<td>" + lim.get(26).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(26).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(26).getLin().getBeskrivelse() + "</td>");
        
        sb.append("<tr><td>" + lim.get(27).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "2" + "</td>");
        sb.append("<td>" + lim.get(27).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(27).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(27).getLin().getBeskrivelse() + "</td>");
        
         sb.append("<tr><td>" + lim.get(28).getMat().getMaterialenavn() + "</td>");
        sb.append("<td>" + "32" + "</td>");
        sb.append("<td>" + lim.get(28).getLin().getAntal() + "</td>");
        sb.append("<td>" + lim.get(28).getMat().getEnhed() + "</td>");
        sb.append("<td>" + lim.get(28).getLin().getBeskrivelse() + "</td>");
        
        sb.append("</tr>");
        
      
    }

}
