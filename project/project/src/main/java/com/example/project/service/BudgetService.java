package com.example.project.service;

import com.example.project.entity.Budget;
import com.example.project.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    // Get all budgets
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    // Get budget by its ID
    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    // Save a new budget
    public Budget saveBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    // Delete budget by ID
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    // Update budget by ID
    public Budget updateid(Long id, Budget budgetDetails) {
        if (budgetRepository.existsById(id)) {
            Budget obj = budgetRepository.findById(id).get();
            obj.setId(id);  // If you want to keep the ID same
            obj.setAmount(budgetDetails.getAmount());
            obj.setDescription(budgetDetails.getDescription());
            return budgetRepository.save(obj);
        }
        return null;  // If not found, return null
    }
}
