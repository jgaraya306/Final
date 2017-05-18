<%-- 
    Document   : show_all_clerks
    Created on : Apr 26, 2017, 5:43:21 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de trabajadores</title>
    </head>
    <body background="Images/background-image.gif">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de los trabajadores en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre del trabajador</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Dirección</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Contraseña</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <d:forEach items="${clerks}" var="currentClerk" varStatus="counter">
                <d:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><d:out value="${currentClerk.name}"/> </font> </td>
                    <td><font size="5"><d:out value="${currentClerk.address}"/></font></td>
                    <td><font size="5"><d:out value="${currentClerk.username}"/></font></td>
                    <td><font size="5"><d:out value="${currentClerk.password}"/></font></td>

                    <td><font size="5"><a href="ClerkManagementServlet?action=edit&clerkUsername=<d:out value="${currentClerk.username}"/>">Modificar</a></font>
                        <font size="5"><a href="ClerkManagementServlet?action=delete&clerkUsername=<d:out value="${currentClerk.username}"/>">Eliminar</a></font></td>
                </tr>

            </d:forEach>


        </table>
        <br><br>
        <a href="index.html">Regresar al menú</a><br><br>
        <a href="ClerkManagementServlet.do?action=edit&clerkUsername=<d:out value="${currentClerk.username}"/>">Modificar</a>
        <a href="ClerkManagementServlet.do?action=delete&clerkUsername=<d:out value="${currentClerk.username}"/>">Eliminar</a>


</center>

</body>
</html>
