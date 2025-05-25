package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BuscarProductoID extends Frame implements ActionListener {

    private Ventana1 ventanaPrincipal;
    private Label labelId;
    private TextField textFieldId;
    private Button botonBuscar;

    public BuscarProductoID(Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Buscar Producto por ID");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Panel panelCentro = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));

        labelId = new Label("Ingrese ID del producto:");
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
            String id = textFieldId.getText().trim();
            List<Producto> lista =  ventanaPrincipal.getListaProductos();

            boolean encontrado = false;
            for (Producto producto : lista) {
                if (producto.getIdProducto().equals(id)) {
                    JOptionPane.showMessageDialog(this, "Producto encontrado:\n\n" + producto.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "Producto con ID " + id + " no encontrado.", "Resultado", JOptionPane.ERROR_MESSAGE);
            }

            this.setVisible(false);
            ventanaPrincipal.setVisible(true);
        }
    }
}
