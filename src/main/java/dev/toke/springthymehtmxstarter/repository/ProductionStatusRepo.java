package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.ProductionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionStatusRepo extends JpaRepository<ProductionStatus, Long> {
}
