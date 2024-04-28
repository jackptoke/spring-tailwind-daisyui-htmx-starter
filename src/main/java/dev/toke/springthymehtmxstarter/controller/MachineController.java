package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.events.ResetMachineDataEvent;
import dev.toke.springthymehtmxstarter.data.model.Machine;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/machines")
@RequiredArgsConstructor
@Slf4j
public class MachineController {
    private final MachineRepo machineRepo;
    private final ApplicationEventPublisher eventPublisher;

    @ResponseBody
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String delete(Model model, @PathVariable long id) {
        log.info("Deleting machine with id {}", id);
        machineRepo.deleteById(id);
        return "";
    }

    @PostMapping
    public HtmxResponse create(Model model, @RequestParam("machineName") String machineName,
                               @RequestParam("machineDescription") String machineDescription,
                               @RequestParam("machineIp") String machineIp) {
        log.info("Creating machine {}", machineName);
        machineRepo.save(new Machine(null, machineName, machineDescription, machineIp));
        model.addAttribute("machines", machineRepo.findAll());
        return HtmxResponse.builder()
                .view("index :: machines")
                .view("index :: machine-form")
                .build();
    }

    @PostMapping("/reset")
    public String reset(Model model) {
        eventPublisher.publishEvent(new ResetMachineDataEvent());
        model.addAttribute("machines", machineRepo.findAll());
        return "fragments/machines :: machine-list";
    }

}
