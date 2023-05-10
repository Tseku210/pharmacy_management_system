package com.example.pharmacy_management_system.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prescription {
    private String customerId;
    private String customer;
    private String age;
    private String gender;
    private String address;
    private String phone;
    private String drug;
    private String strength;
    private String dose;
    private String quantity;
    private String prescriptionNo;
    private String invoiceNo;
    private LocalDateTime date;

    public Prescription(String customer, String prescriptionNo, String invoiceNo, LocalDateTime date) {
        this.customer = customer;
        this.prescriptionNo = prescriptionNo;
        this.invoiceNo = invoiceNo;
        this.date = date;
    }

    public Prescription(String customerId, String customer, String age, String gender, String address, String phone, String drug, String strength, String dose, String quantity, String prescriptionNo, String invoiceNo, LocalDateTime date) {
        this.customerId = customerId;
        this.customer = customer;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.drug = drug;
        this.strength = strength;
        this.dose = dose;
        this.quantity = quantity;
        this.prescriptionNo = prescriptionNo;
        this.invoiceNo = invoiceNo;
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
