package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.WorkPlanDto;

import java.time.LocalDate;
import java.util.List;

public interface WorkPlanService {
    List<WorkPlanDto> getWorkPlans(LocalDate from, LocalDate to);
    WorkPlanDto getWorkPlanById(Long id);
    WorkPlanDto createWorkPlan(WorkPlanDto workPlanDto);
//    WorkPlan updateWorkPlan(WorkPlan workPlan);
//    void deleteWorkPlan(Long id);
}
