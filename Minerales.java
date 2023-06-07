package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Minerales {
    private int Id;
    private String nombre;
    private String tipo;
    private String color;
    private String dureza;
    private String url;

    public Minerales(String string) {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Minerales{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", dureza='" + dureza + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen()throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }
}
