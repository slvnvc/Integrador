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
import java.util.ArrayList;
import java.util.List;

public class OrdenCompra {
    private int idOrdenCompra;
    private int idProveedor; 
    private String fechaOrden;
    private List<ProductoOrden> productos;

    public OrdenCompra() {
    }
    
    public OrdenCompra(String fechaOrden, int idProveedor, List<ProductoOrden> productos) {
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.productos = productos;
    }
    // Constructor
    public OrdenCompra(int idOrdenCompra, String fechaOrden, int idProveedor) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOrden = fechaOrden;
        this.idProveedor = idProveedor; 
        this.productos = new ArrayList<>(); 
    }

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
    
    public void agregarProducto(ProductoOrden producto) {
        productos.add(producto);
    }
    public String obtenerNombreProducto() {
    if (!productos.isEmpty()) {
        return productos.get(0).getNombreProducto(); 
    }
    return null;
}
    public int obtenerCantidadProducto() {
    if (!productos.isEmpty()) {
        return productos.get(0).getCantidad(); 
    }
    return 0;
}

}
