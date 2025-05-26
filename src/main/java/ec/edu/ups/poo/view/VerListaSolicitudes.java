package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Solicitud;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VerListaSolicitudes extends Frame {
    public VerListaSolicitudes(Ventana1 ventanaPrincipal) {
        setTitle("Lista de Solicitudes");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        TextArea areaTexto = new TextArea();
        areaTexto.setEditable(false);

        List<Solicitud> lista = ventanaPrincipal.getListaSolicitudes();
        if (lista.isEmpty()) {
            areaTexto.setText("No hay solicitudes registradas.");
        } else {
            for (Solicitud s : lista) {
                areaTexto.append(s.toString() + "\n\n");
            }
        }

        add(areaTexto, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                ventanaPrincipal.setVisible(true);
            }
        });
    }
}
