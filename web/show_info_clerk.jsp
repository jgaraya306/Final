<%-- 
    Document   : show_info_customer
    Created on : 30/04/2017, 09:35:53 AM
    Author     : Julio
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
         
            
        %>

    </head>
    <body background="imagenes/4.jpg">
        <center>
        <h1>Sus datos ya han sido guardados:</h1>
        
        <br/>
        Nombre:  <%=name%> <br/><br/>
        Dirección: <%=address%><br/><br/>
        Usuario: <%=username%><br/><br/>
        Password: <%=password%><br/><br/>
       
        <hr/>
        <a href="FuncionesDeDependiente.jsp">Empezar a laborar</a><br><br>
        <a href="index.html">Regresar a la pantalla de inicio</a>
        </center>
    </body>
    
</html>
