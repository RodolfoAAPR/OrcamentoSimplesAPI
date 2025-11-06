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
                .orElseThrow(() -> new EntityNotFoundException("Orçamento não encontrado com o ID " + id));
    }

    public BudgetModel createBudget(BudgetModel budgetModel) {
        budgetModel.setStatus("PENDENTE");
        budgetModel.setDiasTrabalhados(0);
        BudgetModel savedBudget = budgetRepository.save(budgetModel);
        return findBudgetById(savedBudget.getId());
    }

    public BudgetModel approveBudget(Long id) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("APROVADO");
        return budgetRepository.save(budget);
    }

    public BudgetModel startService(Long id) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("EM_ANDAMENTO");
        return budgetRepository.save(budget);
    }

    public BudgetModel completeService(Long id, int diasTrabalhados) {
        BudgetModel budget = findBudgetById(id);
        budget.setStatus("CONCLUIDO");
        budget.setDiasTrabalhados(diasTrabalhados);
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
