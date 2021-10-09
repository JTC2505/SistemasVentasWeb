<%-- 
    Document   : RegistrarVenta
    Created on : 9/10/2021, 02:20:57 AM
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
    <title>Registrar Venta</title>
</head>

<body>
    <div class="d-flex">
        <div class="col-sm-4">
            <div class="card">
                <form action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="">Datos del cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoCliente" id="codigoCliente" class="form-control" value="${c.getDni()}"
                                    placeholder="Codigo">
                                <input type="submit" value="BuscarCliente" name="accion" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombresCliente" id="nombresCliente" class="form-control" value="${c.getNomb()}"
                                    placeholder="Datos cliente">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Datos producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoProducto" id="codigoProducto" class="form-control"
                                    placeholder="Codigo">
                                <input type="submit" value="Buscar" name="accion" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombresProducto" id="nombresProducto" class="form-control"
                                    placeholder="Datos producto">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4 d-flex">
                                <input type="text" name="precio" id="precio" class="form-control" placeholder="Q. 0.00">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" id="cant" class="form-control" placeholder="Cant. ">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" id="stock" class="form-control" placeholder="Stock">
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Agregar" name="accion" class="btn btn-outline-info">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex col-sm-5  ml-auto">
                        <label for="">No. Serie</label>
                        <input type="text" name="NroSerie" id="NroSerie" class="form-control">
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nro</th>
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                                <th></th>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer">
                    <div>
                        <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                        <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-8">

    </div>
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