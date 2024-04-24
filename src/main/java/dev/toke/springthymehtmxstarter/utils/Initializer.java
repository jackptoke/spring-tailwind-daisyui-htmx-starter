package dev.toke.springthymehtmxstarter.utils;

import dev.toke.springthymehtmxstarter.model.Machine;
import dev.toke.springthymehtmxstarter.repository.MachineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Initializer {
    private final MachineRepo machineRepo;

    @EventListener(ApplicationReadyEvent.class)
    void reset() {
        machineRepo.deleteAll();
        Stream.of(new Machine(null, "Kappa1", "The Kappa 350 - A", "10.168.1.25"),
                new Machine(null, "Kappa2", "The Kappa 350 - B", "10.168.1.24"),
                new Machine(null, "Kappa3", "The Kappa 350 - B2", "10.168.1.26"),
                new Machine(null, "Kappa4", "The Kappa 350 - C", "10.168.1.28"),
                new Machine(null, "Kappa5", "The Kappa 350 - D", "10.168.1.29"),
                new Machine(null, "Kappa6", "The Kappa 355", "10.168.1.31"),
                new Machine(null, "Kappa7", "The Kappa 355", "10.168.1.35"))
                .forEach( machineRepo::save );

    }
}
