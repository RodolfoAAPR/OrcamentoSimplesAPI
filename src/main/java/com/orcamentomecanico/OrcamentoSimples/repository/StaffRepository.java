package com.orcamentomecanico.OrcamentoSimples.repository;

import com.orcamentomecanico.OrcamentoSimples.model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffModel, Long> {
}
