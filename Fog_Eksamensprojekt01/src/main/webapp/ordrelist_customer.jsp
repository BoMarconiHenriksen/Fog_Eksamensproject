<%-- 
    Document   : ordrelist_customer
    Created on : 28-11-2017, 11:28:13
    Author     : Ticondrus
--%>

<%@page import="Utillities.RendUtilOrderList_Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre Liste</title>
    </head>
    <body>
        <h1>Liste af alle dine Ordre</h1>
        
         <div>
            
            <% out.println(RendUtilOrderList_Customer.invoiceList((List) request.getAttribute("invoiceList")));%>

        </div>
        
        
    </body>
</html>
