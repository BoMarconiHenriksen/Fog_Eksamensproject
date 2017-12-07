<%-- 
    Document   : ordre_liste
    Created on : 18-11-2017, 14:21:47
    Author     : Bo
--%>

<%@page import="Domain.User"%>
<%@page import="Business.LogicFacade"%>
<%@page import="Data.OrdreMapper"%>
<%@page import="Utillities.RendUtilOrderList"%>
<%@page import="Domain.Ordre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="WEB-INF/CSS.css" rel="stylesheet" type="text/css"/>
        <title>Ordre Liste</title>
    </head>
    <body>

        <% User user = (User) session.getAttribute("user");

                  if (user != null) {
                  out.println("Hej " + user.getFirstname() + "");
            }
             else{
                out.println("Hmm der står du hedder null der må være sket en fejl");
            }
                        
          
        %>
        
        <div>
            
            <% out.println(RendUtilOrderList.invoiceList( (List)request.getAttribute("invoiceList")));%>

        </div>
        


    </body>
</html>
