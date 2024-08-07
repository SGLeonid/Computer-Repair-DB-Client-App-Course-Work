module com.example.comprepairdb {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.comprepairdb to javafx.fxml;
    exports com.example.comprepairdb;
}