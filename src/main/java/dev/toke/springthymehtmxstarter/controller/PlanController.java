package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.BatchOrderData;
import dev.toke.springthymehtmxstarter.data.dto.PlanFormData;
import dev.toke.springthymehtmxstarter.data.dto.WorkPlanDto;
import dev.toke.springthymehtmxstarter.data.dto.display.PlanDisplay;
import dev.toke.springthymehtmxstarter.data.model.PlanPriority;
import dev.toke.springthymehtmxstarter.service.BatchOrderService;
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
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;

@Controller
@RequestMapping("/plans")
@RequiredArgsConstructor
@Slf4j
public class PlanController {
    private final WorkPlanService workPlanService;
    private final BatchOrderService batchOrderService;

    @GetMapping
    public String index(Model model) {
        LocalDate from = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        LocalDate to = from.plusDays(14);
        var plans = workPlanService.getWorkPlans(from, to);
        var plansDisplay = plans.stream().map(this::convertPlanDtoToPlanDisplay).toList();
        model.addAttribute("plans", plansDisplay);
        var p = plansDisplay.get(0);
        p.computerName();
        p.description();
        p.id();
        p.machineConfig();
        p.priority();
        p.productionStatus();
        p.runDate();
        p.startDate();
        p.endDate();
        p.transferStatus();
        return "plans/index";
    }

    @GetMapping("/new")
    public String newPlan(Model model) {
        log.info("New plan");
        model.addAttribute("plan", new PlanFormData());
        model.addAttribute("priorities", PlanPriority.values());
        var unplannedBatches = batchOrderService.getUnplannedBatchOrders().stream().map(BatchOrderData::from);
        model.addAttribute("unplannedBatches", unplannedBatches);

        return "plans/plan_form :: plan-form";
    }

    @GetMapping("/machines")
    public String selectPlanMachines(Model model) {
        log.info("Machine selection page");
        model.addAttribute("plan", new PlanFormData());
        model.addAttribute("cuttingJobs", workPlanService.getCuttingJobs(7671L));

//        model.addAttribute("priorities", PlanPriority.values());
//        var unplannedBatches = batchOrderService.getUnplannedBatchOrders().stream().map(BatchOrderData::from);
//        model.addAttribute("unplannedBatches", unplannedBatches);

        return "plans/plan_machines :: plan-machines";
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
