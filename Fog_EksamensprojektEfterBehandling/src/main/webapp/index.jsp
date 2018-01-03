<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        <link href="css/own_custom_style.css" rel="stylesheet" type="text/css"/>

        <!-- Our Own Custom styles for this template - Important for hidden fields -->
        <script src="script/javascript.js" type="text/javascript" charset=UTF-8></script>

        <title>Fogs Carporte</title>
    </head>
    <body>

        <!-- Logo og header billed-->
        <div class="center-img">
            <a href="https://www.johannesfog.dk" target="_blank">
                <img class="logo" src="images/logo_header.jpg" alt="Fog Logo">
            </a>
        </div>

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

                                <a class="nav-link text-uppercase text-expanded" href="register.jsp">Opret Bruger</a>
                            </li>

                            <li class="nav-item px-lg-4">
                                <div class="form-group nav-link text-uppercase text-expanded">
                                    <input type="hidden" name="command" value="login">
                                    <a> Email:</a> 
                                    <input type="text" name="email">
                                    <a>Password:</a> 
                                    <input type="password" name="password">
                                    <button type="submit" name="login" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Login</a> </button>
                                </div>

                            </li>
                        </form>  
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Navigation slut -->
        <!-- Navigation til eksamenspræsentation -->
        <ul class="navbar-nav mx-auto">
            <li><a href="index.jsp">Hjem</a></li>
            <li><a href="finals_benedikte.jsp">Benedikte</a></li>
            <li><a href="finals_bo.jsp">Bo</a></li>
            <li><a href="finals_walther.jsp">Walther</a></li>
            <li><a href="finals_navigations_diagram.jsp">Navigationsdiagram</a></li>
            <li><a href="finals_sekvens_materiale.jsp">Sekvensdiagram stykliste</a></li>

        </ul> 

        <div class="container">
            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">En Carport Efter Dine
                    <strong>Drømme</strong>
                </h2>
                <hr class="divider">
            </div>
            <!--Bruges når en kunde har regisret sig-->
            <div class="bg-faded text-center mr-4" >
                <% if (request.getAttribute("succes") != null) {
                        out.println("<p>" + request.getAttribute("pleaselogin") + "</p>");

                    } else {

                    }%>
            </div> 
            <div class="bg-faded p-4 my-4">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/basis_carport.png" alt="Basis Carport" width="30%">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/dobbelt_carport.png" alt="Dobbelt Carport" width="30%">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/rejsning.png" alt="Carport med Rejsning" width="30%">
                <div class="bg-faded text-center mr-4">
                    <a>Dette er indexsiden i vores carportbestillingssystem. <br>
                        Her kan man enten logge ind eller vælge at gå til registrering, hvis man er ny bruger.<br>
                        Hvis man klikker på headerbilledet kommer man til Johannes Fogs rigtige hjemmeside.<br>
                        Hvis man klikker på hjem kommer man til index.jsp.</a>
                </div> 
            </div>
        </div> 
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

        <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="script/jquery/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
