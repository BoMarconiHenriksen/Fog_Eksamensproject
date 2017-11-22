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
            <p>Carportens samlede pris: ${carportTotalValg}</p><br>
            <p>Caroportens ønskede Længde: ${lentghChosen}</p><br>
            <p>Caroportens ønskede Bredde: ${widthChosen}</p><br>
            <p>Caroportens ønskede Højde: ${heightChosen}</p><br>

        </div>

    </body>

</html>
