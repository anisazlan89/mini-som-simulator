package com.anis.miniProject.service;

import org.springframework.stereotype.Service;

import com.anis.miniProject.dto.CallbackRequest;
import com.anis.miniProject.dto.CreateWorkOrderRequest;
import com.anis.miniProject.dto.WorkOrderResponse;
import com.anis.miniProject.entity.WorkOrder;
import com.anis.miniProject.entity.WorkOrderActivity;
import com.anis.miniProject.model.ActivityStatus;
import com.anis.miniProject.model.WorkOrderStatus;
import com.anis.miniProject.repository.WorkOrderActivityRepository;
import com.anis.miniProject.repository.WorkOrderRepository;

@Service
public class WorkOrderService {

    private final WorkOrderRepository repository;
    private final WorkOrderActivityRepository activityRepository;

    public WorkOrderService(WorkOrderRepository repository, WorkOrderActivityRepository activityRepository) {
        this.repository = repository;
        this.activityRepository = activityRepository;
    }

    public WorkOrder createWorkOrder(CreateWorkOrderRequest request) {

        WorkOrder workOrder = new WorkOrder();
        workOrder.setServiceNumber(request.getServiceNumber());
        workOrder.setCustomerName(request.getCustomerName());
        workOrder.setProduct(request.getProduct());
        workOrder.setStatus(WorkOrderStatus.SUBMITTED);

        generateActivities(workOrder);

        return repository.save(workOrder);
    }

    private void generateActivities(WorkOrder workOrder) {
        workOrder.addActivity(new WorkOrderActivity("Validate Order", ActivityStatus.RDY, null));
        workOrder.addActivity(new WorkOrderActivity("Provision Service", ActivityStatus.NRD, "Validate Order"));
        workOrder.addActivity(new WorkOrderActivity("Notify Billing", ActivityStatus.NRD, "Provision Service"));
    }

    public WorkOrderResponse manualCompleteActivity(Long activityId) {

        WorkOrderActivity activity = activityRepository.findById(activityId)
                .orElseThrow();

        activity.setStatus(ActivityStatus.COM);

        WorkOrder workOrder = activity.getWorkOrder();

        boolean allCompleted = workOrder.getActivities()
                .stream()
                .allMatch(act -> act.getStatus() == ActivityStatus.COM);

        if (allCompleted) {
            workOrder.setStatus(WorkOrderStatus.COM);
        }

        repository.save(workOrder);

        return mapToResponse(workOrder);
    }

    private WorkOrderResponse mapToResponse(WorkOrder workOrder) {
        return new WorkOrderResponse(
                workOrder.getId(),
                workOrder.getServiceNumber(),
                workOrder.getCustomerName(),
                workOrder.getProduct(),
                workOrder.getStatus());
    }

    public WorkOrderResponse processCallback(CallbackRequest request) {

        WorkOrder workOrder = repository.findById(request.getWorkOrderId())
                .orElseThrow();

        WorkOrderActivity activity = workOrder.getActivities()
                .stream()
                .filter(act -> act.getActivityName().equals(request.getActivityName()))
                .findFirst()
                .orElseThrow();

        if ("SUCCESS".equals(request.getResult())) {
            activity.setStatus(ActivityStatus.COM);

            releaseNextActivity(workOrder, activity.getActivityName());

        } else {
            activity.setStatus(ActivityStatus.EXC);
            workOrder.setStatus(WorkOrderStatus.EXC);
        }

        boolean allCompleted = workOrder.getActivities()
                .stream()
                .allMatch(act -> act.getStatus() == ActivityStatus.COM);

        if (allCompleted) {
            workOrder.setStatus(WorkOrderStatus.COM);
        }

        WorkOrder savedWorkOrder = repository.save(workOrder);

        return mapToResponse(savedWorkOrder);
    }

    private void releaseNextActivity(WorkOrder workOrder, String completedActivityName) {

        workOrder.getActivities()
                .stream()
                .filter(act -> completedActivityName.equals(act.getPredecessor()))
                .filter(act -> act.getStatus() == ActivityStatus.NRD)
                .forEach(act -> act.setStatus(ActivityStatus.RDY));
    }
}
