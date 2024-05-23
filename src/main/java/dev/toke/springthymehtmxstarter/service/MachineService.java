package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.MachineDto;
import dev.toke.springthymehtmxstarter.data.model.Machine;

import java.util.List;

public interface MachineService {
    List<MachineDto> getMachines();
    MachineDto getMachineById(Integer id);
    MachineDto addMachine(MachineDto machine);
    MachineDto updateMachine(Integer id, MachineDto machine);
    void deleteMachine(Integer id);
}
