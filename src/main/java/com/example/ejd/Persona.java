package com.example.ejd;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {

    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidos;
    private final SimpleIntegerProperty edad;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public int getEdad() {
        return edad.get();
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }

    // Propiedades para enlazar con la tabla
    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public SimpleStringProperty apellidosProperty() {
        return apellidos;
    }

    public SimpleIntegerProperty edadProperty() {
        return edad;
    }
}
