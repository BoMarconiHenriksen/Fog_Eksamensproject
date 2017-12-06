<%-- 
    Document   : invoice_detail_customer
    Created on : 28-11-2017, 11:22:00
    Author     : Ticondrus
--%>

<%@page import="Utillities.RendUtilCustomerOdetailsFunktions"%>
<%@page import="Utillities.RendUtilOdetaljerMedArbejder"%>
<%@page import="Domain.Odetaljer"%>
<%@page import="Business.Calculator"%>
<%@page import="Business.SkurCalculator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Utillities.XXRendSvg"%>
<%@page import="Business.LogicFacade"%>
<%@page import="Presentation.FrontController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre Detaljer - Kunde</title>
    </head>
    <body>
        <h1>Din Ordre Detaljer samt Model af ønsket Carport</h1>
        
        <h2>Hej <%= (String) session.getAttribute("username" )%> </h2>
<br>

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


    <%= RendUtilCustomerOdetailsFunktions.odetailsForOrder_Customer((Odetaljer) request.getAttribute("od"))%>
    
    <button type="button" style="background-color: buttonface" onclick="location.href = 'Kundepage.jsp';" >Gå Tilbage til Velkomstsiden</button>
        
        
    </body>
</html>
