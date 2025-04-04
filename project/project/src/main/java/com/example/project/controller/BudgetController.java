package com.example.project.controller;

import com.example.project.entity.Budget;
import com.example.project.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Get all budgets
    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    // Get a budget by its ID
    @GetMapping("/{id}")
    public Optional<Budget> getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id);
    }

    // Save a new budget (POST request to /budgets/post)
    @PostMapping("/post")  
    public Budget saveBudget(@RequestBody Budget budget) {
        return budgetService.saveBudget(budget);
    }

    // Delete a budget by its ID
    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }

    // Update a budget by its ID
    @PutMapping("/updatee/{id}")
    public Budget updatebyid(@PathVariable Long id, @RequestBody Budget budgetDetails) {
        return budgetService.updateid(id, budgetDetails);
    }
}
	