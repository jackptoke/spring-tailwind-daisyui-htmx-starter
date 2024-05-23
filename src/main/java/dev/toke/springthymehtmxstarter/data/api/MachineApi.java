package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.MachineDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface MachineApi {
    @GetExchange("/machines")
    List<MachineDto> getMachines();
    @GetExchange("/machines/{id}")
    MachineDto getMachine(@PathVariable("id") Integer id);
    @PostExchange
    MachineDto createMachine(@RequestBody MachineDto machine);
    @PutExchange("/machines/{id}")
    MachineDto updateMachine(@PathVariable("id") Integer id, @RequestBody MachineDto machine);
    @DeleteExchange("/machines/{id}")
    void deleteMachine(@PathVariable("id") Integer id);
}
