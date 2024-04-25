package dev.toke.springthymehtmxstarter.events;


import org.springframework.context.ApplicationEvent;

import java.time.Instant;

public class ResetMachineDataEvent extends ApplicationEvent {
    public ResetMachineDataEvent() {
        super(Instant.now());
    }
}
