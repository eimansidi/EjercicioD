package com.example.ejd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgregarController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private HelloController helloController;

    public void setMainController(HelloController helloController) {
        this.helloController = helloController;
    }

    @FXML
    void guardar(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String edadStr = txtEdad.getText();

        StringBuilder errores = new StringBuilder();
        if (nombre.isEmpty()) {
            errores.append("El campo nombre es obligatorio.\n");
        }

        if (apellidos.isEmpty()) {
            errores.append("El campo apellidos es obligatorio.\n");
        }

        int edad = -1;
        if (edadStr.isEmpty()) {
            errores.append("El campo edad es obligatorio.\n");
        } else {
            try {
                edad = Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                errores.append("La edad debe ser un número entero.\n");
            }
        }

        if (!errores.isEmpty()) {
            mostrarAlertaError("Datos inválidos", errores.toString());
            return;
        }

        Persona nuevaPersona = new Persona(nombre, apellidos, edad);
        helloController.agregarPersonaTabla(nuevaPersona);

        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}