package com.example.pharmacy_management_system.entity;

public class Payment {
    private String invoiceNo;
    private double amount;
    private String type;
    private String serialNo;

    public Payment(String invoiceNo, double amount, String type, String serialNo) {
        this.invoiceNo = invoiceNo;
        this.amount = amount;
        this.type = type;
        this.serialNo = serialNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
