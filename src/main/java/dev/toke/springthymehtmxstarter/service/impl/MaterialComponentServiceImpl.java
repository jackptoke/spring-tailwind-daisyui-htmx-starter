package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.MaterialComponent;
import dev.toke.springthymehtmxstarter.repository.MaterialComponentRepo;
import dev.toke.springthymehtmxstarter.service.MaterialComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialComponentServiceImpl implements MaterialComponentService {
    private final MaterialComponentRepo materialComponentRepo;
    @Override
    public List<MaterialComponent> getMaterialComponents() {
        return materialComponentRepo.findAll();
    }

    @Override
    public MaterialComponent getMaterialComponent(Long id) {
        return materialComponentRepo.findById(id).orElse(null);
    }

    @Override
    public MaterialComponent getMaterialComponentByPartNumber(String partNumber) {
        return materialComponentRepo.findByName(partNumber);
    }

    @Override
    public MaterialComponent addComponent(MaterialComponent newComponent) {
        var existing = materialComponentRepo.findByName(newComponent.getName());
        if(existing != null)
            throw new RuntimeException("Component already exists");
        if(newComponent.getId() != null)
            existing = materialComponentRepo.findById(newComponent.getId()).orElse(null);
        if(existing != null)
            throw new RuntimeException("Component already exists");

        return materialComponentRepo.save(newComponent);
    }

    @Override
    public MaterialComponent updateComponent(MaterialComponent materialComponent) {
        var existing = materialComponentRepo.findById(materialComponent.getId()).orElse(null);
        if(existing == null)
            throw new RuntimeException("Component not found");
        if(!materialComponent.getName().equalsIgnoreCase(existing.getName())){
            var existing2 = materialComponentRepo.findByName(materialComponent.getName());
            if(existing2 != null)
                throw new RuntimeException("Part number already exists");
            existing.setName(materialComponent.getName());
        }
        existing.setUpdatedAt(LocalDateTime.now());
        existing.setUpdatedBy(materialComponent.getUpdatedBy());
        existing.setDescription(materialComponent.getDescription());
        existing.setWeightUnit(materialComponent.getWeightUnit());
        existing.setUom(materialComponent.getUom());
        existing.setWeightPerUnit(materialComponent.getWeightPerUnit());
        existing.setSupplierPartNumber(materialComponent.getSupplierPartNumber());
        existing.setCustomerPartNumber(materialComponent.getCustomerPartNumber());
        return materialComponentRepo.save(existing);
    }

    @Override
    public void deleteComponent(Long id) {
        materialComponentRepo.deleteById(id);
    }
}
