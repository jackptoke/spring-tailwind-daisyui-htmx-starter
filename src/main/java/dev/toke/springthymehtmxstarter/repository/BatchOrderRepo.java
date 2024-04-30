package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchOrderRepo extends JpaRepository<BatchOrder, Long> {
    @Query(value = "SELECT * FROM BatchOrder WHERE workplan_id IS NULL", nativeQuery = true)
    List<BatchOrder> findAllUnplannedBatchOrders();
}
