package com.orcamentomecanico.OrcamentoSimples.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionarios") // Renomeando a tabela para português
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class StaffModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;
}
