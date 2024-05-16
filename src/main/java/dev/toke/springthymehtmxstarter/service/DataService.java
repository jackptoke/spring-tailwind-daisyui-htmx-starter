package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface DataService {
    Flux<WorkOrder> getOpenWorkOrders(LocalDate date);
}
