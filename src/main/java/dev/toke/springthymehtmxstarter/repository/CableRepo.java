package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.Cable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CableRepo extends JpaRepository<Cable, Long> {
}
