package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.api.WorkPlanApi;
import dev.toke.springthymehtmxstarter.data.dto.CuttingJobDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkPlanDto;
import dev.toke.springthymehtmxstarter.service.WorkPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkPlanServiceImpl implements WorkPlanService {
    private final WorkPlanApi workPlanApi;
    @Override
    public List<WorkPlanDto> getWorkPlans(LocalDate from, LocalDate to) {
        return workPlanApi.getWorkPlans(from.toString(), to.toString());
    }

    @Override
    public List<WorkPlanDto> getWorkPlansGreaterThan(Long planId) {
        return workPlanApi.getWorkPlansGreaterThanOrEqual(planId);
    }

    @Override
    public WorkPlanDto getWorkPlanById(Long id) {
        return null;
    }

    @Override
    public WorkPlanDto createWorkPlan(WorkPlanDto workPlan) {

        return null;
    }

    @Override
    public List<CuttingJobDto> getCuttingJobs(Long id) {
        return workPlanApi.getCuttingJobs(id);
    }

}
