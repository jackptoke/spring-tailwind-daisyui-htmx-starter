package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.Machine;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import dev.toke.springthymehtmxstarter.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService {
    private final MachineRepo machineRepo;

    @Override
    public List<Machine> getMachines() {
        return machineRepo.findAll();
    }

    @Override
    public List<Machine> getMachine(String nameOrIp) {
        return machineRepo.findByMachineNameOrIpAddress(nameOrIp);
    }

    @Override
    public Machine getMachineById(Long id) {
        return machineRepo.findById(id).orElse(null);
    }

    @Override
    public Machine getMachineByName(String name) {
        return machineRepo.findByMachineName(name);
    }

    @Override
    public Machine addMachine(Machine machine) {
        Machine currentMachine;
        if(machine.getId() != null)
            currentMachine = machineRepo.findById(machine.getId()).orElse(null);
        else
            currentMachine = machineRepo.findByMachineName(machine.getName());
        if(currentMachine != null) throw new RuntimeException("Machine already exists");

        return machineRepo.save(machine);
    }

    @Override
    public Machine updateMachine(Machine machine) {
        Machine currentMachine = machineRepo.findById(machine.getId()).orElse(null);
        if(currentMachine == null) throw new RuntimeException("Machine not found");
        currentMachine.setName(machine.getName());
        currentMachine.setBrand(machine.getBrand());
        currentMachine.setModel(machine.getModel());
        currentMachine.setDescription(machine.getDescription());
        currentMachine.setDataPath(machine.getDataPath());
        currentMachine.setFeedbackPath(machine.getFeedbackPath());
        currentMachine.setIsActive(machine.getIsActive());
        return machineRepo.save(currentMachine);
    }

    @Override
    public void deleteMachine(Long id) {
        machineRepo.deleteById(id);
    }
}
