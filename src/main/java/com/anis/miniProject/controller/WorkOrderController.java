package com.anis.miniProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anis.miniProject.dto.CreateWorkOrderRequest;
import com.anis.miniProject.entity.WorkOrder;
import com.anis.miniProject.service.WorkOrderService;

import jakarta.validation.Valid;

/*
 * REST controller for managing Work Orders.
 *
 * Provides endpoints to create and manage work orders.
 * Incoming requests are delegated to the service layer,
 * where the workflow and business rules are executed.
 */
@RestController
@RequestMapping("/workorders")
public class WorkOrderController {

    private final WorkOrderService service;

    public WorkOrderController(WorkOrderService service) {
        this.service = service;
    }

    /*
     * Creates a new Work Order.
     *
     * The Workflow Engine initializes the work order,
     * generates the default workflow activities,
     * and sets the initial status.
     */
    @PostMapping
    public WorkOrder createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest request) {
        return service.createWorkOrder(request);
    }
}
