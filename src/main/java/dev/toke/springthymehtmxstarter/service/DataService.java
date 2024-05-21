package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface DataService {
    Flux<WorkOrderDto> getOpenWorkOrders(LocalDate date);
}
