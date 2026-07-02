package com.anis.miniProject.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateWorkOrderRequest {

    @NotBlank(message = "Service number is required")
    private String serviceNumber;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Product is required")
    private String product;

    public CreateWorkOrderRequest() {
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}