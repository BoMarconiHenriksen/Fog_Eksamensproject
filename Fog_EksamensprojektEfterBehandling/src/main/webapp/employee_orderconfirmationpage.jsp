<%-- 
    Document   : employee_orderconfirmationpage
    Created on : 10-12-2017, 19:58:54
--%>

<%@page import="Presentation.Utillities.RendUtilStykListe"%>
<%@page import="Business.Domain.Odetaljer"%>
<%@page import="java.text.DecimalFormat"%>

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

        <title>Bestilling fuldført</title>
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
                      <form class="form-inline" name="UserList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="UserList">
                            <div class="form-group">
                                <button type="submit" name="UserList" value="Submit"class="w3-button nav-link text-uppercase text-expanded"><a>Brugere</a> </button>
                            </div>
                        </form>

                        <form class="form-inline" name="OrdreList" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="OrdreList">
                            <div class="form-group">
                                <button type="submit" name="OrdreList" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Administrer Ordre</a> </button>
                            </div>
                        </form>

                        <form class="form-inline" name="LogOut" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="logout">
                            <div class="form-group">
                                <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logout" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Log af </a></button>
                            </div>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Navigation slut -->

        <div class="container">

            <div class="text-heading text-lg">
                <div class="bg-faded p-4 my-4">
                    <hr class="divider">
                    <h2 class="text-center text-lg text-uppercase my-0"><strong>Ordren er nu placeret med den valgte status.</strong></h2>
                    <hr class="divider">

                    <%
                        Odetaljer oDetaljer = (Odetaljer) request.getAttribute("od");

                        double length = oDetaljer.getCarportLength();
                        double width = oDetaljer.getCarportWidth();
                        double heigth = oDetaljer.getCarportHeight();
                        double skurlength = oDetaljer.getLengthRedskabsrum();
                        double skurWidth = oDetaljer.getWidthRedskabsrum();
                        double skurHeigth = 210;

                        out.println("<p>" + "Bestilling for kunde nr.:  " + request.getAttribute("kunde_ided") + "</p> \n");
                        out.println("<p>" + "Bestillings id: " + oDetaljer.getOrdreId() + "</p> \n");

                        double price = oDetaljer.getPrice();

                        out.println("<p>" + "Carportens samlede pris: " + price + "</p> \n");

                        out.println("<p>" + "Carportens ønskede længde: " + length + "</p>");
                        out.println("<p>" + "Carportens ønskede bredde: " + width + "</p>");
                        out.println("<p>" + "Carportens ønskede højde: " + heigth + "</p>");

                        if (skurlength != 0.00) {
                            out.println("<p>" + "Skurets ønskede længde: " + skurlength + "</p>");
                            out.println("<p>" + "Skurets ønskede bredde: " + skurWidth + "</p>");
                            out.println("<p>" + "Skurets ønskede højde: " + skurHeigth + "</p>");

                        } else {
                            out.println("<p>" + "Carporten er uden skur." + "</p>");
                        }

                    %>
                </div>
            </div>


            <div class="bg-faded p-4 my-4"> 

                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Tegning af carporten</strong>
                </h2>
                <hr class="divider">
                <div class="center-img">

                    <%                        out.println("<a>" + request.getAttribute("carportTegning") + "</a>");
                    %>  
                </div>
            </div>

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Styk Liste</strong>
                </h2>
                <hr class="divider">
                <div class="center-img">
                    <%
                        out.println("<p>" + request.getAttribute("stykListe") + "</p>");
                    %>  

                </div>
            </div>
            <div>
                <%--   found it here : https://stackoverflow.com/questions/40719102/when-button-clicked-download-jsp-table-in-the-form-of-pdf --%>      
                <input name="printPDF" type="submit" value="Download som PDF" name="download" onclick="window.print()" />      

                <button type="button" style="background-color: buttonface" onclick="location.href = 'employeepage.jsp';" >Gå Tilbage til Hovedmenuen</button>
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
