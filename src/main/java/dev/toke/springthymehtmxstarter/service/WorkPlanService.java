package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.CuttingJobDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkPlanDto;

import java.time.LocalDate;
import java.util.List;

public interface WorkPlanService {
    List<WorkPlanDto> getWorkPlans(LocalDate from, LocalDate to);
    List<WorkPlanDto> getWorkPlansGreaterThan(Long planId);
    WorkPlanDto getWorkPlanById(Integer id);
    WorkPlanDto createWorkPlan(WorkPlanDto workPlanDto);
    List<CuttingJobDto> getCuttingJobs(Long id);
//    WorkPlan updateWorkPlan(WorkPlan workPlan);
//    void deleteWorkPlan(Long id);
}
