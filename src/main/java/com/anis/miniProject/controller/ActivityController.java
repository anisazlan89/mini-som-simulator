package com.anis.miniProject.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anis.miniProject.dto.WorkOrderResponse;
import com.anis.miniProject.service.WorkOrderService;

/*
 * Manually completes an activity.
 *
 * This endpoint is intended for support or administrative purposes,
 * allowing an activity to be completed without waiting for a callback
 * from the downstream system.
 */
@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final WorkOrderService service;

    public ActivityController(WorkOrderService service) {
        this.service = service;
    }

    @PutMapping("/{id}/manual-complete")
    public WorkOrderResponse completeActivity(@PathVariable Long id) {
        return service.manualCompleteActivity(id);
    }
}
