package com.anis.miniProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anis.miniProject.dto.CallbackRequest;
import com.anis.miniProject.dto.WorkOrderResponse;
import com.anis.miniProject.service.WorkOrderService;

import jakarta.validation.Valid;

/*
 * Callback API for receiving processing results from a downstream system.
 *
 * In this project, Postman simulates the downstream system by sending
 * the processing result back to the Workflow Engine.
 *
 * Flow:
 * Client -> Workflow Engine -> Downstream System -> Callback -> Workflow Engine
 *
 * Once the callback is received:
 * 1. Update the activity status.
 * 2. Release the next activity if its predecessor is completed.
 * 3. Complete the Work Order when all activities are COM.
 */

@RestController
@RequestMapping("/callback")
public class CallbackController {

    private final WorkOrderService service;

    public CallbackController(WorkOrderService service) {
        this.service = service;
    }

    @PostMapping
    public WorkOrderResponse callback(@Valid @RequestBody CallbackRequest request) {
        return service.processCallback(request);
    }
}
