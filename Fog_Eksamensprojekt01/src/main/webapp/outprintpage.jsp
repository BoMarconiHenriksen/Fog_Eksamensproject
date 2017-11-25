<%-- 
    Document   : outprintpage
    Created on : 09-11-2017, 12:26:33
    Author     : Ticondrus
--%>

<%@page import="Domain.StykLinje"%>
<%@page import="Business.LogicFacade"%>
<%@page import="Domain.User"%>
<%@page import="java.util.List"%>
<%@page import="Domain.Materiale"%>
<%@page import="Presentation.FrontController"%>
<%@page import="Utillities.RendUtilGetMaterials"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Din Bestilling</title>
    </head>
    <body>
        
        <h1>Tak for din bestilling!</h1>
        <p>Vi har nu modtaget din bestilling. En af vores dygtige medarbejdere vil hurtigst muligt tage kontakt til dig for at aftale et møde,
        hvor vi kan gå igennem designet. På mødet er der også mulighed for at få rådgivning i forhold til byggetilladelse, afstand til skel og andre praktiske informationer.
        </p>
        
        <p>De bedste hilsener</p>
        <p>Fog Tømmerhandel</p>
        
        <h2>Information om din ordre</h2>

            
            <div>
                
                 <%if (request.getAttribute("widthInput") == null) {
                out.println("");
            } else {
                out.println("<p> Hello User nr. " + request.getAttribute("userNr") + "</p><br>");
                out.println("<h2>Pris på valgt Carport: </h2><br>");
                out.println("<p> Samlet Carport pris: " + (String) request.getAttribute("carportTotaludenSkur") + "</p><br>");

                out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInput") + "</p><br>");
                out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInput") + "</p><br>");
                out.println("<p> Ønsket Højde: " + (Double) request.getAttribute("heightInput") + "</p><br>");

                if (Double.parseDouble(request.getParameter("lentgchoiceskur")) != 0) {

                    out.println("<p> Samlet Carport pris, med skur: " + (String) request.getAttribute("carportTotalmedSkur") + "</p><br>");
                    out.println("<p> Ønsket Længde på Skuret: " + (Double) request.getAttribute("lentghInputSkuret") + "</p><br>");
                    out.println("<p> Ønsket Bredde på Skuret: " + (Double) request.getAttribute("widthInputSkuret") + "</p><br>");
                    out.println("<p> Standard Højde på Skuret: " + (Double) request.getAttribute("heightInputSkuret") + "</p><br>");
                } else {
                    out.println("");
                }

            }%>
                
            </div>
            
      <button type="button" style="background-color: buttonface" onclick="location.href = 'index.jsp';" >Gå Tilbage til Index</button>

    </body>

</html>
