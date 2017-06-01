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
    <body background="imagenes/7.jpg">



        <br><br><br>

    <center>
        <i>
            <b><font color="black" size="8">Lista de parqueos en el Sistema </font></b>

        </i>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>ID parqueo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Cantidad de espacios</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Techo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Accion</b></font> </td>

            <c:forEach items="${parkingLots}" var="currentParkingLot" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentParkingLot.name}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentParkingLot.id}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentParkingLot.numberOfSpaces}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentParkingLot.ceiling? 'Si':'No'}"/> </font> </td>


                    <td><font size="5"><a href="ParkingManagmentServlet.do?action=edit&parkingLotName=<c:out value="${currentParkingLot.name}"/>">Modificar</a>
                        <a href="ParkingManagmentServlet.do?action=delete&parkingLotName=<c:out value="${currentParkingLot.name}"/>">Eliminar</a>
                        <a href="SpaceRetrievalServlet?idParking=<c:out value="${currentParkingLot.id}"/>">Ver espacios</a></font></td>
                </tr>

            </c:forEach>


        </table>
        <br><br>
        <font size="5"><a style="color:#424242" href="FuncionesDeAdministrador.jsp">Cambiar de operacion</a>
        <br><br>
        <a style="color:#424242" href="insert_parkingLot.jsp">Insertar un parqueo</a>
        <br><br>
        <a style="color:#424242" href="index.html">Regresar al menú</a></font>
    </center>

</body>
</html>
