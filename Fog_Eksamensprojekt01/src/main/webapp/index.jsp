<%-- 
    Document   : index.jsp
    Created on : 09-11-2017, 12:08:28
    Author     : Ticondrus
--%>

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
    
   <form action="IndexController" method="POST">
  Længde:<br>
  <input type="text" name="lentgh" value=""><br>
  Brede:<br>
  <input type="text" name="width" value=""><br><br>
   Height:<br>
  <input type="text" name="height" value=""><br><br>
  <input type="submit" value="Submit">
</form>
</html>
