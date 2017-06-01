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
            <marquee  <b><font color="lightgreen" size="8">Autos suyos en el parqueo</font></b>
            </marquee>
        </i>
    <center>
        <table border="2">
            <td bgcolor="white" ><font size="5" color="#00009C"><b>ID del parqueo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>ID espacio</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacio preferencial?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tipo de vehiculo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Accion</b></font> </td>
            
            <c:forEach items="${listaEspacios}" var="currentSpace" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">
                    <td><font size="5"><c:out value="${currentSpace.idParking}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.id}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.disabilityAdaptation}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentSpace.vehicleType}"/></font></td>

                    <td><font size="5"><font size="5"><a href="RetireVehicleServlet?action=cancelReservation&id=<c:out value="${currentSpace.id}"/>&idParking=<c:out value="${currentSpace.idParking}"/>&idCustomer=<c:out value="${idCustomer}"/>">Retirar vehiculo</a></font></td>
                </tr>

            </c:forEach>
        </table>   

    </center>
    <br><br>
    <a href="loginCustomer.jsp">Salir</a>
</body>
</html>

