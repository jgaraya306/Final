<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fnt" uri="http://java.sun.com/jstl/fmt_rt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Administrador</title>

    </head>
    <body background="Images/background-image.gif">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de Administradores del Sistema </font></b>
            </marquee>
        </i>
    <center>

        <form name="modifyAdminForm" action="AdminManagementServlet.do" method="post">

            <table>
                <tr><h2>  Formulario de modificación de administrador </h2></tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> </td>
                    <td><input type="text" name="name" size="30" value="${admin.name}"></td>
                </tr>
                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Dirección: </label> </b></font></td>
                    <td><input type="text" name="address" size="30" value="${admin.address}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Username: </label> </b></font></td> 
                    <td><input type="text" name="username" size="30" value="${admin.username}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Password: </label> </b></font></td>
                    <td><input type="text" name="password" size="30" value="${admin.password}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar administrador"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
                </tr>
            </table>
        </form>
    </center>

</body>
</html>