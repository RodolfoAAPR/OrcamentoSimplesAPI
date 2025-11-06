package com.orcamentomecanico.OrcamentoSimples.service;

import com.orcamentomecanico.OrcamentoSimples.model.BudgetModel;
import com.orcamentomecanico.OrcamentoSimples.repository.BudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<BudgetModel> findAllBudgets() {
        return budgetRepository.findAll();
    }

    public BudgetModel findBudgetById(Long id) {
        return budgetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Budget not found with id " + id));
    }

    public BudgetModel createBudget(BudgetModel budgetModel) {
        budgetModel.setStatus("PENDING");
        budgetModel.setDaysWorked(0);
        BudgetModel savedBudget = budgetRepository.save(budgetModel);
        // Recarrega o orçamento recém-salvo para garantir que todas as relações EAGER sejam populadas
        return findBudgetById(savedBudget.getId());
    }

    public BudgetModel approveBudget(Long id) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("APPROVED");
        return budgetRepository.save(budget);
    }

    public BudgetModel startService(Long id) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("IN_PROGRESS");
        return budgetRepository.save(budget);
    }

    public BudgetModel completeService(Long id, int daysWorked) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("COMPLETED");
        budget.setDaysWorked(daysWorked);
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
