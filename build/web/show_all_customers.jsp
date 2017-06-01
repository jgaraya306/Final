<%-- 
    Document   : show_all_customers
    Created on : Apr 26, 2017, 5:43:21 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de clientes</title>
    </head>
    <body background="imagenes/7.jpg">



    <center>
        <i>
            <b><font color=#2E2E2E size="8">Lista de Clientes en el Sistema </font></b>

        </i>

        <br><br><br>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre del cliente</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Correo electrónico</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Teléfono</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Dirección</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Contraseña</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Discapacidad?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Adulto mayor?</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${customers}" var="currentCustomer" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentCustomer.name}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentCustomer.email}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.phone}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.address}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.username}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.password}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.disabilityPresented? 'Si' : 'No'}"/></font></td>
                    <td><font size="5"><c:out value="${currentCustomer.goldenCiticen? 'Si' : 'No'}"/></font></td>

                    <td><font size="5"><a href="CustomerManagementServlet.do?action=edit&customerUsername=<c:out value="${currentCustomer.username}"/>">Modificar</a></font>
                        <font size="5"><a href="CustomerManagementServlet.do?action=delete&customerUsername=<c:out value="${currentCustomer.username}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>
        <br><br>
        <font size="7"><a style="color:#2E2E2E" href="index.html ">Salir</a></font>
    </center>

</body>
</html>
