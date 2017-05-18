

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesion de dependiente</title>
    </head>
    <form action="ClerkLoginInfo" method="get">
        <body background="imagenes/4.jpg">
        <center>
            <h1>Inicio de sección del dependiente</h1>
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
            <input type="submit" value="Comprobar cuenta"><br>

        </center>
    </body>
</form>
<hr/>

<br><br>
<a href="index.html">Regresar a la pantalla de inicio</a>
<br><br>


</html>