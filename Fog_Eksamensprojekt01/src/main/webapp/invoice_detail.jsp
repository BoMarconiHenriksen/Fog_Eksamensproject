<%-- 
    Document   : invoice_detail
    Created on : 19-11-2017, 14:29:23
    Author     : Bo
--%>

<%@page import="Domain.Odetaljer"%>
<%@page import="Utillities.RendUtilOdetaljerMedArbejder"%>
<%@page import="Business.SkurCalculator"%>
<%@page import="Utillities.XXRendUtilStykListe"%>
<%@page import="Utillities.XXRendSvg"%>

<%@page import="java.text.DecimalFormat"%>

<%@page import="Business.Calculator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre Detaljer</title>
    </head>

    <body>


        <br>


        <%Calculator calc = new Calculator();
            SkurCalculator scalc = new SkurCalculator();
            XXRendUtilStykListe rusl = new XXRendUtilStykListe();

            double length = (Double) request.getAttribute("length");
            double width = (Double) request.getAttribute("width");
            double heigth = (Double) request.getAttribute("height");
            double skurlength = (Double) request.getAttribute("redskabsskur_length");
            double skurWidth = (Double) request.getAttribute("redskabsskur_width");
            DecimalFormat df = new DecimalFormat("#0.00");
            double pris = ((Double) calc.calculateCarportSimple(length, width, heigth) + (Double) scalc.skurPrisBeregner(skurlength, skurWidth));
        %>





        <%
            out.println("<h3>Pris</h3><p>" + df.format(pris) + "</p>");

        %>

        <%= RendUtilOdetaljerMedArbejder.odetailsForOrder((Odetaljer) request.getAttribute("od"))%>
        <%=RendUtilOdetaljerMedArbejder.customerDetailsForOrder((Odetaljer) request.getAttribute("od"))%>
        <br> <br>
        <div>
            <%   StringBuilder sb= new StringBuilder();
       
            out.println("<p>"+(String)rusl.createLineItemList(  sb,length, width, skurlength, skurWidth)+"</p>");%>   


        </div>
        <div class="w3-display-bottomleft">
            <%
                XXRendSvg svag = new XXRendSvg();

                String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);

                out.println("<a>" + carportTegning + "</a>");
            %>  

        </div>     


    </body>
</html>


