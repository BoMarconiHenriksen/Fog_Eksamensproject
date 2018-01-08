<%-- 
    Document   : customerpage
    Created on : 05-12-2017, 11:00:25
--%>

<%@page import="Business.DataFacade"%>
<%@page import="java.util.List"%>
<%@page import="Presentation.FrontController"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <!-- Skal nok slettes-->
        <!--<script type="text/javascript" src="jquery-1.8.3.js"></script>-->

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template -->
        <link href="css/business-casual.css" rel="stylesheet" type="text/css"/>
        <link href="css/own_custom_style.css" rel="stylesheet" type="text/css"/>

        <!-- Our Own Custom styles for this template - Important for hidden fields -->
        <script src="script/javascript.js" type="text/javascript" charset=UTF-8></script>

        <title>Fog Trælast - Velkomstside</title>
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
                                    <button type="submit" name="Customer_UserOptions" value="Submit" class="w3-button nav-link text-uppercase text-expanded"><a>Kontooplysninger </a></button>
                                </div>
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
   <!-- Navigation til eksamenspræsentation -->
        <ul class="navbar-nav mx-auto">
            <li><a href="finals_benedikte.jsp">Benedikte</a></li>
            <li><a href="finals_bo.jsp">Bo</a></li>
            <li><a href="finals_walther.jsp">Walther</a></li>
            <li><a href="finals_fullsystem_diagram.jsp">Overblik full system</a></li>
        </ul> 



        <!-- Welcome Message -->
        <div class="text-center mt-4">
            <h1 class="my-2">Velkommen til, <%=(String) session.getAttribute("username")%></h1>
            <div class="text-heading text-lg">Hvis du har brug for rådgivning, så ring og aftale et møde.</div>
            <div class="text-heading text-lg">Vores telefonnummer er 45 87 10 01.</div>
        </div>

        <div class="container">

            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <a href="customer_order_carport.jsp">
                        <strong>Basis Carport</strong>
                    </a>
                </h2>
                <hr class="divider">
                <a href="customer_order_carport.jsp">
                    <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/basis_carport.png" alt="Basis Carport" width="25%">
                </a>

                <p>Her kan man bestille en helt almindelig carport med fladt tag, med eller uden redskabsskur.</p>
                <p>Man kan også få en tegning af taget set ovenfra.</p>
                <p>og når man har bestilt carporten så får man også en liste over hvilke materialer der skal bruges hvor</p>
            </div>



            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Dobbelt Carport</strong>
                </h2>
                <hr class="divider">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/dobbelt_carport.png" alt="Dobbelt Carport" width="30%">
                <p>Her kan man på et endnu ikke fastsat tidspunkt bestille en dobbelt carport med fladt tag, med eller uden redskabsskur.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit totam libero expedita magni est delectus pariatur aut, aperiam eveniet velit cum possimus, autem voluptas. Eum qui ut quasi voluptate blanditiis?</p>
            </div>  



            <div class="bg-faded p-4 my-4">
                <hr class="divider">
                <h2 class="text-center text-lg text-uppercase my-0">
                    <strong>Carport med Rejsningstag</strong>
                </h2>
                <hr class="divider">
                <img class="img-fluid float-left mr-4 d-none d-lg-block" src="images/rejsning.png" alt="Carport med Tagrejsning" width="30%">
                <p>Her kommer man muligvis til at kunne bestille en carport med rejsningstag, med eller uden redskabsskur..</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laboriosam pariatur perspiciatis reprehenderit illo et vitae iste provident debitis quos corporis saepe deserunt ad, officia, minima natus molestias assumenda nisi velit?</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit totam libero expedita magni est delectus pariatur aut, aperiam eveniet velit cum possimus, autem voluptas. Eum qui ut quasi voluptate blanditiis?</p>
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
