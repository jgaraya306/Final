<%-- 
    Document   : insertAdmin
    Created on : 15/05/2017, 07:48:12 PM
    Author     : juang
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Administrador</title>
    </head>
    <body>
        <i>
            <marquee  <b><font color="lightgreen" size="8">Ingreso de Administrador al Sistema </font></b>
            </marquee>
        </i>
    <center>
        <form action="AdminInfoServlet" method="get">
AdminInfoServlet
            <table>
                <tr>
                <h2>  Formulario de ingreso de administradores </h2>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="name" size="30">

                    </td>

                </tr>
                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Dirección: </label> </b></font> 


                    </td>

                    <td>

                        <input type="text" name="address" size="30">

                    </td>

                </tr>
                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Username: </label> </b></font> 


                    </td>

                    <td>

                        <input type="text" name="username" size="30">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Password: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="password" size="30">

                    </td>

                </tr>

                <tr>

                    <td>

                        <input type="submit" value="Guardar"/>

                    </td>

                    <td>

                        <input type="reset" value="Cancelar" />

                    </td>

                </tr>

            </table>
        </form>
    </center>

</body>
</html>
