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
import DAO.NotificacionDAO;
import Modelo.Encargado;
import Modelo.Equipo;
import Modelo.OrdenAsignacion;
import Modelo.OrdenCompra;
import Modelo.OrdenSalida;
import Modelo.Proveedor;
import Modelo.Trabajador;
import Modelo.GuiaRemision;
import Modelo.Notificacion;
import Modelo.ProductoOrden;
import controlador.EquipoControlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                //cambioss equipo.getModelo(),
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
    private void cargarTabla1() {
    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.obtenerEquiposConProveedor(); // Cambia a obtenerEquiposConProveedor
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos2.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                //cambioss equipo.getModelo(),
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
                //equipo.getModelo(),
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
                //equipo.getModelo(),
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
    private void actualizarTabla1() {
    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.obtenerEquipos();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos2.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                //equipo.getModelo(),
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
    try {
        TrabajadorControlador trabajadorControlador = new TrabajadorControlador();
        List<Trabajador> listaTrabajadores = trabajadorControlador.obtenerTrabajadores();

        DefaultTableModel modeloTabla = (DefaultTableModel) tblTrabajadores.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (Trabajador trabajador : listaTrabajadores) {
            Object[] fila = {
                trabajador.getNombre(),
                trabajador.getDNI(),
                trabajador.getTelefono(),
                trabajador.getCorreo(),
                trabajador.getEquipos() //para equipos asignados
            };
            modeloTabla.addRow(fila); // Agregar fila
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

    
    private void limpiarFormulario() {
        // cambios txtCod.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        cmbCategoria.setSelectedIndex(-1);  
        // cambioss txtModelo.setText("");
     // cambioss   txtSerie.setText("");
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
        // Obtener la lista de equipos defectuosos desde el controlador
        List<Equipo> equiposDefectuosos = equipoControlador.obtenerEquiposDefectuosos();
        cmbEquiposD.removeAllItems();  // limpio cmb
        //lleno cmb con los NOMBRES de los equipos defectuosos
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
//    private void cargarProveedores() {
//    ProveedorControlador proveedorControlador = new ProveedorControlador();
//    try {
//        List<Proveedor> proveedores = proveedorControlador.obtenerTodosLosProveedores();
//        cmbProveedores.removeAllItems(); // Limpiar el combo antes de llenarlo
//
//        for (Proveedor proveedor : proveedores) {
//            cmbProveedores.addItem(proveedor.getNombre()); // Llenar combo de proveedores
//        }
//        
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al cargar los proveedores.");
//    }
//}
//    private void cargarNombresEquipos() {
//    ProveedorControlador proveedorControlador = new ProveedorControlador();
//    
//    // Verifica si hay un proveedor seleccionado en cmbProveedores
//    if (cmbProveedores.getSelectedItem() == null) {
//        cmbNombres.removeAllItems(); // Limpiar cmbNombres si no hay proveedor seleccionado
//        return;
//    }
//
//    try {
//        // Obtén el nombre del proveedor seleccionado y su ID
//        String proveedorSeleccionado = cmbProveedores.getSelectedItem().toString();
//        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);
//
//        // Obtén la lista de nombres de equipos para el proveedor seleccionado
//        List<String> nombresEquipos = proveedorControlador.obtenerNombresEquiposPorProveedor(idProveedor);
//
//        // Limpia el ComboBox de nombres antes de añadir nuevos elementos
//        cmbNombres.removeAllItems();
//
//        // Rellena el ComboBox cmbNombres con los nombres de equipos
//        for (String nombre : nombresEquipos) {
//            cmbNombres.addItem(nombre);
//        }
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al cargar los nombres de equipos.");
//    }
//}
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
    private void cargarOrdenesCompra1() {
    OrdenCompraControlador ordenCompraControlador = new OrdenCompraControlador();
    try {
        List<OrdenCompra> ordenesCompra = ordenCompraControlador.obtenerTodasLasOrdenes();
        cmbOrdenCompra1.removeAllItems(); // Limpiar el combo antes de llenarlo

        for (OrdenCompra orden : ordenesCompra) {
            cmbOrdenCompra1.addItem("Orden N°: "+orden.getIdOrdenCompra()); // Agrega cada objeto OrdenCompra al combo
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar las órdenes de compra.");
    }
}
//    private void cargarProductosPorOrden(int idOrdenCompra) {
//    try {
//        List<ProductoOrden> productos = OrdenCompraControlador.obtenerProductosPorOrden(idOrdenCompra);
//        // Asumiendo que tienes una tabla o un combo para mostrar productos
//        cmbOrdenCompra.removeAllItems();
//
//        for (ProductoOrden producto : productos) {
//            model.addRow(new Object[]{producto.getNombreProducto(), producto.getCantidad()});
//        }
//        
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al cargar los productos de la orden.");
//    }
//}

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
//private void cargarProducto() {
//    ProveedorControlador proveedorControlador = new ProveedorControlador();
//    
//    // para que provedores no sea nulo y tenga un elemento selecionado por defecto
//    if (cmbProveedores.getSelectedItem() == null) {
//        cmbNombres.setSelectedIndex(-1); // limpiar lbl si no hay proveedor seleccionado
//        return; 
//    }
//    
//    try {
//        // obtengo el id del proveedor seleccionado
//        String proveedorSeleccionado = cmbProveedores.getSelectedItem().toString();
//        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);
//
//        //cada provedor provee un tipo de producto 
//        String producto = proveedorControlador.obtenerProductosPorProveedor(idProveedor); 
//
//        // rellena lbl 
//        //lblProducto.setText(producto); 
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al cargar el producto.");
//    }
//}
//
////------------
//    private void limpiarFormularioOC() {
//    txtFechadeOrden.setText("");
//    txtMonto.setText("");
//    cmbProveedores.setSelectedIndex(-1);
//    cmbNombres.setSelectedIndex(-1); 
//}

////private void cargarTablaOrdenCompra() {
////    DefaultTableModel modeloTabla = (DefaultTableModel) tblOrdenC.getModel();
////    modeloTabla.setRowCount(0); // limpio la tbl antes de cargar nuevos datos
////
////    OrdenCompraControlador controlador = new OrdenCompraControlador();
////    ProveedorControlador proveedorControlador = new ProveedorControlador(); // Asegúrate de tener esto
////    try {
////        List<OrdenCompra> ordenes = controlador.obtenerTodasLasOrdenes();
////
////        for (OrdenCompra orden : ordenes) {
////            // obtengo el nombre del proveedor usando su ID
////            String nombreProveedor = proveedorControlador.obtenerProveedorPorId(orden.getIdProveedor());
////
////            Object[] fila = {
////                orden.getFechaOrden(),
////                nombreProveedor,  
////                orden.getNombreProducto(), //modelo
////                orden.getMontoTotal()
////            };
////            modeloTabla.addRow(fila);
////        }
////    } catch (SQLException e) {
////        e.printStackTrace();
////        JOptionPane.showMessageDialog(null, "Error al cargar las órdenes de compra desde la base de datos.");
////    }
////}
    
    private void cargarTablaOrdenCompra() {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblOrdenC.getModel();
    modeloTabla.setRowCount(0); // limpio la tabla antes de cargar nuevos datos

    OrdenCompraControlador controlador = new OrdenCompraControlador();
    ProveedorControlador proveedorControlador = new ProveedorControlador(); // Asegúrate de tener esto
    
    try {
        List<OrdenCompra> ordenes = controlador.obtenerTodasLasOrdenes();

        for (OrdenCompra orden : ordenes) {
            // Obtengo el nombre del proveedor usando su ID
            //String nombreProveedor = proveedorControlador.obtenerProveedorPorId(orden.getIdProveedor());

            // Itero sobre cada producto en la orden
            for (ProductoOrden producto : orden.getProductos()) {
                Object[] fila = {
                    orden.getFechaOrden(),     // Fecha de la orden
                    orden.getIdProveedor(),           // Nombre del proveedor
                    producto.getNombreProducto(), // Nombre del producto
                    producto.getCantidad()       // Cantidad del producto
                };
                modeloTabla.addRow(fila); // Agrego una fila por cada producto
            }
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
        // verificación de selección de equipo defectuoso
        if (cmbEquiposD.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un equipo defectuoso.");
            return;
        }

        EquipoControlador equipoControlador = new EquipoControlador();
        ProveedorControlador proveedorControlador = new ProveedorControlador();

        // obtener el id y el nombre del equipo defectuoso seleccionado
        String nombreEquipo = cmbEquiposD.getSelectedItem().toString();
        int idEquipo = equipoControlador.obtenerIdEquipoPorNombre(nombreEquipo);

        // obtener el nombre del proveedor asociado al equipo defectuoso
        String nombreProveedor = proveedorControlador.obtenerNombreProveedorPorEquipo(idEquipo);
        lblDestino.setText(nombreProveedor);

        // verificar que los campos de fecha y motivo no estén vacíos
        String fechaSalida = txtFechaSalida.getText();
        String motivo = jtxtMotivo.getText();

        if (fechaSalida.isEmpty() || motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete los campos de fecha de salida y motivo.");
            return;
        }

        OrdenSalida nuevaOrden = new OrdenSalida(idEquipo, fechaSalida, motivo);
        nuevaOrden.setNombreEquipo(nombreEquipo); // nombre del equipo
        nuevaOrden.setNombreProveedor(nombreProveedor); // nombre del proveedor
        
        OrdenSalidaControlador ordenSalidaControlador = new OrdenSalidaControlador();
        ordenSalidaControlador.agregarOrdenSalida(nuevaOrden);

        // cambiar el estado del equipo 
        equipoControlador.actualizarEstadoEquipo(idEquipo, "En devolución");
        
        // crear la notificación para la salida del equipo
        Notificacion notificacion = new Notificacion();
        
        // asignamos los valores para la notificación usando los valores de nuevaOrden
        notificacion.setIdOrdenSalida(nuevaOrden.getIdOrdenSalida());
        notificacion.setNombre(nombreEquipo + " en devolución");
        notificacion.setMensaje("El equipo " + nombreEquipo + " está siendo enviado con su proveedor: " 
                                + nombreProveedor + " por el siguiente motivo: " + motivo);
        
        // guardar la noti en la bd
        NotificacionDAO.addNotificacion(notificacion);
        
        // obtener todas las notificaciones asociadas a esta orden de salida
        ArrayList<Notificacion> notificaciones = NotificacionDAO.getNotificacionesPorOrdenSalida(nuevaOrden.getIdOrdenSalida());

        // cosntruir el texto de notificaciones para mostrarlo en el jtxt
        StringBuilder textoNotificaciones = new StringBuilder();
        
        for (Notificacion noti : notificaciones) {
            textoNotificaciones.append(noti.getNombre()).append("\n").append(noti.getMensaje()).append("\n\n");
        }

        // asignar el texto
        txtNotificaciones.setText(textoNotificaciones.toString());
        //System.out.println(textoNotificaciones.toString());
        
        JOptionPane.showMessageDialog(null, "Orden de salida guardada exitosamente.");

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
            
            // obtener el id del equipo seleccionado
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
        btnRemision = new javax.swing.JButton();
        btnCS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblSaludo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNotificaciones = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        txtBuscarEquipo = new javax.swing.JTextField();
        btnBuscarEquipoI = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnRegistrarVarios = new javax.swing.JButton();
        PCompra = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblOrdenC = new javax.swing.JTable();
        btnVerOrdenC = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
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
        txtBuscarTrabajador = new javax.swing.JTextField();
        btnBuscarEquipo = new javax.swing.JButton();
        btnRefrescar1 = new javax.swing.JButton();
        PNotificaciones = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtNotificaciones = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cmbNombres1 = new javax.swing.JComboBox<>();
        cmbProveedores1 = new javax.swing.JComboBox<>();
        txtFechadeOrden1 = new javax.swing.JTextField();
        btnGuardarOC1 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblAgregarOC = new javax.swing.JTable();
        btnVerOrdenC1 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        spinnerCantidad = new javax.swing.JSpinner();
        btnLimpiar = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtEstado1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        cmbOrdenCompra1 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        lblNombreR = new javax.swing.JLabel();
        lblProveedorR1 = new javax.swing.JLabel();
        lblCategoriaR = new javax.swing.JLabel();
        lblMarcaR = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblEquipos2 = new javax.swing.JTable();
        btnRegistrarEquipo1 = new javax.swing.JButton();

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInventario)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemision)
                        .addGap(48, 48, 48)
                        .addComponent(btnSalida))
                    .addComponent(lblSaludo, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCS)
                    .addComponent(btnNotificaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
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
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInventario)
                            .addComponent(btnRemision)
                            .addComponent(btnCS)
                            .addComponent(btnSalida)
                            .addComponent(jButton1))))
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Categoria", "Serie", "Estado"
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

        btnBuscarEquipoI.setText("Buscar ");
        btnBuscarEquipoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipoIActionPerformed(evt);
            }
        });

        btnRefrescar.setText("Limpiar búsqueda");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnRegistrarVarios.setText("Registrar Pedido");
        btnRegistrarVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnVerTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(btnRegistrarVarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarEquipoI)
                        .addGap(30, 30, 30)
                        .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarEquipoI)
                        .addComponent(btnRefrescar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btnRegistrarVarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(37, 37, 37)
                        .addComponent(btnAsignar)
                        .addGap(41, 41, 41)
                        .addComponent(btnVerTrabajadores)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
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
        jLabel19.setText("Registro de órdenes de compra");

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
        if (tblOrdenC.getColumnModel().getColumnCount() > 0) {
            tblOrdenC.getColumnModel().getColumn(3).setHeaderValue("Cantidad");
        }

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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addComponent(btnVerOrdenC))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(180, 215, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnVerOrdenC)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Marca:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Categoría:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Estado:");

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

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnRegistrarEquipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarEquipo.setText("Registrar");
        btnRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEquipoActionPerformed(evt);
            }
        });

        tblEquipos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Categoria", "Serie", "Estado", "Proveedor"
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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblProveedorR, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnVolverr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrarEquipo)
                                .addGap(105, 105, 105)))))
                .addGap(14, 14, 14))
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(lblProveedorR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarEquipo)
                            .addComponent(btnVolverr))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PRegistrarLayout = new javax.swing.GroupLayout(PRegistrar);
        PRegistrar.setLayout(PRegistrarLayout);
        PRegistrarLayout.setHorizontalGroup(
            PRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRegistrarLayout.setVerticalGroup(
            PRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PRegistrarLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Correo", "Equipo/s"
            }
        ));
        jScrollPane4.setViewportView(tblTrabajadores);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Trabajadores:");

        btnBuscarEquipo.setText("Buscar equipo");
        btnBuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEquipoActionPerformed(evt);
            }
        });

        btnRefrescar1.setText("Limpiar búsqueda");
        btnRefrescar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescar1ActionPerformed(evt);
            }
        });

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
                        .addGap(88, 88, 88)
                        .addComponent(txtBuscarTrabajador)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefrescar1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverr1)
                .addGap(385, 385, 385))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtBuscarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar1))
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

        txtNotificaciones.setColumns(20);
        txtNotificaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNotificaciones.setRows(5);
        jScrollPane9.setViewportView(txtNotificaciones);

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
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
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

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Orden de compra");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Fecha de Orden:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Proveedor:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Producto:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Cantidad:");

        cmbProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedores1ActionPerformed(evt);
            }
        });

        txtFechadeOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechadeOrden1ActionPerformed(evt);
            }
        });

        btnGuardarOC1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarOC1.setText("Guardar Orden de compra");
        btnGuardarOC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOC1ActionPerformed(evt);
            }
        });

        tblAgregarOC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha de Orden", "Proveedor", "Producto", "Cantidad"
            }
        ));
        jScrollPane11.setViewportView(tblAgregarOC);

        btnVerOrdenC1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerOrdenC1.setText("Ver órdenes de compra");
        btnVerOrdenC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerOrdenC1ActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar selecciones");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerOrdenC1)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbNombres1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechadeOrden1)
                            .addComponent(cmbProveedores1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarOC1)))
                .addGap(47, 47, 47))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(cmbNombres1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVerOrdenC1)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtFechadeOrden1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(cmbProveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnGuardarOC1)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab9", jPanel10);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Registrar un nuevo equipo");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Proveedor:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Marca:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Estado:");

        txtEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Orden de Compra:");

        cmbOrdenCompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrdenCompra1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Categoría:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Cantidad:");

        tblEquipos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Marca", "Categoria", "Serie", "Estado", "Proveedor"
            }
        ));
        jScrollPane12.setViewportView(tblEquipos2);

        btnRegistrarEquipo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarEquipo1.setText("Registrar");
        btnRegistrarEquipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEquipo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(81, 81, 81)
                                                .addComponent(lblMarcaR, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)))
                                        .addGap(56, 56, 56)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCategoriaR, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblProveedorR1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbOrdenCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addComponent(btnRegistrarEquipo1)
                                .addGap(94, 94, 94))))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel43)
                                    .addComponent(cmbOrdenCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblNombreR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(lblMarcaR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(lblCategoriaR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42)
                                    .addComponent(lblProveedorR1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarEquipo1)
                        .addGap(58, 58, 58))))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab10", jPanel13);

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
        // cerrar la ventana actual
        this.dispose();

        // crear una instancia de la ventana de login
        Login lg = new Login();

        // hacer la ventana de login visible
        lg.setVisible(true);

        // centrar la ventana de login
        lg.setLocationRelativeTo(null);

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
        
        gestionarAsignacion();
        cargarTablaAsignacion();
        //limpiarFormAsignacion();
        cargarEquiposDisponibles(); //orden al final
        
    }//GEN-LAST:event_btnAsignarEquipoActionPerformed

    private void btnVerOrdenAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenAsignacionActionPerformed
        int filaSeleccionada = tblAsignacion.getSelectedRow(); // Fila seleccionada

    if (filaSeleccionada == -1) {
        // Si no hay fila seleccionada, mostrar mensaje
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
        return; // Salir para que el usuario pueda seleccionar
    }

    // Obtener los datos de la fila seleccionada
    String equipo = tblAsignacion.getValueAt(filaSeleccionada, 0).toString();
    String trabajador = tblAsignacion.getValueAt(filaSeleccionada, 1).toString();
    String fecha = tblAsignacion.getValueAt(filaSeleccionada, 2).toString();
    String area = tblAsignacion.getValueAt(filaSeleccionada, 3).toString();

    // Crear una nueva instancia de OrdenAsignacion con los datos obtenidos
    OrdenAsignacion ordenAsignacion = new OrdenAsignacion(filaSeleccionada, fecha, area, trabajador, equipo);
       
    //abrir pantalla de la vista
    OrdenAsignacionVista ordenAsignacionVista = new OrdenAsignacionVista(ordenAsignacion);
    ordenAsignacionVista.setVisible(true);
    ordenAsignacionVista.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnVerOrdenAsignacionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVolverrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverrActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        cargarTablaI();
    }//GEN-LAST:event_btnVolverrActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        //Nombre
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        //Marca
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        //Estado
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void btnRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEquipoActionPerformed
   // Botón para registrar EQUIPO
// Validación de campos vacíos antes de continuar
if (txtNombre.getText().isEmpty() || 
    txtMarca.getText().isEmpty() || 
    cmbCategoria.getSelectedItem() == null ||
    //txtModelo.getText().isEmpty() || 
    //txtSerie.getText().isEmpty() || cambioss
    //txtCod.getText().isEmpty() || cambioss
    txtEstado.getText().isEmpty()) {
    
    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de registrar el equipo.");
    return; // Detiene el proceso si algún campo está vacío
}

// Crear un objeto de la clase Equipo con los datos del formulario
String nombre = txtNombre.getText();
String marca = txtMarca.getText();
String categoria = (String) cmbCategoria.getSelectedItem();
//String modelo = txtModelo.getText();
//String numeroSerie = txtSerie.getText(); cambioss
//String numeroSerie;
//String codigoInventario ;
//String codigoInventario = txtCod.getText(); cambioss
String estado = txtEstado.getText();

try {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    int idProveedor = proveedorControlador.obtenerIdProveedorPorCategoria(categoria);

    Equipo nuevoEquipo = new Equipo(0, nombre, marca, categoria, estado, idProveedor);

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

    private void btnGuardarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOSActionPerformed
        gestionarDevolucion();
        cargarTablaOrdenSalida();
        cargarEquiposDefectuosos();//nuevp
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
    int idOrdenCompra = Integer.parseInt(tblGuiaRemision.getValueAt(filaSeleccionada, 0).toString());
    String fechaOrdenCompra = tblGuiaRemision.getValueAt(filaSeleccionada, 1).toString();
    String nombreProveedor = tblGuiaRemision.getValueAt(filaSeleccionada, 2).toString();
    String fechaRecepcion = tblGuiaRemision.getValueAt(filaSeleccionada, 3).toString();
    String comentarios = tblGuiaRemision.getValueAt(filaSeleccionada, 4).toString();

    // crear una nueva instancia de GuiaRemision con los datos del constructor
    GuiaRemision guiaRemision = new GuiaRemision(idOrdenCompra, fechaOrdenCompra, nombreProveedor, fechaRecepcion, comentarios);

    // abrir pantalla de visualización de guía de remisión
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

    private void btnVerOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenCActionPerformed
     int filaSeleccionada = tblOrdenC.getSelectedRow(); //fila seleccionada

        if (filaSeleccionada == -1) {
            // si no hay fila seleccionada, mostrar mensaje
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila.");
            return; // salir para que pueda seleccioanr 
        }

        // obtener los datos de la fila seleccionada
        String fechaOrden = tblOrdenC.getValueAt(filaSeleccionada, 0).toString();
        int proveedor = (int)tblOrdenC.getValueAt(filaSeleccionada, 1);
        String producto = tblOrdenC.getValueAt(filaSeleccionada, 2).toString();
        int cantidad = (int)tblOrdenC.getValueAt(filaSeleccionada, 3);

        // para crear una nueva instancia de OrdenCompra con los datos del contructor
        OrdenCompra ordenCompra = new OrdenCompra(filaSeleccionada, fechaOrden, proveedor);
        ProductoOrden productoorden = new ProductoOrden(producto, cantidad);
        // abro pantalla
        OrdenCompraVista ordenCompraVista = new OrdenCompraVista(ordenCompra, productoorden);
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
            int idOrdenCompra = Integer.parseInt(selectedText.replace("Orden N°: ", "").trim());

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

        lblProveedorR.setText(proveedor != null ? proveedor : "");//sin proveedor

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el proveedor para la categoría seleccionada.");
    }
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnBuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipoActionPerformed
        String nombreEquipo = txtBuscarTrabajador.getText().trim();

    if (nombreEquipo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre de un equipo para buscar.");
        return;
    }

    try {
        TrabajadorControlador trabajadorControlador = new TrabajadorControlador();
        List<Trabajador> listaTrabajadores = trabajadorControlador.buscarTrabajadoresPorEquipo(nombreEquipo);

        DefaultTableModel modeloTabla = (DefaultTableModel) tblTrabajadores.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (Trabajador trabajador : listaTrabajadores) {
            Object[] fila = {
                trabajador.getNombre(),
                trabajador.getDNI(),
                trabajador.getTelefono(),
                trabajador.getCorreo(),
                trabajador.getEquipos() 
            };
            modeloTabla.addRow(fila); 
        }
        txtBuscarTrabajador.setText("");
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al buscar trabajadores por equipo.");
    }
    }//GEN-LAST:event_btnBuscarEquipoActionPerformed

    private void btnBuscarEquipoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEquipoIActionPerformed
         String criterio = txtBuscarEquipo.getText().trim();

    if (criterio.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un criterio de búsqueda.");
        return;
    }

    try {
        EquipoControlador equipoControlador = new EquipoControlador();
        List<Equipo> listaEquipos = equipoControlador.buscarEquipos(criterio);

        DefaultTableModel modeloTabla = (DefaultTableModel) tblEquipos.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        for (Equipo equipo : listaEquipos) {
            Object[] fila = {
                equipo.getCodigoInventario(),
                equipo.getNombre(),
                equipo.getMarca(),
                equipo.getCategoria(),
                //equipo.getModelo(),
                equipo.getNumeroSerie(),
                equipo.getEstado()
            };
            modeloTabla.addRow(fila); // Agregar fila a la tabla
        }
        txtBuscarEquipo.setText("");//limpia la busqueda
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al buscar equipos.");
    }
    }//GEN-LAST:event_btnBuscarEquipoIActionPerformed
  
private void agregarProducto() {
    String fechaOrden = txtFechadeOrden1.getText(); // Obtener la fecha de orden
    String proveedorNombre = (String) cmbProveedores1.getSelectedItem(); // Obtener proveedor seleccionado
    int idProveedor = proveedorMap.get(proveedorNombre); // Obtener ID del proveedor usando el mapa
    String producto = (String) cmbNombres1.getSelectedItem(); // Obtener producto seleccionado
    int cantidad = (int) spinnerCantidad.getValue(); // Obtener la cantidad del spinner

    // Validar cantidad
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que cero.");
        return;
    }

    // Verificar si el producto ya está en la tabla
    DefaultTableModel model = (DefaultTableModel) tblAgregarOC.getModel();
     DefaultTableModel modeloo = (DefaultTableModel) tblOrdenC.getModel(); //cambioss
    boolean productoExistente = false;

    for (int i = 0; i < model.getRowCount(); i++) {
       Object valorProveedor = model.getValueAt(i, 1); // Proveedor
        Object valorProducto = model.getValueAt(i, 2); // Producto

        if (valorProveedor != null && valorProducto != null) {
            // Comparar solo si los valores no son null
            if (valorProducto.equals(producto) && valorProveedor.equals(idProveedor)) {
                int nuevaCantidad = (int) model.getValueAt(i, 3) + cantidad; // Actualizar cantidad
                model.setValueAt(nuevaCantidad, i, 3); // Actualizar cantidad
                productoExistente = true;
                break; // Salir del bucle una vez que se ha encontrado el producto
            }
        }
    }
    // Si no existe el producto, agregar uno nuevo a la tabla
    if (!productoExistente) {
        model.addRow(new Object[]{fechaOrden, idProveedor, producto, cantidad}); 
        modeloo.addRow(new Object[]{fechaOrden, idProveedor, producto, cantidad});
    }

    // Reiniciar campos
    cmbProveedores1.setSelectedIndex(-1); 
    cmbNombres1.setSelectedIndex(-1);
    spinnerCantidad.setValue(0); 
}


// Método para guardar la orden de compra
private void guardarOrdenCompra() {
    DefaultTableModel model = (DefaultTableModel) tblAgregarOC.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        String proveedor = (String) model.getValueAt(i, 1);
        String producto = (String) model.getValueAt(i, 2);
        int cantidad = (int) model.getValueAt(i, 4);

        
    }

    // Limpiar la tabla después de guardar
    model.setRowCount(0);
}

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarTablaI();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnRefrescar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescar1ActionPerformed
        actualizarTablaTrabajadores();
    }//GEN-LAST:event_btnRefrescar1ActionPerformed

    private void cmbProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedores1ActionPerformed
       cargarNombresEquipos1();
    }//GEN-LAST:event_cmbProveedores1ActionPerformed

    private void txtFechadeOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechadeOrden1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechadeOrden1ActionPerformed

    private void btnGuardarOC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOC1ActionPerformed
         try {
        // Validar que hay productos en tblAgregarOC
        if (tblAgregarOC.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe agregar al menos un producto a la orden.");
            return;
        }

        // Obtener la fecha de la orden
        String fechaOrden = txtFechadeOrden1.getText(); 

        // Crear una lista para almacenar los productos de la orden
        List<ProductoOrden> listaProductos = new ArrayList<>();
        int idProveedor = -1; // Suponiendo que solo hay un proveedor por orden

        for (int i = 0; i < tblAgregarOC.getRowCount(); i++) {
            if (idProveedor == -1) {
                idProveedor = (int) tblAgregarOC.getValueAt(i, 1); 
            }
            String nombreProducto = (String) tblAgregarOC.getValueAt(i, 2); 
            int cantidad = (int) tblAgregarOC.getValueAt(i, 3); 

            // Crear un nuevo producto y agregarlo a la lista
            listaProductos.add(new ProductoOrden(nombreProducto, cantidad));
        }

        // crear la nueva orden de compra
        OrdenCompra nuevaOrden = new OrdenCompra(fechaOrden, idProveedor, listaProductos);

        // uso del controlador y DAO
        OrdenCompraControlador controlador = new OrdenCompraControlador();
        controlador.agregarOrdenCompra(nuevaOrden);
        
        //carga la tabla de ordenes registradas
        cargarTablaOrdenCompra(); 
        // Limpiar la tabla después de guardar
        txtFechadeOrden1.setText("");
    DefaultTableModel model = (DefaultTableModel) tblAgregarOC.getModel();
    model.setRowCount(0); // Esto limpia todas las filas de la tabla
    
        JOptionPane.showMessageDialog(null, "Orden de compra guardada exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al guardar la orden de compra en la base de datos.");
    }
    }//GEN-LAST:event_btnGuardarOC1ActionPerformed
    
    private void btnVerOrdenC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerOrdenC1ActionPerformed
       jTabbedPane1.setSelectedIndex(1);
       cargarTablaOrdenCompra(); 
    }//GEN-LAST:event_btnVerOrdenC1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       agregarProducto();
    }//GEN-LAST:event_btnAgregarActionPerformed
//    private void cargarProveedores1() {
//    ProveedorControlador proveedorControlador = new ProveedorControlador();
//    try {
//        List<Proveedor> proveedores = proveedorControlador.obtenerTodosLosProveedores();
//        cmbProveedores1.removeAllItems(); // Limpiar el combo antes de llenarlo
//
//        for (Proveedor proveedor : proveedores) {
//            cmbProveedores1.addItem(proveedor.getNombre()); // Llenar combo de proveedores
//        }
//        
//    } catch (SQLException e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al cargar los proveedores.");
//    }
//}
////    private void cargarProveedores1() {
////    ProveedorControlador proveedorControlador = new ProveedorControlador();
////    try {
////        List<Proveedor> proveedores = proveedorControlador.obtenerTodosLosProveedores();
////        cmbProveedores1.removeAllItems(); // Limpiar el combo antes de llenarlo
////
////        for (Proveedor proveedor : proveedores) {
////            cmbProveedores1.addItem(proveedor); // Llenar el combo con el objeto Proveedor completo
////        }
////        
////    } catch (SQLException e) {
////        e.printStackTrace();
////        JOptionPane.showMessageDialog(null, "Error al cargar los proveedores.");
////    }
////}
    private Map<String, Integer> proveedorMap = new HashMap<>();

private void cargarProveedores1() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    try {
        List<Proveedor> proveedores = proveedorControlador.obtenerTodosLosProveedores();
        cmbProveedores1.removeAllItems(); // Limpiar el combo antes de llenarlo
        proveedorMap.clear(); // Limpiar el mapa antes de llenarlo

        for (Proveedor proveedor : proveedores) {
            cmbProveedores1.addItem(proveedor.getNombre()); // Agregar solo el nombre del proveedor
            proveedorMap.put(proveedor.getNombre(), proveedor.getIdProveedor()); // Guardar el mapeo
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los proveedores.");
    }
}



    private void cargarNombresEquipos1() {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    
    if (cmbProveedores1.getSelectedItem() == null) {
        cmbNombres1.removeAllItems(); 
        return;
    }

    try {
        // obtener el nombre del proveedor seleccionado y su ID
        String proveedorSeleccionado = cmbProveedores1.getSelectedItem().toString();
        int idProveedor = proveedorControlador.obtenerIdProveedorPorNombre(proveedorSeleccionado);

        List<String> nombresEquipos = proveedorControlador.obtenerNombresEquiposPorProveedor(idProveedor);

        cmbNombres1.removeAllItems();

        for (String nombre : nombresEquipos) {
            cmbNombres1.addItem(nombre);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al cargar los nombres de equipos.");
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jTabbedPane1.setSelectedIndex(8);
       cargarProveedores1();
       cmbProveedores1.setSelectedIndex(-1);
       cmbNombres1.setSelectedIndex(-1);
       DefaultTableModel model = (DefaultTableModel) tblAgregarOC.getModel();
       model.setRowCount(0); 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado1ActionPerformed

    private void cmbOrdenCompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrdenCompra1ActionPerformed
         String selectedText = (String) cmbOrdenCompra1.getSelectedItem();

if (selectedText != null && selectedText.startsWith("Orden N°: ")) {
    try {
        // extraer el id de la orden de compra
        int idOrdenCompra = Integer.parseInt(selectedText.replace("Orden N°: ", "").trim());

        OrdenCompraControlador ordenCompraControlador = new OrdenCompraControlador();
        OrdenCompra ordenSeleccionada = ordenCompraControlador.obtenerOrdenPorId(idOrdenCompra); 

        if (ordenSeleccionada != null) {
            
            //obtener el proveedor
            ProveedorControlador proveedorControlador = new ProveedorControlador();
            String nombreProveedor = proveedorControlador.obtenerProveedorPorId(ordenSeleccionada.getIdProveedor());
            lblProveedorR1.setText(nombreProveedor);

            // obtener el nombre del producto y dividirlo en palabras
            String nombreProducto = ordenSeleccionada.obtenerNombreProducto();
            lblNombreR.setText(nombreProducto);
            if (nombreProducto != null) {
                String[] partesNombre = nombreProducto.split(" ");
                if (partesNombre.length > 0) {
                    lblCategoriaR.setText(partesNombre[0]); // primera palabra como categoría
                }
                if (partesNombre.length > 1) {
                    lblMarcaR.setText(partesNombre[1]); // segunda palabra como marca
                }
                
            }
            int cantidadProducto = ordenSeleccionada.obtenerCantidadProducto();
            lblCantidad.setText(String.valueOf(cantidadProducto));
           
            txtEstado1.setText("Disponible"); 
            
        }
    } catch (NumberFormatException | SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener detalles de la orden de compra.");
    }
} else {
    // Limpiar los labels si no hay selección válida
    lblNombreR.setText("");
    lblProveedorR1.setText("");
    lblMarcaR.setText("");
    lblCategoriaR.setText("");
    txtEstado1.setText("");
    lblCantidad.setText("");
}

    }//GEN-LAST:event_cmbOrdenCompra1ActionPerformed

    private void btnRegistrarVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVariosActionPerformed
        jTabbedPane1.setSelectedIndex(9);
        cargarTabla1();
        cargarOrdenesCompra1();
        cmbOrdenCompra1.setSelectedIndex(-1);
        
        
    }//GEN-LAST:event_btnRegistrarVariosActionPerformed

    private void btnRegistrarEquipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEquipo1ActionPerformed
        // Botón para registrar EQUIPO
// Validación de campos vacíos antes de continuar
if (lblNombreR.getText().isEmpty() || 
    lblMarcaR.getText().isEmpty() || 
    lblCategoriaR.getText().isEmpty() || 
    txtEstado1.getText().isEmpty() || 
    lblCantidad.getText().isEmpty() || 
    lblProveedorR1.getText().isEmpty()) {
    
    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de registrar el equipo.");
    return; 
}


String nombre = lblNombreR.getText();
String marca = lblMarcaR.getText();
String categoria = lblCategoriaR.getText();
String estado = txtEstado1.getText(); 
int cantidad;

try {
    
    cantidad = Integer.parseInt(lblCantidad.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.");
    return; // Detiene el proceso si la cantidad no es válida
}

// obtener el ID del proveedor usando el nombre en lblProveedorR1
try {
    ProveedorControlador proveedorControlador = new ProveedorControlador();
    int idProveedor = proveedorControlador.obtenerIdProveedorPorCategoria(categoria);

   for (int i = 0; i < cantidad; i++) {
        Equipo nuevoEquipo = new Equipo(0, nombre, marca, categoria, estado, idProveedor);
       
    EquipoControlador equipoControlador = new EquipoControlador();
    equipoControlador.agregarEquipo(nuevoEquipo);
    }

      actualizarTabla1();
    cmbOrdenCompra1.setSelectedIndex(-1);
    JOptionPane.showMessageDialog(this, "Equipos registrados exitosamente.");
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error al registrar los equipos.");
}
    

  

    }//GEN-LAST:event_btnRegistrarEquipo1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblAgregarOC.getModel();
    model.setRowCount(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed
    

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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignarEquipo;
    private javax.swing.JButton btnBuscarEquipo;
    private javax.swing.JButton btnBuscarEquipoI;
    private javax.swing.JButton btnCS;
    private javax.swing.JButton btnGuardarGuiaR;
    private javax.swing.JButton btnGuardarOC1;
    private javax.swing.JButton btnGuardarOS;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNotificaciones;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRefrescar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarEquipo;
    private javax.swing.JButton btnRegistrarEquipo1;
    private javax.swing.JButton btnRegistrarVarios;
    private javax.swing.JButton btnRemision;
    private javax.swing.JButton btnSalida;
    private javax.swing.JButton btnVerGuiaRemision;
    private javax.swing.JButton btnVerOrdenAsignacion;
    private javax.swing.JButton btnVerOrdenC;
    private javax.swing.JButton btnVerOrdenC1;
    private javax.swing.JButton btnVerOrdenS;
    private javax.swing.JButton btnVerTrabajadores;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVolverr;
    private javax.swing.JButton btnVolverr1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEquipo;
    private javax.swing.JComboBox<String> cmbEquiposD;
    private javax.swing.JComboBox<String> cmbNombres1;
    private javax.swing.JComboBox<String> cmbOrdenCompra;
    private javax.swing.JComboBox<String> cmbOrdenCompra1;
    private javax.swing.JComboBox<String> cmbProveedores1;
    private javax.swing.JComboBox<String> cmbTrabajador;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
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
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jtxtComentarios;
    private javax.swing.JTextArea jtxtMotivo;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoriaR;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFechaOC;
    private javax.swing.JLabel lblMarcaR;
    private javax.swing.JLabel lblNombreR;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblProveedorR;
    private javax.swing.JLabel lblProveedorR1;
    private javax.swing.JLabel lblSaludo;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTable tblAgregarOC;
    private javax.swing.JTable tblAsignacion;
    private javax.swing.JTable tblEquipos;
    private javax.swing.JTable tblEquipos1;
    private javax.swing.JTable tblEquipos2;
    private javax.swing.JTable tblGuiaRemision;
    private javax.swing.JTable tblOrdenC;
    private javax.swing.JTable tblOrdenSalida;
    private javax.swing.JTable tblTrabajadores;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscarEquipo;
    private javax.swing.JTextField txtBuscarTrabajador;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstado1;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtFechadeOrden1;
    private javax.swing.JTextField txtFecharecepcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtNotificaciones;
    // End of variables declaration//GEN-END:variables
}
