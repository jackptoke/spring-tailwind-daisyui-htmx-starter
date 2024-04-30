package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;

import java.util.List;

public interface BatchOrderService {
    List<BatchOrder> getBatchOrders();
    List<BatchOrder> getUnplannedBatchOrders();
    BatchOrder createBatchOrder(BatchOrder batchOrder);
    BatchOrder updateBatchOrder(BatchOrder batchOrder);
    void deleteBatchOrder(BatchOrder batchOrder);
}
