<%-- 
    Document   : kunde_useroptionspage
    Created on : 06-12-2017, 15:11:32
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

        <title>Dine Brugeroplysninger</title>
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
                            <a class="nav-link text-uppercase text-expanded" href="customerpage.jsp">Hjem
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>

                        <li class="nav-item px-lg-4">
                            <a class="nav-link text-uppercase text-expanded" href="customer_order_carport.jsp">Bestil Carport</a>
                        </li>

                        <form class="form-inline" name="OrdreList_Customer" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="OrdreList_Customer">
                            <div class="form-group">
                                <button type="submit" name="OrdreList_Customer" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Ordre Historie</a> </button>
                            </div>
                        </form>

                        <form class="form-inline" name="Customer_UserOptions" action="FrontController" method="POST">
                            <div>     
                                <input type="hidden" name="command" value="Customer_UserOptions">
                                <div class="form-group">
                                    <button type="submit" name="Customer_UserOptions" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Kontooplysninger</a></button>
                                </div>
                            </div>
                        </form>

                        <form class="form-inline" name="LogOut" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="logout">
                            <div class="form-group">
                                <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logout" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Log af</a></button>
                            </div>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Navigation slut -->

        <div class="container">
            <div class="text-center mt-4">

                <div class="bg-faded p-4 my-4">
                    <hr class="divider">
                    <h2 class="text-center text-lg text-uppercase my-0">
                        <strong>Dine konto oplysninger</strong>
                    </h2>
                    <hr class="divider">

                    <div class="text-center">
                        <p>Dit Fornavn: ${yourFirstname}</p><br>
                        <p>Din Efternavn: ${yourLastname}</p><br>
                        <p>Din Email: ${yourEmail}</p><br>
                        <p>Din Adresse: ${yourAddress}</p><br>
                        <p>Dit Postnummer: ${yourZipcode}</p><br>
                        <p>Dit Telefonnummer: ${yourPhoneNr}</p><br>
                    </div>
                    <br>
                    <div class="center-img">
                        <form name="Customer_UserOptions" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="Customer_UserOptions">

                            Intast nuværende Password: <br><input type="password" name="passwordOld" ><br>

                            Ændre Password:<br> <input type="password" name="passwordNew" >
                            <br><br>
                            <button type="submit" name="Customer_UserOptionsPasswordChange" value="Submit">Udfør Password ændring </button>
                        </form>

                    </div>
                    <br>

                    <% if ((int) request.getAttribute("outprintpasswordchangestatus") == 0) {
                            out.println("<p> Dit tidligere password var ikke korrekt. Prøv igen. </p><br>");
                        } else if ((int) request.getAttribute("outprintpasswordchangestatus") == 1) {
                            out.println("<p> Dit password er nu ændret. </p><br>");
                        } else {
                            out.println("");
                        }
                    %>
                </div>

                <div class="center-img">

                    <button type="button"  onclick="location.href = 'customerpage.jsp';" >Gå Tilbage til velkomstsiden</button>
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
