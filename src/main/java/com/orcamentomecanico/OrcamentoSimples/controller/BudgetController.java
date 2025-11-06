package com.orcamentomecanico.OrcamentoSimples.controller;

import com.orcamentomecanico.OrcamentoSimples.model.BudgetModel;
import com.orcamentomecanico.OrcamentoSimples.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<BudgetModel> getAllBudgets() {
        return budgetService.findAllBudgets();
    }

    @GetMapping("/{id}")
    public BudgetModel getBudgetById(@PathVariable Long id) {
        return budgetService.findBudgetById(id);
    }

    @PostMapping
    public BudgetModel createBudget(@RequestBody BudgetModel budgetModel) {
        return budgetService.createBudget(budgetModel);
    }

    @PutMapping("/{id}/approve")
    public BudgetModel approveBudget(@PathVariable Long id) {
        return budgetService.approveBudget(id);
    }

    @PutMapping("/{id}/start")
    public BudgetModel startService(@PathVariable Long id) {
        return budgetService.startService(id);
    }

    @PutMapping("/{id}/complete")
    public BudgetModel completeService(@PathVariable Long id, @RequestParam int daysWorked) {
        return budgetService.completeService(id, daysWorked);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
    }
}
