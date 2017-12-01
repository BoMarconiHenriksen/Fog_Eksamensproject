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
        
                <script type="text/javascript" src="jquery-1.8.3.js"></script>
        <script src="script/javascript.js" type="text/javascript"></script>
        
        <title>Fog Trælast - Velkomstside</title>
    </head>
    <body>
        <h1>Fog Trælast</h1>

        <h2>Velkommen. Vælg her en carport type.</h2>

        <button type="button" style="background-color: buttonface" onclick="location.href = 'bestilbasiscarportpage.jsp';" >Bestil en simpel carport</button>
                <button type="button" style="background-color: threedshadow" onclick="location.href = 'basiscarportmedrejsning.jsp';" >Bestil en carport med rejsnings tag </button>
    
        
        <form name="OrdreList_Customer" action="FrontController" method="POST">
        <input type="hidden" name="command" value="OrdreList_Customer">
        
        <button type="submit" name="OrdreList_Customer" value="Submit">Se Dine Ordre </button>
        
        </form>
        

     
  </body>



</html>
