package com.anis.miniProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anis.miniProject.entity.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

}
