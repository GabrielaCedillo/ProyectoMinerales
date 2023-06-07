package org.example;

import org.example.controlador.ControladorMinerales;
import org.example.vista.VentanaMinerales;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaMinerales view = new VentanaMinerales("Proyecto MINERALES");
        ControladorMinerales controller = new ControladorMinerales(view);
    }
}