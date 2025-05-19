package ec.edu.ups.poo;

import ec.edu.ups.poo.controller.Ventana1Controller;
import ec.edu.ups.poo.view.VentRegEmp;
import ec.edu.ups.poo.view.VentRegPro;
import ec.edu.ups.poo.view.Ventana1;

public class Main {
    public static void main(String[] args) {
        Ventana1Controller controller = new Ventana1Controller();

        Ventana1 vent1 = new Ventana1();

        vent1.addWindowListener(controller);


        vent1.setVisible(true);



    }
}