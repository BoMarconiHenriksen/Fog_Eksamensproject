<%-- 
    Document   : index.jsp
    Created on : 09-11-2017, 12:08:28
    Author     : Ticondrus
--%>


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
        <h1>Hello World!</h1>


        Her testes om der er hul igennem gennem frontcontroller- command - commandoen getAllMaterials 
        - logicfacade - datamapper - database og det er der :-)den skal fjernes igen

        Der udskrives blot et materiale fra databasen ikke interessant men det virker

        <form name="basisCarport" action="FrontController" method="POST">
            <input type="hidden" name="command" value="basisCarport">




            <br><br>
            <%-- <form name="Form1" action="IndexController" method="POST">--%>

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
            <input type="number" name="height"min="225" ><br><br>
            Skur<br>
            <input type="checkbox" name="skur">
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
            <input type="submit" name="basisCarport" value="Submit">
        </form>

        <h2>Pris på valgt Carport: </h2><br>
        <%if ("basisCarport" == null) {
                out.println("...");
            } else {

                out.println("<p> Samlet Carport pris: " + (Double) request.getAttribute("carportTotal") + "</p><br>");

                out.println("<p> Ønsket Længde: " + (Double) request.getAttribute("lentghInput") + "</p><br>");
                out.println("<p> Ønsket Bredde: " + (Double) request.getAttribute("widthInput") + "</p><br>");
                out.println("<p> Ønsket Højde: " + (Double) request.getAttribute("heightInput") + "</p><br>");
            }%>


    </body>



</html>
