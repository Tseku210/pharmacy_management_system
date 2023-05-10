package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.DAO.UserDAOImpl;
import com.example.pharmacy_management_system.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button btn_login;

    @FXML
    private ChoiceBox<String> cb_type;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;

    private UserDAOImpl userDAO = UserDAOImpl.getInstance();


//    ObservableList<User> users = FXCollections.observableArrayList(
//            new User(1, "John", "Doe", "123 Main St, Anytown USA", "A001", "admin@example.com", "555-1234", "admin", "password", role),
//            new User(2, "Jane", "Doe", "456 Oak St, Anytown USA", "M001", "manager@example.com", "555-5678", "manager", "password", role),
//            new User(3, "Jack", "Smith", "789 Pine St, Anytown USA", "C001", "cashier@example.com", "555-9012", "cashier", "password", role),
//            new User(4, "Bold", "Suren", "123 Pine St, Anytown USA", "CP001", "pharmacist@example.com", "666-9870", "pharmacist", "password", role)
//    );

    @FXML
    void onLogin(ActionEvent event) {
        String username = tf_username.getText();
        String password = tf_password.getText();

        if (isValid(username, password)) {
            Stage loginStage = (Stage) btn_login.getScene().getWindow();
            loginStage.close();

            User user = userDAO.getUserByUsername(username);
            changeStage(user.getRole());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Буруу өгөгдөл");
            alert.setHeaderText(null);
            alert.setContentText("Нэвтрэх нэр эсвэл нууц үг буруу байна");
            alert.showAndWait();
        }
    }

    private boolean isValid(String username, String password) {
        User user = userDAO.getUserByUsername(username);

        if (user != null) {
            return user.getPassword().equals(password);
        }

        return false;
    }

    private void openModuleWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-view.fxml"));
            Parent root = loader.load();
            Stage adminStage = new Stage();
            adminStage.setScene(new Scene(root));
            adminStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void changeStage(String role) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(role + "-view.fxml"));
            System.out.println(loader);
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        cb_type.getItems().addAll("admin", "manager", "cashier", "pharmacist");
    }
}
