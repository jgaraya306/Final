<%-- 
    Document   : loginUsuario
    Created on : 30-abr-2017, 11:17:32
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="CustomerLoginInfo" method="get">
        <body background="imagenes/7.jpg">
        <center>
            <h1>Inicio de sesión de usuario</h1>
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" id="username"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="password" id="password"> </td>                 
                </tr>
            </table>

            <br/>        
            <input type="submit" value="Comprobar cuenta">
            </form>

            </form>
            </center>
                <hr/>
                <font size="5"><a style="color:#424242" href="RegistrationWindow.jsp">Registrarse</a>
                <br><br>
                <a style="color:#424242" href="index.html">Regresar a la pantalla de inicio</a></font>
                </body>
                </html>
