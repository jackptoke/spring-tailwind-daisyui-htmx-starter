package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;
import dev.toke.springthymehtmxstarter.service.BatchOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch-orders")
@Slf4j
@RequiredArgsConstructor
public class BatchOrderController {
    private final BatchOrderService batchOrderService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("batchOrders", batchOrderService.getBatchOrders());
        return "batch-orders/index";
    }

    @GetMapping("/new")
    public String newBatchForm(Model model) {
        model.addAttribute("batchOrder", new BatchOrder());
        return "batch-orders/form";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("batchOrders", batchOrderService.getBatchOrders());
        return "batch-orders/list";
    }
}
