package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.WorkPlan;
import dev.toke.springthymehtmxstarter.repository.WorkPlanRepo;
import dev.toke.springthymehtmxstarter.service.WorkPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkPlanServiceImpl implements WorkPlanService {
    private final WorkPlanRepo workPlanRepo;

    @Override
    public List<WorkPlan> getWorkPlans() {
        return workPlanRepo.findAll();
    }

    @Override
    public WorkPlan getWorkPlanById(Long id) {
        return workPlanRepo.findById(id).orElse(null);
    }

    @Override
    public WorkPlan createWorkPlan(WorkPlan workPlan) {
        if(workPlanRepo.existsById(workPlan.getId())) throw new RuntimeException("Plan already exists");
        return workPlanRepo.save(workPlan);
    }

    @Override
    public WorkPlan updateWorkPlan(WorkPlan workPlan) {
        var plan = workPlanRepo.findById(workPlan.getId()).orElse(null);
        if(plan == null) throw new RuntimeException("Plan not found");
        plan.setDescription(workPlan.getDescription());
        plan.setStartDate(workPlan.getStartDate());
        plan.setRunDate(workPlan.getRunDate());
        plan.setPriority(workPlan.getPriority());
        plan.setProductionStatus(workPlan.getProductionStatus());
        plan.setTransferStatus(workPlan.getTransferStatus());
        plan.setWorkOrders(workPlan.getWorkOrders());
        plan.setSelectedMachines(workPlan.getSelectedMachines());
        return workPlanRepo.save(plan);
    }

    @Override
    public void deleteWorkPlan(Long id) {
        workPlanRepo.deleteById(id);
    }
}
