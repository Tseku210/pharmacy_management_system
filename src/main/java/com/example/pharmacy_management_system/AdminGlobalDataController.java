package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class AdminGlobalDataController {
    @FXML
    private TableColumn<?, ?> medCategory;

    @FXML
    private TableColumn<?, ?> medCity;

    @FXML
    private TableColumn<?, ?> medCompany;

    @FXML
    private TableColumn<?, ?> medCost;

    @FXML
    private TableColumn<?, ?> medDate;

    @FXML
    private TableColumn<?, ?> medDesc;

    @FXML
    private TableColumn<?, ?> medId;

    @FXML
    private TableColumn<?, ?> medName;

    @FXML
    private TableColumn<?, ?> medQuantity;

    @FXML
    private TableColumn<?, ?> medStatus;

    @FXML
    private TableColumn<?, ?> medSupplier;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableView<Medicine> medicine_table;

    ObservableList<Medicine> medicinesDB = FXCollections.observableArrayList(
            new Medicine(1, "Paracetamol", "Painkiller", "For headache and fever", "ABC Company", "XYZ Supplier", "New York", 100, 5.99, "Available", LocalDate.of(2022, 5, 1)),
            new Medicine(2, "Ibuprofen", "Painkiller", "For body aches and pains", "DEF Company", "PQR Supplier", "Los Angeles", 50, 7.99, "Available", LocalDate.of(2022, 6, 1)),
            new Medicine(3, "Amoxicillin", "Antibiotic", "For bacterial infections", "GHI Company", "MNO Supplier", "San Francisco", 75, 10.99, "Available", LocalDate.of(2022, 7, 1)),
            new Medicine(4, "Lisinopril", "Blood pressure medication", "For hypertension", "JKL Company", "STU Supplier", "Chicago", 30, 12.99, "Available", LocalDate.of(2022, 8, 1)),
            new Medicine(5, "Metformin", "Diabetes medication", "For type 2 diabetes", "MNO Company", "ABC Supplier", "Houston", 20, 9.99, "Available", LocalDate.of(2022, 9, 1)),
            new Medicine(6, "Warfarin", "Anticoagulant", "For blood clots", "PQR Company", "DEF Supplier", "Miami", 40, 15.99, "Available", LocalDate.of(2022, 10, 1)),
            new Medicine(7, "Simvastatin", "Cholesterol medication", "For high cholesterol", "STU Company", "GHI Supplier", "Dallas", 60, 8.99, "Available", LocalDate.of(2022, 1, 1)),
            new Medicine(8, "Cephalexin", "Antibiotic", "For bacterial infections", "ABC Company", "MNO Supplier", "Philadelphia", 25, 11.99, "Available", LocalDate.of(2022, 12, 1)),
            new Medicine(9, "Zolpidem", "Sedative", "For insomnia", "DEF Company", "ABC Supplier", "Phoenix", 15, 6.99, "Available", LocalDate.of(2023, 1, 1)),
            new Medicine(10, "Omeprazole", "Acid reflux medication", "For heartburn and indigestion", "GHI Company", "DEF Supplier", "Seattle", 35, 9.99, "Available", LocalDate.of(2023, 2, 1))
    );

    public Medicine getMax() {
        Medicine maxMed = null;
        double maxCost = 0.0;
        for (Medicine med : medicinesDB) {
            if (med.getCost() > maxCost) {
                maxMed = med;
                maxCost = med.getCost();
            }
        }

        return maxMed;
    }

    public Medicine getMin() {
        Medicine minMed = null;
        for (Medicine med : medicinesDB) {
            if (minMed == null || med.getCost() < minMed.getCost()) {
                minMed = med;
            }
        }

        return minMed;
    }
    @FXML
    void onSearch(ActionEvent event) {
        String selectedValue = comboBox.getValue();

        switch (selectedValue) {
            case "All" -> medicine_table.setItems(medicinesDB);
            case "Max" -> medicine_table.setItems(FXCollections.observableArrayList(getMax()));
            case "Min" -> medicine_table.setItems(FXCollections.observableArrayList(getMin()));
        }
    }

    public void initialize() {
        comboBox.setItems(FXCollections.observableArrayList("All", "Max", "Min"));

        medicine_table.setItems(medicinesDB);

        medId.setCellValueFactory(new PropertyValueFactory<>("id"));
        medName.setCellValueFactory(new PropertyValueFactory<>("name"));
        medCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        medDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        medCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        medSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        medCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        medQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        medCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        medStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        medDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

}
