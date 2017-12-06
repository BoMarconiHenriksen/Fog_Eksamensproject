<%-- 
    Document   : ordrelist_customer
    Created on : 28-11-2017, 11:28:13
    Author     : Ticondrus
--%>

<%@page import="Domain.User"%>
<%@page import="Utillities.RendUtilOrderList_Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre Liste - Kunde</title>
    </head>
    <body>
        <h1>Liste af alle dine Ordre</h1>
        
         <h2>Velkommen <%= (String) session.getAttribute("username" )%> </h2>

        <div>

            <% out.println(request.getAttribute("customer_orderlist")); %>

        </div>


           <button type="button"  onclick="location.href = 'Kundepage.jsp';" >Gå Tilbage til velkomstsiden</button>

           <div>
               <%if (request.getAttribute("customerlist") == null ) {
                    out.println("Din ordreliste er tom. Bestil en ordre, og den vil kunne fremvise her på siden.");
                } else {
                    out.println("");
                }%>
</div>
       


    </body>
</html>
