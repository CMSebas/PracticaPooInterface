package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Empleado;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class VentRegEmp extends Frame implements ActionListener {

    private Ventana1 ventanaPrincipal;
    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelLabels;
    private Panel panelConPadding;
    private Panel panelConPadding2;
    private Panel panelBoton;

    private Label labelNumero1;

    private Button boton1;

    private Label labelNumero2;
    private Label labelNumero3;
    private Label labelNumero4;
    private Label labelNumero5;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;
    private TextField textField4;

    public VentRegEmp(Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registro de Empleado");
        setSize(600, 350);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());
        panelTitulo = new Panel();
        panelLabels = new Panel(new GridLayout(4, 2, 10, 10));
        panelBoton = new Panel(new FlowLayout());

        panelConPadding = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding.add(panelLabels);

        panelConPadding2 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding2.add(panelBoton);

        labelNumero1 = new Label("Registro de empleado");
        labelNumero1.setFont(new Font("Arial", Font.BOLD, 28));
        panelTitulo.add(labelNumero1);

        labelNumero2 = new Label("Nombre ");
        labelNumero3 = new Label("Cédula ");
        labelNumero4 = new Label("Cargo ");
        labelNumero5 = new Label("Departamento ");

        textField1 = new TextField("", 10);
        textField2 = new TextField("", 10);
        textField3 = new TextField("", 10);
        textField4 = new TextField("", 10);

        panelLabels.add(labelNumero2);
        panelLabels.add(textField1);
        panelLabels.add(labelNumero3);
        panelLabels.add(textField2);
        panelLabels.add(labelNumero4);
        panelLabels.add(textField3);
        panelLabels.add(labelNumero5);
        panelLabels.add(textField4);

        boton1 = new Button("GUARDAR");
        boton1.addActionListener(this);
        panelBoton.add(boton1);

        panelGeneral.add(panelTitulo, BorderLayout.NORTH);
        panelGeneral.add(panelConPadding, BorderLayout.CENTER);
        panelGeneral.add(panelConPadding2, BorderLayout.SOUTH);

        add(panelGeneral);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventanaPrincipal.setVisible(true);
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            String nombre = textField1.getText();
            String cedula = textField2.getText();
            String cargo = textField3.getText();
            String departamento = textField4.getText();

            Empleado empleado = new Empleado(nombre, cedula, cargo, departamento);
            ventanaPrincipal.listaEmpleados.add(empleado);

            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(null, "Empleado guardado con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            ventanaPrincipal.setVisible(true);
            boton1.setVisible(false);
        }
    }
}
