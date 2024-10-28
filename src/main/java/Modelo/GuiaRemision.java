/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Silvana Villanueva
 */
public class GuiaRemision {
    private int idGuiaRemision;
    private int idOrdenCompra;
    private int idProveedor;
    private String fechaOrdenCompra; 
    private String nombreProveedor;
    private String fechaRecepcion;
    private String comentarios; 

    //constructor usado en la vista
    public GuiaRemision(int idOrdenCompra, String fechaOrdenCompra, String nombreProveedor, String fechaRecepcion, String comentarios) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.nombreProveedor = nombreProveedor;
        this.fechaRecepcion = fechaRecepcion;
        this.comentarios = comentarios;
    }

   // constructor para insertar una nueva guía de remisión en la bd
    public GuiaRemision(int idOrdenCompra, int idProveedor, String fechaRecepcion, String comentarios) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProveedor = idProveedor;
        this.fechaRecepcion = fechaRecepcion;
        this.comentarios = comentarios;
    }
    // constructor completo para obtener datos desde la BD con JOIN
    public GuiaRemision(int idGuiaRemision, int idOrdenCompra, String fechaOrdenCompra, String nombreProveedor, String fechaRecepcion, String comentarios) {
        this.idGuiaRemision = idGuiaRemision;
        this.idOrdenCompra = idOrdenCompra;
        this.fechaOrdenCompra = fechaOrdenCompra;
        this.nombreProveedor = nombreProveedor;
        this.fechaRecepcion = fechaRecepcion;
        this.comentarios = comentarios;
    }
    
    //constructor vacio para la vista
    public GuiaRemision() {
    }
    public int getIdGuiaRemision() {
        return idGuiaRemision;
    }

    public void setIdGuiaRemision(int idGuiaRemision) {
        this.idGuiaRemision = idGuiaRemision;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public String getFechaOrdenCompra() {
        return fechaOrdenCompra;
    }

    public void setFechaOrdenCompra(String fechaOrdenCompra) {
        this.fechaOrdenCompra = fechaOrdenCompra;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
}
