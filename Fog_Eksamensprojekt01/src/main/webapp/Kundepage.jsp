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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script type="text/javascript" src="jquery-1.8.3.js"></script>
        <script src="script/javascript.js" type="text/javascript"></script>
<<<<<<< HEAD
        
=======
    <img class="w3-image" src=https://www.johannesfog.dk/globalassets/header/logo.png alt="FogLogo" onclick="location.href = 'https://www.johannesfog.dk/'" width="17%" height="17%" >
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <link href="startbootstrap-business-casual-gh-pages/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="startbootstrap-business-casual-gh-pages/css/business-casual.css" rel="stylesheet" type="text/css"/>
    <img class="background-image" src="https://www.johannesfog.dk/globalassets/inriver/resources/33529" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport" width="75%" height="75%"float="right">
>>>>>>> origin/Design

    <script type="text/javascript" src="jquery-1.8.3.js"></script>
    <script src="script/javascript.js" type="text/javascript"></script>

    <title>Fog Trælast - Velkomstside</title>
</head>



<body>
    <!-- Welcome Message -->
    <div class="text-center mt-4">
        <div class="text-heading  text-lg">Velkommen til</div>
        <h1 class="my-2"><%= (String) session.getAttribute("username")%></h1>


    </div>


    <div class="container"



         <!-- Navigation -->
         <div class="w3-side">


            <div class="w3-bar w3-blue w3-wide w3-padding w3-card">

                <!-- Float links to the right. Hide them on small screens -->
                <a onclick="location.href = 'bestilbasiscarportpage.jsp'" class="w3-bar-item w3-button">Hjem</a>
                <a onclick="location.href = 'bestilbasiscarportpage.jsp'" class="w3-bar-item w3-button">Bestil carport</a>
                <form class="form-inline" name="OrdreList_Customer" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="OrdreList_Customer">
                    <div class="form-group">
                        <button type="submit" name="OrdreList_Customer" value="Submit" class="w3-bar-item w3-button"><a>Ordreliste</a> </button>
                    </div>
                </form>
                <form class="form-inline" name="LogOut" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <div class="form-group">
                <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logout" value="Submit" class="w3-bar-item w3-button"><a>Log af </a></button>
            </div>
        </form>
<<<<<<< HEAD
        
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
=======
               
            </div>
        </div>

        <%--session.invalidate();--%>
        <div class="text-heading text-muted text-lg">
            <div class="bg-faded p-4 my-4">
>>>>>>> origin/Design

                <div class="w3-display-container">
                    <div class="w3-display-topleft w3-blue w3-padding">Simpel Carport</div>
                    <img onclick="location.href = 'bestilbasiscarportpage.jsp'"src="https://www.johannesfog.dk/globalassets/inriver/resources/9078632_carport_enkelt_300x480mtr_web.jpg/ProductPage" alt="House" style="width:25%">
                    <a> Her kan du bestille en simpel carport med eller uden skur</a>
                </div>

                <div class="w3-display-container">
                    <div class="w3-display-topleft w3-blue w3-padding">Dobbelt carport</div>
                    <img src="https://www.johannesfog.dk/globalassets/inriver/resources/9078639_carport_dobbel_600x540mtr_web.jpg/ProductPage" alt="House" style="width:25%">
                    <a> Her kan du endnu ikke bestille en dobbelt carport med eller uden skur</a>
                </div>     

                <div class="w3-display-container">
                    <div class="w3-display-topleft w3-blue w3-padding">Carport med rejsningstag</div>
                    <img src="https://www.johannesfog.dk/globalassets/inriver/resources/9078618_carport_car01h_540x360mtr_web.jpg/ProductPage" alt="House" style="width:25%">
                    <a> Her kan du endnu ikke bestille en carport med tag med rejsning med eller uden skur</a>
                </div>                   
            </div>     
        </div>        
 
   
    </div> 

</div>
<br>

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
