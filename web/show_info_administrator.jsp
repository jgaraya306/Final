<%-- 
    Document   : show_info_administrator
    Created on : 12/05/2017, 10:22:18 AM
    Author     : juang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos insertados</title>
        <%
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String schedule = request.getParameter("schedule");
            String ID = request.getParameter("identification");

        %>
    </head>
    <body>
            <center>
        <h1>Sus datos ya han sido guardados:</h1>
        <br/>
        Nombre:  <%=name%> <br/><br/>
        Dirección: <%=address%><br/><br/>
        Usuario: <%=username%><br/><br/>
        Password: <%=password%><br/><br/>
        Phone: <%=schedule%><br/><br/>
        Identifiacion <%=ID%><br/><br/>
        <hr/>  
        <a href="ReservarEspacio.jsp">Reservar su espacio en el parqueo</a><br><br>
        <a href="index.html">Regresar a la pantalla de inicio</a>
            </center>
    </body>
</html>
