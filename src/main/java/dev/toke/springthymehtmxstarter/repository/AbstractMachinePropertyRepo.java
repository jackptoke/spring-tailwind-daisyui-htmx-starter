package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.MachineProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractMachinePropertyRepo<T extends MachineProperty> extends JpaRepository<T, Long> {
    @Query(value = "SELECT TOP 1 * FROM MACHINES_PROPERTIES WHERE propertyName = :propertyName", nativeQuery = true)
    T findMachinePropertyByPropertyName(String propertyName);
}
