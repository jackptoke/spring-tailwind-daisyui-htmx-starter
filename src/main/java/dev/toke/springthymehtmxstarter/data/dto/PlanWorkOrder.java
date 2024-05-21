package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanWorkOrder {
    private Long planId;
    private Long workOrderId;
    private SortType sortType;
    private WorkPlanDto plan;
    private dev.toke.springthymehtmxstarter.data.model.WorkOrder workOrder;
}