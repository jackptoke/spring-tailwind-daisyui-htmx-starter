package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.Printer;
import dev.toke.springthymehtmxstarter.repository.PrinterRepo;
import dev.toke.springthymehtmxstarter.service.PrinterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrinterServiceImpl implements PrinterService {
    private final PrinterRepo printerRepo;

    @Override
    public List<Printer> findAll() {
        return printerRepo.findAll();
    }

    @Override
    public List<Printer> findAllByUsername(String username) {
        return printerRepo.findByUsername(username);
    }

    @Override
    public Printer findById(Long id) {
        return printerRepo.findById(id).orElse(null);
    }

    @Override
    public Printer save(Printer printer) {
        if (printer.getId() != null) {
            var existingPrinter = printerRepo.findById(printer.getId()).orElse(null);
            if (existingPrinter != null) throw new RuntimeException("Printer with id " + printer.getId() + " already exists");
        }

        return printerRepo.save(printer);
    }

    @Override
    public Printer update(Printer printer) {
        var existingPrinter = printerRepo.findById(printer.getId()).orElse(null);
        if (existingPrinter == null) throw new RuntimeException("Printer with id " + printer.getId() + " not found");
        return printerRepo.save(printer);
    }

    @Override
    public void deleteById(Long id) {
        printerRepo.deleteById(id);
    }
}
