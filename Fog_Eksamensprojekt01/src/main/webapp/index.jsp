<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Velkomst side</title>
    </head>
    <body>
        <h1>Velkommen til Fog Trælast</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="">
                        <br>
                        <button type="submit" name="login" value="Submit">Login </button>
                    </form>
                </td>
                
                <td>Eller Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" pattern=".{6,}" title="7 eller flere karakter">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" pattern=".{6,}" title="7 eller flere karakter">
                        <br>
                        Fornavn:<br>
                        <input type="text" name="firstname" value="Peter">
                        <br>
                        Efternavn:<br>
                        <input type="text" name="lastname" value="Jensen">
                        <br>
                        Addresse:<br>
                        <input type="text" name="addresse" value="Jensen">
                        <br>
                        Post Nummer (0001):<br>
                        <input type="text" name="postnummer" pattern="[0-9]{4}" title="4 Cifre" >
                        <br>
                        Telefon nummer <br>
                        <input type="number" name="telefonnummer" min="1" max="99999999999" >
                        <br>
                        <button type="submit" name="register" value="Submit">Opret Bruger </button>
                    </form>
                </td>
            </tr>
        </table>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>
