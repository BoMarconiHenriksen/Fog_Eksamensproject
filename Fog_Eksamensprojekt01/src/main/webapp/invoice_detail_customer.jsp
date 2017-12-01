<%-- 
    Document   : invoice_detail_customer
    Created on : 28-11-2017, 11:22:00
    Author     : Ticondrus
--%>

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
        
        <h1>Pris</h1>
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

    out.println("<p>" + df.format(pris) + "</p>");%>
<br> <br><div>

    <%
        XXRendSvg svag = new XXRendSvg();

        String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);

        out.println("<a>" + carportTegning + "</a>");
    %>  


    <form name="OrdreList_Customer" action="FrontController" method="POST">
        <input type="hidden" name="command" value="OrdreList_Customer">
        
        <button type="submit" name="OrdreList_Customer" value="Submit">Tilbage til din Ordre Liste </button>
    </form>
        
        
    </body>
</html>