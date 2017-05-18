

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Administrador</title>
    </head>
    <form action="AdminInfoServlet">
        <center>
            <body background="imagenes/4.jpg">
                <h1>Ingrese sus datos para registrarse en el sistema</h1>
                <table>
                    <tr>
                        <td>Ingrese su Nombre:</td>
                        <td><input type="text" name="name"></td>          
                    </tr>
                    <tr>
                        <td>Ingrese su Identificación:</td>
                        <td><input type="text" name="id">  </td>        
                    </tr>
                    <tr>
                        <td>Cree una contraseña:</td> 
                        <td><input type="text" name="password"></td>
                    </tr>
                    <tr>
                        <td>Ingrese su Username:</td>
                        <td><input type="text" name="username"></td>                
                    </tr>
                    <tr>
                        <td>Ingrese su dirección:</td>         
                        <td><input type="text" name="address"></td>      
                    </tr>
                </table>
                <br/>
                <input type="submit" value="Registrarse">

                <input type="reset" value="Cancelar">
                </form>
            </body>
        </center>
</html>
