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
        <input type="number" name="length" min="240" ><br>
        Carport Bredde:<br>
        <input type="number" name="width" min="240"><br><br>
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
         
        
        <%if ("basisCarport"==null){
            out.println("");
        }
            else {
            %> <h2>Pris på valgt Carport: </h2><br><%
             out.println("<a>"+(Double)request.getAttribute("carportTotal")+"</a>");
            }%>
        
        
 </body>
   
    

</html>
