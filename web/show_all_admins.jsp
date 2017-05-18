<%-- 
    Document   : show_all_admins
    Created on : 15/05/2017, 08:08:13 PM
    Author     : juang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de administradores</title>
    </head>
    <body background="Images/background-image.gif">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de Administradores en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre del Administrador</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Dirección</b></font> </td>
                <td bgcolor="white" ><font size="5" color="#00009C"><b>Identificacion</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${admins}" var="currentAdministrator" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentAdministrator.name}"/> </font> </td>
                     <td><font size="5"><c:out value="${currentAdministrator.address}"/></font></td>
                    <td><font size="5"><c:out value="${currentAdministrator.email}"/></font></td>           
                    <td><font size="5"><c:out value="${currentAdministrator.username}"/></font></td>

                    <td><font size="5"><a href="AdminManagementServlet.do?action=edit&adminUsername=<c:out value="${currentAdministrator.username}"/>">Modificar</a></font>
                        <font size="5"><a href="AdminManagementServlet.do?action=delete&customerUsername=<c:out value="${currentAdministrator.username}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>
        <br><br>
        <a href="index.html">Regresar al menú</a>
    </center>

</body>
</html>

