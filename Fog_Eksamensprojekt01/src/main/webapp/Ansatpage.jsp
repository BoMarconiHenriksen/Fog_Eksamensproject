<%-- 
    Document   : Ansatpage
    Created on : 07-12-2017, 12:19:03
    Author     : Ticondrus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Fog Trælast - Hovedsiden for medarbejder</title>
    </head>
    <body>
        <h1>Hovedmenuen for medarbejdere</h1>
       <h2>Hej <%= (String) session.getAttribute("username")%></h2>
        
        
        
        
        <form name="OrdreList" action="FrontController" method="POST">
        <input type="hidden" name="command" value="OrdreList">
        
        <button type="submit" name="OrdreList" value="Submit">Se og administrer kundernes ordre </button>
        
        </form>
        
        <div>
        <form name="Employee_UserOptions" action="FrontController" method="POST">
            <input type="hidden" name="command" value="Employee_UserOptions">
            
            <button type="submit" name="Employee_UserOptions" value="Submit">Se eller ret dine kontooplysninger </button>
        </form>
            
            <form class="form-inline" name="LogOut" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <div class="form-group">
                <button type="submit" onclick="javascript:return show_confirmLogOff();" name="logout" value="Submit" class="w3-bar-item w3-button"><a>Log af </a></button>
            </div>
        </form>
    </body>
</html>
