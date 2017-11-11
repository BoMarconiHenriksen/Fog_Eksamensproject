<%-- 
    Document   : index.jsp
    Created on : 09-11-2017, 12:08:28
    Author     : Ticondrus
--%>


<%@page import="Domain.Materiale"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>

    <form name="Form1" action="IndexController" method="POST">
        Carport Længde:<br>
        <input type="number" name="lentgh" ><br>
        Carport Bredde:<br>
        <input type="number" name="width" ><br><br>
       Carport Højde:<br>
        <input type="number" name="height" ><br><br>
    Tagtype:<br>
   <ul>
  <select name="kundetrevalg">
  <option value="trykimpo">Trykimp.</option>
  <option value="reguler">Regulær</option>
</select>
</ul>

        <input type="submit" value="Submit">






    </form>
    
    

</html>
