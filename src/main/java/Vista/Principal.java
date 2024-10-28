/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.OrdenAsignacionControlador;
import Controlador.OrdenCompraControlador;
import Controlador.ProveedorControlador;
import Controlador.TrabajadorControlador;
import Controlador.OrdenSalidaControlador;
import Controlador.GuiaRemisionControlador;
import Modelo.Encargado;
import Modelo.Equipo;
import Modelo.OrdenAsignacion;
import Modelo.OrdenCompra;
import Modelo.OrdenSalida;
import Modelo.Proveedor;
import Modelo.Trabajador;
import Modelo.GuiaRemision;
import controlador.EquipoControlador;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Silvana Villanueva
 */
public class Principal extends javax.swing.JFrame {

    
    /**
     * Creates new form Principal
     */
    private Encargado encargado;
    
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTablaI();
        cargarEquiposDisponibles();
        cargarTrabajadores();
    }
    
    private void cargarTabla() {
    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.obtenerEquiposConProveedor(); // Cambia a obtenerEquiposConProveedor
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos1.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                equipo.getModelo(),
                equipo.getNumeroSerie(),
                equipo.getEstado(),
                equipo.getNombreProveedor() // Agrega el nombre del proveedor
            };
            modeloTabla.addRow(fila); // Agregar fila
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    
     private void cargarTablaI() {
        //carga la tabla previamente en el panel registrar
    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.obtenerEquipos();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                equipo.getModelo(),
                equipo.getNumeroSerie(),
                equipo.getEstado()
            };
            modeloTabla.addRow(fila); // Agregar fila
        }
        } catch (SQLException ex) {
        ex.printStackTrace();
            }
    }
    
     //para mencionar el nombre de la persona que inicia sesion
     public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public void cargarEncargado() {
        
        lblSaludo.setText("Te damos la bienvenida \n" + encargado.getNombre());

    }
    
    private void actualizarTabla() {
    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.obtenerEquipos();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos1.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                equipo.getModelo(),
                equipo.getNumeroSerie(),
                equipo.getEstado(),
                equipo.getNombreProveedor()
            };
            modeloTabla.addRow(fila); // Agregar fila
        }
        } catch (SQLException ex) {
        ex.printStackTrace();
            }
    }
    
    private void actualizarTablaTrabajadores() {
    try { //crear instancia de trabjador controlador
        TrabajadorControlador trabajadorControlador = new TrabajadorControlador();
        List<Trabajador> listaTrabajadores = trabajadorControlador.obtenerTrabajadores();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblTrabajadores.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Trabajador trabajador : listaTrabajadores) {
            Object[] fila = {
                
                trabajador.getNombre(),
                trabajador.getDNI(),
                trabajador.getTelefono(),
                trabajador.getCorreo()
                
            };
            modeloTabla.addRow(fila); // Agregar fila
        }
        } catch (SQLException ex) {
        ex.printStackTrace();
            }
    }
    
    private void limpiarFormulario() {
         txtCod.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        cmbCategoria.setSelectedIndex(-1);  
        txtModelo.setText("");
        txtSerie.setText("");
        txtEstado.setText("");
        lblProveedor.setText("");
    }
//carga de los combo box//
       // cargar los equipos disponibles en el Cmb
    public void cargarEquiposDisponibles() {
        EquipoControlador equipoControlador = new EquipoControlador();
        
        try {
            // Obtener la lista de equipos disponibles desde el controlador
            List<Equipo> equiposDisponibles = equipoControlador.obtenerEquiposDispo();
            
            cmbEquipo.removeAllItems();  // limpio cmb

            //lleno cmb con los NOMBRES de los equipos disponibles
            for (Equipo equipo : equiposDisponibles) {
                cmbEquipo.addItem(equipo.getNombre());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    }
    
    public void cargarEquiposDefectuosos() {
        EquipoControlador equipoControlador = new EquipoControlador();
        try {
        // Obtener la lista de equipos disponibles desde el controlador
        List<Equipo> equiposDefectuosos = equipoControlador.obtenerEquiposDefectuosos();
        cmbEquiposD.removeAllItems();  // limpio cmb
        //lleno cmb con los NOMBRES de los equipos disponibles
        for (Equipo equipo : equiposDefectuosos) {
            cmbEquiposD.addItem(equipo.getNombre());
        }
    } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    }
    //cargar trabjadores en el combo
    public void cargarTrabajadores() {
        TrabajadorControlador trabajadorControlador = new TrabajadorControlador();
        
        try {
            // Obtener la lista de trabajadores desde el controlador
            List<Trabajador> trabajadores = trabajadorControlador.obtenerTrabajadores();
            
            cmbTrabajador.removeAllItems();  // limpio cmb

            //lleno cmb con los NOMBRES de los trabajdores 
            for (Trabajador trabajador : trabajadores) {
                cmbTrabajador.addItem(trabajador.getNombre());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    }
    //COMBO BOX
    private void cargarProveedores() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    try {
        List<Proveedor> proveedores = proveedorControlador.obtenerTodosLosProveedores();
        cmbProveedores.removeAllItems(); // Limpiar el combo antes de llenarlo

        for (Proveedor proveedor : proveedores) {
            cmbProveedores.addItem(proveedor.getNombre()); // Llenar combo de proveedores
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los proveedores.");
    }
}
    private void cargarNombresEquipos() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    
    // Verifica si hay un proveedor seleccionado en cmbProveedores
    if (cmbProveedores.getSelectedItem() == null) {
        cmbNombres.removeAllItems(); // Limpiar cmbNombres si no hay proveedor seleccionado
        return;
    }

    try {
        // Obtén el nombre del proveedor seleccionado y su ID
        String proveedorSeleccionado = cmbProveedores.getSelectedItem().toString();
        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);

        // Obtén la lista de nombres de equipos para el proveedor seleccionado
        List<String> nombresEquipos = proveedorControlador.obtenerNombresEquiposPorProveedor(idProveedor);

        // Limpia el ComboBox de nombres antes de añadir nuevos elementos
        cmbNombres.removeAllItems();

        // Rellena el ComboBox cmbNombres con los nombres de equipos
        for (String nombre : nombresEquipos) {
            cmbNombres.addItem(nombre);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los nombres de equipos.");
    }
}
    private void cargarOrdenesCompra() {
    OrdenCompraControlador ordenCompraControlador = new OrdenCompraControlador();
    try {
        List<OrdenCompra> ordenesCompra = ordenCompraControlador.obtenerOrdenesCompraBasicas();
        cmbOrdenCompra.removeAllItems(); // Limpiar el combo antes de llenarlo

        for (OrdenCompra orden : ordenesCompra) {
            cmbOrdenCompra.addItem("Orden N°: "+orden.getIdOrdenCompra()); // Agrega cada objeto OrdenCompra al combo
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las órdenes de compra.");
    }
}
    public void cargarCategorias() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    
    try {
        // Obtener la lista de categorías desde el controlador
        List<String> categorias = proveedorControlador.obtenerCategorias();
        
        cmbCategoria.removeAllItems();  // Limpiar cmbCategoria

        // Llenar cmbCategoria con las categorías
        for (String categoria : categorias) {
            cmbCategoria.addItem(categoria);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las categorías.");
    }
}

//----
private void cargarProducto() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    
    // para que provedores no sea nulo y tenga un elemento selecionado por defecto
    if (cmbProveedores.getSelectedItem() == null) {
        cmbNombres.setSelectedIndex(-1); // limpiar lbl si no hay proveedor seleccionado
        return; 
    }
    
    try {
        // obtengo el id del proveedor seleccionado
        String proveedorSeleccionado = cmbProveedores.getSelectedItem().toString();
        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);

        //cada provedor provee un tipo de producto 
        String producto = proveedorControlador.obtenerProductosPorProveedor(idProveedor); 

        // rellena lbl 
        //lblProducto.setText(producto); 
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar el producto.");
    }
}

//------------
    private void limpiarFormularioOC() {
    txtFechadeOrden.setText("");
    txtMonto.setText("");
    cmbProveedores.setSelectedIndex(-1);
    cmbNombres.setSelectedIndex(-1); 
}

private void cargarTablaOrdenCompra() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblOrdenC.getModel();
    modeloTabla.setRowCount(0); // limpio la tbl antes de cargar nuevos datos

    OrdenCompraControlador controlador = new OrdenCompraControlador();
    ProveedorControlador proveedorControlador = new ProveedorControlador(); // Asegúrate de tener esto
    try {
        List<OrdenCompra> ordenes = controlador.obtenerTodasLasOrdenes();

        for (OrdenCompra orden : ordenes) {
            // obtengo el nombre del proveedor usando su ID
            String nombreProveedor = proveedorControlador.obtenerProveedorPorId(orden.getIdProveedor());

            Object[] fila = {
                orden.getFechaOrden(),
                nombreProveedor,  
                orden.getNombreProducto(), //modelo
                orden.getMontoTotal()
            };
            modeloTabla.addRow(fila);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las órdenes de compra desde la base de datos.");
    }
}
    //ORDEN ASIGNACION
    public void gestionarAsignacion() {
    try {
        // verificacion seleccion de trabajdor y equipo
        if (cmbEquipo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo.");
            return;
        }

        if (cmbTrabajador.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un trabajador.");
            return;
        }

        EquipoControlador equipoControlador = new EquipoControlador();
        TrabajadorControlador trabajadorControlador = new TrabajadorControlador();

        // recopilar datos de combos y txtfield
        int idEquipo = equipoControlador.obtenerIdEquipoPorNombre(cmbEquipo.getSelectedItem().toString());
        int idTrabajador = trabajadorControlador.obtenerIdTrabajadorPorNombre(cmbTrabajador.getSelectedItem().toString());
        String fechaAsignacion = txtFechaAsignacion.getText();
        String areaAsignacion = txtArea.getText();

        //validacion que no esten vacios 
        if (fechaAsignacion.isEmpty() || areaAsignacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de asignar.");
            return;
        }

        OrdenAsignacion nuevaOrden = new OrdenAsignacion(idEquipo, idTrabajador, fechaAsignacion, areaAsignacion);

        //usando controlador
        OrdenAsignacionControlador controlador = new OrdenAsignacionControlador();
        controlador.agregarOrdenAsignacion(nuevaOrden);

        equipoControlador.actualizarEstadoEquipo(idEquipo, "Asignado"); //se le cambia el estado
        JOptionPane.showMessageDialog(null, "Asignación guardada exitosamente.");

        // limpiar al final para que no se borre lo seleccioando
        limpiarFormAsignacion();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar la asignación en la base de datos.");
    }
}

    private void cargarTablaAsignacion() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblAsignacion.getModel();
    modeloTabla.setRowCount(0); 

    OrdenAsignacionControlador controlador = new OrdenAsignacionControlador();
    try {
        List<OrdenAsignacion> ordenes = controlador.obtenerTodasLasOrdenes();

        for (OrdenAsignacion orden : ordenes) {
            Object[] fila = {
                orden.getNombreEquipo(),      //nuevos atributos en modelo
                orden.getNombreTrabajador(),  
                orden.getFechaAsignacion(),
                orden.getArea()              
            };
            modeloTabla.addRow(fila);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las asignaciones desde la base de datos.");
    }
    
}
// limpiar todo
    private void limpiarFormAsignacion() {
    cmbEquipo.setSelectedIndex(-1);  
    cmbTrabajador.setSelectedIndex(-1); 
    txtFechaAsignacion.setText("");  
    txtArea.setText("");  
}
    //ORDEN SALIDA
    public void gestionarDevolucion() {
    try {
        // Verificación de selección de equipo defectuoso
        if (cmbEquiposD.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo defectuoso.");
            return;
        }

        EquipoControlador equipoControlador = new EquipoControlador();
        ProveedorControlador proveedorControlador = new ProveedorControlador();

        // Obtener el id del equipo defectuoso seleccionado
        int idEquipo = equipoControlador.obtenerIdEquipoPorNombre(cmbEquiposD.getSelectedItem().toString());

        // Obtener el nombre del proveedor asociado al equipo defectuoso y llenar lblDestino
        String nombreProveedor = proveedorControlador.obtenerNombreProveedorPorEquipo(idEquipo);
        lblDestino.setText(nombreProveedor);

        // Verificar que los campos de fecha y motivo no estén vacíos
        String fechaSalida = txtFechaSalida.getText();
        String motivo = jtxtMotivo.getText();

        if (fechaSalida.isEmpty() || motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete los campos de fecha de salida y motivo.");
            return;
        }

        // Crear la orden de salida y guardarla usando el controlador
        OrdenSalida nuevaOrden = new OrdenSalida(idEquipo, fechaSalida, motivo);
        OrdenSalidaControlador ordenSalidaControlador = new OrdenSalidaControlador();
        ordenSalidaControlador.agregarOrdenSalida(nuevaOrden);

        // Cambiar el estado del equipo a "En devolución"
        equipoControlador.actualizarEstadoEquipo(idEquipo, "En devolución");
        
        JOptionPane.showMessageDialog(null, "Orden de salida guardada exitosamente.");

        // Limpiar el formulario
        limpiarFormOS();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar la orden de salida en la base de datos.");
    }
}
    private void actualizarDestino() {
    if (cmbEquiposD.getSelectedItem() != null) {
        try {
            EquipoControlador equipoControlador = new EquipoControlador();
            ProveedorControlador proveedorControlador = new ProveedorControlador();
            
            // Obtener el id del equipo seleccionado
            int idEquipo = equipoControlador.obtenerIdEquipoPorNombre(cmbEquiposD.getSelectedItem().toString());
            
            // Obtener el nombre del proveedor asociado y actualizar lblDestino
            String nombreProveedor = proveedorControlador.obtenerNombreProveedorPorEquipo(idEquipo);
            lblDestino.setText(nombreProveedor);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar el proveedor destino.");
        }
    } else {
        lblDestino.setText("");
    }
}
    private void cargarTablaOrdenSalida() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblOrdenSalida.getModel();
    modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

    OrdenSalidaControlador controlador = new OrdenSalidaControlador();
    try {
        List<OrdenSalida> ordenesSalida = controlador.obtenerTodasLasOrdenesSalida();

        for (OrdenSalida orden : ordenesSalida) {
            Object[] fila = {
                orden.getNombreEquipo(),      
                orden.getNombreProveedor(),   
                orden.getFechaSalida(),       
                orden.getMotivo()             
            };
            modeloTabla.addRow(fila);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las órdenes de salida.");
    }
}

    private void limpiarFormOS() {
    cmbEquiposD.setSelectedIndex(-1);  
    lblDestino.setText("");  
    txtFechaSalida.setText("");  
    jtxtMotivo.setText("");  
}
    //GUIA REMISION
    public void gestionarGuiaRemision() {
    try {
        //verificar seleccion
        if (cmbOrdenCompra.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden de compra.");
            return;
        }

        // verificacion de los campos
        String fechaRecepcion = txtFecharecepcion.getText();
        String comentarios = jtxtComentarios.getText();

        if (fechaRecepcion.isEmpty() || comentarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de guardar la guía de remisión.");
            return;
        }

        // obtener ID de la orden de compra seleccionada
        String selectedText = (String) cmbOrdenCompra.getSelectedItem();
        int idOrdenCompra = Integer.parseInt(selectedText.replace("Orden N°: ", "").trim());

        // obtenr ID del proveedor en base a la orden de compra seleccionada
        OrdenCompraControlador ordenCompraControlador = new OrdenCompraControlador();
        int idProveedor = ordenCompraControlador.obtenerIdProveedorPorOrden(idOrdenCompra);

        // crear la guiaremision con idProveedor incluido
        GuiaRemision nuevaGuia = new GuiaRemision(idOrdenCompra, idProveedor, fechaRecepcion, comentarios);

        // guardar en la base de datos
        GuiaRemisionControlador controlador = new GuiaRemisionControlador();
        controlador.agregarGuiaRemision(nuevaGuia);

        JOptionPane.showMessageDialog(null, "Guía de remisión guardada exitosamente.");

        //actualizar la tabla
        cargarTablaGuiaRemision();

        //limpiar campos
        limpiarFormularioGuiaRemision();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar la guía de remisión en la base de datos.");
    }
}

    private void cargarTablaGuiaRemision() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblGuiaRemision.getModel();
    modeloTabla.setRowCount(0); // Limpiar la tabla antes de llenarla

    GuiaRemisionControlador controlador = new GuiaRemisionControlador();
    try {
        List<GuiaRemision> guias = controlador.obtenerTodasLasGuiasRemision();

        for (GuiaRemision guia : guias) {
            Object[] fila = {
                guia.getIdOrdenCompra(),       
                guia.getFechaOrdenCompra(),    
                guia.getNombreProveedor(),    
                guia.getFechaRecepcion(),      
                guia.getComentarios()          
            };
            modeloTabla.addRow(fila);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las guías de remisión.");
    }
}
    private void limpiarFormularioGuiaRemision() {
    cmbOrdenCompra.setSelectedIndex(-1); 
    lblFechaOC.setText("");             
    lblProveedor.setText("");            
    txtFecharecepcion.setText("");       
    jtxtComentarios.setText("");          
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnInventario = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        btnRemision = new javax.swing.JButton();
        btnCS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSaludo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNotificaciones = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PInventario = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        btnAsignar = new javax.swing.JButton();
        btnVerTrabajadores = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        PCompra = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtFechadeOrden = new javax.swing.JTextField();
        cmbProveedores = new javax.swing.JComboBox<>();
        btnGuardarOC = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblOrdenC = new javax.swing.JTable();
        btnVerOrdenC = new javax.swing.JButton();
        cmbNombres = new javax.swing.JComboBox<>();
        PSalida = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnGuardarOS = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtFechaSalida = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtxtMotivo = new javax.swing.JTextArea();
        cmbEquiposD = new javax.swing.JComboBox<>();
        lblDestino = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblOrdenSalida = new javax.swing.JTable();
        btnVerOrdenS = new javax.swing.JButton();
        PRemision = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtxtComentarios = new javax.swing.JTextArea();
        txtFecharecepcion = new javax.swing.JTextField();
        btnGuardarGuiaR = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblGuiaRemision = new javax.swing.JTable();
        btnVerGuiaRemision = new javax.swing.JButton();
        cmbOrdenCompra = new javax.swing.JComboBox<>();
        lblFechaOC = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        PRegistrar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        btnRegistrarEquipo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEquipos1 = new javax.swing.JTable();
        btnVolverr = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblProveedorR = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        PAsignar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnAsignarEquipo = new javax.swing.JButton();
        btnVerOrdenAsignacion = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cmbEquipo = new javax.swing.JComboBox<>();
        cmbTrabajador = new javax.swing.JComboBox<>();
        txtArea = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAsignacion = new javax.swing.JTable();
        txtFechaAsignacion = new javax.swing.JTextField();
        PVerTrabajadores = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnVolverr1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTrabajadores = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        btnBuscarTrabajador = new javax.swing.JButton();
        txtBuscarTrabajador = new javax.swing.JTextField();
        PNotificaciones = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        btnInventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnSalida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalida.setText("Salida");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        btnCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCompra.setText("Compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnRemision.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemision.setText("Remisión");
        btnRemision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemisionActionPerformed(evt);
            }
        });

        btnCS.setBackground(new java.awt.Color(204, 0, 0));
        btnCS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCS.setText("Cerrar sesión");
        btnCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoo.png"))); // NOI18N

        lblSaludo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblSaludo.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("SISTEMA DE INVENTARIO ");

        btnNotificaciones.setBackground(new java.awt.Color(51, 51, 51));
        btnNotificaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNotificaciones.setText("Notificaciones");
        btnNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnInventario)
                        .addGap(31, 31, 31)
                        .addComponent(btnCompra)
                        .addGap(31, 31, 31)
                        .addComponent(btnSalida)
                        .addGap(31, 31, 31)
                        .addComponent(btnRemision)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCS)
                    .addComponent(btnNotificaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(389, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNotificaciones)
                            .addComponent(lblSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInventario)
                            .addComponent(btnSalida)
                            .addComponent(btnCompra)
                            .addComponent(btnRemision)
                            .addComponent(btnCS))))
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel3)
                    .addContainerGap(151, Short.MAX_VALUE)))
        );

        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Categoria", "Modelo", "Serie", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblEquipos);

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnVerTrabajadores.setText("Ver Trabajadores");
        btnVerTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTrabajadoresActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("Equipos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnRegistrar)
                        .addGap(37, 37, 37)
                        .addComponent(btnAsignar)
                        .addGap(41, 41, 41)
                        .addComponent(btnVerTrabajadores)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PInventarioLayout = new javax.swing.GroupLayout(PInventario);
        PInventario.setLayout(PInventarioLayout);
        PInventarioLayout.setHorizontalGroup(
            PInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInventarioLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        PInventarioLayout.setVerticalGroup(
            PInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PInventarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("tab1", PInventario);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Orden de compra");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Fecha de Orden:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Proveedor:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Monto total:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Producto:");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        txtFechadeOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechadeOrdenActionPerformed(evt);
            }
        });

        cmbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedoresActionPerformed(evt);
            }
        });

        btnGuardarOC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarOC.setText("Guardar Orden de compra");
        btnGuardarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOCActionPerformed(evt);
            }
        });

        tblOrdenC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha de Orden", "Proveedor", "Producto", "Monto total"
            }
        ));
        jScrollPane7.setViewportView(tblOrdenC);

        btnVerOrdenC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerOrdenC.setText("Ver orden de compra");
        btnVerOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOrdenCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerOrdenC)
                .addGap(158, 158, 158))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnGuardarOC))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNombres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(txtFechadeOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(cmbProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(cmbNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtFechadeOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(btnGuardarOC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnVerOrdenC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout PCompraLayout = new javax.swing.GroupLayout(PCompra);
        PCompra.setLayout(PCompraLayout);
        PCompraLayout.setHorizontalGroup(
            PCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PCompraLayout.setVerticalGroup(
            PCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", PCompra);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Orden de salida");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Equipo:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Destinatario:");

        btnGuardarOS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarOS.setText("Guardar Orden de salida");
        btnGuardarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOSActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Motivo:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Fecha de salida:");

        txtFechaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaSalidaActionPerformed(evt);
            }
        });

        jtxtMotivo.setColumns(20);
        jtxtMotivo.setRows(5);
        jScrollPane5.setViewportView(jtxtMotivo);

        cmbEquiposD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEquiposDActionPerformed(evt);
            }
        });

        tblOrdenSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Equipo", "Destinatario", "Fecha Salida", "Motivo"
            }
        ));
        jScrollPane10.setViewportView(tblOrdenSalida);

        btnVerOrdenS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerOrdenS.setText("Ver Orden Salida");
        btnVerOrdenS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOrdenSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbEquiposD, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                                            .addComponent(lblDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(139, 139, 139)
                .addComponent(btnVerOrdenS, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 339, Short.MAX_VALUE)
                .addComponent(btnGuardarOS)
                .addGap(311, 311, 311))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(460, 460, 460)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(btnVerOrdenS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cmbEquiposD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(btnGuardarOS)
                        .addGap(40, 40, 40))))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PSalidaLayout = new javax.swing.GroupLayout(PSalida);
        PSalida.setLayout(PSalidaLayout);
        PSalidaLayout.setHorizontalGroup(
            PSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PSalidaLayout.setVerticalGroup(
            PSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", PSalida);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setText("Guía de Remisión");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Orden de Compra:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Fecha Orden de Compra:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Fecha de recepción:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Comentarios:");

        jtxtComentarios.setColumns(20);
        jtxtComentarios.setRows(5);
        jScrollPane6.setViewportView(jtxtComentarios);

        txtFecharecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecharecepcionActionPerformed(evt);
            }
        });

        btnGuardarGuiaR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarGuiaR.setText("Guardar Guía de Remisión");
        btnGuardarGuiaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGuiaRActionPerformed(evt);
            }
        });

        tblGuiaRemision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Orden Compra", "Fecha Orden de compra", "Proveedor", "Fecha de recepción", "Comentarios"
            }
        ));
        jScrollPane8.setViewportView(tblGuiaRemision);

        btnVerGuiaRemision.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerGuiaRemision.setText("Ver Guía de Remisión");
        btnVerGuiaRemision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerGuiaRemisionActionPerformed(evt);
            }
        });

        cmbOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenCompraActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Proveedor:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbOrdenCompra, 0, 161, Short.MAX_VALUE)
                                            .addComponent(lblFechaOC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFecharecepcion))))
                                .addGap(0, 31, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarGuiaR, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnVerGuiaRemision)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(cmbOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(lblFechaOC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(btnGuardarGuiaR)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnVerGuiaRemision)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(lblProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel37)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(txtFecharecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel35))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
        );

        javax.swing.GroupLayout PRemisionLayout = new javax.swing.GroupLayout(PRemision);
        PRemision.setLayout(PRemisionLayout);
        PRemisionLayout.setHorizontalGroup(
            PRemisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRemisionLayout.setVerticalGroup(
            PRemisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRemisionLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", PRemision);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Registrar un nuevo equipo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Cod:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Marca:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Categoría:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Modelo:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Serie:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Estado:");

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnRegistrarEquipo.setText("Registrar");
        btnRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEquipoActionPerformed(evt);
            }
        });

        tblEquipos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Categoria", "Modelo", "Serie", "Estado", "Proveedor"
            }
        ));
        jScrollPane2.setViewportView(tblEquipos1);

        btnVolverr.setText("Volver");
        btnVolverr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverrActionPerformed(evt);
            }
        });

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Proveedor:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(528, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnVolverr)
                                .addGap(32, 32, 32)
                                .addComponent(btnRegistrarEquipo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(23, 23, 23))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblProveedorR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblProveedorR, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEquipo)
                    .addComponent(btnVolverr))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout PRegistrarLayout = new javax.swing.GroupLayout(PRegistrar);
        PRegistrar.setLayout(PRegistrarLayout);
        PRegistrarLayout.setHorizontalGroup(
            PRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRegistrarLayout.setVerticalGroup(
            PRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab5", PRegistrar);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Asignación de equipos");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Seleccionar un equipo:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Seleccionar trabajador:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Fecha de Asignación:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Área:");

        btnAsignarEquipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAsignarEquipo.setText("Asignar Equipo");
        btnAsignarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEquipoActionPerformed(evt);
            }
        });

        btnVerOrdenAsignacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVerOrdenAsignacion.setText("Ver Orden Asignación");
        btnVerOrdenAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOrdenAsignacionActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cmbEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEquipoActionPerformed(evt);
            }
        });

        cmbTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTrabajadorActionPerformed(evt);
            }
        });

        tblAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipo", "Trabajador", "Fecha", "Área"
            }
        ));
        jScrollPane3.setViewportView(tblAsignacion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnVolver))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAsignarEquipo)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnVerOrdenAsignacion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTrabajador, 0, 158, Short.MAX_VALUE)
                            .addComponent(cmbEquipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaAsignacion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cmbTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtFechaAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAsignarEquipo)
                            .addComponent(btnVerOrdenAsignacion))
                        .addGap(29, 29, 29)
                        .addComponent(btnVolver))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PAsignarLayout = new javax.swing.GroupLayout(PAsignar);
        PAsignar.setLayout(PAsignarLayout);
        PAsignarLayout.setHorizontalGroup(
            PAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PAsignarLayout.setVerticalGroup(
            PAsignarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab6", PAsignar);

        btnVolverr1.setText("Volver");
        btnVolverr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverr1ActionPerformed(evt);
            }
        });

        tblTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Correo"
            }
        ));
        jScrollPane4.setViewportView(tblTrabajadores);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Trabajadores:");

        btnBuscarTrabajador.setText("Buscar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250)
                        .addComponent(txtBuscarTrabajador)
                        .addGap(50, 50, 50)
                        .addComponent(btnBuscarTrabajador)
                        .addGap(60, 60, 60))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverr1)
                .addGap(385, 385, 385))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(btnBuscarTrabajador)
                    .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverr1)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout PVerTrabajadoresLayout = new javax.swing.GroupLayout(PVerTrabajadores);
        PVerTrabajadores.setLayout(PVerTrabajadoresLayout);
        PVerTrabajadoresLayout.setHorizontalGroup(
            PVerTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PVerTrabajadoresLayout.setVerticalGroup(
            PVerTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PVerTrabajadoresLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab7", PVerTrabajadores);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Notificaciones");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane9.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PNotificacionesLayout = new javax.swing.GroupLayout(PNotificaciones);
        PNotificaciones.setLayout(PNotificacionesLayout);
        PNotificacionesLayout.setHorizontalGroup(
            PNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PNotificacionesLayout.setVerticalGroup(
            PNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNotificacionesLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab8", PNotificaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(184, 184, 184)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
       jTabbedPane1.setSelectedIndex(1);
       
       cargarProveedores();
       cmbProveedores.setSelectedIndex(-1);
       cmbNombres.setSelectedIndex(-1);
//
       //cargarProducto();
       //limpiarFormularioOC();
       cargarTablaOrdenCompra();
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
       jTabbedPane1.setSelectedIndex(2);
       cargarEquiposDefectuosos();
    //gestionarAsignacion(); //para que se actualice el combo
      cargarTablaOrdenSalida();
      limpiarFormOS();
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void btnRemisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemisionActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        cargarOrdenesCompra();
        cmbOrdenCompra.setSelectedIndex(-1);
        cargarTablaGuiaRemision(); //sale el mensaje error
        limpiarFormularioGuiaRemision();
        //cargar tbal
        //limpiar
    }//GEN-LAST:event_btnRemisionActionPerformed

    private void btnCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSActionPerformed
       
//        this.dispose();
//        Login lg= new Login();
//        
//        lg.setVisible(true);
//        lg.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnCSActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
      jTabbedPane1.setSelectedIndex(5);
      cargarEquiposDisponibles();
    //gestionarAsignacion(); //para que se actualice el combo
      cargarTablaAsignacion();
      limpiarFormAsignacion();
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      jTabbedPane1.setSelectedIndex(4);
       cargarCategorias();
      cmbCategoria.setSelectedIndex(-1); 
      cargarTabla();
      limpiarFormulario();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAsignarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEquipoActionPerformed
        //cargarEquiposDisponibles();
        gestionarAsignacion();
        cargarTablaAsignacion();
        //limpiarFormAsignacion();
        
    }//GEN-LAST:event_btnAsignarEquipoActionPerformed

    private void btnVerOrdenAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenAsignacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerOrdenAsignacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVolverrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverrActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnVolverrActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        //Codigo
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        //Nombre
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        //Marca
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        //Modelo
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed
        //Serie
    }//GEN-LAST:event_txtSerieActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        //Estado
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void btnRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEquipoActionPerformed
   // Botón para registrar EQUIPO
// Validación de campos vacíos antes de continuar
if (txtNombre.getText().isEmpty() || 
    txtMarca.getText().isEmpty() || 
    cmbCategoria.getSelectedItem() == null ||
    txtModelo.getText().isEmpty() || 
    txtSerie.getText().isEmpty() || 
    txtCod.getText().isEmpty() || 
    txtEstado.getText().isEmpty()) {
    
    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de registrar el equipo.");
    return; // Detiene el proceso si algún campo está vacío
}

// Crear un objeto de la clase Equipo con los datos del formulario
String nombre = txtNombre.getText();
String marca = txtMarca.getText();
String categoria = (String) cmbCategoria.getSelectedItem();
String modelo = txtModelo.getText();
String numeroSerie = txtSerie.getText();
String codigoInventario = txtCod.getText();
String estado = txtEstado.getText();

try {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    int idProveedor = proveedorControlador.obtenerIdProveedorPorCategoria(categoria);

    Equipo nuevoEquipo = new Equipo(0, nombre, marca, categoria, modelo, numeroSerie, codigoInventario, estado, idProveedor);

    EquipoControlador equipoControlador = new EquipoControlador();
    equipoControlador.agregarEquipo(nuevoEquipo);

    actualizarTabla();
    limpiarFormulario();
    JOptionPane.showMessageDialog(this, "Equipo registrado exitosamente.");
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error al registrar el equipo.");
}

    }//GEN-LAST:event_btnRegistrarEquipoActionPerformed

    private void btnVerTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTrabajadoresActionPerformed
        jTabbedPane1.setSelectedIndex(6);
        actualizarTablaTrabajadores();
    }//GEN-LAST:event_btnVerTrabajadoresActionPerformed

    private void cmbEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEquipoActionPerformed
        //
    }//GEN-LAST:event_cmbEquipoActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtFechadeOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechadeOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechadeOrdenActionPerformed

    private void btnGuardarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOCActionPerformed
         try {
        // verificar que proveedor y producto esten seleccionados
        if (cmbProveedores.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor.");
            return;
        }

        if (cmbNombres.getSelectedItem() == null) { 
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
            return;
        }

        // recopilacion de datos 
        String fechaOrden = txtFechadeOrden.getText();
        String montoTotal = txtMonto.getText();
        String proveedorSeleccionado = cmbProveedores.getSelectedItem().toString();
        String productoSeleccionado = cmbNombres.getSelectedItem().toString();

        // validaciones
        if (fechaOrden.isEmpty() || montoTotal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos antes de guardar.");
            return;
        }

        // obtener id del proveedor
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);

        //crear nueva orden en la bd
        OrdenCompra nuevaOrden = new OrdenCompra(idProveedor, fechaOrden, Double.parseDouble(montoTotal), productoSeleccionado);

        // uso del controlador
        OrdenCompraControlador controlador = new OrdenCompraControlador();
        controlador.agregarOrdenCompra(nuevaOrden);

        JOptionPane.showMessageDialog(null, "Orden de compra guardada exitosamente.");

        //cargo la tabla y limpio campos
        cargarTablaOrdenCompra(); 
        limpiarFormularioOC();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar la orden de compra en la base de datos.");
    }

    }//GEN-LAST:event_btnGuardarOCActionPerformed

    private void btnGuardarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOSActionPerformed
        gestionarDevolucion();
        cargarTablaOrdenSalida();
        
    }//GEN-LAST:event_btnGuardarOSActionPerformed

    private void txtFechaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaSalidaActionPerformed

    private void txtFecharecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecharecepcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecharecepcionActionPerformed

    private void btnGuardarGuiaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGuiaRActionPerformed
        gestionarGuiaRemision();
        cargarTablaGuiaRemision();
    }//GEN-LAST:event_btnGuardarGuiaRActionPerformed

    private void btnVerGuiaRemisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerGuiaRemisionActionPerformed
        int filaSeleccionada = tblGuiaRemision.getSelectedRow(); // Fila seleccionada

    if (filaSeleccionada == -1) {
        // Si no hay fila seleccionada, mostrar mensaje
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
        return; // Salir para que pueda seleccionar
    }

    // Obtener los datos de la fila seleccionada
    //int idGuia = Integer.parseInt(tblGuiaRemision.getValueAt(filaSeleccionada, 0).toString());
    int idOrdenCompra = Integer.parseInt(tblGuiaRemision.getValueAt(filaSeleccionada, 0).toString());
    String fechaOrdenCompra = tblGuiaRemision.getValueAt(filaSeleccionada, 1).toString();
    String nombreProveedor = tblGuiaRemision.getValueAt(filaSeleccionada, 2).toString();
    String fechaRecepcion = tblGuiaRemision.getValueAt(filaSeleccionada, 3).toString();
    String comentarios = tblGuiaRemision.getValueAt(filaSeleccionada, 4).toString();

    // Crear una nueva instancia de GuiaRemision con los datos del constructor
    GuiaRemision guiaRemision = new GuiaRemision(idOrdenCompra, fechaOrdenCompra, nombreProveedor, fechaRecepcion, comentarios);

    // Abrir pantalla de visualización de guía de remisión
    GuiaRemisionVista guiaRemisionVista = new GuiaRemisionVista(guiaRemision);
    guiaRemisionVista.setVisible(true);
    guiaRemisionVista.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerGuiaRemisionActionPerformed

    private void btnNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificacionesActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnNotificacionesActionPerformed

    private void btnVolverr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverr1ActionPerformed
       jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnVolverr1ActionPerformed

    private void cmbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedoresActionPerformed
        //cargarProducto(); //que se carguen los productos cada que se muestre el combo box
        cargarNombresEquipos();
    }//GEN-LAST:event_cmbProveedoresActionPerformed

    private void btnVerOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenCActionPerformed
     int filaSeleccionada = tblOrdenC.getSelectedRow(); //fila seleccionada

        if (filaSeleccionada == -1) {
            // si no hay fila seleccionada, mostrar mensaje
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
            return; // salir para que pueda seleccioanr 
        }

        // obtener los datos de la fila seleccionada
        String fechaOrden = tblOrdenC.getValueAt(filaSeleccionada, 0).toString();
        String proveedor = tblOrdenC.getValueAt(filaSeleccionada, 1).toString();
        String producto = tblOrdenC.getValueAt(filaSeleccionada, 2).toString();
        String montoTotal = tblOrdenC.getValueAt(filaSeleccionada, 3).toString();

        // para crear una nueva instancia de OrdenCompra con los datos del contructor
        OrdenCompra ordenCompra = new OrdenCompra(filaSeleccionada, proveedor,fechaOrden, Double.parseDouble(montoTotal), producto);
        // abro pantalla
        OrdenCompraVista ordenCompraVista = new OrdenCompraVista(ordenCompra);
        ordenCompraVista.setVisible(true);
        ordenCompraVista.setLocationRelativeTo(null);
    
    }//GEN-LAST:event_btnVerOrdenCActionPerformed

    private void cmbEquiposDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEquiposDActionPerformed
       actualizarDestino();
       //cargarEquiposDefectuosos();
    }//GEN-LAST:event_cmbEquiposDActionPerformed

    private void cmbTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTrabajadorActionPerformed

    private void btnVerOrdenSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenSActionPerformed
        int filaSeleccionada = tblOrdenSalida.getSelectedRow(); //fila seleccionada

        if (filaSeleccionada == -1) {
            // si no hay fila seleccionada, mostrar mensaje
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
            return; // salir para que pueda seleccioanr 
        }

        // obtener los datos de la fila seleccionada
        String equipo = tblOrdenSalida.getValueAt(filaSeleccionada, 0).toString();
        String destinatario = tblOrdenSalida.getValueAt(filaSeleccionada, 1).toString();
        String fechasalida = tblOrdenSalida.getValueAt(filaSeleccionada, 2).toString();
        String motivo = tblOrdenSalida.getValueAt(filaSeleccionada, 3).toString();

        // para crear una nueva instancia de ordensalida con los datos del contructor
        OrdenSalida ordensalida = new OrdenSalida(filaSeleccionada, filaSeleccionada, equipo, destinatario, fechasalida, motivo);
        // abro pantalla
        OrdenSalidaVista ordenSalidaVista = new OrdenSalidaVista(ordensalida);
        ordenSalidaVista.setVisible(true);
        ordenSalidaVista.setLocationRelativeTo(null);
    
    }//GEN-LAST:event_btnVerOrdenSActionPerformed

    private void cmbOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenCompraActionPerformed
        String selectedText = (String) cmbOrdenCompra.getSelectedItem();

    if (selectedText != null && selectedText.startsWith("Orden N°: ")) {
        try {
            // Extraer el ID de la orden de compra
            int idOrdenCompra = Integer.parseInt(selectedText.replace("Orden N°: ", "").trim());

            // Obtener detalles de la orden de compra
            OrdenCompraControlador ordenCompraControlador = new OrdenCompraControlador();
            OrdenCompra ordenSeleccionada = ordenCompraControlador.obtenerDetallesOrdenCompra(idOrdenCompra);

            if (ordenSeleccionada != null) {
                lblFechaOC.setText(ordenSeleccionada.getFechaOrden()); // Llenar el label de fecha de orden
                ProveedorControlador proveedorControlador = new ProveedorControlador();
                String nombreProveedor = proveedorControlador.obtenerProveedorPorId(ordenSeleccionada.getIdProveedor());
                lblProveedor.setText(nombreProveedor);
            }
        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener detalles de la orden de compra.");
        }
    } else {
        // Limpiar los labels si no hay selección válida
        lblFechaOC.setText("");
        lblProveedor.setText("");
    }
    }//GEN-LAST:event_cmbOrdenCompraActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        String categoriaSeleccionada = (String) cmbCategoria.getSelectedItem();

    try {
        // Llamar al controlador para obtener el nombre del proveedor
        ProveedorControlador proveedorControlador = new ProveedorControlador();
        String proveedor = proveedorControlador.obtenerProveedorPorCategoria(categoriaSeleccionada);

        // Mostrar el nombre del proveedor en el JLabel
        lblProveedorR.setText(proveedor != null ? proveedor : "");//sin proveedor

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el proveedor para la categoría seleccionada.");
    }
    }//GEN-LAST:event_cmbCategoriaActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PAsignar;
    private javax.swing.JPanel PCompra;
    private javax.swing.JPanel PInventario;
    private javax.swing.JPanel PNotificaciones;
    private javax.swing.JPanel PRegistrar;
    private javax.swing.JPanel PRemision;
    private javax.swing.JPanel PSalida;
    private javax.swing.JPanel PVerTrabajadores;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignarEquipo;
    private javax.swing.JButton btnBuscarTrabajador;
    private javax.swing.JButton btnCS;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnGuardarGuiaR;
    private javax.swing.JButton btnGuardarOC;
    private javax.swing.JButton btnGuardarOS;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnNotificaciones;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarEquipo;
    private javax.swing.JButton btnRemision;
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btnVerGuiaRemision;
    private javax.swing.JButton btnVerOrdenAsignacion;
    private javax.swing.JButton btnVerOrdenC;
    private javax.swing.JButton btnVerOrdenS;
    private javax.swing.JButton btnVerTrabajadores;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolverr;
    private javax.swing.JButton btnVolverr1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEquipo;
    private javax.swing.JComboBox<String> cmbEquiposD;
    private javax.swing.JComboBox<String> cmbNombres;
    private javax.swing.JComboBox<String> cmbOrdenCompra;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JComboBox<String> cmbTrabajador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jtxtComentarios;
    private javax.swing.JTextArea jtxtMotivo;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFechaOC;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblProveedorR;
    private javax.swing.JLabel lblSaludo;
    private javax.swing.JTable tblAsignacion;
    private javax.swing.JTable tblEquipos;
    private javax.swing.JTable tblEquipos1;
    private javax.swing.JTable tblGuiaRemision;
    private javax.swing.JTable tblOrdenC;
    private javax.swing.JTable tblOrdenSalida;
    private javax.swing.JTable tblTrabajadores;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscarTrabajador;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtFechadeOrden;
    private javax.swing.JTextField txtFecharecepcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
