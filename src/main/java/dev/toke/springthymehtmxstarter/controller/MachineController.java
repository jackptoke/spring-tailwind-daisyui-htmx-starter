package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.dto.MachineConfigFormData;
import dev.toke.springthymehtmxstarter.data.dto.MachineConfigurationDto;
import dev.toke.springthymehtmxstarter.data.dto.MachineDto;
import dev.toke.springthymehtmxstarter.data.dto.MachineFormData;
import dev.toke.springthymehtmxstarter.data.model.PrintColour;
import dev.toke.springthymehtmxstarter.data.model.User;
import dev.toke.springthymehtmxstarter.events.ResetMachineDataEvent;
import dev.toke.springthymehtmxstarter.service.MachineService;
import dev.toke.springthymehtmxstarter.service.UserService;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxRequest;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/machines")
@RequiredArgsConstructor
@Slf4j
public class MachineController {
    private final MachineService machineService;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping
    public String index(Model model, HtmxRequest htmxRequest) {
        log.info("Retrieving all machines");
        var machines = machineService.getMachines();
        log.info("# machines retrieved: {}", machines.size());
        for (var machine : machines) {
            if(machine.getConfiguration() == null)
                machine.setConfiguration(new MachineConfigurationDto());
        }
        model.addAttribute("machines", machines);
        if(!machines.isEmpty()) {
            model.addAttribute("displayMachine", machines.get(0));
        }
        else {
            model.addAttribute("machineConfig", new MachineDto());
        }

        if(htmxRequest.isHtmxRequest()) {
            log.info("HtmxRequest received for machines data");
            log.info("Machines #: " + machineService.getMachines().size());
            return "machines/machines_list :: machines_list";
        }
        return "machines/index";
    }

    @GetMapping("/home")
    public String redirect(Model model, RedirectAttributes redirectAttributes,
                                 HtmxRequest htmxRequest) {
        log.info("Redirecting ...");
        model.addAttribute("machines", machineService.getMachines());
        return "machines/machines_list";
    }

    @GetMapping("/new")
    public String newMachine(Model model) {
        log.info("New machine page requested");
        model.addAttribute("page_title", "New Machine");
        model.addAttribute("machine", new MachineFormData());
        return "machines/machine_form :: machine_form";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        log.info("Retrieving machine with id {}", id);

        MachineDto machine = machineService.getMachineById(id);
        model.addAttribute("page_title", "Machine " + machine.getMachineName());
        model.addAttribute("machine", toMachineFormData(machine));
        return "machines/machine_form :: machine_form";
    }

    @DeleteMapping(value = "/{id}")
    public HtmxResponse delete(Model model, @PathVariable Integer id, RedirectAttributes redirectAttributes,
                         HtmxRequest htmxRequest) {
        log.info("Delete button {}", htmxRequest.getTriggerId());
        log.info("Deleting machine with id {}", id);
        machineService.deleteMachine(id);
        if("delete-button".equals(htmxRequest.getTriggerId())){
            log.info("Redirecting delete button");
            redirectAttributes.addFlashAttribute("successMessage", "Deleted Machine!");
            model.addAttribute("machines", machineService.getMachines());
            return HtmxResponse.builder()
                    .view("machines/machines_list :: machines_list")
                    .build();
        }
        return HtmxResponse.builder().build();
    }

    @PostMapping
    @HxRequest
    public String create(MachineFormData machineData, Model model) {
        log.info("Creating machine {}", machineData.getMachineName());

        // TODO: - Update to Logged in user
        User user = userService.findByUsername("jackptoke");

        machineService.addMachine(
            new MachineDto(
            null,
            machineData.getMachineName(),
            machineData.getMachineBrand(),
            machineData.getMachineModel(),
                    machineData.getSerialNumber(),
                    machineData.getDataPath(),
                    machineData.getFeedbackPath(),
                    LocalDateTime.now(),
                    user.getUsername(),
                    LocalDateTime.now(),
                    user.getUsername(),
                    1234,
                    machineData.getIsActive(),
                    14, null));
        model.addAttribute("machine", new MachineFormData());
//        return HtmxResponse.builder()
//                .view("index :: machines")
//                .view("index :: machine-form")
//                .build();
        return "machines/show :: machine-form";
    }

    @PostMapping("/reset")
    public String reset(Model model) {
        eventPublisher.publishEvent(new ResetMachineDataEvent());
        model.addAttribute("machines", machineService.getMachines());
        return "fragments/machines :: machine-list";
    }

    private MachineFormData toMachineFormData(MachineDto machine) {
        return new MachineFormData(machine.getId(),
                machine.getMachineName(),
                machine.getMachineType(),
                machine.getMachineSubType(),
                machine.getSerialNumber(),
                machine.getWpcsDataPath(),
                machine.getWpcsFeedbackPath(),
                machine.getIsInUse(),
                machine.getUpdatedBy()
                );
    }

    private PrintColour getPrintColour(String colour) {
        return switch (colour) {
            case "WHITE" -> PrintColour.WHITE;
            case "BLACK" -> PrintColour.BLACK;
            case "BOTH" -> PrintColour.BOTH;
            case "NONE" -> PrintColour.NONE;
            default -> PrintColour.WHITE;
        };
    }
}
