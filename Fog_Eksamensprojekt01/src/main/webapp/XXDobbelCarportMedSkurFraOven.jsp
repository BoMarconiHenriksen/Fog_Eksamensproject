<%-- 
    Document   : DobbelCarportMedSkurFraOven
    Created on : 20-11-2017, 13:11:10
    Author     : BenedikteEva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DobbelCarportMedSkurFraOven</title>
    </head>
    <body>
        <h1>Dobbel Carport med skur fra oven</h1>

        <SVG width="75%"  

             <svg x="200" y="0" width="<%=780%>" height="<%=600%>" 
             viewBox="0 0 <%=780 + 200%> <%=600 + 200%>"
             viewBox="0 0 780 600">

        <svg x="200" y="0" width="<%=780%>" height="<%=600%>" 
             viewBox="0 0 <%=780 + 1%> <%=600 + 1%>">


        rammen
        <rect x="0" y="0" height="600" width="780"
              style="stroke:#000000; fill: #ffffff"/>
        ydre spær
        <rect x="0" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="776" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        remme
        <rect x="0" y="30" height="2.5" width="780"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="0" y="570" height="2.5" width="780"
              style="stroke:#000000; fill: #ffffff"/>
        indre spær
        <rect x="55" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="110" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="165" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="220" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="275" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="330" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="385" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="440" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="495" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="550" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="605" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="660" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>
        <rect x="715" y="0" height="600" width="2.5"
              style="stroke:#000000; fill: #ffffff"/>

        Skur

        <rect x="550" y="30" height="540" width="2.5"
              style="stroke:#000000; fill: #gg0000;  opacity: 0.2"/>
        <rect x="550" y="30" height="540" width="200"
              style="stroke:#000000; fill: #gg0000;  opacity: 0.2"/>
        <rect x="747" y="30" height="540" width="2.5"
              style="stroke:#000000; fill: #gg0000;  opacity: 0.2"/>

        Stolper
        <rect x="105" y="28" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="475" y="28" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="105" y="568" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="475" y="568" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="550" y="568" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="745" y="568" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="550" y="28" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="745" y="28" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="550" y="300" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>
        <rect x="745" y="300" height="9.7" width="9.7"
              style="stroke:#000000; fill: #000000;  opacity: 0.6"/>

        Hulbånd
        <line x1="53"x2="548" y1="30" y2="570" width="10"
              stroke-dasharray="10,10"
              style="stroke:#000000;   opacity: 0.6 "/>

        <line x1="56"x2="552" y1="570" y2="30" width="10"
              stroke-dasharray="10,10"
              style="stroke:#000000; opacity: 0.6 "/>  

        <line x1="53"x2="548" y1="570" y2="30" width="10"
              stroke-dasharray="10,10"
              style="stroke:#000000; opacity: 0.6 "/>

        <line x1="56"x2="552" y1="30" y2="570" width="10"
              stroke-dasharray="10,10"
              style="stroke:#000000;   opacity: 0.6 "/>
       
        </svg>
        Pile og tekst
        <defs>
    <marker id="beginArrow" 
            markerWidth="18" markerHeight="18" 
            refX="0" refY="9" 
            orient="auto">
        <path d="M0,9 L16,0 L16,16 L0,9" style="fill: #000000;" />

    </marker>
    <marker id="endArrow" 
            markerWidth="18" markerHeight="18" 
            refX="18" refY="9" 
            orient="auto">
        <path d="M0,0 L16,9 L0,16 L0,0" style="fill: #000000;" />
    </marker>
    </defs>

    <!-- Vertical line -->
    <line x1="100"  y1="0" x2="100" y2="<%=600%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="140" y="<%=600 / 2%>"
          font-size="40px"
          text-anchor="middle"
          style="writing-mode: tb;">Height: <%=600%></text>
    <!-- Horizontal line %-->
    <line x1="200"  y1="<%=600 + 100%>" x2="<%=780 + 200%>"   y2="<%=600 + 100%>" 
          style="stroke:#006600;
          marker-start: url(#beginArrow);
          marker-end: url(#endArrow);"/>
    <text x="<%=780 / 2 + 200%>" y="<%=600 + 80%>"
          font-size="40px"
          text-anchor="middle">Width: <%=780%></text>
    </svg>

   

    </SVG> 

</body>
</html>
