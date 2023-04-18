package org.example;

import org.example.View.Vista;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        vista.setSize(800, 600); // establece el tamaño de la ventana a 800x600 píxeles
        vista.setLocationRelativeTo(null); // centra la ventana en la pantalla
        vista.setVisible(true);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}