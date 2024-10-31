package Modelo;

import java.util.Random;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String marca;
    private String categoria;
    //private String modelo;
    private String numeroSerie;
    private String codigoInventario;
    private String estado;
    private int idProveedor;
    private String nombreProveedor; 

    // Constructor
    public Equipo(int idEquipo, String nombre, String marca, String categoria, String numeroSerie, String codigoInventario, String estado) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        //this.modelo = modelo;
        setNumeroSerie(); // Genera número de serie automáticamente
        setCodigoInventario(); // Genera código de inventario automáticamente
        this.estado = estado;
    }

    public Equipo(int idEquipo, String nombre, String marca, String categoria,  
                  String numeroSerie, String codigoInventario, String estado, int idProveedor) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        //this.modelo = modelo;
        setNumeroSerie(); // Genera número de serie automáticamente
        setCodigoInventario(); // Genera código de inventario automáticamente
        this.estado = estado;
        this.idProveedor = idProveedor;
    }

    public Equipo(int idEquipo, String nombre, String marca, String categoria, String numeroSerie, String codigoInventario, String estado, int idProveedor, String nombreProveedor) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        //this.modelo = modelo;
        setNumeroSerie(); // Genera número de serie automáticamente
        setCodigoInventario(); // Genera código de inventario automáticamente
        this.estado = estado;
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
    }
    //cambioss
    public Equipo(int idEquipo, String nombre, String marca, String categoria,  String estado, int idProveedor) {
    this.idEquipo = idEquipo;
    this.nombre = nombre;
    this.marca = marca;
    this.categoria = categoria;
    //this.modelo = modelo;
    setNumeroSerie(); // Genera número de serie automáticamente
    setCodigoInventario(); // Genera código de inventario automáticamente
    this.estado = estado;
    this.idProveedor = idProveedor;
}
//    //nuevo
//    public Equipo(int idEquipo, String nombre, String marca, String categoria, String estado, int idProveedor) {
//        this.idEquipo = idEquipo;
//        this.nombre = nombre;
//        this.marca = marca;
//        this.categoria = categoria;
//        this.estado = estado;
//        this.idProveedor = idProveedor;
//
//        setNumeroSerie(); // Genera número de serie automáticamente
//        setCodigoInventario(); // Genera código de inventario automáticamente
//    }
    private void setCodigoInventario() {
        if (nombre != null && !nombre.isEmpty()) {
            char inicial = nombre.toUpperCase().charAt(0);
            int randomNum = new Random().nextInt(900) + 100; // genera un número de 3 dígitos
            this.codigoInventario = inicial + String.valueOf(randomNum);
        }
    }

    private void setNumeroSerie() {
        Random random = new Random();
        int numSerie = random.nextInt(900000) + 100000; // genera un número de 6 dígitos
        this.numeroSerie = String.valueOf(numSerie);
    }

    // Métodos getters y setters restantes
    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
        setCodigoInventario(); // actualiza el código de inventario al cambiar el nombre
    }

    public String getMarca() { return marca; } 
    public void setMarca(String marca) { this.marca = marca; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    //public String getModelo() { return modelo; }
    //public void setModelo(String modelo) { this.modelo = modelo; }

    public String getNumeroSerie() { return numeroSerie; }

    public String getCodigoInventario() { return codigoInventario; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }
}
