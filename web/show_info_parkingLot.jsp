<%-- 
    Document   : show_info_customer
    Created on : 30/04/2017, 09:35:53 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos insertados</title>
        <%
            String name = request.getParameter("name");
            String ID = request.getParameter("ID");
            String ceiling = request.getParameter("ceiling");
           String parkingNumberOfSpaces = request.getParameter("parkingNumberOfSpaces");
            String numberOfSpaces = request.getParameter("spaces");
            String numberOfSpacesDisability = request.getParameter("spacesDisability");
           String motorcycle = request.getParameter("motorcycle");
           String heavyVehicle = request.getParameter("heavyvehicle");
            String vehicle = request.getParameter("vehicle");
           String bicycle= request.getParameter("bicycle");
            


        %>

    </head>
    <body>
        <h1>Los datos del parqueo ya han sido guardados:</h1>

        <br/>
        Nombre:  <%=name%> <br/><br/>
        Techo: <%=ceiling%><br/><br/>
        ID: <%=ID%><br/><br/>
        Cantidad de espacios: <%=numberOfSpaces%><br/><br/>
       Cantidad de espacios para personas con discapacidad:<%=numberOfSpacesDisability%><br/><br/>
        Cantidad de espacios para motocicleta: <%=motorcycle%><br/><br/>
        Cantidad de espacios para vehículo liviano: <%=vehicle%><br/><br/>
        Cantidad de espacios para vehículo pesado: <%=heavyVehicle%><br/><br/>
        Cantidad de espacios para bicicleta: <%=bicycle%><br/><br/>
        <hr/>

    </body>

</html>
