<%-- 
    Document   : show_all_customers
    Created on : May 16, 2017, 10:43:21 AM
    Author     : Allan 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de parqueos</title>
    </head>
    <body background="Images/background-image.gif">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de parqueos en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Identificación </b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacios preferenciales</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Techo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacios para moto</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacios para liviano</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Espacios para bici</b></font> </td>

            <c:forEach items="${parkingLots}" var="currentParkingLot" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentParkingLot.name}"/> </font> </td>



                    <td><font size="5"><a href="ParkingManagmentServlet.do?action=edit&parkingLotName=<c:out value="${currentParkingLot.name}"/>">Modificar</a></font>
                        <font size="5"><a href="ParkingManagmentServlet.do?action=delete&parkingLotName==<c:out value="${currentParkingLot.name}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>
        <br><br>
        <a href="index.html">Regresar al menú</a>
    </center>

</body>
</html>
