package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.WorkPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlanRepo extends JpaRepository<WorkPlan, Long> {
}
