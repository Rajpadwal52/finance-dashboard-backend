package com.raj.financedashboard.service;

import com.raj.financedashboard.model.FinancialRecord;
import com.raj.financedashboard.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordService {

    private final RecordRepository repo;

    public RecordService(RecordRepository repo) {
        this.repo = repo;
    }

    public FinancialRecord save(FinancialRecord record, String role) {

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Access Denied: Only ADMIN can create records");
        }

        if (record.getAmount() <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

public Map<String, Double> getSummary() {

    double income = repo.findByType("INCOME")
            .stream()
            .mapToDouble(FinancialRecord::getAmount)
            .sum();

    double expense = repo.findByType("EXPENSE")
            .stream()
            .mapToDouble(FinancialRecord::getAmount)
            .sum();

    double balance = income - expense;

    Map<String, Double> summary = new HashMap<>();
    summary.put("totalIncome", income);
    summary.put("totalExpense", expense);
    summary.put("balance", balance);

    return summary;
}
}