package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import dev.toke.springthymehtmxstarter.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {
    private final WorkOrderService workOrderService;

    @GetMapping
    public String index(Model model) {
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        List<WorkOrderDto> workOrders = workOrderService.getWorkOrders(date, "O");
        model.addAttribute("workOrders", workOrders);

        model.addAttribute("OrderIds", workOrders.stream().map(WorkOrderDto::getId).toList());
        return "workorders/index";
    }
}
