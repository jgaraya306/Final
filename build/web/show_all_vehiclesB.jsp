<%-- 
    Document   : show_all_customers
    Created on : 12/05/2017, 09:14:32 PM
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de vehículos</title>
    </head>
    <body background="imagenes/7.jpg">


    <center>

        <i><b><font color="black" size="8">Lista de vehículos  en el Sistema </font></b></i>


        <br><br><br>
        <table border="2">
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Placa</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Marca</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Modelo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Tipo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Id del cliente</b></font> </td> <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${vehicles}" var="currentVehicle" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/> 
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentVehicle.plate}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentVehicle.brand}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.model}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.vehicleType}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.idCustomer}"/></font></td>
                    <td><font size="5"><a href="VehicleManagmentServlet.do?action=edit&idCustomer=<c:out value="${currentVehicle.idCustomer}"/>">Modificar</a></font>
                        <font size="5"><a href="VehicleManagmentServlet.do?action=delete&idCustomer=<c:out value="${currentVehicle.idCustomer}"/>">Eliminar</a></font></td>
                </tr>


            </c:forEach>


        </table>
        <br><br>    <font size="6"><a style="color:#0000FF" href="VehicleRetrievalServlet">Refrescar tabla</a></font>
        <br><br>    <font size="6"><a style="color:#0000FF" href="FuncionesDeDependiente.jsp">Cambiar de operacion</a></font>
        <br><br>    <font size="6"><a style="color:#0000FF" href="index.html" >Volver al menu principal</a></font>

    </center>



</body>
</html>  