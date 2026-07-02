package com.anis.miniProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anis.miniProject.dto.CallbackRequest;
import com.anis.miniProject.dto.WorkOrderResponse;
import com.anis.miniProject.service.WorkOrderService;

import jakarta.validation.Valid;

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
