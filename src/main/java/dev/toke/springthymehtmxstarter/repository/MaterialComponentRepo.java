package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.MaterialComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialComponentRepo extends JpaRepository<MaterialComponent, Long> {
    MaterialComponent findByPartNumber(String partNumber);
}
