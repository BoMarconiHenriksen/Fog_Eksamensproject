<%-- 
    Document   : customer_confirmationpage
    Created on : 01-12-2017, 13:31:48
    Author     : Ticondrus
--%>

<%@page import="Utillities.XXRendUtilStykListe"%>
<%@page import="Utillities.XXRendSvg"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Business.SkurCalculator"%>
<%@page import="Business.Calculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestilling fuldført.</title>
    </head>
    <body>
        <h1>Din ordre er nu bestilt.</h1>
        
        
        
         <%Calculator calc = new Calculator();
    SkurCalculator scalc = new SkurCalculator();

    double length = (Double) request.getAttribute("length");
    double width = (Double) request.getAttribute("width");
    double heigth = (Double) request.getAttribute("height");
    double skurlength = (Double) request.getAttribute("redskabsskur_length");
    double skurWidth = (Double) request.getAttribute("redskabsskur_width");
    DecimalFormat df = new DecimalFormat("#0.00");
    double pris = ((Double) calc.calculateCarportSimple(length, width, heigth) + (Double) scalc.skurPrisBeregner(skurlength, skurWidth));

    out.println("<p>" + "Carportens samlede pris: " + df.format(pris) + "</p> \n");
    
    out.println("<p>" + "Carportens ønskede længde: " + length + "</p>");
    out.println("<p>" + "Carportens ønskede bredde: " + width + "</p>");
    out.println("<p>" + "Carportens ønskede højde: " + heigth + "</p>");
    
    if ( (Double) request.getAttribute("redskabsskur_length") != 0){
    out.println("<p>" + "Skurets ønskede længde: " + skurlength + "</p>");
    out.println("<p>" + "Skurets ønskede bredde: " + skurWidth + "</p>");
    out.println("<p>" + "Skurets ønskede højde: 210" + "</p>");
    
    }else{
        out.println("<p>" + "Carporten er uden skur." + "</p>");
    }
    
         %>
<br> <br><div>

    <%
        XXRendSvg svag = new XXRendSvg();

        String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);

        out.println("<a>" + carportTegning + "</a>");
    %>  
        </div>
        
        <button type="button" style="background-color: buttonface" onclick="location.href = 'index.jsp';" >Gå Tilbage til Index</button>
        
    </body>
</html>