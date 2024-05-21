package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.api.WorkOrderApi;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import dev.toke.springthymehtmxstarter.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderServiceImpl implements WorkOrderService {
    private final WorkOrderApi workOrderApi;

    @Override
    public List<WorkOrderDto> getWorkOrders(LocalDate releaseDateFrom, String status) {
        return workOrderApi.getWorkOrders(releaseDateFrom, status);
    }

    @Override
    public WorkOrderDto getWorkOrder(long id) {
        return workOrderApi.getWorkOrder(id);
    }
}
