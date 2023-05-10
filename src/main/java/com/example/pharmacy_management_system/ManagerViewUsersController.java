package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.DAO.UserDAOImpl;
import com.example.pharmacy_management_system.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManagerViewUsersController {

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> addressCol1;

    @FXML
    private TableColumn<?, ?> addressCol11;

    @FXML
    private TableView<User> cashier_table;

    @FXML
    private TableColumn<?, ?> firstnameCol;

    @FXML
    private TableColumn<?, ?> firstnameCol1;

    @FXML
    private TableColumn<?, ?> firstnameCol11;

    @FXML
    private TableColumn<?, ?> lastnameCol;

    @FXML
    private TableColumn<?, ?> lastnameCol1;

    @FXML
    private TableColumn<?, ?> lastnameCol11;

    @FXML
    private TableView<User> manager_table;

    @FXML
    private TableView<User> pharmacist_table;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> phoneCol1;

    @FXML
    private TableColumn<?, ?> phoneCol11;

    @FXML
    private TableColumn<?, ?> staffIdCol;

    @FXML
    private TableColumn<?, ?> staffIdCol1;

    @FXML
    private TableColumn<?, ?> staffIdCol11;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TableColumn<?, ?> userIdCol1;

    @FXML
    private TableColumn<?, ?> userIdCol11;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private TableColumn<?, ?> usernameCol1;

    @FXML
    private TableColumn<?, ?> usernameCol11;

    private UserDAOImpl userDAO = UserDAOImpl.getInstance();

    ObservableList<User> pharmacists = FXCollections.observableArrayList(userDAO.getPharmacists());

    ObservableList<User> managers = FXCollections.observableArrayList(userDAO.getManagers());

    ObservableList<User> cashiers = FXCollections.observableArrayList(userDAO.getCashiers());

    public void initialize() {
        pharmacist_table.setItems(pharmacists);
        manager_table.setItems(managers);
        cashier_table.setItems(cashiers);

        userIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        userIdCol1.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol1.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol1.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol1.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol1.setCellValueFactory(new PropertyValueFactory<>("phone"));

        userIdCol11.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol11.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol11.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol11.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol11.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol11.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol11.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

}
