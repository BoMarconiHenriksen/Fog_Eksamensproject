<%-- 
    Document   : ordrelist_customer
    Created on : 28-11-2017, 11:28:13
    Author     : Ticondrus
--%>


<%@page import="Business.LogicFacade"%>
<%@page import="Domain.User"%>
<%@page import="Utillities.RendUtilOrderList_Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script type="text/javascript" src="jquery-1.8.3.js"></script>
        <script src="script/javascript.js" type="text/javascript"></script>
    <img class="w3-image" src=https://www.johannesfog.dk/globalassets/header/logo.png alt="FogLogo" onclick="location.href = 'https://www.johannesfog.dk/'" width="17%" height="17%" >
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <link href="startbootstrap-business-casual-gh-pages/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="startbootstrap-business-casual-gh-pages/css/business-casual.css" rel="stylesheet" type="text/css"/>
    <img class="background-image" src="https://www.johannesfog.dk/globalassets/inriver/resources/33529" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport" width="75%" height="75%"float="right">

    <script type="text/javascript" src="jquery-1.8.3.js"></script>
    <script src="script/javascript.js" type="text/javascript"></script>
    <title>Ordreliste - Kunde</title>
</head>
<body>
    <div class="text-center mt-4">
        <h1>Dine ordrer</h1>

        <h2>Velkommen <%= (String) session.getAttribute("username")%> </h2>

        <div class="container">
            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Ordre detaljer</strong>
                </h2>
               
       
                
               <% out.println(request.getAttribute("customerlist")); %>

            
            </div>
        </div>
    </div>

    <div class="text-center mt-4">
        <button type="button"  onclick="location.href = 'Kundepage.jsp';" >Gå Tilbage til velkomstsiden</button>

    </div>


    <footer class="bg-faded text-center py-5">
        <div class="container">
            <p class="m-0">
                <img class="w3-image" src=https://www.johannesfog.dk/globalassets/header/logo.png alt="FogLogo" onclick="location.href = 'https://www.johannesfog.dk/'" width="5%" height="5%" >        
                Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439                       Alle priser er inkl. moms
            </p>
        </div>
    </footer>  
<script src="script/jquery/jquery.min.js" type="text/javascript"></script>
<script src="script/popper/popper.min.js" type="text/javascript"></script>
<script src="css/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
