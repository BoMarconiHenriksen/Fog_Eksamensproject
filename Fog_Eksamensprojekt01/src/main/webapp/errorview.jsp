<%-- 
    Document   : errorview
    Created on : 04-12-2017, 20:49:45
    Author     : Bo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error View!</h1>
        
        <% out.println("<a>"+session.getAttribute("error")+"</a>");%>
    </body>
</html>
