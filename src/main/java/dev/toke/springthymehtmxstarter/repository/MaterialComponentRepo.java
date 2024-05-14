package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.MaterialComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaterialComponentRepo extends JpaRepository<MaterialComponent, Long> {
    @Query(value = "SELECT * FROM MaterialComponents M JOIN BaseComponents B ON B.Id = M.componentId WHERE B.name = :name", nativeQuery = true)
    MaterialComponent findByName(String name);
    MaterialComponent findMaterialComponentByName(String name);
}
