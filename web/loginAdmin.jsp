

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesion del administrador</title>
    </head>
    <form action="AdminLoginInfo" method="get">
        <center>
            <body background="imagenes/7.jpg">
                <h1>Inicio de sección del administrador</h1>
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" id="username"></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="text" name="password" id="password"></td>
                    </tr>
                </table>
                <br/>        
                <input type="submit" value="Comprobar cuenta">
                <input type="reset" value="Cancelar">
            </body>
        </center>
    </form>
    <hr/>
    <font size="5"><a style="color:#2E2E2E" href="RegistrationWindowAdmin.jsp">Registrar nuevo administrador</a>
    <br/><br>
    <a style="color:#2E2E2E" href="index.html">Regresar a la pantalla de inicio</a></font>
</html>