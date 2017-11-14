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
<%@page import="Controls.IndexController"%>
<%@page import="Utillities.RendUtilGetMaterials"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>

    <div>

        <p>Husets Længde: ${sizelentgh}</p><br>
        <p>Husets Længde: ${sizewidth}</p><br>
        <p>Husets Længde: ${sizeheight}</p><br>
        <p>Trævalg: ${trechosen}</p><br>

      
        <%
     LogicFacade logic = new LogicFacade();%>
        <div>
            <%= RendUtilGetMaterials.getSpecifikMaterial(logic.getMaterial())%>

        </div>



    </div>
</html>
