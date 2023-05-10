package com.example.pharmacy_management_system.entity;

import java.time.LocalDate;

public class Medicine {
    private int id;
    private String name;
    private String category;
    private String description;
    private String company;
    private String supplier;
    private String city = null;
    private int quantity;
    private double cost;
    private String status;
    private LocalDate date;

    public Medicine(int id, String name, String category, String description, String company, String supplier, String city, int quantity, double cost, String status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.company = company;
        this.supplier = supplier;
        this.city = city;
        this.quantity = quantity;
        this.cost = cost;
        this.status = status;
        this.date = date;
    }

    public Medicine(String name, String category, String description, String company, String supplier, String city, int quantity, double cost, String status, LocalDate date) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.company = company;
        this.supplier = supplier;
        this.city = city;
        this.quantity = quantity;
        this.cost = cost;
        this.status = status;
        this.date = date;
    }

    public Medicine(int id, String name, String category, String description, String company, String supplier, int quantity, double cost, String status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.company = company;
        this.supplier = supplier;
        this.quantity = quantity;
        this.cost = cost;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
