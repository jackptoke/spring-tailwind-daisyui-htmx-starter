package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.Printer;

import java.util.List;

public interface PrinterService {
    List<Printer> findAll();
    List<Printer> findAllByUsername(String username);
    Printer findById(Long id);
    Printer save(Printer printer);
    Printer update(Printer printer);
    void deleteById(Long id);
}
