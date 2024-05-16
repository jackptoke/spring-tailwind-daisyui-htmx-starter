package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import dev.toke.springthymehtmxstarter.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final WebClient webClient;

    @Override
    public Flux<WorkOrder> getOpenWorkOrders(LocalDate date) {
        return webClient.get().uri("/work-orders?releaseDueDate=2024-05-17&status=O")
                .retrieve()
                .bodyToFlux(WorkOrder.class);
    }
}
