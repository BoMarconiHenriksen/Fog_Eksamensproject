<%-- 
    Document   : ordre_liste
    Created on : 18-11-2017, 14:21:47
    Author     : Bo
--%>

<%@page import="Business.LogicFacade"%>
<%@page import="Data.OrdreMapper"%>
<%@page import="Utillities.RendUtilOrderList"%>
<%@page import="Domain.Ordre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre Liste</title>
    </head>
    <body>

        <% //User user = (User) session.getAttribute("user");

            //       if (user != null) {
            //         out.println("Hello " + user.getUserName() + ". Which order do you want to see?");
            //   }
            // else{
            //     out.println("Hello  You have to log in again to see history. Which order do you want to see?");
            // }
            //UserMapper um = new UserMapper();
            //String cName = (String) request.getAttribute("cName");
            
            
            request.getAttribute("invoiceList");
            
        %>
        
        <div>
            
            <% out.println(RendUtilOrderList.invoiceList((List) request.getAttribute("invoiceList")));%>

        </div>
            


    </body>
</html>
