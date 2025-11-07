package com.example.practica_5_listas;

public class Videojuegos {
    private String nombre;
    private String genero;
    private String año;
    private int imagen;

    public Videojuegos(String nombre, String genero, String año, int imagen) {
        this.nombre = nombre;
        this.genero = genero;
        this.año = año;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
