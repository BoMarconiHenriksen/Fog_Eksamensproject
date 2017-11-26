<%-- 
    Document   : stykListe
    Created on : 11-11-2017, 22:10:01
    Author     : BenedikteEva
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Business.Calculator"%>
<%@page import="Business.LogicFacade"%>
<%@page import="Utillities.XXRendUtilStykListe"%>
<%@page import="Utillities.XXRendSvg"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="Domain.LineItem"%>
<%@page import="java.util.List"%>
<%@page import="Domain.Materiale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>StykListe</title>
    </head>
    
        <h1>Pris</h1>
        <br>
        
        <%Calculator calc = new Calculator(); DecimalFormat df = new DecimalFormat("#0.00");%>
        <p>
            <%=df.format(calc.calculateCarportSimple(600/100,300/100,225/100))%>
       </p>
        <br><br>
          <%XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(lentgh, width, skurlength, skurwidth); %>
       
          <p>
       <%=carportTegning%>
        
           </p>
      <br><br>
    
      <p>
      <% XXRendUtilStykListe rusl= new XXRendUtilStykListe();%>
    <%=rusl.getStykListeBaseSimpel(600,300)%>
    
     </p>
      
        
        
      
       <%--=(String)(request.getAttribute("carportTegning"))--%>
   <!-- Horizontal line %-->
            
        </SVG>
      
   




    
</html>
