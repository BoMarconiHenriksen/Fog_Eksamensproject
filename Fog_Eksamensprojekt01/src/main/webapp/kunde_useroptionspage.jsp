<%-- 
    Document   : kunde_useroptionspage
    Created on : 06-12-2017, 15:11:32
    Author     : Ticondrus
--%>

<%@page import="Domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Din Konto</title>
    </head>
    <body>
        <h1>Hej: <%= (String) session.getAttribute("username")%> </h1>

        <h2>Dine konto oplysninger</h2>

        <p>Dit Fornavn: ${yourFirstname}</p><br>
        <p>Din Efternavn: ${yourLastname}</p><br>
        <p>Din Email: ${yourEmail}</p><br>
        <p>Din Adresse: ${yourAddress}</p><br>
        <p>Dit Postnummer: ${yourZipcode}</p><br>
        <p>Dit Telefonnummer: ${yourPhoneNr}</p><br>
        <p></p>

        <div>
            <form name="Customer_UserOptionsPasswordChange" action="FrontController" method="POST">
                <input type="hidden" name="command" value="Customer_UserOptionsPasswordChange">

                Intast nuværende Password: <input type="password" name="passwordOld" ><br>
                Ændre Password: <input type="password" name="passwordNew" ><br>
                <button type="submit" name="Customer_UserOptionsPasswordChange" value="Submit">Udfør Password ændring </button>
            </form>
        </div>
        
        <div>
 
           </div>             
        <button type="button"  onclick="location.href = 'Kundepage.jsp';" >Gå Tilbage til velkomstsiden</button>

    </body>
</html>
