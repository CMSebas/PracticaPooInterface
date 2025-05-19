package ec.edu.ups.poo.view;

import ec.edu.ups.poo.controller.Ventana1Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana1 extends Frame implements ActionListener {
    private Panel panelGeneral;
    private Panel panelTitulo;
    private Panel panelBotones;
    private Panel panelConPadding;

    private Label labelNumero1;

    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;
    private Button boton7;

    public Ventana1() {
        setTitle("Calculadora del Sabado");
        setSize(500, 300);
        setLocationRelativeTo(null);




        panelGeneral = new Panel(new BorderLayout());
        panelTitulo = new Panel();

        panelBotones = new Panel(new GridLayout(6, 1,10,10));
        labelNumero1 = new Label("Menu Principal ");
        panelConPadding = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelConPadding.add(panelBotones);

        labelNumero1.setFont(new Font("Arial", Font.BOLD, 28));

        panelTitulo.add(labelNumero1);
        panelGeneral.add(panelConPadding, BorderLayout.CENTER);
        panelGeneral.add(panelTitulo, BorderLayout.NORTH);

        boton1 = new Button("VER LISTA DE PROVEDORES");
        boton2 = new Button("REGISTRAR PROVEDORES");
        boton3 = new Button("VER LISTA DE PRODUCTOS");
        boton4 = new Button("REGISTRAR PRODUCTOS");
        boton5 = new Button("REGISTRAR SOLICITUD");
        boton6 = new Button("VER SOLICITUD");
        boton7 = new Button("SALIR");



        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);
        panelBotones.add(boton7);

        boton2.addActionListener(this);








        add(panelGeneral);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1) {

        } else if (e.getSource() == boton2) {
            VentRegPro ventanaPro = new VentRegPro(this); // ✅ pasa la instancia actual
            ventanaPro.addWindowListener(new Ventana1Controller());
            ventanaPro.setVisible(true);
            this.setVisible(false);
        }
    }
}
