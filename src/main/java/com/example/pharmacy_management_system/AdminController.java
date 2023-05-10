package com.example.pharmacy_management_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminController {

    @FXML
    private HBox menu_cashier;

    @FXML
    private HBox menu_dashboard;

    @FXML
    private HBox menu_global_data;

    @FXML
    private HBox menu_local_data;

    @FXML
    private HBox menu_logout;

    @FXML
    private HBox menu_manager;

    @FXML
    private HBox menu_pharmacist;

    @FXML
    private StackPane contentPane;

    @FXML
    private FlowPane dashboardView;


    private Parent pharmacistView;
    private Parent managerView;
    private Parent cashierView;
    private Parent localDataView;
    private Parent globalDataView;

    @FXML
    void onDashboardClick(MouseEvent event) {

        contentPane.getChildren().setAll(dashboardView);
    }

    @FXML
    void onPharmacistClick(MouseEvent event) {
        if (pharmacistView == null) {
            try {
                pharmacistView = FXMLLoader.load(getClass().getResource("pharmacist-admin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(pharmacistView);
    }

    @FXML
    void onManagerClick(MouseEvent event) {
        if (managerView == null) {
            try {
                managerView = FXMLLoader.load(getClass().getResource("manager-admin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(managerView);
    }

    @FXML
    void onCashierClick(MouseEvent event) {
        if (cashierView == null) {
            try {
                cashierView = FXMLLoader.load(getClass().getResource("cashier-admin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(cashierView);
    }

    @FXML
    void onLocalDataClick(MouseEvent event) {
        if (localDataView == null) {
            try {
                localDataView = FXMLLoader.load(getClass().getResource("local-admin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(localDataView);
    }

    @FXML
    void onGlobalDataClick(MouseEvent event) {
        if (globalDataView == null) {
            try {
                globalDataView = FXMLLoader.load(getClass().getResource("global-admin.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        contentPane.getChildren().setAll(globalDataView);
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
    void onHoverIn(MouseEvent event) {
        HBox menu = (HBox) event.getSource();
        menu.setStyle("-fx-background-color: #72a5f7;");
    }

    @FXML
    void onHoverOut(MouseEvent event) {
        HBox menu = (HBox) event.getSource();
        menu.setStyle("-fx-background-color: #aeccfc;");
    }

    public void changeContentPane(Parent newContent) {
        contentPane.getChildren().setAll(newContent);
    }

    @FXML
    void initialize() throws IOException {
    }

}