package ec.edu.ups.poo.view;

import ec.edu.ups.poo.models.Producto;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VerListaProductos extends Frame {
    public VerListaProductos(Ventana1 ventanaPrincipal) {
        setTitle("Lista de Productos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        TextArea areaTexto = new TextArea();
        areaTexto.setEditable(false);

        List<Producto> lista = ventanaPrincipal.getListaProductos();
        if (lista.isEmpty()) {
            areaTexto.setText("No hay productos registrados.");
        } else {
            for (Producto p : lista) {
                areaTexto.append(p.toString() + "\n\n");
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
