package com.anis.miniProject.entity;

import com.anis.miniProject.model.ActivityStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "work_order_activity")
public class WorkOrderActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activityName;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    @ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder;

    private String predecessor;

    public void setId(Long id) {
        this.id = id;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    public WorkOrderActivity() {
    }

    public WorkOrderActivity(String activityName, ActivityStatus status, String predecessor) {
        this.activityName = activityName;
        this.status = status;
        this.predecessor = predecessor;
    }

    public Long getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }
}
