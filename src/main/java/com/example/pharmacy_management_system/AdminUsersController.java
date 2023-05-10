package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.DAO.UserDAOImpl;
import com.example.pharmacy_management_system.entity.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

public class AdminUsersController {

    @FXML
    private TextField user_address;

    @FXML
    private TextField user_firstname;

    @FXML
    private TextField user_lastname;

    @FXML
    private TextField user_mail;

    @FXML
    private TextField user_password;

    @FXML
    private TextField user_phone;

    @FXML
    private TextField user_staffId;

    @FXML
    private TextField user_username;

    @FXML
    private TableView<User> users_table;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<User, Void> deleteCol;

    @FXML
    private TableColumn<?, ?> firstnameCol;

    @FXML
    private TableColumn<?, ?> lastnameCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> staffIdCol;

    @FXML
    private TableColumn<User, Void> updateCol;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private Label type_lbl;

    private static int idCount = 0;

    private UserDAOImpl userDAO = UserDAOImpl.getInstance();
    ObservableList<User> userList = null;


    @FXML
    void onAddUser(ActionEvent event) {
        if (user_firstname.getText().equals("") || user_lastname.getText().equals("") ||
                user_address.getText().equals("") || user_staffId.getText().equals("") ||
                user_mail.getText().equals("") || user_phone.getText().equals("") ||
                user_username.getText().equals("") || user_password.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Дутуу өгөгдөл");
            alert.setHeaderText(null);
            alert.setContentText("Бүх мөрийг бөглөнө үү");
            alert.showAndWait();
            return;
        }

        User newUser = new User(idCount++, user_firstname.getText(), user_lastname.getText(),
                user_address.getText(), user_staffId.getText(), user_mail.getText(),  user_phone.getText(), user_username.getText(), user_password.getText(),  "pharmacist");

        if (type_lbl.getText().toLowerCase().contains("pharmacist")) {
            newUser.setRole("pharmacist");
        } else if (type_lbl.getText().toLowerCase().contains("cashier")) {
            newUser.setRole("cashier");
        }

        userDAO.addUser(newUser);
        refreshUsers();
        clearUserFields();

    }

    private void refreshUsers() {
        if (type_lbl.getText().toLowerCase().contains("manager")) {
            userList.setAll(userDAO.getManagers());
        } else if (type_lbl.getText().toLowerCase().contains("pharmacist")) {
            userList.setAll(userDAO.getPharmacists());
        } else if (type_lbl.getText().toLowerCase().contains("cashier")) {
            userList.setAll(userDAO.getCashiers());
        }
    }

    private void clearUserFields() {
        user_firstname.clear();
        user_lastname.clear();
        user_address.clear();
        user_staffId.clear();
        user_mail.clear();
        user_phone.clear();
        user_username.clear();
        user_password.clear();
    }

    private Callback<TableColumn<User, Void>, TableCell<User, Void>> getUpdateButtonCellFactory() {
        Callback<TableColumn<User, Void>, TableCell<User, Void>> cellFactory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {

                    private final Button updateButton = new Button("Өөрчлөх");

                    {
                        updateButton.setOnAction((ActionEvent event) -> {
                            User user = getTableView().getItems().get(getIndex());
                            // Create a new dialog
                            Dialog<User> dialog = new Dialog<>();

                            dialog.setTitle("Хэрэглэгчийн мэдээлэл өөрчлөх");
                            dialog.setHeaderText("Хэрэглэгч: " + user.getFirstName() + " " + user.getLastName());

                            // Set the button types for the dialog
                            ButtonType updateButtonType = new ButtonType("Хадгалах", ButtonBar.ButtonData.OK_DONE);
                            ButtonType deleteButtonType = new ButtonType("Буцах", ButtonBar.ButtonData.CANCEL_CLOSE);
                            dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, deleteButtonType);

                            // Create the text fields for the dialog
                            TextField staffIdField = new TextField(user.getStaffId());
                            TextField firstNameField = new TextField(user.getFirstName());
                            TextField lastNameField = new TextField(user.getLastName());
                            TextField addressField = new TextField(user.getAddress());
                            TextField phoneField = new TextField(user.getPhone());

                            // Add the text fields to the dialog
                            GridPane grid = new GridPane();
                            grid.setHgap(10);
                            grid.setVgap(10);
                            grid.add(new Label("Staff ID:"), 0, 0);
                            grid.add(staffIdField, 1, 0);
                            grid.add(new Label("First Name:"), 0, 1);
                            grid.add(firstNameField, 1, 1);
                            grid.add(new Label("Last Name:"), 0, 2);
                            grid.add(lastNameField, 1, 2);
                            grid.add(new Label("Address:"), 0, 3);
                            grid.add(addressField, 1, 3);
                            grid.add(new Label("Phone:"), 0, 4);
                            grid.add(phoneField, 1, 4);
                            dialog.getDialogPane().setContent(grid);

                            // Request focus on the first name field by default
                            Platform.runLater(staffIdField::requestFocus);

                            // Convert the result to a User object when the update button is clicked
                            dialog.setResultConverter(dialogButton -> {
                                if (dialogButton == updateButtonType) {
                                    user.setStaffId(staffIdField.getText());
                                    user.setFirstName(firstNameField.getText());
                                    user.setLastName(lastNameField.getText());
                                    user.setAddress(addressField.getText());
                                    user.setPhone(phoneField.getText());
                                    return user;
                                }
                                return null;
                            });

                            // Show the dialog and update the user if the update button is clicked
                            Optional<User> result = dialog.showAndWait();
                            result.ifPresent(updatedUser -> {
                                userDAO.updateUser(updatedUser);
                                users_table.refresh();
                            });
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(updateButton);
                        }
                    }
                };
                return cell;
            }
        };
        return cellFactory;
    }

    private Callback<TableColumn<User, Void>, TableCell<User, Void>> getDeleteButtonCellFactory() {
        Callback<TableColumn<User, Void>, TableCell<User, Void>> cellFactory = new Callback<TableColumn<User, Void>, TableCell<User, Void>>() {
            @Override
            public TableCell<User, Void> call(final TableColumn<User, Void> param) {
                final TableCell<User, Void> cell = new TableCell<User, Void>() {

                    private final Button deleteButton = new Button("Устгах");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            User user = getTableView().getItems().get(getIndex());
                            userDAO.removeUser(user.getId());
                            refreshUsers();
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

        if (type_lbl.getText().toLowerCase().contains("manager")) {
            userList = FXCollections.observableArrayList(userDAO.getManagers());
        } else if (type_lbl.getText().toLowerCase().contains("pharmacist")) {
            userList = FXCollections.observableArrayList(userDAO.getPharmacists());

        } else if (type_lbl.getText().toLowerCase().contains("cashier")) {
            userList = FXCollections.observableArrayList(userDAO.getCashiers());
        }

        users_table.setItems(userList);

        userIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffIdCol.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

        updateCol.setCellFactory(getUpdateButtonCellFactory());
        deleteCol.setCellFactory(getDeleteButtonCellFactory());
    }
}
