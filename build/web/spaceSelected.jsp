<%-- 
    Document   : insert_tariff
    Created on : 20-may-2017, 10:37:29
    Author     : Allan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar tarifa</title>
    </head>
    <body background="imagenes/7.jpg">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Espacios del parqueo</font></b>
            </marquee>
        </i>
    <center>
        <table border="2">
            <td bgcolor="white" ><font size="5" color="#00009C"><b>ID del parqueo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>ID espacio</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacio preferencial?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacio ocupado?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tipo de vehiculo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Accion</b></font> </td>
            
            <c:forEach items="${listaEspacios}" var="currentSpace" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                              
                <tr bgcolor= "${color}">
                    <td><font size="5"><c:out value="${currentSpace.idParking}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.id}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.disabilityAdaptation?'Si':'No'}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.spaceTaken?'Si':'No'}"/></font></td>
                    <td><font size="5"><c:out value="${currentSpace.vehicleType}"/></font></td>

                    <td><font size="5"><a href="ReservationSpaceServlet?action=reservation&id=<c:out value="${currentSpace.id}"/>&idParking=<c:out value="${currentSpace.idParking}"/>&vehicleType=<c:out value="${vehicleType}"/>&idCustomer=<c:out value="${customerID}"/>">Reservar aquí</a></font>
                        <font size="5"><a href="ReservationSpaceServlet?action=cancelReservation&id=<c:out value="${currentSpace.id}"/>&idParking=<c:out value="${currentSpace.idParking}"/>&vehicleType=<c:out value="${vehicleType}"/>&idCustomer=<c:out value="${customerID}"/>">Cancelar</a></font></td>
                </tr>
                
            </c:forEach>

        </table>   


    </center>
    <br><br>
    <a href="index.html">Salir</a>
</body>
</html>

