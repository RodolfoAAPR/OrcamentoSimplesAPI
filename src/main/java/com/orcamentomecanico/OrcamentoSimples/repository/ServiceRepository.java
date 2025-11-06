package com.orcamentomecanico.OrcamentoSimples.repository;

import com.orcamentomecanico.OrcamentoSimples.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
