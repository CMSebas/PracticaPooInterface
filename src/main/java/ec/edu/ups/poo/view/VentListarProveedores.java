package ec.edu.ups.poo.view;

import ec.edu.ups.poo.controllers.Controller;
import ec.edu.ups.poo.models.Proveedor;

import java.awt.*;
import java.awt.event.*;

public class VentListarProveedores extends Frame {
    private Ventana1 ventanaPrincipal;
    private Controller controller;
    private Panel panelConPadding;
    private Label titulo;
    private TextArea textArea;
    private Button botonVolver;
    private Panel panelBoton;

    public VentListarProveedores(Controller controller, Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.controller = controller;

        setTitle("Listado de Proveedores");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        titulo = new Label("LISTADO DE PROVEEDORES", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);


        textArea = new TextArea();

        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.ITALIC, 13));

        for (Proveedor p : controller.getProveedores()) {
            textArea.append(p.toString() + "\n\n");
        }


        panelConPadding = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding.add(textArea);
        add(panelConPadding, BorderLayout.CENTER);


        botonVolver = new Button("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ventanaPrincipal.setVisible(true);
            }
        });

        panelBoton = new Panel();
        panelBoton.add(botonVolver);
        add(panelBoton, BorderLayout.SOUTH);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }
}