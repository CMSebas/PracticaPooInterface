package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;

public class VentRegSolic extends Frame implements ActionListener {

    private Ventana1 ventanaPrincipal;
    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelEstado;
    private Panel panelFecha;
    private Panel panelDetalles;
    private Panel panelID;
    private Panel panelBoton;

    private Label labelTitulo;
    private Label labelFecha;
    private Label labelDetalles;
    private Label labelID;
    private Label labelMensajeGuardado;

    private TextField textFieldFecha;
    private TextArea textAreaDetalles;
    private TextField textFieldID;

    private CheckboxGroup estadoGroup;
    private Checkbox checkboxAprobado;
    private Checkbox checkboxDesaprobado;

    private Button botonGuardar;

    public VentRegSolic(Ventana1 ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        setTitle("Sistema de Gestión de Inventario");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel principal
        panelGeneral = new Panel(new BorderLayout());

        // Panel título
        panelTitulo = new Panel();
        labelTitulo = new Label("Registro de Solicitud");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panelTitulo.add(labelTitulo);

        // Panel estado (radio buttons)
        panelEstado = new Panel(new FlowLayout());
        estadoGroup = new CheckboxGroup();
        checkboxAprobado = new Checkbox("Aprobado", estadoGroup, false);
        checkboxDesaprobado = new Checkbox("Desaprobado", estadoGroup, false);
        panelEstado.add(new Label("Estado: "));
        panelEstado.add(checkboxAprobado);
        panelEstado.add(checkboxDesaprobado);

        // Panel fecha
        panelFecha = new Panel(new FlowLayout(FlowLayout.LEFT));
        labelFecha = new Label("Fecha (dd/mm/aaaa): ");
        textFieldFecha = new TextField(15);
        panelFecha.add(labelFecha);
        panelFecha.add(textFieldFecha);

        //Panel id
        panelID = new Panel(new FlowLayout(FlowLayout.LEFT));
        labelID = new Label("ID: ");
        textFieldID = new TextField(10); // ¡IMPORTANTE!
        panelID.add(labelID);
        panelID.add(textFieldID);
        // Panel detalles con estilo
        panelDetalles = new Panel(new BorderLayout());
        panelDetalles.setBackground(new Color(245, 245, 245)); // Fondo claro
        panelDetalles.setPreferredSize(new Dimension(400, 150));
        panelDetalles.setLayout(new BorderLayout());

        labelDetalles = new Label("Detalles:");
        labelDetalles.setFont(new Font("Arial", Font.BOLD, 16));
        labelDetalles.setForeground(Color.DARK_GRAY);

        textAreaDetalles = new TextArea(5, 40);
        textAreaDetalles.setFont(new Font("Arial", Font.PLAIN, 14));
        textAreaDetalles.setBackground(Color.WHITE);
        textAreaDetalles.setForeground(Color.BLACK);
        textAreaDetalles.setPreferredSize(new Dimension(380, 100));

        panelDetalles.add(labelDetalles, BorderLayout.NORTH);
        panelDetalles.add(textAreaDetalles, BorderLayout.CENTER);

        // Panel botón
        panelBoton = new Panel(new FlowLayout());
        botonGuardar = new Button("GUARDAR");
        botonGuardar.addActionListener(this);
        panelBoton.add(botonGuardar);

        //Panel mensaje final
        labelMensajeGuardado = new Label("");
        labelMensajeGuardado.setForeground(Color.GREEN);
        panelBoton.add(labelMensajeGuardado);
        // Armar centro
        Panel panelCentro = new Panel(new BorderLayout());
        Panel panelCentroArriba = new Panel(new GridLayout(3, 1));
        panelCentroArriba.add(panelID);
        panelCentroArriba.add(panelEstado);
        panelCentroArriba.add(panelFecha);
        panelCentro.add(panelCentroArriba, BorderLayout.NORTH);
        panelCentro.add(panelDetalles, BorderLayout.CENTER);

        // Agregar todos los paneles al panel general
        panelGeneral.add(panelTitulo, BorderLayout.NORTH);
        panelGeneral.add(panelCentro, BorderLayout.CENTER);
        panelGeneral.add(panelBoton, BorderLayout.SOUTH);

        add(panelGeneral);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonGuardar) {
            String estadoSeleccionado = estadoGroup.getSelectedCheckbox().getLabel();
            String fecha = textFieldFecha.getText();
            String detalles = textAreaDetalles.getText();
            String id = textFieldID.getText();
            System.out.println("ID: "+ id);
            System.out.println("Estado: " + estadoSeleccionado);
            System.out.println("Fecha: " + fecha);
            System.out.println("Detalles: " + detalles);
            labelMensajeGuardado.setText("Solicitud Guardada Con Exito");
            labelMensajeGuardado.setFont(new Font("Arial", Font.BOLD, 16));
            botonGuardar.setVisible(false);
        }
    }
}
