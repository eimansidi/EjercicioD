package com.example.ejd.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Clase que representa una Persona con atributos basicos como nombre, apellidos y edad.
 * Utiliza propiedades de JavaFX para permitir el enlace de datos con componentes graficos.
 */
public class Persona {

    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidos;
    private final SimpleIntegerProperty edad;

    /**
     * Constructor que inicializa una nueva instancia de Persona.
     *
     * @param nombre    Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param edad      Edad de la persona.
     */
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos.get();
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Apellidos a establecer.
     */
    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad.get();
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad Edad a establecer.
     */
    public void setEdad(int edad) {
        this.edad.set(edad);
    }

    /**
     * Propiedad de nombre para permitir el enlace con componentes graficos.
     *
     * @return Propiedad del nombre.
     */
    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    /**
     * Propiedad de apellidos para permitir el enlace con componentes graficos.
     *
     * @return Propiedad de los apellidos.
     */
    public SimpleStringProperty apellidosProperty() {
        return apellidos;
    }

    /**
     * Propiedad de edad para permitir el enlace con componentes graficos.
     *
     * @return Propiedad de la edad.
     */
    public SimpleIntegerProperty edadProperty() {
        return edad;
    }
}