<%-- 
    Document   : invoice_detail
    Created on : 19-11-2017, 14:29:23
    Author     : Bo
--%>

<%@page import="Utillities.XXRendUtilStykListe"%>
<%@page import="Utillities.XXRendSvg"%>

<%@page import="java.text.DecimalFormat"%>

<%@page import="Business.Calculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ordre Detaljer</title>
</head>


<h1>Pris</h1>
<br>

<%Calculator calc = new Calculator();
    XXRendUtilStykListe rusl = new XXRendUtilStykListe();
    double length = (Double) request.getAttribute("length");
    double width = (Double) request.getAttribute("width");
    double heigth = (Double) request.getAttribute("height");
    double pris = (Double) calc.calculateCarportSimple(length, width, heigth);

    out.println("<p>" + pris + "</p>");%>
    <br> <br>
<%
    XXRendSvg svag = new XXRendSvg();

    String carportTegning = svag.simpelCarport(length, width);

    out.println("<a>" + carportTegning + "</a>");
%>  








<%String styk = rusl.getStykListeBaseSimpel((Double) request.getAttribute("length"), (Double) request.getAttribute("width"));
    out.println("<a>" + styk + "</a>");%>







