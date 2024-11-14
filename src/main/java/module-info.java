module com.example.ejd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejd to javafx.fxml;
    exports com.example.ejd;
    exports com.example.ejd.model;
    opens com.example.ejd.model to javafx.fxml;
}