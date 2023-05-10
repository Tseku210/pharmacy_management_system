package com.example.pharmacy_management_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacistController {
    @FXML
    private StackPane contentPane;

    @FXML
    private FlowPane dashboardView;


    @FXML
    private HBox menu_dashboard;

    @FXML
    private HBox menu_logout;

    @FXML
    private HBox menu_prescription;

    @FXML
    private HBox menu_stock;

    @FXML
    private HBox menu_users;

    private Parent prescriptionView;
    private Parent stockView;

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
    void onPrescriptionClick(MouseEvent event) {
        if (prescriptionView == null) {
            try {
                prescriptionView = FXMLLoader.load(getClass().getResource("prescription-pharmacist.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(prescriptionView);
    }

    @FXML
    void onStockClick(MouseEvent event) {
        if (stockView == null) {
            try {
                stockView = FXMLLoader.load(getClass().getResource("stock-pharmacist.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(stockView);
    }

}
