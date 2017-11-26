<%-- 
    Document   : bestilbasiscarportpage.jsp
    Created on : 09-11-2017, 12:08:28
    Author     : Ticondrus
--%>


<%@page import="Business.LogicFacade"%>
<%@page import="Utillities.RendUtilGetMaterials"%>
<%@page import="Utillities.RendUtilCustomerPresentation"%>
<%@page import="Domain.Materiale"%>
<%@page import="java.util.List"%>
<%@page import="Presentation.FrontController"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>For Carporte</title>

        <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
        <script src="script/javascript.js" type="text/javascript"></script>

    </head>
    <body>
        <h1Bestilling af Carporte</h1>

        <h2>Her kan indtastes input til en ønsket carport med eller uden skur...</h2>

        <form name="basisCarport" action="FrontController" method="POST">
            <input type="hidden" name="command" value="basisCarport">
            <input type="hidden" name="command" value="basisCarportChecud">


            <div>

                <table border=4>
                    <tr>
                        <th>Carport Længde</th>
                        <th>Carport Bredde</th>
                        <th>Carport Højde<br>(Standard)</th>

                    </tr>

                    <tr>

                        <td>
                            <select name="lentgchoice">
                                <option number="240">240</option>
                                <option number="270">270</option>
                                <option number="300">300</option>
                                <option number="330">330</option>
                                <option number="360">360</option>
                                <option number="390">390</option>
                                <option number="420">420</option>
                                <option number="450">450</option>
                                <option number="480">480</option>
                                <option number="510">510</option>
                                <option number="540">540</option>
                                <option number="570">570</option>
                                <option number="600">600</option>
                                <option number="630">630</option>
                                <option number="660">660</option>
                                <option number="660">690</option>
                                <option number="720">720</option>
                                <option number="750">750</option>
                                <option number="780">780</option>
                            </select>
                        </td>

                        <td>
                            <select name="widthchoice">
                                <option number="240">240</option>
                                <option number="270">270</option>
                                <option number="300">300</option>
                                <option number="330">330</option>
                                <option number="360">360</option>
                                <option number="390">390</option>
                                <option number="420">420</option>
                                <option number="450">450</option>
                                <option number="480">480</option>
                                <option number="510">510</option>
                                <option number="540">540</option>
                                <option number="570">570</option>
                                <option number="600">600</option>
                                <option number="630">630</option>
                                <option number="660">660</option>
                                <option number="660">690</option>
                                <option number="720">720</option>
                                <option number="750">750</option>
                            </select>
                        </td>

                        <td>
                            <select name="heightchoice">
                                <option number="225">225</option>
                            </select>
                        </td>
                    </tr>
                </table>

            </div>

            <!--Her starter vores hidden skur-->
            <!-- <form action="#" method="POST">-->
            <div>
                Ønsker du en carport med skur? Tryk på checkboksen! <input type="checkbox" id="trigger" name="question">
            </div>
            <div id="hidden_fields">
                Hvor stort skal skuret være? 

                <br><br>
                <body>
                    <table border=4>
                        <tr>
                            <th>Skur Længde</th>
                            <th>Skur Bredde</th>
                            <th>Skur Højde<br>(Standard)</th>

                        </tr>

                        <tr>

                            <td><select name="lentgchoiceskur">
                                    <option number="0" value="0"> Fravalgt</option>
                                    <option number="210">210</option>
                                    <option number="240">240</option>
                                    <option number="270">270</option>
                                    <option number="300">300</option>
                                    <option number="330">330</option>
                                    <option number="360">360</option>
                                    <option number="390">390</option>
                                    <option number="420">420</option>
                                    <option number="450">450</option>
                                    <option number="480">480</option>
                                    <option number="510">510</option>
                                    <option number="540">540</option>
                                    <option number="570">570</option>
                                    <option number="600">600</option>
                                    <option number="630">630</option>
                                    <option number="660">660</option>
                                    <option number="660">690</option>
                                    <option number="720">720</option>

                                </select>

                            </td>

                            <td><select name="widthchoiceskur">
                                    <option number="0" value="0"> Fravalgt</option>
                                    <option number="150">150</option>
                                    <option number="180">180</option>
                                    <option number="210">210</option>
                                    <option number="240">240</option>
                                    <option number="270">270</option>
                                    <option number="300">300</option>
                                    <option number="330">330</option>
                                    <option number="360">360</option>
                                    <option number="390">390</option>
                                    <option number="420">420</option>
                                    <option number="450">450</option>
                                    <option number="480">480</option>
                                    <option number="510">510</option>
                                    <option number="540">540</option>
                                    <option number="570">570</option>
                                    <option number="600">600</option>
                                    <option number="630">630</option>
                                    <option number="660">660</option>
                                    <option number="660">690</option>

                                </select></td>    

                            <td> <select name="heightchoiceskur">
                                    <option number="0" value="0"> Fravalgt</option>
                                    <option number="210">210</option>
                                </select></td>

                        </tr>
                    </table>
                    <!--Her slutter hidden skur-->    

            </div>

            <br><br>

            <button type="submit" name="basisCarport" value="CheckPrice">Tjek Pris </button>
            <button type="submit" name="basisCarportCheckud" value="BestilOrdre">Bestil Carport </button>

        </form>
        
        

      <%--  <form name="Checkout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="checkoutFunktion">

            <button type="submit" name="checkoutFunktion" value="Submit">Bestil </button>        

        </form>--%>

        <p>
            Vi gør opmærksom på at efter at hvis De trykker på tjek pris og  derefter vil bestille bedes De
            lige vælge målene på den ønskede carport igen. Vi arbejder på at rette fejlen og beklager den 
            tort og smerte De måtte opleve i forbindelse med dette.(dette skal selvfølgelig fjernes når fejlen er rettet).
        </p>
        <%--   <button type="button" style="background-color: buttonface" onclick="location.href = 'index.jsp';" >Gå Tilbage til Index</button> --%>

        <!--Hvis basisCarport er null printes der ikke noget på siden-->
        <%if (request.getAttribute("widthInput") == null) {
                out.println("");
            } else {
                out.println("<p> Hello User nr. " + request.getAttribute("userNr") + "</p><br>");
                out.println("<h2>Pris på valgt Carport: </h2><br>");
                out.println("<p> Samlet Carport pris: " + (String) request.getAttribute("carportTotaludenSkur") + "</p><br>");

                out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInput") + "</p><br>");
                out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInput") + "</p><br>");
                out.println("<p> Ønsket Højde: " + (Double) request.getAttribute("heightInput") + "</p><br>");

                if (Double.parseDouble(request.getParameter("lentgchoiceskur")) != 0) {

                    out.println("<p> Samlet Carport pris, med skur: " + (String) request.getAttribute("carportTotalmedSkur") + "</p><br>");
                    out.println("<p> Ønsket Længde på Skuret: " + (Double) request.getAttribute("lentghInputSkuret") + "</p><br>");
                    out.println("<p> Ønsket Bredde på Skuret: " + (Double) request.getAttribute("widthInputSkuret") + "</p><br>");
                    out.println("<p> Standard Højde på Skuret: " + (Double) request.getAttribute("heightInputSkuret") + "</p><br>");
                } else {
                    out.println("");
                }

            }%>

    </body>
</html>
