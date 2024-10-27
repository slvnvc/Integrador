/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
public class OrdenCompra {
    private int idOrdenCompra;
    private int idProveedor; // fk
    private String fechaOrden;
    private double montoTotal;
    private String producto; // atributo para almacenar el nombre del producto

    public OrdenCompra(int idOrdenCompra, int idProveedor, String fechaOrden, double montoTotal, String producto) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.montoTotal = montoTotal;
        this.producto = producto;
    }

    public OrdenCompra(int idProveedor, String fechaOrden, double montoTotal, String producto) {
        this.idProveedor = idProveedor;
        this.fechaOrden = fechaOrden;
        this.montoTotal = montoTotal;
        this.producto = producto;
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

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getProducto() {
        return producto;
    }

    public String getNombreProducto() {
        return this.producto; // para devolver el nombre del producto (String)
    }
}
