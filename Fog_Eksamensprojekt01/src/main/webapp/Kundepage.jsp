<%-- 
    Document   : Kundepage
    Created on : 05-12-2017, 11:00:25
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

        <h2>Velkommen <%= (String) session.getAttribute("username")%> </h2>


        <button type="button" style="background-color: buttonface" onclick="location.href = 'bestilbasiscarportpage.jsp';" >Bestil en simpel carport</button>
        <button type="button" style="background-color: threedshadow" onclick="location.href = 'basiscarportmedrejsning.jsp';" >Bestil en carport med rejsnings tag </button>


        <form name="OrdreList_Customer" action="FrontController" method="POST">
            <input type="hidden" name="command" value="OrdreList_Customer">

            <button type="submit" name="OrdreList_Customer" value="Submit">Se Dine Ordre </button>

        </form>
        
        <form name="LogOut" action="FrontController" method="POST">
        <input type="hidden" name="command" value="logout">
        
        <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logout" value="Submit">Log af </button>
        
        </form>
        
        <div>
        <form name="Customer_UserOptions" action="FrontController" method="POST">
            <input type="hidden" name="command" value="Customer_UserOptions">
            
            <button type="submit" name="Customer_UserOptions" value="Submit">Se eller ret dine kontooplysninger </button>
        </form>
        </div>


    </body>



</html>
