package com.example.pharmacy_management_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CashierController {
    @FXML
    private StackPane contentPane;

    @FXML
    private FlowPane dashboardView;

    @FXML
    private ImageView makePayments;

    @FXML
    private HBox menu_dashboard;

    @FXML
    private HBox menu_logout;

    @FXML
    private HBox menu_makePayments;

    private Parent paymentsView;

    @FXML
    void onDashboardClick(MouseEvent event) {
        contentPane.getChildren().setAll(dashboardView);
    }

    @FXML
    void onHoverIn(MouseEvent event) {
        HBox menu = (HBox) event.getSource();
        menu.setStyle("-fx-background-color: #72a5f7;");
    }

    @FXML
    void onHoverOut(MouseEvent event) {
        HBox menu = (HBox) event.getSource();
        menu.setStyle("-fx-background-color: #aeccfc;");
    }

    @FXML
    void onLogout(MouseEvent event) {
        try {
            Stage currentStage = (Stage) menu_logout.getScene().getWindow();
            currentStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();
            Stage loginStage = new Stage();
            loginStage.setScene(new Scene(root));
            loginStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onPaymentsClick(MouseEvent event) {
        if (paymentsView == null) {
            try {
                paymentsView = FXMLLoader.load(getClass().getResource("payments-cashier.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(paymentsView);
    }
}
