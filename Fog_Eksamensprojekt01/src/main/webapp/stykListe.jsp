<%-- 
    Document   : stykListe
    Created on : 11-11-2017, 22:10:01
    Author     : BenedikteEva
--%>

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
        <h1>Hello World!</h1>



        <%-- out.println("<a>" + (List<Materiale>) request.getAttribute("mats") + "</a>");--%>

        <% out.println("<a>" + (String) request.getAttribute("mat1") + "</a>");%>




    </body>
</html>
