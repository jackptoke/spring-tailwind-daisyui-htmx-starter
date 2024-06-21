package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.*;
import dev.toke.springthymehtmxstarter.data.dto.display.PlanDisplay;
import dev.toke.springthymehtmxstarter.data.model.PlanPriority;
import dev.toke.springthymehtmxstarter.service.BatchOrderService;
import dev.toke.springthymehtmxstarter.service.MachineService;
import dev.toke.springthymehtmxstarter.service.WorkOrderService;
import dev.toke.springthymehtmxstarter.service.WorkPlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/plans")
@RequiredArgsConstructor
@Slf4j
public class PlanController {
    private final WorkPlanService workPlanService;
    private final BatchOrderService batchOrderService;
    private final MachineService machineService;
    private final WorkOrderService workOrderService;

    @GetMapping
    public String index(Model model) {
//        LocalDate from = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
//        LocalDate to = from.plusDays(14);
        Long startPlanId = 7660L;
        var plans = workPlanService.getWorkPlansGreaterThan(startPlanId);
        var plansDisplay = plans.stream().map(this::convertPlanDtoToPlanDisplay).toList();
        model.addAttribute("plans", plansDisplay);
        return "plans/index";
    }

    @GetMapping("/new")
    public String newPlan(Model model) {
        log.info("New plan");
        LocalDate today = LocalDate.of(2024, 5, 15);
        var workOrders = workOrderService.getUnplannedWorkOrders(today);
        var plannedWorkOrders = new ArrayList<WorkOrderWithCircuitCountDto>();
        model.addAttribute("plan", new PlanFormData());
        model.addAttribute("priorities", PlanPriority.values());
        model.addAttribute("workOrders", workOrders);
        model.addAttribute("plannedWorkOrders", plannedWorkOrders);
        WorkOrderDto test = new WorkOrderDto();

        var unplannedBatches = batchOrderService.getUnplannedBatchOrders().stream().map(BatchOrderData::from);
//        model.addAttribute("unplannedBatches", unplannedBatches);

        return "plans/plan_form :: plan-form";
    }

    @GetMapping("/machines")
    public String selectPlanMachines(Model model) {
        log.info("Machine selection page");
        model.addAttribute("plan", new PlanFormData());
        model.addAttribute("machines", machineService.getMachines());
        model.addAttribute("cuttingJobs", workPlanService.getCuttingJobs(7671L));
        var machineConfigData = new MachineConfigFormData(1,
                "Some machine", 40, 40,
                40, 240, 5000,
                true, true, true,
                true, "BLACK");
        model.addAttribute("machineConfig", machineConfigData);

//        model.addAttribute("priorities", PlanPriority.values());
//        var unplannedBatches = batchOrderService.getUnplannedBatchOrders().stream().map(BatchOrderData::from);
//        model.addAttribute("unplannedBatches", unplannedBatches);

        return "plans/plan_machines :: plan-machines";
    }

    @GetMapping("/optimize")
    public String optimizePlan(Model model) {
        log.info("Optimize jobs");
        model.addAttribute("plan", new PlanFormData());
        model.addAttribute("cuttingJobs", workPlanService.getCuttingJobs(7671L));
        return "plans/plan_optimize :: plan-machines";
    }

    @GetMapping("/day/{day}/month/{month}/year/{year}")
    public String changeDate(Model model,
                             @PathVariable int day,
                             @PathVariable int month,
                             @PathVariable int year) {
        LocalDate date = LocalDate.of(year, month, day);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("firstDay", date.withDayOfMonth(1));
        model.addAttribute(
                "lastDay", date.with(TemporalAdjusters
                                .lastDayOfMonth())
                        .getDayOfMonth());
        return "fragments/datepicker :: datepicker";
    }

    @PostMapping
    public String createPlan(Model model, PlanFormData planFormData) {
        return "redirect:plans/index";
    }
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private PlanDisplay convertPlanDtoToPlanDisplay(WorkPlanDto planDto) {
        return new PlanDisplay(
                planDto.getId(),
                planDto.getDescription(),
                dateTimeFormatter.format(planDto.getStartDate()),
                dateTimeFormatter.format(planDto.getEndDate()),
                dateTimeFormatter.format(planDto.getRunDate()),
                planDto.getPriority(),
                planDto.getComputerName(),
                planDto.getProductionStatus().getStatus(),
                planDto.getTransferStatus(),
                ""+planDto.getMachineConfig().getId(),
                planDto.getWorkOrders().size(),
                dateTimeFormatter.format(planDto.getUpdatedAt())
        );
    }
}
