package com.orcamentomecanico.OrcamentoSimples.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orcamentos") // Renomeando a tabela para português
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class BudgetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veiculo_id", nullable = false) // Renomeando a coluna de chave estrangeira
    private VehicleModel veiculo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avaliador_id", nullable = false) // Renomeando a coluna de chave estrangeira
    private StaffModel avaliador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "orcamento_servicos", // Renomeando a tabela de junção
        joinColumns = @JoinColumn(name = "orcamento_id"),
        inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<ServiceModel> servicos;

    @Column(name = "status")
    private String status; // PENDENTE, APROVADO, EM_ANDAMENTO, CONCLUIDO

    @Column(name = "dias_trabalhados")
    private Integer diasTrabalhados;
}
