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
            <a onclick="location.href = 'bestilbasiscarportpage.jsp'" class="w3-bar-item w3-button">bestil carport</a>
            <a onclick="location.href = 'ordre_liste.jsp'" class="w3-bar-item w3-button">ordreliste</a>
            <a onclick="location.href = 'index.jsp'" class="w3-bar-item w3-button">home</a>
        </div>
    </div>
</div>

<body>

<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
 <img class="background-image" src=" https://www.johannesfog.dk/globalassets/forsiden/forside-carport.jpg" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport" width="100%" height="100%"float="right">
   
  <div class="w3-display-middle w3-margin-top w3-center">
  </div>
</header>
    <br><br>
     <div class="w3-container w3-padding-32" id="projects">
    <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Om projektet</h3>
  </div>
 
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Brick House</div>
        <img src="/w3images/house5.jpg" alt="House" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Renovated</div>
        <img src="/w3images/house4.jpg" alt="House" style="width:99%">
      </div>
    </div>
    <div class="w3-col l3 m6 w3-margin-bottom">
      <div class="w3-display-container">
        <div class="w3-display-topleft w3-black w3-padding">Barn House</div>
        <img src="/w3images/house3.jpg" alt="House" style="width:99%">
      </div>
    </div>
  </div>
    
  


</body>
</html>
