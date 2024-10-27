package Modelo;


public class Equipo {
    private int idEquipo;
    private String nombre;
    private String marca;
    private String categoria;
    private String modelo;
    private String numeroSerie;
    private String codigoInventario;
    private String estado;

    //Constructor
    public Equipo(int idEquipo, String nombre, String marca, String categoria, String modelo, String numeroSerie, String codigoInventario, String estado) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.codigoInventario = codigoInventario;
        this.estado = estado;
    }
    
    public int getIdEquipo() { 
        return idEquipo; 
    }
    public void setIdEquipo(int idEquipo) { 
        this.idEquipo = idEquipo; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getMarca() { 
        return marca; 
    } 
    public void setMarca(String marca) { 
        this.marca = marca; 
    }

    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }

    public String getModelo() { 
        return modelo; 
    }
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }

    public String getNumeroSerie() { 
        return numeroSerie; 
    }
    public void setNumeroSerie(String numeroSerie) { 
        this.numeroSerie = numeroSerie; 
    }

    public String getCodigoInventario() { 
        return codigoInventario; 
    }
    public void setCodigoInventario(String codigoInventario) { 
        this.codigoInventario = codigoInventario; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
}
