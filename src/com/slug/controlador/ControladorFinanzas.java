package com.slug.controlador;

import javax.swing.JFrame;

import com.slug.vista.Menu;
import com.slug.vista.vista;
import com.slug.vista.vistaFinanzas;
import com.slug.modelo.Finanza;
import com.slug.modelo.FinanzaDAO;
import com.slug.modelo.Persona;
import com.slug.vista.vistaFinanzas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ControladorFinanzas implements ActionListener {

    FinanzaDAO finanzaDAO = new FinanzaDAO();
    Finanza p = new Finanza();
    vistaFinanzas vista = new vistaFinanzas();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorFinanzas(vistaFinanzas vista) {
        this.vista = vista;
        initComponents();
    }

    public ControladorFinanzas(Menu v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initComponents() {
        vista.btnListar.addActionListener(this);
        vista.btnAgregar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnListar) {
            limpiarTabla();
            listar(vista.tabla);
            // nuevo();
        }
        if (e.getSource() == vista.btnAgregar) {
            add();
            listar(vista.tabla);
            // nuevo();
        }
    }

    public void listar(JTable tabla) {
        System.out.println("Listando");
        
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Finanza> lista = finanzaDAO.listar();
        Object[] objeto = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getMonto();
            objeto[2] = lista.get(i).getFecha();
            objeto[3] = lista.get(i).getMetodoPago();
            objeto[4] = lista.get(i).getTipo();
            objeto[5] = lista.get(i).getComentarios();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }


    public void add() {
        System.out.println("Agregando");
        String monto = vista.txtMonto.getText();
        String fecha = vista.txtFecha.getText();
        String tipo = vista.txtTipo.getText();
        String metodo = vista.txtMetodo.getText();
        String comentario = vista.txtComentario.getText();
        p.setMonto(monto);
        p.setFecha(fecha);
        p.setTipo(tipo);
        p.setMetodoPago(metodo);
        p.setComentarios(comentario);
        int r = this.finanzaDAO.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Finanza Agregada con Exito.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
        limpiarTabla();
    }

    private void centrarCeldas(JTable tabla) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    private void limpiarTabla() {
        modelo.setRowCount(0);
    }
}
