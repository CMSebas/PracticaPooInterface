package ec.edu.ups.poo.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

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
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel principal con borde
        panelGeneral = new Panel(new BorderLayout(10, 10));
        panelGeneral.setBackground(Color.WHITE);
        panelGeneral.setPreferredSize(new Dimension(550, 400));

        // Título
        panelTitulo = new Panel(new FlowLayout(FlowLayout.CENTER));
        labelTitulo = new Label("Registro de Solicitud");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panelTitulo.add(labelTitulo);

        // Panel superior (ID + Fecha)
        Panel panelIDFecha = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        labelID = new Label("ID:");
        textFieldID = new TextField(10);
        labelFecha = new Label("Fecha (dd/mm/aaaa):");
        textFieldFecha = new TextField(15);
        panelIDFecha.add(labelID);
        panelIDFecha.add(textFieldID);
        panelIDFecha.add(labelFecha);
        panelIDFecha.add(textFieldFecha);

        // Panel estado
        panelEstado = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        estadoGroup = new CheckboxGroup();
        checkboxAprobado = new Checkbox("Aprobado", estadoGroup, false);
        checkboxDesaprobado = new Checkbox("Desaprobado", estadoGroup, false);
        panelEstado.add(new Label("Estado: "));
        panelEstado.add(checkboxAprobado);
        panelEstado.add(checkboxDesaprobado);

        // Panel detalles (con bordes y padding visual)
        panelDetalles = new Panel(new BorderLayout(10, 10));
        panelDetalles.setBackground(new Color(245, 245, 245));
        panelDetalles.setPreferredSize(new Dimension(500, 160));
        panelDetalles.setLayout(new BorderLayout(10, 10));

        labelDetalles = new Label("Detalles:");
        labelDetalles.setFont(new Font("Arial", Font.BOLD, 16));
        labelDetalles.setForeground(Color.DARK_GRAY);
        textAreaDetalles = new TextArea(5, 40);
        textAreaDetalles.setFont(new Font("Arial", Font.PLAIN, 14));
        textAreaDetalles.setBackground(Color.WHITE);
        textAreaDetalles.setForeground(Color.BLACK);
        textAreaDetalles.setPreferredSize(new Dimension(40, 40));
        textAreaDetalles.setSize(30,30);


        panelDetalles.add(labelDetalles, BorderLayout.NORTH);
        panelDetalles.add(textAreaDetalles, BorderLayout.CENTER);
        panelDetalles.setPreferredSize(new Dimension(500, 150));
        panelDetalles.setBounds(50, 50, 500, 150);

        // Panel botón
        panelBoton = new Panel(new FlowLayout());
        botonGuardar = new Button("GUARDAR");
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 14));
        botonGuardar.setBackground(new Color(60, 179, 113));
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.addActionListener(this);
        panelBoton.add(botonGuardar);

        // Mensaje (ya no se usa visualmente)
        labelMensajeGuardado = new Label("");
        panelBoton.add(labelMensajeGuardado);

        // Centro
        Panel panelCentro = new Panel(new BorderLayout(10, 10));
        panelCentro.add(panelIDFecha, BorderLayout.NORTH);
        panelCentro.add(panelEstado, BorderLayout.CENTER);
        panelCentro.add(panelDetalles, BorderLayout.SOUTH);

        // Agregar todo
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
            JOptionPane.showMessageDialog(this, " Solicitud guardada con éxito",
                    "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE
            );
            this.setVisible(false);
            ventanaPrincipal.setVisible(true);
            botonGuardar.setVisible(false);
        }
    }
}
