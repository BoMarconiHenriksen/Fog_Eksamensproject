<%-- 
    Document   : Ansatpage
    Created on : 07-12-2017, 12:19:03
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

        <title>Fog Trælast - Hovedsiden for medarbejder</title>
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

                        <li class="nav-item active px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="employeepage.jsp">Hjem
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="employee_register_user.jsp">Opret Bruger</a>
                        </li>

                        <form class="form-inline" name="OrdreList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="OrdreList">
                            <div class="form-group">
                                <button type="submit" name="OrdreList" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Administrer Ordrer</a> </button>
                            </div>
                        </form>

                        <form class="form-inline" name="UserList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="UserList">
                            <div class="form-group">
                                <button type="submit" name="UserList" value="Submit"class="w3-button nav-link text-uppercase text-expanded"><a>Brugere</a> </button>
                            </div>
                        </form>
                        <form class="form-inline" name="LogOut" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="logout">
                            <div class="form-group">
                                <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logOut" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Log af </a></button>
                            </div>
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
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Hovedmenu for medarbejdere</strong>
                </h2>
                <hr class="divider">
                <div class="center-img">
                <h2>Hej <%= (String) session.getAttribute("username")%></h2>
                 </div>
              
                <div class="center-img">
                    <form class="form-inline"  name="OrdreList" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="OrdreList">
                        <button type="submit" name="OrdreList" value="action">Ordrer</button>
                    </form>
                </div> 
                <div class="center-img">
                    <form class="form-inline" name="UserList" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="UserList">
                        <button type="submit" name="UserList" value="action" ><a>Brugere</a> </button>
                    </form>

                </div>
                <div class="center-img">
                    <form class="form-inline" name="Employee_SetupOrderCarportFunctions" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Employee_SetupOrderCarportFunctions">
                        <button type="submit" name="Employee_SetupOrderCarportFunctions" value="action">Bestil en Carport for en kunde </button>
                    </form>
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

    </body>
</html>
