package com.example.pharmacy_management_system;

import com.example.pharmacy_management_system.entity.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CashierPaymentsController {
    @FXML
    private TextField amount;

    @FXML
    private Label invoiceNo;

    @FXML
    private ComboBox<String> paymentMethod;

    @FXML
    private TextField serialNo;


    ObservableList<Payment> payments = FXCollections.observableArrayList();

    @FXML
    void onAddPayment(ActionEvent event) {
        String invoiceNoValue = invoiceNo.getText();
        double amountValue = Double.parseDouble(amount.getText());
        String paymentMethodValue = paymentMethod.getValue();
        String serialNoValue = serialNo.getText();

        Payment payment = new Payment(invoiceNoValue, amountValue, paymentMethodValue, serialNoValue);
        payments.add(payment);

        int numPayments = payments.size();
        invoiceNo.setText(String.format("INV-%05d", numPayments));
    }

    public void initialize() {
        ObservableList<String> paymentMethods = FXCollections.observableArrayList(
                "Cash", "Credit Card", "Debit Card", "Mobile Payment");
        paymentMethod.setItems(paymentMethods);
    }
}
