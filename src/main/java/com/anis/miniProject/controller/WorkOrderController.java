package com.anis.miniProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anis.miniProject.dto.CreateWorkOrderRequest;
import com.anis.miniProject.entity.WorkOrder;
import com.anis.miniProject.service.WorkOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/workorders")
public class WorkOrderController {

    private final WorkOrderService service;

    public WorkOrderController(WorkOrderService service) {
        this.service = service;
    }

    @PostMapping
    public WorkOrder createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest request) {
        return service.createWorkOrder(request);
    }
}
