package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.WorkPlan;

import java.util.List;

public interface WorkPlanService {
    List<WorkPlan> getWorkPlans();
    WorkPlan getWorkPlanById(Long id);
    WorkPlan createWorkPlan(WorkPlan workPlan);
    WorkPlan updateWorkPlan(WorkPlan workPlan);
    void deleteWorkPlan(Long id);
}
