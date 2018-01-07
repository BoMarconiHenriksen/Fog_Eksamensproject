<%-- 
    Document   : finals_walther
    Created on : 02-01-2018, 19:31:08
    Author     : Ejer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- Vores scripts ligger i head, ellers virker vores skjulte tabel ikke -->
        <script src="css/js/bootstrap.js" type="text/javascript"></script> 

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        <link href="css/own_custom_style.css" rel="stylesheet" type="text/css"/>

        <!-- Our Own Custom styles for this template - Important for hide/show fields. Skal ligge øverst. -->
        <script src="script/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="script/javascript.js" type="text/javascript" charset=UTF-8></script>

        <title>Walther</title>
    </head>
    <body>

        <!-- Logo og header billed-->

       <div class="center-img">
            <a href="https://www.johannesfog.dk" target="_blank">
                <img class="logo" src="images/logo_header.jpg" alt="Fog Logo">
            </a>
        </div>


        <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Walther præsenterer</div>
        <div class="tagline-lower text-center text-expanded text-shadow text-uppercase text-white mb-5 d-none d-lg-block">Navigation | Bestil en carport</div>

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
            <li><a href="finals_benedikte.jsp">Benedikte</a></li>
            <li><a href="finals_bo.jsp">Bo</a></li>
            <li><a href="finals_walther.jsp">Walther</a></li>
            <li><a href="finals_arkitektur_diagram.jsp">Arkitektur</a></li>
            <li><a href="finals_fullsystem_diagram.jsp">Overblik full system</a></li>
        </ul> 




        <div class="container">

            <div class="text-heading text-lg">
                <div class="text-center mt-4">
                    <div class="bg-faded p-4 my-4">

                        <h2>Synopsis</h2>



                  
                        <ul class="navbar-nav mx-auto">
                            <li><a href="finals_navigations_diagram.jsp">Navigationsdiagram</a></li>    
                            <li><a href="index.jsp">Bestil en carport</a></li>
                            <li><a  href = 'https://github.com/walter01git/Fog_Eksamensproject/issues/45'>userstory "Kunde bestiller en ordre"</a></li>
                            
                        </ul> 
                    </div>
                </div>
            </div>
        </div>
       
        <footer class="bg-faded text-center py-5">
            <div class="container">
                <p class="m-0">Copyright &copy; The Data Builders 2017</p>
            </div>
        </footer>
    </body>
</html>
