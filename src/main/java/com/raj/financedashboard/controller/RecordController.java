package com.raj.financedashboard.controller;

import com.raj.financedashboard.model.FinancialRecord;
import com.raj.financedashboard.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialRecord create(
            @RequestBody FinancialRecord record,
            @RequestParam String role) {

        return service.save(record, role);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }
}