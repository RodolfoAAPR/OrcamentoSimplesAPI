package com.orcamentomecanico.OrcamentoSimples.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicos") // Renomeando a tabela para português
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Double preco;
}
