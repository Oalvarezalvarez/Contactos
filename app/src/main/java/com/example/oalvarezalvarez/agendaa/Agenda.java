package com.example.oalvarezalvarez.agendaa;

/**
 * Created by oalvarezalvarez on 10/12/14.
 */
import java.io.Serializable;


public class Agenda implements Serializable {
    private String nombre;
    private int telefono;

    public Agenda() {
    }

    public Agenda(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"\n  "+"Teléfono: "+telefono;
    }
}
