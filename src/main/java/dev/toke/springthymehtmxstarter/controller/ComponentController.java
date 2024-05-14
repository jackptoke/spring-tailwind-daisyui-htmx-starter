package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.model.MaterialComponent;
import dev.toke.springthymehtmxstarter.service.MaterialComponentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/components")
@RequiredArgsConstructor
public class ComponentController {
    private final MaterialComponentService materialComponentService;

    @GetMapping
    public String getComponents(Model model) {
        model.addAttribute("components", materialComponentService.getMaterialComponents());
        return "components/index";
    }

    @GetMapping("/new")
    public String newComponent(Model model) {
        model.addAttribute("component", new MaterialComponent());
        return "components/form";
    }

    @PostMapping
    public String newComponent(@Valid @ModelAttribute("component") MaterialComponent component, Model model) {
        materialComponentService.addComponent(component);
        model.addAttribute("model", new MaterialComponent());
        return "components/form";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("components", materialComponentService.getMaterialComponents());
        return "components/index";
    }
}
