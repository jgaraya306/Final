<%-- 
    Document   : customersOptions
    Created on : 29-may-2017, 12:12:55
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/7.jpg">
    <center>
        <br><br>   <br><br>   <br><br>   <br><br>   <br><br>
        <a href="ReservarEspacio.jsp">Reservar espacio en el parqueo</a><br><br>       
        <a href="RetireVehicleServlet?action=showVehiclesOfUser&customerUsername=<c:out value="${username}"/>">Retirar el vehículo</a><br><br> 

    </center>
</body>
</html>
