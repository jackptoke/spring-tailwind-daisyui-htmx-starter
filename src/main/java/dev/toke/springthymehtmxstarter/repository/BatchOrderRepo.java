package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchOrderRepo extends JpaRepository<BatchOrder, Long> {
//    @Query(value = "SELECT * FROM BatchOrders WHERE workplan_id IS NULL", nativeQuery = true)
//    List<BatchOrder> findAllUnplannedBatchOrders();
//    @Query(value = "SELECT * FROM BatchOrders WHERE workplan_id = :workPlanId", nativeQuery = true)
//    List<BatchOrder> findAllByWorkPlanId(Long workPlanId);
//    @Query(value = "SELECT * FROM BatchOrders WHERE workplan_id IS NULL OR workplan_id = :batchId", nativeQuery = true)
//    List<BatchOrder> findAllByUnplannedAndWorkPlanId(Long batchId);
}
