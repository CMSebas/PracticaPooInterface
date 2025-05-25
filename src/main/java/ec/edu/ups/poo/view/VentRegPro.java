package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Proveedor;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class VentRegPro extends Frame implements ActionListener {

    private Ventana1 ventanaPrincipal;
    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelLabels;
    private Panel panelConPadding;
    private Panel panelConPadding2;
    private Panel panelBoton;

    private Label labelTitulo;

    private Button botonGuardar;

    private Label labelNombre;
    private Label labelCedula;
    private Label labelEmpresa;
    private Label labelRuc;

    private TextField textFieldNombre;
    private TextField textFieldCedula;
    private TextField textFieldEmpresa;
    private TextField textFieldRuc;

    public VentRegPro(Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registro de Proveedor");
        setSize(600, 250);
        setLocationRelativeTo(null);

        panelGeneral = new Panel(new BorderLayout());
        panelTitulo = new Panel();
        panelLabels = new Panel(new GridLayout(2, 4, 10, 0));
        panelBoton = new Panel(new FlowLayout());

        panelConPadding = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding.add(panelLabels);

        panelConPadding2 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding2.add(panelBoton);

        labelTitulo = new Label("Registro de Proveedor");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panelTitulo.add(labelTitulo);

        labelNombre = new Label("Nombre ");
        labelCedula = new Label("Cédula ");
        labelEmpresa = new Label("Nombre de empresa ");
        labelRuc = new Label("RUC ");

        textFieldNombre = new TextField("", 10);
        textFieldCedula = new TextField("", 10);
        textFieldEmpresa = new TextField("", 10);
        textFieldRuc = new TextField("", 10);

        panelLabels.add(labelNombre);
        panelLabels.add(textFieldNombre);
        panelLabels.add(labelCedula);
        panelLabels.add(textFieldCedula);
        panelLabels.add(labelEmpresa);
        panelLabels.add(textFieldEmpresa);
        panelLabels.add(labelRuc);
        panelLabels.add(textFieldRuc);

        botonGuardar = new Button("GUARDAR");
        botonGuardar.addActionListener(this);
        panelBoton.add(botonGuardar);

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
        if (e.getSource() == botonGuardar) {
            String nombre = textFieldNombre.getText();
            String cedula = textFieldCedula.getText();
            String empresa = textFieldEmpresa.getText();
            String ruc = textFieldRuc.getText();

            Proveedor proveedor  = new Proveedor(nombre, cedula, empresa, ruc);
            ventanaPrincipal.listaProveedores.add(proveedor);

            JOptionPane.showMessageDialog(this, "Proveedor guardado con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            this.setVisible(false);
            ventanaPrincipal.setVisible(true);
            botonGuardar.setVisible(false);
        }
    }
}
