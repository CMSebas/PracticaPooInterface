package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BuscarProvedoID extends Frame implements ActionListener {

    private Ventana1 ventanaPrincipal;
    private Label labelId;
    private TextField textFieldId;
    private Button botonBuscar;

    public BuscarProvedoID(Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Buscar Proveedor por ID");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Panel panelCentro = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));

        labelId = new Label("Ingrese cédula del proveedor:");
        textFieldId = new TextField(15);
        botonBuscar = new Button("Buscar");

        botonBuscar.addActionListener(this);

        panelCentro.add(labelId);
        panelCentro.add(textFieldId);
        panelCentro.add(botonBuscar);

        add(panelCentro, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonBuscar) {
            String cedula = textFieldId.getText().trim();
            List<Proveedor> lista = ventanaPrincipal.getListaProveedores();
            boolean encontrado = false;
            for (Proveedor p : lista) {
                if (p.getCedula().equals(cedula)) {
                    JOptionPane.showMessageDialog(this, "Proveedor encontrado: " + p.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Proveedor con cédula " + cedula + " no encontrado.", "Resultado", JOptionPane.ERROR_MESSAGE);
            }
            this.setVisible(false);
            ventanaPrincipal.setVisible(true);
        }
    }
}
