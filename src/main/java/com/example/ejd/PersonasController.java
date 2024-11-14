package com.example.ejd;

import com.example.ejd.model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para gestionar las personas en la aplicacion.
 * Permite agregar nuevas personas y visualizarlas en una tabla.
 */
public class PersonasController implements Initializable {

    @FXML
    private TableView<Persona> tableView;

    @FXML
    private TableColumn<Persona, String> nombre;

    @FXML
    private TableColumn<Persona, String> apellidos;

    @FXML
    private TableColumn<Persona, Integer> edad;

    /**
     * Inicializa las columnas de la tabla con las propiedades de los objetos Persona.
     *
     * @param location  Ubicacion utilizada para resolver rutas relativas para el objeto raiz, o null si no se conoce.
     * @param resources Recursos utilizados para localizar el objeto raiz, o null si no se especifican.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configura las columnas de la tabla para enlazar con las propiedades de Persona
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        edad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    }

    /**
     * Maneja el evento de agregar una nueva persona.
     * Abre una ventana modal para ingresar los datos de la nueva persona.
     *
     * @param event Evento que dispara la accion.
     */
    @FXML
    void agregar(ActionEvent event) {
        try {
            // Carga el archivo FXML para la ventana de agregar persona
            FXMLLoader loader = new FXMLLoader(getClass().getResource("agregar.fxml"));
            Scene scene = new Scene(loader.load());

            // Obtiene el controlador de la ventana de agregar persona
            AgregarController agregarController = loader.getController();
            agregarController.setMainController(this);

            // Configura y muestra la ventana modal
            Stage stage = new Stage();
            stage.setTitle("Nueva Persona");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Agrega una nueva persona a la tabla.
     *
     * @param persona La nueva persona a agregar.
     */
    public void agregarPersonaTabla(Persona persona) {
        tableView.getItems().add(persona);
    }

}
