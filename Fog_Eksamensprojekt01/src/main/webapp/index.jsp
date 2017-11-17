<%-- 
    Document   : index.jsp
    Created on : 09-11-2017, 12:08:28
    Author     : Ticondrus
--%>


<%@page import="Business.LogicFacade"%>
<%@page import="Utillities.RendUtilGetMaterials"%>
<%@page import="Utillities.RendUtilCustomerPresentation"%>
<%@page import="Domain.Materiale"%>
<%@page import="java.util.List"%>
<%@page import="Presentation.FrontController"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Fog Trælast</h1>


        <h2>Velkommen. Vælg her en carport type.</h2>

        <form name="OrderSelectionCommand" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderSelectionSimpleCarport">
            <input type="hidden" name="command" value="orderSelectionSimpleCarportmedSkur">


            <button type="submit" name="orderSelectionSimpleCarport" value="Submit">Bestil en simpel carport </button>

            <button type="submit" name="orderSelectionSimpleCarportmedSkur" value="Submit"> Bestil en simpel carport med skur </button>



    </body>



</html>
