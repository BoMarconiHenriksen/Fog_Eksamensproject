<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

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
    <script src="script/javascript.js" type="text/javascript"></script>
    <title>Velkomst side</title>
</head>
<body>

     <div class="text-center mt-4">
           <div class="text-heading  text-lg">Velkommen til</div>
    <h1>  Fogs carport side</h1>
</div>
    <div class="container"
         <!-- Navigation -->
         <div class="w3-side">

            <div class="w3-bar w3-blue w3-wide w3-padding w3-card">

                <!-- Float links to the right. Hide them on small screens -->
                <a onclick="location.href = 'https://www.johannesfog.dk/'" class="w3-bar-item w3-button">Hjem</a>
                <form  class="form-inline" name="login" action="FrontController" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="command" value="login">
                        <a> Email:</a> 
                        <input type="text" name="email" value=""  >
                        <a>Password:</a> 
                        <input type="password" name="password" value="">
                        <button type="submit" name="login" value="Submit" class="w3-bar-item w3-button"><a>Login</a> </button>
                    </div> 
                </form>
            </div>
        </div>


       <div class="bg-faded p-4 my-4">
           <div class="text-center mt-4">
                 <h2 class="text-left text-lg text-uppercase my-0">
            Fyld formen ud hvis du er ny kunde
            </h2>
        <table>     
          
            <td>
                <form name="register" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="register">
                    Email:<br>
                    <input type="text" name="email" value="someone@nowhere.com">
                    <br>
                    Password:<br>
                    <input type="password" name="password1" pattern=".{6,}" title="7 eller flere karakter">
                    <br>
                    Retype Password:<br>
                    <input type="password" name="password2" pattern=".{6,}" title="7 eller flere karakter">
                    <br>
                    Fornavn:<br>
                    <input type="text" name="firstname" value="Peter">
                    <br>
                    Efternavn:<br>
                    <input type="text" name="lastname" value="Jensen">
                    <br>
                    Addresse:<br>
                    <input type="text" name="addresse" value="Jensen">
                    <br>
                    Post Nummer (0001):<br>
                    <input type="text" name="postnummer" pattern="[0-9]{4}" title="4 Cifre" >
                    <br>
                    Telefon nummer <br>
                    <input type="number" name="telefonnummer" min="1" max="99999999999" >
                    <br>
                    <button type="submit" name="register" value="Submit">Opret Bruger </button>
                </form>
            </td>
         
        </table>
      </div>
    </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
            
            
            <footer class="bg-faded text-center py-5">
        <div class="container">
            <p class="m-0">
                <img class="w3-image" src=https://www.johannesfog.dk/globalassets/header/logo.png alt="FogLogo" onclick="location.href = 'https://www.johannesfog.dk/'" width="5%" height="5%" >        
                Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439                       Alle priser er inkl. moms
            </p>
        </div>
    </footer>      
     </div>
    <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="script/popper/popper.min.js" type="text/javascript"></script>
    <script src="css/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
