<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sistema de Parqueos</title>
<style>
    #navigation {
        list-style: none;
        font-family: "Century Gothic", Verdana, Arial, Sans-Serif;
        margin: 30;
        padding: 67;
        font-size: 1.2em;
    }


    #navigation li
    {
        clear: both;
        height: 2em;
    }

    #navigation li a
    {
        float: left;
        display: block;
        background-color:#000;
        padding: 4px;
        text-decoration: none;
        color:#fff;  /* Color de las letras*/ 
      
        margin-bottom: 5px;
        margin-right: 10px;
    }


    #navigation li:hover a,
    #navigation li a:hover
    {
        background: #999;
        color: #1C1C1C;  
    }

    #navigation ul {display: none;}

    /* Each Child Item will be visible if mouse hover */
    #navigation li:hover ul {display: block;}

    #navigation ul
    {
        list-style: none;
        float: left;
        margin: 0;
        padding: 4px 7px;
    }

    #navigation ul li
    {
        float: left;
        clear: none;
        margin: 0;
        padding: 0;
        width: auto;
        height: auto;
        color:#1C1C1C;
    }

    /* Reset and re style link of each child item */
    #navigation li:hover ul li a,
    #navigation ul li a
    {
        display: inline;
        padding: 0 6px 0 0;
        float: none;
        text-transform: lowercase;
        color: #1C1C1C;
        background: none;
    }

    #navigation li:hover ul li a:hover,
    #navigation ul li a:hover
    {
        background: none;
        color: #000;
    </style>
    <body background="imagenes/7.jpg">
  <h1>Funciones de Administrador</h1>
        <ul id="navigation">

            <li class=""> <a href="#">Opciones para vehículo</a>
                <ul>
                    <li><a href="VehicleRetrievalServlet">Consultar vehículo</a></li>
                    <li><a href="insertVehicle.jsp">Ingresar vehículos</a></li></ul>


            <li class=""> <a href="#">Opciones para empleado</a>
                <ul>
                    <li class=""> <a  href="ClerkRetrievalServlet">Consultar empleados</a></li>
                    <li class=""><a href="RegistrationWindowClerk.jsp">Ingresar empleados</a></li></ul></li>


            <li class=""> <a href="#">Opciones para cliente</a>
                <ul>
                    <li class=""> <a href="CustomerRetrievalServlet">Consultar clientes</a> </li>
                    <li class=""> <a href="RegistrationWindow.jsp">Ingresar clientes</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones para administrador</a>
                <ul>
                    <li class=""> <a href="AdminRetrievelServlet">Consultar administradores</a> </li>
                    <li class=""> <a href="RegistrationWindowAdmin.jsp">Ingresar adminsitradores</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones para tarifas</a>
                <ul>
                    <li class=""> <a href="TarifaRetrievalServlet">Consultar tarifas</a> </li>
                    <li class=""> <a href="insert_tariff.jsp">Insertar tarifas</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones para las reservaciones</a>
                <ul>
                    <li class=""> <a href="ReservarEspacio.jsp">Consultar reservaciones</a> </li>
                    <li class=""> <a href="ReservarEspacio.jsp">Cancelar reseravaciones</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones para parqueo</a>
                <ul>
                    <li class=""> <a href="ParkingRetrievalServlet">Consultar parqueos</a> </li>
                    <li class=""> <a href="insert_parkingLot.jsp">Agregar parqueos</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones de faturación</a>
                <ul>
                    <li class=""> <a href="ReservarEspacio.jsp">Cobrar servicio</a> </li>
                    <li class=""> <a href="#">Cancelar factura</a> </li>
                </ul>
            </li>
            <li class=""> <a href="#">Opciones de impresion PDF</a>
                <ul>
                    <li class=""> <a href="EmailServlet">Imprimir customers</a> </li>
                    
                </ul>
            </li>