package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/machines")
@RequiredArgsConstructor
@Slf4j
public class MachineController {
    private final MachineRepo machineRepo;

    @ResponseBody
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String delete(Model model, @PathVariable long id) {
        log.info("Deleting machine with id {}", id);
        machineRepo.deleteById(id);
        return "";
    }

}
