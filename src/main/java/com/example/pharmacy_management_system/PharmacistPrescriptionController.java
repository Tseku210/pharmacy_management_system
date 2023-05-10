package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.time.LocalDateTime;
import java.util.UUID;

public class PharmacistPrescriptionController {

    @FXML
    private TableColumn<?, ?> presCustomerCol;

    @FXML
    private TableColumn<?, ?> presDateCol;

    @FXML
    private TableColumn<Prescription, Void> presDeleteCol;

    @FXML
    private TableColumn<?, ?> presInvoiceNoCol;

    @FXML
    private TableColumn<?, ?> presPresNoCol;

    @FXML
    private TextField pres_customerAddress;

    @FXML
    private TextField pres_customerAge;

    @FXML
    private TextField pres_customerGender;

    @FXML
    private TextField pres_customerId;

    @FXML
    private TextField pres_customerName;

    @FXML
    private TextField pres_customerPhone;

    @FXML
    private TextField pres_dose;

    @FXML
    private ComboBox<String> pres_drug;

    @FXML
    private TextField pres_quantity;

    @FXML
    private TextField pres_strength;

    @FXML
    private TableView<Prescription> prescription_table;

    ObservableList<Prescription> prescriptions = FXCollections.observableArrayList(
            new Prescription("1", "Jane Doe", "25", "Female", "123 Main St", "555-555-5555", "Ibuprofen", "200mg", "1 tablet", "30", "5678", "9012", LocalDateTime.now()),
            new Prescription("2", "Bob Johnson", "50", "Male", "456 Elm St", "555-555-5555", "Acetaminophen", "500mg", "2 tablets", "60", "1234", "3456", LocalDateTime.now())
    );

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }

    @FXML
    void onAddPrescription(ActionEvent event) {
        String customerId = pres_customerId.getText();
        String customer = pres_customerName.getText();
        String age = pres_customerAge.getText();
        String gender = pres_customerGender.getText();
        String address = pres_customerAddress.getText();
        String phone = pres_customerPhone.getText();
        String drug = pres_drug.getValue().toString();
        String strength = pres_strength.getText();
        String dose = pres_dose.getText();
        String quantity = pres_quantity.getText();
        String prescriptionNo = generateUUID();
        String invoiceNo = generateUUID();
        LocalDateTime date = LocalDateTime.now();

        Prescription prescription = new Prescription(customerId, customer, age, gender, address, phone, drug, strength, dose, quantity, prescriptionNo, invoiceNo, date);

        prescription_table.getItems().add(prescription);

        pres_customerId.clear();
        pres_customerName.clear();
        pres_customerAge.clear();
        pres_customerGender.clear();
        pres_customerAddress.clear();
        pres_customerPhone.clear();
        pres_strength.clear();
        pres_dose.clear();
        pres_quantity.clear();
    }

    private Callback<TableColumn<Prescription, Void>, TableCell<Prescription, Void>> getDeleteButtonCellFactory() {
        Callback<TableColumn<Prescription, Void>, TableCell<Prescription, Void>> cellFactory = new Callback<TableColumn<Prescription, Void>, TableCell<Prescription, Void>>() {
            @Override
            public TableCell<Prescription, Void> call(final TableColumn<Prescription, Void> param) {
                final TableCell<Prescription, Void> cell = new TableCell<Prescription, Void>() {

                    private final Button deleteButton = new Button("Устгах");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            Prescription Prescription = getTableView().getItems().get(getIndex());
                            prescriptions.remove(Prescription);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteButton);
                        }
                    }
                };
                return cell;
            }
        };
        return cellFactory;
    }

    public void initialize() {
        ObservableList<String> drugs = FXCollections.observableArrayList(
                "Aspirin",
                "Ibuprofen",
                "Acetaminophen",
                "Lisinopril",
                "Metformin",
                "Atorvastatin"
        );
        pres_drug.setItems(drugs);

        prescription_table.setItems(prescriptions);

        presCustomerCol.setCellValueFactory(new PropertyValueFactory<>("customer"));
        presPresNoCol.setCellValueFactory(new PropertyValueFactory<>("prescriptionNo"));
        presInvoiceNoCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        presDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        presDeleteCol.setCellFactory(getDeleteButtonCellFactory());
    }
}
