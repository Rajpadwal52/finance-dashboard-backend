package com.raj.financedashboard.controller;

import com.raj.financedashboard.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final RecordService service;

    public DashboardController(RecordService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary(@RequestParam String role) {

        if (role.equals("VIEWER") || role.equals("ANALYST") || role.equals("ADMIN")) {
            return service.getSummary();
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}