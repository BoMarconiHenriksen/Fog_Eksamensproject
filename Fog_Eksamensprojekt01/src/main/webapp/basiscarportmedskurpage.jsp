<%-- 
    Document   : basiscarportmedskurpage
    Created on : 09-16-2017, 18:59:28
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simpel carport med skur</h1>


        <h2>Her kan intastes input til en ønsket carport og udskrives en pris på hvad den vil koste.</h2>

        <form name="basisCarport" action="FrontController" method="POST">
            <input type="hidden" name="command" value="basisCarportmedSkur">
            <input type="hidden" name="command" value="checkoutFunktion">
            

            <br><br>
            <body>
                <table border=4>
                    <tr>
                        <th>Carport Længde</th>
                        <th>Carport Bredde</th>
                        <th>Corport Højde</th>
                        <th>Skur Længde</th>
                        <th>Skur Bredde</th>
                        <th>Skur Højde</th>

                    </tr>

                    <tr>
                        <td> <select name="lentgchoice">
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

                        <td><select name="widthchoice">
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
                            </select></td>

                        <td> <select name="heightchoice">
                                <option number="225">225</option>
                            </select></td>

                        <td><select name="lentgchoiceskur">
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

                        <td><select name="widthchoiceskur">
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
                            </select></td>    

                        <td> <select name="heightchoiceskur">
                                <option number="xxx">xxx</option>
                            </select></td>

                    </tr>
                </table>




                <br><br>
                Tagtype:<br>
                <ul>
                    <select name="kundetrevalg">
                        <option value="Trykimp">Trykimp.</option>
                        <option value="Reguler">Regulr</option>
                    </select>
                </ul>



                <%--   <input type="submit" value="Submit">
              </form> --%>
                <button type="submit" name="basisCarportmedSkur" value="Submit">Tjek Pris </button>

                <button type="submit" name="checkoutFunktion" value="Submit"> Bestil </button>

        </form>


    <h2>Pris på valgt Carport: </h2><br>
    <%if ("basisCarport" == null) {
            out.println("...");
        } else {

            out.println("<p> Samlet Carport pris, med skur og det hele: " + request.getAttribute("carportTotal") + "</p><br>");
            
                        out.println("<p> Carportens Ønskede størrelse: ");

            out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInput") + "</p><br>");
            out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInput") + "</p><br>");
            out.println("<p> Ønsket Højde: " + (Double) request.getAttribute("heightInput") + "</p><br>");
            
            out.println("<p> Skurets Ønskede størrelse: ");
            
            out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInputSkur") + "</p><br>");
            out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInputSkur") + "</p><br>");

            out.println("<p> Trætype: " + request.getAttribute("trevalgInput") + "</p><br>");
        }%>


</body>



</html>
