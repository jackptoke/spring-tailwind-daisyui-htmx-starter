package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.MaterialComponent;

import java.util.List;

public interface MaterialComponentService {
    List<MaterialComponent> getMaterialComponents();
    MaterialComponent getMaterialComponent(Long id);
    MaterialComponent getMaterialComponentByPartNumber(String partNumber);
    MaterialComponent addComponent(MaterialComponent newComponent);
    MaterialComponent updateComponent(MaterialComponent materialComponent);
    void deleteComponent(Long id);
}
