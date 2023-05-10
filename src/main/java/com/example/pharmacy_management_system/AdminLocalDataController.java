package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.DAO.UserDAOImpl;
import com.example.pharmacy_management_system.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminLocalDataController {
    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private ComboBox<?> cityComboBox;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<?, ?> firstnameCol;

    @FXML
    private TableColumn<?, ?> lastnameCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private Button searchBtn;

    @FXML
    private TableColumn<?, ?> staffIdCol;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private TableView<User> users_table;

    private UserDAOImpl userDAO = UserDAOImpl.getInstance();

    ObservableList<User> localDB = FXCollections.observableArrayList(userDAO.getAllUsers());

    @FXML
    void onCitySearch(ActionEvent event) {
//        String selectedCity = cityComboBox.getValue().toString();
        String search = searchField.getText().toLowerCase();

        ObservableList<User> filteredList = FXCollections.observableArrayList();

        for (User user : localDB) {
            if (user.getAddress().toLowerCase().contains(search)) {
                filteredList.add(user);
            }
        }

        users_table.setItems(filteredList);
    }

    public void initialize() {
        users_table.setItems(localDB);

        userIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

}
