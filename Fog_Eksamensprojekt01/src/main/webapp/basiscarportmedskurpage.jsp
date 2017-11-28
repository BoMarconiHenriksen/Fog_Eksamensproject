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
        <title>Carport med skur</title>
    </head>
    <body>
        <h1>Carport med skur</h1>


        <h2>Her kan indtastes input til en ønsket carport og udskrives en pris på hvad den vil koste.</h2>

        <form name="basisCarport" action="FrontController" method="POST">
            <input type="hidden" name="command" value="basisCarportmedSkur">
            <input type="hidden" name="command" value="checkoutFunktion">
            

            <br><br>
            <body>
            
                
                Carport Længde:<br>
            <ul>
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
            </ul>
            Carport Bredde:<br>
            <ul>
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
            </ul>
            Carport Højde:<br>
            <ul>
                <select name="heightchoice">
                    <option number="225">225</option>
                </select>
            </ul>
           
                <table border=4>
                    <tr>
                        <th>Skur Længde</th>
                        <th>Skur Bredde</th>
                        <th>Skur Højde<br>(Standard)</th>

                    </tr>

                    <tr>

                        <td><select name="lentgchoiceskur">
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
                                <option number="210">210</option>
                            </select></td>

                    </tr>
                </table>




             <%--   <br><br>
                Tagtype:<br>
                <ul>
                    <select name="kundetrævalg">
                        <option value="Trykimp">Trykimp.</option>
                        <option value="Reguler">Regulr</option>
                    </select>
                </ul> --%>



                <%--   <input type="submit" value="Submit">
              </form> --%>
                <br>
                <button type="submit" name="basisCarportmedSkur" value="Submit">Tjek Pris </button>

             <%--   <button type="submit" name="checkoutFunktion" value="Submit"> Bestil </button> --%>

        </form>


    <!--Hvis basisCarport er null printes der ikke noget på siden-->
        <%if (request.getAttribute("widthInput") == null) {
                out.println("");
            } else {
                out.println("<h2>Pris på valgt Carport: </h2><br>");
                out.println("<p> Samlet Carport pris: " + (String)request.getAttribute("carportTotal") + "</p><br>");
                out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInput") + "</p><br>");
                out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInput") + "</p><br>");
                out.println("<p> Ønsket Højde: " + (Double) request.getAttribute("heightInput") + "</p><br>");
                //if (request.getAttribute("skurInput") != null) {
                   // out.println("<p> Skur: " + request.getAttribute("skurInput") + "</p><br>");
                //} else {
                    //out.println("<p> Skur: Fravalgt");
               // }
              //  out.println("<p> Trætype: " + request.getAttribute("trevalgInput") + "</p><br>");
            }%>

             
    
       
    
    
</body>



</html>
