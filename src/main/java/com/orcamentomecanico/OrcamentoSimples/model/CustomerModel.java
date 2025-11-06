package com.orcamentomecanico.OrcamentoSimples.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes") // Renomeando a tabela para português
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf;

}
