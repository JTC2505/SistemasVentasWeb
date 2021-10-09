<%-- 
    Document   : Empleado
    Created on : 9/10/2021, 02:21:27 AM
    Author     : estua
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Empleado</title>
</head>

<body>
    <div class="d-flex">
        <div class="card col-sm-6">
            <div class="card-body">
                <form action="Controlador?menu=Empleado" method="POST">
                    <div class="form-group"><label for="">DNI</label><input type="text" value="${empleado.getDni()}" name="txtDni" id="txtDni"
                            class="form-control"></div>
                    <div class="form-group"><label for="">Nombres</label><input type="text" value="${empleado.getNomb()}" name="txtNombres"
                            id="txtNombres" class="form-control"></div>
                    <div class="form-group"><label for="">Teléfono</label><input type="text" value="${empleado.getTel()}" name="txtTel" id="txtTel"
                            class="form-control"></div>
                    <div class="form-group"><label for="">Estado</label><input type="text" value="${empleado.getEstado()}" name="txtEstado" id="txtEstado"
                            class="form-control"></div>
                    <div class="form-group"><label for="">Usuario</label><input type="text" value="${empleado.getUser()}" name="txtUsuario" id="txtUsuario"
                            class="form-control"></div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info" id="btnAgregar">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success" id="btnActualizar">
                    <!-- <input type="submit" name="cancelar" value="Cancelar" class="btn btn-danger" id="btnCancelarActualizacion" style="text-align: right; display: none;"> -->
                </form>
            </div>
        </div>
        <div class="col-sm-6">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>TELEFONO</th>
                        <th>ESTADO</th>
                        <th>USUARIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="em" items="${empleados}">
                        <tr>
                            <td>${em.getDni()}</td>
                            <td>${em.getNomb()}</td>
                            <td>${em.getTel()}</td>
                            <td>${em.getEstado()}</td>
                            <td>${em.getUser()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}" onclick="Editar()">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        function Editar() {
            document.getElementById('btnAgregar').style.display = 'none';
            document.getElementById('btnActualizar').style.display = 'block';
            document.getElementById('btnCancelarActualizacion').style.display = 'block';
        }
    </script>
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