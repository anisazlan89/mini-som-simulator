package com.anis.miniProject.dto;

import com.anis.miniProject.model.WorkOrderStatus;

public class WorkOrderResponse {

    private Long id;
    private String serviceNumber;
    private String customerName;
    private String product;
    private WorkOrderStatus status;

    public WorkOrderResponse(Long id, String serviceNumber, String customerName, String product,
            WorkOrderStatus status) {
        this.id = id;
        this.serviceNumber = serviceNumber;
        this.customerName = customerName;
        this.product = product;
        this.status = status;
    }

    public Long getId() {
        return id;
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

    public WorkOrderStatus getStatus() {
        return status;
    }

}
