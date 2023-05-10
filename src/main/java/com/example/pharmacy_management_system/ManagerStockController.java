package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.time.LocalDate;

public class ManagerStockController {

    @FXML
    private TableColumn<Medicine, Void> deleteCol;

    @FXML
    private TableColumn<?, ?> medCategory;

    @FXML
    private TableColumn<?, ?> medDate;

    @FXML
    private TableColumn<?, ?> medDesc;

    @FXML
    private TableColumn<?, ?> medId;

    @FXML
    private TableColumn<?, ?> medName;

    @FXML
    private TableColumn<?, ?> medStatus;

    @FXML
    private TextField med_category;

    @FXML
    private TextField med_company;

    @FXML
    private TextField med_cost;

    @FXML
    private TextField med_desc;

    @FXML
    private TextField med_name;

    @FXML
    private TextField med_quantity;

    @FXML
    private TextField med_supplier;

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


    @FXML
    void onAddMedicine(ActionEvent event) {
        int id = medicinesDB.size() + 1;
        String name = med_name.getText();
        String category = med_category.getText();
        String description = med_desc.getText();
        String company = med_company.getText();
        String supplier = med_supplier.getText();
//        String city = med_city.getText();
        String status = "Available";
        int quantity = Integer.parseInt(med_quantity.getText());
        double cost = Double.parseDouble(med_cost.getText());
        LocalDate expiryDate = LocalDate.now().plusYears(1); // set the expiry date to 1 year from now

        Medicine medicine = new Medicine(id, name, category, description, company, supplier, quantity, cost, status, expiryDate);
        medicinesDB.add(medicine);

        medicine_table.setItems(medicinesDB);

        med_name.clear();
        med_category.clear();
        med_desc.clear();
        med_company.clear();
        med_supplier.clear();
        med_quantity.clear();
        med_cost.clear();
    }

    private Callback<TableColumn<Medicine, Void>, TableCell<Medicine, Void>> getDeleteButtonCellFactory() {
        Callback<TableColumn<Medicine, Void>, TableCell<Medicine, Void>> cellFactory = new Callback<TableColumn<Medicine, Void>, TableCell<Medicine, Void>>() {
            @Override
            public TableCell<Medicine, Void> call(final TableColumn<Medicine, Void> param) {
                final TableCell<Medicine, Void> cell = new TableCell<Medicine, Void>() {

                    private final Button deleteButton = new Button("Устгах");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            Medicine medicine = getTableView().getItems().get(getIndex());
                            medicinesDB.remove(medicine);
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
        medId.setCellValueFactory(new PropertyValueFactory<>("id"));
        medName.setCellValueFactory(new PropertyValueFactory<>("name"));
        medCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        medDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        medStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        medDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        medicine_table.setItems(medicinesDB);
        deleteCol.setCellFactory(getDeleteButtonCellFactory());
    }
}
