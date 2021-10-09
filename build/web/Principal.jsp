<%-- 
    Document   : Principal
    Created on : 2/10/2021, 05:16:29 PM
    Author     : estua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inicio</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light"
                        href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light"
                        href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light"
                        href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none;" class="btn btn-outline-light"
                        href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva venta</a>
                </li>
            </ul>
            <div class="dropdown">
                <button style="border: none;" class="btn btn-outline-light dropdown-toggle" type="button"
                    id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <p hidden id="userLogueado">${usuario.getNomb()}</p>
                    ${usuario.getNomb()}
                </button>
                <div class="dropdown-menu" style="margin-left: -50px;">
                    <a class="dropdown-item text-center" href="#"><img src="img/User.png" alt="60" width="60" /></a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">
                        <script>
                            let userLogueado = document.getElementById("userLogueado");
                            userLogueado = userLogueado.innerText;
                            userLogueado = userLogueado.split(' ');
                            let email = userLogueado[0].substring(0, 1) + userLogueado[1] + '@email.com';
                            document.write(email.toLowerCase());
                        </script>
                    </a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="post">
                        <button name="accion" value="salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height: 550px;">
        <iframe src="" name="myFrame" style="height: 100%; width: 100%; border: none;"></iframe>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
</body>

</html>