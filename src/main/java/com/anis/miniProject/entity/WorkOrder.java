package com.anis.miniProject.entity;

import java.util.ArrayList;
import java.util.List;

import com.anis.miniProject.model.WorkOrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "work_order")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceNumber;
    private String customerName;
    private String product;

    @Enumerated(EnumType.STRING)
    private WorkOrderStatus status;

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL)
    private List<WorkOrderActivity> activities = new ArrayList<>();

    public WorkOrder() {
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

    public List<WorkOrderActivity> getActivities() {
        return activities;
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

    public void setStatus(WorkOrderStatus status) {
        this.status = status;
    }

    public void addActivity(WorkOrderActivity activity) {
        activities.add(activity);
        activity.setWorkOrder(this);
    }
}