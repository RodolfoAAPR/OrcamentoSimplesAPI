package com.orcamentomecanico.OrcamentoSimples.repository;

import com.orcamentomecanico.OrcamentoSimples.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
