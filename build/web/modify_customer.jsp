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
        <title>Modificar cliente</title>

    </head>
    <body   <body background="imagenes/7.jpg">

    <center>
        <i>
            <b><font color="black" size="8">Modificación de Clientes del Sistema </font></b>

        </i>

        <form name="modifyCustomerForm" action="CustomerManagementServlet.do" method="post">

            <table>
                <tr><h2>  Formulario de modificación de clientes </h2></tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Nombre: </label> </b></font> </td>
                    <td><input type="text" name="name" size="30" value="${customer.name}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Correo: </label> </b></font></td> 
                    <td><input type="text" name="email" size="30" value="${customer.email}"></td>  
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Teléfono: </label> </b></font></td>
                    <td><input type="text" name="phone" size="30" value="${customer.phone}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="black"><b> <label>Dirección: </label> </b></font></td>
                    <td><input type="text" name="address" size="30" value="${customer.address}"></td>             
                </tr>
                <tr>
                  
                    <td><input hidden="" type="text" name="username" size="30" value="${customer.username}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Password: </label> </b></font></td>
                    <td><input type="text" name="password" size="30" value="${customer.password}"></td>
                </tr>
                
                <tr>
                    <td><font size="5" color="black"><b> <label>Preferencia: </label> </b></font></td>
                    <td><input type="text" name="disabilityPresented" size="30" value="${customer.disabilityPresented}"></td>
                </tr>
                
                <tr>
                    <td><font size="5" color="black"><b> <label>Ciudadano de oro: </label> </b></font></td>
                    <td><input type="text" name="goldenCiticen" size="30" value="${customer.goldenCiticen}"></td>
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
