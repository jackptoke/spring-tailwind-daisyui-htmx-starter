package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;
import dev.toke.springthymehtmxstarter.repository.BatchOrderRepo;
import dev.toke.springthymehtmxstarter.service.BatchOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchOrderServiceImpl implements BatchOrderService {
    private final BatchOrderRepo batchOrderRepo;

    @Override
    public List<BatchOrder> getBatchOrders() {
        return batchOrderRepo.findAll();
    }

    @Override
    public List<BatchOrder> getUnplannedBatchOrders() {
        return batchOrderRepo.findAllUnplannedBatchOrders();
    }

    @Override
    public BatchOrder createBatchOrder(BatchOrder batchOrder) {
        if(batchOrder.getId() != null && batchOrderRepo.existsById(batchOrder.getId())) {
            throw new RuntimeException("Batch order already exists");
        }

        return batchOrderRepo.save(batchOrder);
    }

    @Override
    public BatchOrder updateBatchOrder(BatchOrder batchOrder) {
        var batch = batchOrderRepo.findById(batchOrder.getId()).orElse(null);
        if(batch == null) throw new RuntimeException("Batch {" + batchOrder.getId() + "} is not found");
        batch.setQuantity(batchOrder.getQuantity());
        batch.setCircuitCount(batchOrder.getCircuitCount());
        batch.setTerminationCount(batchOrder.getTerminationCount());
        batch.setCustomer(batchOrder.getCustomer());
        batch.setSiteName(batchOrder.getSiteName());
        batch.setDeliveryLocation(batchOrder.getDeliveryLocation());
        batch.setDeliveryLocation(batchOrder.getDeliveryLocation());
        batch.setReleaseLocation(batchOrder.getReleaseLocation());
        batch.setSpecialCode(batchOrder.getSpecialCode());
        batch.setPlDone(batchOrder.getPlDone());
        batch.setReleaseDueDate(batchOrder.getReleaseDueDate());
        batch.setDispatchedDate(batchOrder.getDispatchedDate());
        batch.setReleasedDate(batchOrder.getReleasedDate());
        batch.setDispatchedDate(batchOrder.getDispatchedDate());
        batch.setUpdatedBy(batchOrder.getUpdatedBy());
        batch.setUpdatedDate(batchOrder.getUpdatedDate());
        batch.setWorkPlan(batchOrder.getWorkPlan());
        return batchOrderRepo.save(batch);
    }

    @Override
    public void deleteBatchOrder(BatchOrder batchOrder) {
        var batch = batchOrderRepo.findById(batchOrder.getId()).orElse(null);
        if(batch != null) {
            batchOrderRepo.delete(batch);
        }
    }
}
