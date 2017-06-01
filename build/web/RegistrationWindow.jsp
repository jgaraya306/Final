

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="CustomerInfoServlet">
  <body background="imagenes/7.jpg">
        <center>
            <h1>Ingrese sus datos para registrarse en el sistema</h1>
            <table>
                <tr>
                    <td>Ingrese su nombre:</td>
                    <td> <input type="text" name="name"> </td>
                </tr>  

                <tr>
                    <td>Ingrese su identificación:</td>
                    <td>   <input type="text" name="id"></td>
                </tr>  
                <tr>
                    <td>Ingrese su correo:</td>             
                    <td><input type="text" name="mail"></td>
                </tr>
                <tr>
                    <td>Ingrese un nombre de usuario:</td>                
                    <td><input type="text" name="username"></td>              
                </tr>
                <tr>
                    <td>Cree una contraseña:</td>               
                    <td><input type="text" name="password"></td>   
                </tr>
                <tr>
                    <td>Ingrese su numero de teléfono:</td>          
                    <td><input type="text" name="phone"></td>         
                </tr>
                <tr>
                    <td>Ingrese su dirección:</td>
                    <td><input type="text" name="address"></td>                 
                </tr>
                <tr>
                    <td>disabilityPresented:</td>
                    <td><input name="disabilityPresented" type="text">(Yes or Not)</input></td>
                </tr>
                <tr>
                    <td>Tiene más de 65 años:</td>
                    <td><input name="goldenCiticen" type="text">(Yes or Not)</input></td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Registrarse">
            <br><br>
            <font size="6"><a style="color:#2E2E2E" href="index.html">Regresar a la pantalla de inicio</a><font>
    </form>
</center>
</body>
</html>