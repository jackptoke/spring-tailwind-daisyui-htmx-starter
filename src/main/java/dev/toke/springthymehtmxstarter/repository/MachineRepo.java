package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Long> {
}
