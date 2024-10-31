/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import Controlador.ProveedorControlador;
/**
 *
 * @author Silvana Villanueva
 */
//public class OrdenCompra {
//    private int idOrdenCompra;
//    private int idProveedor; // fk
//    private String fechaOrden;
//    private double montoTotal;
//    private String producto; // atributo para almacenar el nombre del producto
//    private String proveedor;
//    
//    //nuevo
//    public OrdenCompra(int idOrdenCompra, String proveedor,String fechaOrden, double montoTotal, String producto ) {
//        this.idOrdenCompra = idOrdenCompra;
//        //this.idProveedor = idProveedor;
//        this.fechaOrden = fechaOrden;
//        this.montoTotal = montoTotal;
//        this.producto = producto;
//        this.proveedor = proveedor;
//    }
//    //para llamadas mas sencillas
//    public OrdenCompra(int idOrdenCompra, String fechaOrden, int idProveedor) {
//        this.idOrdenCompra = idOrdenCompra;
//        this.fechaOrden = fechaOrden;
//        this.idProveedor = idProveedor;
//    }
//    public OrdenCompra() {
//    }
//
//    public String getProveedor() {
//        return proveedor;
//    }
//
////    public void setProveedor(String proveedor) {
////        this.proveedor = proveedor;
////    }
//
//    public OrdenCompra(int idOrdenCompra, int idProveedor, String fechaOrden, double montoTotal, String producto) {
//        this.idOrdenCompra = idOrdenCompra;
//        this.idProveedor = idProveedor;
//        this.fechaOrden = fechaOrden;
//        this.montoTotal = montoTotal;
//        this.producto = producto;
//    }
//
//    public OrdenCompra(int idProveedor, String fechaOrden, double montoTotal, String producto) {
//        this.idProveedor = idProveedor;
//        this.fechaOrden = fechaOrden;
//        this.montoTotal = montoTotal;
//        this.producto = producto;
//    }
//
//    public int getIdOrdenCompra() {
//        return idOrdenCompra;
//    }
//
//    public int getIdProveedor() {
//        return idProveedor;
//    }
//
//    public String getFechaOrden() {
//        return fechaOrden;
//    }
//
//    public double getMontoTotal() {
//        return montoTotal;
//    }
//
//    public String getProducto() {
//        return producto;
//    }
//
//    public String getNombreProducto() {
//        return this.producto; // para devolver el nombre del producto (String)
//    }
//    public String getNombreProveedor() {
//        return this.proveedor; // para devolver el nombre del producto (String)
//    }
//}

////public class OrdenCompra {
////    private int idOrdenCompra;
////    private int idProveedor; // fk
////    private String fechaOrden;
////    private List<ProductoOrden> productos; // Lista de productos
////
////    public OrdenCompra(int idProveedor, String fechaOrden, List<ProductoOrden> productos) {
////        this.idProveedor = idProveedor;
////        this.fechaOrden = fechaOrden;
////        this.productos = productos;
////    }
////
////    // Getters y Setters
////    public int getIdOrdenCompra() {
////        return idOrdenCompra;
////    }
////
////    public void setIdOrdenCompra(int idOrdenCompra) {
////        this.idOrdenCompra = idOrdenCompra;
////    }
////
////    public int getIdProveedor() {
////        return idProveedor;
////    }
////
////    public void setIdProveedor(int idProveedor) {
////        this.idProveedor = idProveedor;
////    }
////
////    public String getFechaOrden() {
////        return fechaOrden;
////    }
////
////    public void setFechaOrden(String fechaOrden) {
////        this.fechaOrden = fechaOrden;
////    }
////
////    public List<ProductoOrden> getProductos() {
////        return productos;
////    }
////
////    public void setProductos(List<ProductoOrden> productos) {
////        this.productos = productos;
////    }
////
////    // Método para obtener el nombre de los productos
////    public String getNombresProductos() {
////        StringBuilder nombres = new StringBuilder();
////        for (ProductoOrden producto : productos) {
////            if (nombres.length() > 0) {
////                nombres.append(", "); // Separador entre nombres
////            }
////            nombres.append(producto.getNombreProducto());
////        }
////        return nombres.toString();
////    }
////
////    // Método para obtener el nombre del proveedor
////    public String getNombresProveedores(List<Proveedor> proveedores) {
////    StringBuilder nombres = new StringBuilder();
////    for (Proveedor proveedor : proveedores) {
////        if (nombres.length() > 0) {
////            nombres.append(", "); // Separador entre nombres
////        }
////        nombres.append(proveedor.getNombre()); // Asumiendo que tienes un método getNombre en la clase Proveedor
////    }
////    return nombres.toString();
////}
////
////}
import java.util.List;

//public class OrdenCompra {
//    private int idOrdenCompra; // ID único para la orden de compra
//    private String fechaOrden; // Fecha de la orden
//    private List<ProductoOrden> productos; // Lista de productos en la orden
//    private List<Integer> idsProveedores; // Lista de IDs de proveedores
//
//    public OrdenCompra(String fechaOrden, List<ProductoOrden> productos, List<Integer> idsProveedores) {
//        this.fechaOrden = fechaOrden;
//        this.productos = productos;
//        this.idsProveedores = idsProveedores; // Asignar la lista de IDs de proveedores
//    }
//
//    // Getters y Setters
//    public int getIdOrdenCompra() {
//        return idOrdenCompra;
//    }
//
//    public void setIdOrdenCompra(int idOrdenCompra) {
//        this.idOrdenCompra = idOrdenCompra;
//    }
//
//    public String getFechaOrden() {
//        return fechaOrden;
//    }
//
//    public void setFechaOrden(String fechaOrden) {
//        this.fechaOrden = fechaOrden;
//    }
//
//    public List<ProductoOrden> getProductos() {
//        return productos;
//    }
//
//    public void setProductos(List<ProductoOrden> productos) {
//        this.productos = productos;
//    }
//
//    public List<Integer> getIdsProveedores() {
//        return idsProveedores;
//    }
//
//    public void setIdsProveedores(List<Integer> idsProveedores) {
//        this.idsProveedores = idsProveedores;
//    }
//}

import java.util.List;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

import java.util.List;

public class OrdenCompra {
    private int idOrdenCompra;
    private int idProveedor; // Un solo ID de proveedor
    private String fechaOrden;
    private List<ProductoOrden> productos;

    public OrdenCompra(String fechaOrden, int idProveedor, List<ProductoOrden> productos) {
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.productos = productos;
    }
    // Constructor
    public OrdenCompra(int idOrdenCompra, String fechaOrden, int idProveedor) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOrden = fechaOrden;
        this.idProveedor = idProveedor; // Asignar el ID del proveedor
        this.productos = new ArrayList<>(); // Inicializa la lista de productos
    }
    // Getters
    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public List<ProductoOrden> getProductos() {
        return productos;
    }
}
