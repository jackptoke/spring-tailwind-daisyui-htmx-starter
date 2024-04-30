package dev.toke.springthymehtmxstarter.repository;


import dev.toke.springthymehtmxstarter.data.model.CableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CableTypeRepo extends JpaRepository<CableType, Long> {
}
