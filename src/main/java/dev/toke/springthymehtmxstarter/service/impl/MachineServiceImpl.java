package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.api.MachineApi;
import dev.toke.springthymehtmxstarter.data.dto.MachineDto;
import dev.toke.springthymehtmxstarter.data.model.Machine;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import dev.toke.springthymehtmxstarter.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService {
//    private final MachineRepo machineRepo;
    private final MachineApi machineApi;

    @Override
    public List<MachineDto> getMachines() {
        return machineApi.getMachines();
    }


    @Override
    public MachineDto getMachineById(Integer id) {
        return machineApi.getMachine(id);
    }

    @Override
    public MachineDto addMachine(MachineDto machine) {

        return machineApi.createMachine(machine);
    }

    @Override
    public MachineDto updateMachine(Integer id, MachineDto machine) {
        return machineApi.updateMachine(id, machine);
    }

    @Override
    public void deleteMachine(Integer id) {
        machineApi.deleteMachine(id);
    }
}
