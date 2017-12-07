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
        <h1>Hej <%= (String) session.getAttribute("username")%></h1>

        <br>

 <div>

        <%
            out.println("<h3>Pris</h3><p>" + request.getAttribute("priceTwoDecimal") + "</p>");
        %>


        <%= RendUtilOdetaljerMedArbejder.odetailsForOrder((Odetaljer) request.getAttribute("od"))%>
        <%=RendUtilOdetaljerMedArbejder.customerDetailsForOrder((Odetaljer) request.getAttribute("od"))%>

        <br> <br>
        
       
            <%
                out.println("<p>" + (String) request.getAttribute("LineItemsList") + "</p>");
            %>   

        </div>
        <div class="w3-display-bottomleft">
            <%
                out.println("<a>" + request.getAttribute("carportTegning") + "</a>");
            %>  

        </div>     
            
            <div>
                <button type="button"  onclick="location.href = 'Ansatpage.jsp';" >Gå Tilbage til Hovedmenuen</button>
            </div>


    </body>
</html>


