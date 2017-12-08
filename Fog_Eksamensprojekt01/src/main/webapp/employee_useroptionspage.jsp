<%-- 
    Document   : employee_useroptionspage
    Created on : 07-12-2017, 12:39:49
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
            <form name="Employee_UserOptionsPasswordChange" action="FrontController" method="POST">
                <input type="hidden" name="command" value="Employee_UserOptionsPasswordChange">

                Intast nuværende Password: <input type="password" name="passwordOld" ><br>
                Ændre Password: <input type="password" name="passwordNew" ><br>
                <button type="submit" name="Employee_UserOptionsPasswordChange" value="Submit">Udfør Password ændring </button>
            </form>
        </div>
        
        <div>
 
           </div>             
        <button type="button"  onclick="location.href = 'employeepage.jsp';" >Gå Tilbage til hovedmenuen</button>

    </body>
</html>