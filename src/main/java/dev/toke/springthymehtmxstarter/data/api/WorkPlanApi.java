package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.CuttingJobDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkPlanDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface WorkPlanApi {
    @GetExchange("/plans")
    List<WorkPlanDto> getWorkPlans(
            @RequestParam(name = "startDate", required = false)String startDate,
            @RequestParam(name = "endDate", required = false) String endDate);

    @GetExchange("/plans/{planId}")
    WorkPlanDto getWorkPlan(@PathVariable(name = "planId") Long planId);

    @GetExchange("/plans/{planId}/greater-or-equals")
    List<WorkPlanDto> getWorkPlansGreaterThanOrEqual(@PathVariable(name="planId") Long planId);

    @GetExchange("/plans/{planId}/jobs")
    List<CuttingJobDto> getCuttingJobs(@PathVariable(name = "planId") Long planId);
}
