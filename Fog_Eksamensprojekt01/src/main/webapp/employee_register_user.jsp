<%-- 
    Document   : register
    Created on : 07-12-2017, 16:20:16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        <link href="css/own_custom_style.css" rel="stylesheet" type="text/css"/>

        <!-- Our Own Custom styles for this template - Important for hidden fields -->
        <script src="script/javascript.js" type="text/javascript" charset=UTF-8></script>
        <title>Registrering</title>
    </head>
    <body>

        <!-- Logo og header billed-->
        <div class="center-img">
            <a href="https://www.johannesfog.dk" target="_blank">
                <img class="logo" src="images/logo.png" alt="Fog Logo">
            </a>

            <img class="header_image" src="images/carport_efter_mål.jpg" onclick="location.href = 'index.jsp'" alt="Carport efter eget mål">
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
                            <span class="sr-only">(current)</span>
                        </li>

                        <form class="form-inline" name="OrdreList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="OrdreList">
                            <div class="form-group">
                                <button type="submit" name="OrdreList" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Administer Ordrer</a> </button>
                            </div>
                        </form>

                        <form class="form-inline" name="UserList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="UserList">
                            <div class="form-group">
                                <button type="submit" name="UserList" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Administer brugere</a> </button>
                            </div>
                        </form>


                        <form class="form-inline" name="Employee_UserOptions" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="Employee_UserOptions">
                            <div class="form-group">
                                <button type="submit" name="Employee_UserOptions" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Ret Kontooplysninger</a> </button>
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


        <div class="container">
            <div class="bg-faded p-4 my-4">


                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">Fyld formen ud, for at registrere en ny bruger.</h2>
                <hr class="divider">

                <table>     

                    <td>
                        <form name="register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="register">
                            Email:<br>
                            <input type="text" name="email" pattern="[a-z-æøå0-9._%+-]+@[a-z-æøå0-9.-]+\.[a-z-æøå]{2,3}$" > <!--Email skal følge standarden navn@navn.dk-->
                            <br>
                            Password:<br>
                            <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z-æøå])(?=.*[A-Z-ÆØÅ]).{7,}" 
                                   title="Passwordet skal bestå af mindst et nummer, et stort bogstav, et lille bogstav og
                                   mindst 7 eller flere tegn">
                            <br>
                            Retype Password:<br>
                            <input type="password" name="passwordRetype" pattern="(?=.*\d)(?=.*[a-z-æøå])(?=.*[A-Z-ÆØÅ]).{7,}" 
                                   title="Passwordet skal bestå af mindst et nummer, et stort bogstav, et lille bogstav og
                                   mindst 7 eller flere tegn">
                            <br>
                            Fornavn:<br>
                            <input type="text" name="firstname" >
                            <br>
                            Efternavn:<br>
                            <input type="text" name="lastname">
                            <br>
                            Adresse:<br>
                            <input type="text" name="addresse"> 
                            <br>
                            PostNummer:<br>
                            <input type="text" name="postnummer" pattern="[0-9]{4}" title="4 Cifre" value="1000">

                            <br>
                            Telefonnummer <br>
                            <input type="tel" name="telefonnummer">
                            <br>
                            <button type="submit" name="register" onclick="return checkNotnullOrEmpty();" value="Submit">Opret Bruger </button>
                            <input type="reset">
                        </form>
                    </td>
                </table>
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