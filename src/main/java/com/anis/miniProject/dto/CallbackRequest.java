package com.anis.miniProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CallbackRequest {

    @NotNull(message = "Work order id is required")
    private Long workOrderId;

    @NotBlank(message = "Activity name is required")
    private String activityName;

    @NotBlank(message = "Result is required")
    private String result;

    public CallbackRequest() {
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
