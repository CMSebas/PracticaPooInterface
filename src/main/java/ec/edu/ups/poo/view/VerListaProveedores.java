package ec.edu.ups.poo.view;
import ec.edu.ups.poo.models.Proveedor;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VerListaProveedores extends Frame {
    public VerListaProveedores(Ventana1 ventanaPrincipal) {
        setTitle("Lista de Proveedores");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        TextArea areaTexto = new TextArea();
        areaTexto.setEditable(false);

        List<Proveedor> lista = ventanaPrincipal.getListaProveedores();
        if (lista.isEmpty()) {
            areaTexto.setText("No hay proveedores registrados.");
        } else {
            for (Proveedor p : lista) {
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
