package com.orcamentomecanico.OrcamentoSimples.repository;

import com.orcamentomecanico.OrcamentoSimples.model.BudgetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetModel, Long> {
}
