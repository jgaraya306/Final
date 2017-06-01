<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="ClerkInfoServlet">
         <body background="imagenes/7.jpg">
        <center>
            <h1>Ingrese sus datos para registrarse en el sistema</h1>
            <table>
                <tr>
                    <td>
                        Ingrese su nombre:
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>


                <tr>
                    <td>
                        Ingrese su identificación:
                    </td>
                    <td>
                        <input type="text" name="id">
                    </td>

                </tr>
                <tr>
                    <td>
                        Cree su nombre de usuario:
                    </td>
                    <td>
                        <input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cree una contraseña:
                    </td>
                    <td>
                        <input type="text" name="password">
                    </td>
                </tr>

                <tr>
                    <td>
                        Ingrese su dirección:
                    </td>
                    <td>
                        <input type="text" name="address">
                    </td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Registrarse">
            <br><br>
            <a href="index.html">Regresar a la pantalla de inicio</a>
    </form>
</center>
</body>
</html>