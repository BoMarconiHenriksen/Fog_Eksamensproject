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

        <div>
            <!-- Sætter attributerne i session-->
            <p>Carportens samlede pris: ${carportTotal}</p><br>
            <p>Carportens ønskede Længde: ${lentghInput}</p><br>
            <p>Carportens ønskede Bredde: ${widthInput}</p><br>
            <p>Carportens ønskede Højde: ${heightInput}</p><br>
            

        </div>
    <button type="button" style="background-color: buttonface" onclick="location.href = 'index.jsp';" >Gå Tilbage til Index</button>
    </body>

</html>
