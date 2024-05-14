package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Long> {
    @Query(value = "SELECT * FROM Machines WHERE name = :nameOrIp OR ipAddress = :nameOrIp", nativeQuery = true)
    List<Machine> findByMachineNameOrIpAddress(String nameOrIp);
    @Query(value = "SELECT * FROM Machines WHERE name = :name ", nativeQuery = true)
    Machine findByMachineName(String name);
}
