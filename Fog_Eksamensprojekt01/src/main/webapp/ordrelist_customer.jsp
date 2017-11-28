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
        <title>Ordre Liste - Kunde</title>
    </head>
    <body>
        <h1>Liste af alle dine Ordre</h1>

        <div>

            <% out.println(RendUtilOrderList_Customer.invoiceList_Customer((List) request.getAttribute("invoiceList_Customer")));%>

        </div>

        <form name="NavigatetoIndex" action="FrontController" method="POST">
            <input type="hidden" name="command" value="NavigatetoIndex">

            <button type="submit" name="NavigatetoIndex" value="Submit">Tilbage til Index </button>
        </form>

        <form name="InvoiceDetail_Customer" action="FrontController" method="POST">
            <input type="hidden" name="command" value="InvoiceDetail_Customer_DeleteOrder">

            <button type="submit" name="InvoiceDetail_Customer_DeleteOrder" value="Submit">Slet Ordren </button>
        </form>


    </body>
</html>
