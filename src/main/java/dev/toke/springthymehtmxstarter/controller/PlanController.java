package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.BatchOrderData;
import dev.toke.springthymehtmxstarter.data.dto.PlanFormData;
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

import java.time.LocalDate;
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
        model.addAttribute("plans", workPlanService.getWorkPlans());
        return "plans/index";
    }

    @GetMapping("/new")
    public String newPlan(Model model) {
        log.info("New plan");
        model.addAttribute("plan", new PlanFormData());
        LocalDate date = LocalDate.now();
        model.addAttribute("year", date.getYear());
        model.addAttribute("month", date.getMonthValue());
        model.addAttribute("day", date.getDayOfMonth());
        model.addAttribute("firstDay", date.withDayOfMonth(1));
        model.addAttribute(
                "lastDay", date.with(TemporalAdjusters
                                            .lastDayOfMonth())
                                            .getDayOfMonth());
        model.addAttribute("priorities", PlanPriority.values());

        var unplannedBatches = batchOrderService.getUnplannedBatchOrders().stream().map(BatchOrderData::from);
        model.addAttribute("unplannedBatches", unplannedBatches);

        return "plans/plan_form :: plan-form";
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
}
