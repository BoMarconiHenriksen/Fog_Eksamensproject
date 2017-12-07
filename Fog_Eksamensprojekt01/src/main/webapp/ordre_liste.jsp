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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
    <title>Ordre Liste</title>
</head>
<body>
    <h1>Hej <%= (String) session.getAttribute("username")%></h1>

    <% //User user = (User) session.getAttribute("user");

        //       if (user != null) {
        //         out.println("Hello " + user.getUserName() + ". Which order do you want to see?");
        //   }
        // else{
        //     out.println("Hello  You have to log in again to see history. Which order do you want to see?");
        // }
        //Spg til Thomas
        //request.getAttribute("invoiceList");
        //out.println(request.getAttribute("invoiceList"));
    %>

    <div>

        <% out.println(RendUtilOrderList.invoiceList((List) request.getAttribute("invoiceList")));%>

    </div>

    <div >
        <button type="button"  onclick="location.href = 'Ansatpage.jsp';" >Gå Tilbage til Hovedmenuen</button>

    </div>


</body>
</html>
