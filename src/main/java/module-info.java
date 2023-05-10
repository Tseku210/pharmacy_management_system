module com.example.pharmacy_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pharmacy_management_system to javafx.fxml;
    exports com.example.pharmacy_management_system;
    exports com.example.pharmacy_management_system.entity;
    opens com.example.pharmacy_management_system.entity to javafx.fxml;
    exports com.example.pharmacy_management_system.DAO;
    opens com.example.pharmacy_management_system.DAO to javafx.fxml;
}