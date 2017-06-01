<%-- 
    Document   : show_all_tariffs
    Created on : 20-may-2017, 9:56:11
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de tarifas</title>
    </head>
    <body background="imagenes/7.jpg">


        <br><br><br>
    <center>
        <i>
            <b><font color="black" size="8">Lista de Tarifas en el Sistema </font></b>
        </i>
        <table border="2">
            
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Numero de tarifa</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tipo de vehiculo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa media hora</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa una hora</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa por dia</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa por semana</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa por mes</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tarifa por año</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${tariffs}" var="currentTariff" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">
                    
                    <td><font size="5"><c:out value="${currentTariff.id}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentTariff.vehicleType}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentTariff.priceHalfHour}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentTariff.priceOneHour}"/></font></td>
                    <td><font size="5"><c:out value="${currentTariff.pricePerDay}"/></font></td>
                    <td><font size="5"><c:out value="${currentTariff.pricePerWeek}"/></font></td>
                    <td><font size="5"><c:out value="${currentTariff.pricePerMonth}"/></font></td>
                    <td><font size="5"><c:out value="${currentTariff.pricePerYear}"/></font></td>

                    <td><font size="5"><a href="TarifaManagementServlet.do?action=edit&id=<c:out value="${currentTariff.id}"/>">Modificar</a></font>
                        <font size="5"><a href="TarifaManagementServlet.do?action=delete&id=<c:out value="${currentTariff.id}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>
        <br><br>
        <font size="5"><a style="color:#0080FF" href="FuncionesDeAdministrador.jsp">Cambiar de operacion</a>
        <br><br>
        <a style="color:#0080FF" href="insert_tariff.jsp">Insertar una tarifa</a>
        <br><br>
        <a style="color:#0080FF" href="index.html">Regresar al menú</a></font>
    </center>

</body>
</html>

