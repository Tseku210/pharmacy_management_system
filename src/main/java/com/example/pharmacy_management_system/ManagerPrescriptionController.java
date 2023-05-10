package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDateTime;

public class ManagerPrescriptionController {
    @FXML
    private TableColumn<?, ?> customerCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> invoiceNoCol;

    @FXML
    private TableColumn<?, ?> prescriptionNoCol;

    @FXML
    private TableView<Prescription> prescription_table;

    ObservableList<Prescription> prescriptions = FXCollections.observableArrayList(
            new Prescription("John Doe", "RX123", "INV456", LocalDateTime.now()),
            new Prescription("Jane Smith", "RX456", "INV789", LocalDateTime.now()),
            new Prescription("Bob Johnson", "RX789", "INV123", LocalDateTime.now())
    );

    public void initialize() {
        prescription_table.setItems(prescriptions);

        customerCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
        prescriptionNoCol.setCellValueFactory(new PropertyValueFactory<>("prescriptionNo"));
        invoiceNoCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
}
