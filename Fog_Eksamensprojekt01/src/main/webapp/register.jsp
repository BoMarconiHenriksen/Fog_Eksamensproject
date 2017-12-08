<%-- 
    Document   : register
    Created on : 07-12-2017, 16:20:16
    Author     : Ejer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrering</title>
    </head>
    <body>
       
        
        
        
        
       <div class="bg-faded p-4 my-4">
            <div class="text-center mt-4">
                <h2 class="text-left text-lg text-uppercase my-0">
                    Fyld formen ud hvis du er ny kunde
                </h2>
                <table>     

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

                </table>
            </div>
        </div>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
