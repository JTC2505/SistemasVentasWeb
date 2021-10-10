/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;

/**
 *
 * @author estua
 */
public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cli = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto pr = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    Venta v = new Venta();
    List < Venta > lista = new ArrayList < > ();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalPagar;
    String numeroserie;
    VentaDAO vdao = new VentaDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNomb(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniUpdate = request.getParameter("txtDni");
                    String nomUpdate = request.getParameter("txtNombres");
                    String telUpdate = request.getParameter("txtTel");
                    String estUpdate = request.getParameter("txtEstado");
                    String userUpdate = request.getParameter("txtUsuario");
                    em.setDni(dniUpdate);
                    em.setNomb(nomUpdate);
                    em.setTel(telUpdate);
                    em.setEstado(estUpdate);
                    em.setUser(userUpdate);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaClientes = cdao.listar();
                    request.setAttribute("clientes", listaClientes);
                    break;
                case "Agregar":
                    String dniClientes = request.getParameter("txtDni");
                    String nomClientes = request.getParameter("txtNombres");
                    String dirClientes = request.getParameter("txtDir");
                    String estClientes = request.getParameter("txtEstado");
                    cli.setDni(dniClientes);
                    cli.setNomb(nomClientes);
                    cli.setDir(dirClientes);
                    cli.setEstado(estClientes);
                    cdao.agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniClienteUpdate = request.getParameter("txtDni");
                    String nomClienteUpdate = request.getParameter("txtNombres");
                    String dirClienteUpdate = request.getParameter("txtDir");
                    String estClienteUpdate = request.getParameter("txtEstado");
                    cli.setDni(dniClienteUpdate);
                    cli.setNomb(nomClienteUpdate);
                    cli.setDir(dirClienteUpdate);
                    cli.setEstado(estClienteUpdate);
                    cli.setId(ide);
                    cdao.actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List listaProductos = pdao.listar();
                    request.setAttribute("productos", listaProductos);
                    break;
                case "Agregar":
                    String nomProductos = request.getParameter("txtNombres");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String estProductos = request.getParameter("txtEstado");
                    pr.setNomb(nomProductos);
                    pr.setPrecio(Integer.parseInt(precio));
                    pr.setStock(Integer.parseInt(stock));
                    pr.setEstado(estProductos);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(ide);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomProductoUpdate = request.getParameter("txtNombres");
                    String precioUpdate = request.getParameter("txtPrecio");
                    String stockUpdate = request.getParameter("txtStock");
                    String estProductoUpdate = request.getParameter("txtEstado");
                    pr.setNomb(nomProductoUpdate);
                    pr.setPrecio(Integer.parseInt(precioUpdate));
                    pr.setStock(Integer.parseInt(stockUpdate));
                    pr.setEstado(estProductoUpdate);
                    pr.setId(ide);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigoCliente");
                    cli.setDni(dni);
                    cli = cdao.buscar(dni);
                    request.setAttribute("c", cli);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    pr = pdao.listarId(id);
                    request.setAttribute("c", cli);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("c", cli);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pr.getId();
                    descripcion = request.getParameter("nombresProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cantidad);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    v.setIdcliente(cli.getId());
                    v.setIdemplado(1);
                    v.setNumserie(numeroserie);
                    v.setFecha("2021-10-09");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    int idv = Integer.parseInt(vdao.idVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);

                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();;
                        int IdProducto = lista.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr = aO.buscar(IdProducto);
                        int sac = pr.getStock() - cantidad;
                        aO.actualizarStock(IdProducto, sac);
                    }
                    break;
                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "000000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    //request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        // switch (accion) {
        //     case "Principal":
        //         request.getRequestDispatcher("Principal.jsp").forward(request, response);
        //         break;
        //     case "Producto":
        //         request.getRequestDispatcher("Producto.jsp").forward(request, response);
        //         break;
        //     case "Cliente":
        //         request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        //         break;
        //     case "Empleado":
        //         request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        //         break;
        //     case "NuevaVenta":
        //         request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        //         break;
        //     default:
        //         break;
        // }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>

}