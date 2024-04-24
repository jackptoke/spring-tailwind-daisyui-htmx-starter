package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalTime;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final MachineRepo machineRepo;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("machines", machineRepo.findAll());
        return "index";
    }


    @GetMapping(value = "/htmx")
    public String htmx(@RequestParam(value="delay", required = false) Integer delayInSeconds,
                       Model model,
                       HttpServletRequest request) throws InterruptedException {
        String elementId = request.getHeader("Hx-Trigger");
        log.info("elementId: {}", elementId);
        if(delayInSeconds != null) {
            Thread.sleep(delayInSeconds*1000L);
        }
        model.addAttribute("currentTime", LocalTime.now());
        return "fragments/htmx :: message";
    }

    @GetMapping(value ="/greet")
    public String greet(Model model) {
        model.addAttribute("name", "Jack");
        log.info("greet has been executed");
        return "fragments/greet :: greeting";
    }

    @GetMapping(value = "/counter")
    public String counter(Model model) {
        return "fragments/counter :: counter";
    }
}
