<%-- 
    Document   : om_projektet
    Created on : 02-12-2017, 22:33:55
    Author     : Ejer
--%>

<%@page import="Utillities.RendUtilOrderList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>

        <meta name="viewport" content="width=device-width">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">

        <link href="WEB-INF/CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <br><br>
 <img class="w3-image" src=https://www.johannesfog.dk/globalassets/header/logo.png alt="FogLogo" onclick="location.href = 'https://www.johannesfog.dk/'" width="15%" height="15%" >
  <img class="background-image" src="https://www.johannesfog.dk/globalassets/inriver/resources/33529" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport" width="52%" height="52%"float="right">
    <title>Om projektet</title>
</head>
<div class="w3-top">
   

    <div class="w3-bar w3-blue w3-wide w3-padding w3-card">

        <!-- Float links to the right. Hide them on small screens -->
            <a onclick="location.href = 'bestilbasiscarportpage.jsp'" class="w3-bar-item w3-button">Bestil carport</a>
            <a onclick="location.href = 'ordre_liste.jsp'" class="w3-bar-item w3-button">ordreliste</a>
            <a onclick="location.href = 'index.jsp'" class="w3-bar-item w3-button">home</a>
        </div>
    </div>
</div>

<body>

<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
 <img class="background-image" src=" https://www.johannesfog.dk/globalassets/forsiden/forside-carport.jpg" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport" width="100%" height="100%"float="right">
   
   </div>
  </div>
 
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Simpel Carport</div>
        <img onclick="location.href = 'bestilbasiscarportpage.jsp'"src="https://www.johannesfog.dk/globalassets/inriver/resources/9078632_carport_enkelt_300x480mtr_web.jpg/ProductPage" alt="House" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Carport med rejsningstag</div>
        <img src="https://www.johannesfog.dk/globalassets/inriver/resources/9078618_carport_car01h_540x360mtr_web.jpg/ProductPage" alt="House" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Dobbelt carport</div>
        <img src="https://www.johannesfog.dk/globalassets/inriver/resources/9078639_carport_dobbel_600x540mtr_web.jpg/ProductPage" alt="House" style="width:99%">
      </div>
    </div>
  </div>
<div class="container">
     <footer class="bg-faded text-center py-5">
            
                <p class="m-0">Copyright &copy; The Data Builders 2017</p>
          
        </footer>

  </div>
</body>
</html>
