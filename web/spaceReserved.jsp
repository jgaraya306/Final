<%-- 
    Document   : spaceReserved
    Created on : 29-may-2017, 12:23:16
    Author     : Allan
--%>

<%@page import="Data.ParkingLotData"%>
<%@page import="Domain.ParkingLot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <%
        ParkingLotData parkingLotData = new ParkingLotData();
        int idParking = Integer.parseInt(request.getParameter("idParking"));
        int id = Integer.parseInt(request.getParameter("id"));
        System.err.println("perro "+idParking);
        ParkingLot parking = new ParkingLot();
        parking = parkingLotData.getParkingLotById(""+idParking);
        
        String idParkingLot = ""+parking.getId();
        String name = parking.getName();
        String cieling = ""+parking.isCeiling();
        //String numberOfSpacesDisability = request.getParameter("spacesDisability");

    %>


    <body background="imagenes/7.jpg">
        <center>
        <h1>Se ha seleccionado su espacio en el parqueo:</h1>

        <br/>
        Id del parqueo:  <%=idParkingLot%> <br/><br/>
        Numero de espacio:  <%=id%> <br/><br/>
        Nombre del parqueo: <%=name%><br/><br/>
        ¿Tiene techo? <%=cieling%><br/><br/>


        <hr/>
        <a href="index.html">Finalizar</a>
        </center>
    </body>
</html>
