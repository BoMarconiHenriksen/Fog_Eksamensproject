<%-- 
    Document   : stykListe
    Created on : 11-11-2017, 22:10:01
    Author     : BenedikteEva
--%>

<%@page import="Utillities.XXRendSvg"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="Domain.LineItem"%>
<%@page import="java.util.List"%>
<%@page import="Domain.Materiale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>StykListe</title>
    </head>
    <body>
        <h1>Pris</h1>



        <%out.println("<a>" + (Double) request.getAttribute("totalPris") + "</a>");%>
        
        
        
        <%XXRendSvg svag = new XXRendSvg();String carportTegning = svag.simpelCarport(480, 300); %>
        <%=carportTegning%>
      
       <%--=(String)(request.getAttribute("carportTegning"))--%>
   <!-- Horizontal line %-->
            
        </SVG>
      
   




    </body>
</html>
