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

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Skal nok slettes-->
        <!--<script type="text/javascript" src="jquery-1.8.3.js"></script>-->

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        <link href="css/own_custom_style.css" rel="stylesheet" type="text/css"/>

        <!-- Our Own Custom styles for this template - Important for hidden fields -->
        <script src="script/javascript.js" type="text/javascript"></script>

        <title>Fogs Carporte</title>
    </head>
    <body>

        <!-- Logo og header billed-->
        <a href="https://www.johannesfog.dk" target="_blank">
            <img class="logo" src="images/logo.png" alt="Fog Logo">
        </a>

        <img class="header_image" src="images/carport_efter_mål.jpg" onclick="location.href = 'bestilbasiscarportpage.jsp'" alt="Carport efter eget mål">

        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Fogs Carporte</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Carporte Efter Egne Mål | Tlf. 45 87 10 01</div>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
            <div class="container">

                <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Menu</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav mx-auto">

                        <form  class="form-inline" name="login" action="FrontController" method="POST">

                            <li class="nav-item active px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="index.jsp">Hjem
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>

                            <li class="nav-item px-lg-4">

                                <a class="nav-link text-uppercase text-expanded" href="login.jsp">Opret Bruger</a>
                            </li>

                            <li class="nav-item px-lg-4">
                                <div class="form-group nav-link text-uppercase text-expanded">
                                    <input type="hidden" name="command" value="login">
                                    <a> Email:</a> 
                                    <input type="text" name="email" value=""  >
                                    <a>Password:</a> 
                                    <input type="password" name="password" value="">
                                    <button type="submit" name="login" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Login</a> </button>
                                </div>

                            </li>
                        </form>  
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Navigation slut -->
        <div class="container">
            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">En Carport Efter Dine
                    <strong>Drømme</strong>
                </h2>
                <hr class="divider">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/basis_carport.png" alt="Basis Carport" width="30%">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/dobbelt_carport.png" alt="Dobbelt Carport" width="30%">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/rejsning.png" alt="Carport med Rejsning" width="30%">

                <h1>Fog Trælast</h1>

                <h2>Velkommen. Vælg her en carport type.</h2>

                <button type="button" style="background-color: buttonface" onclick="location.href = 'bestilbasiscarportpage.jsp';" >Bestil en simpel carport</button>
                <button type="button" style="background-color: threedshadow" onclick="location.href = 'basiscarportmedskurpage.jsp';" >Bestil en simpel carport med skur</button>

                <form name="OrdreList_Customer" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="OrdreList_Customer">

                    <button type="submit" name="OrdreList_Customer" value="Submit">Se Dine Ordre </button>

                </form>


            </div> 
        </div>









        <!--<div class="bg-faded p-4 my-4">
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
        </div>-->
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>


        <footer class="bg-faded text-center py-5">
            <div class="container">
                <p class="m-0">
                    <a href="https://www.johannesfog.dk" target="_blank">
                        <img class="fog_bottom_logo" src="images/logo.png" alt="Fog Logo">        
                    </a>
                    Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439 - Alle priser er inkl. moms
                </p>
            </div>
        </footer>      
    </div>

    <script src="script/jquery/jquery.js" type="text/javascript"></script>
    <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="script/popper/popper.min.js" type="text/javascript"></script>
    <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="script/popper/popper.min.js" type="text/javascript"></script>
    <script src="css/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
