package com.orcamentomecanico.OrcamentoSimples.repository;

import com.orcamentomecanico.OrcamentoSimples.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
}
