package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.Machine;

import java.util.List;

public interface MachineService {
    List<Machine> getMachines();
    List<Machine> getMachine(String nameOrIp);
    Machine getMachineById(Long id);
    Machine getMachineByName(String name);
    Machine addMachine(Machine machine);
    Machine updateMachine(Machine machine);
    void deleteMachine(Long id);
}
