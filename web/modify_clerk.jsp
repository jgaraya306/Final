<%-- 
    Document   : modify_customer
    Created on : May 1, 2017, 4:54:16 PM
    Author     : Julio
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar trabajador</title>

    </head>
    <body background="Images/background-image.gif">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de los trabajadores del Sistema </font></b>
            </marquee>
        </i>
    <center>

        <form name="modifyCustomerForm" action="ClerkManagementServlet" method="post">

            <table>
                <tr><h2>  Formulario de modificación de trabajadores </h2></tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> </td>
                    <td><input type="text" name="name" size="30" value="${clerk.name}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Dirección: </label> </b></font></td>
                    <td><input type="text" name="address" size="30" value="${clerk.address}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Username: </label> </b></font></td> 
                    <td><input type="text" name="username" size="30" value="${clerk.username}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Password: </label> </b></font></td>
                    <td><input type="text" name="password" size="30" value="${clerk.password}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar cliente"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
                </tr>
            </table>
        </form>
    </center>

</body>
</html>
