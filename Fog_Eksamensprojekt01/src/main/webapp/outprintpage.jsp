<%-- 
    Document   : outprintpage
    Created on : 09-11-2017, 12:26:33
    Author     : Ticondrus
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Materiale"%>
<%@page import="Controls.IndexController"%>

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

        <p>Husets Længde: ${size1}</p><br>

        Her testes om der er hul igennem gennem frontcontroller- command - commandoen getAllMaterials 
        - logicfacade - datamapper - database og det er der :-)den skal fjernes igen

        <form name="getAllMaterials" action="FrontController" method="POST">
            <input type="hidden" name="command" value="getAllMaterials">

            <%-- out.println("<a>" + (List<Materiale>) request.getAttribute("mat1") + "</a>");--%>
            
              <% out.println("<a>" + (String) request.getAttribute("mat1") + "</a>");%>
            <input type="submit" value="Submit">
        </form>



    </div>
</html>
