package com.orcamentomecanico.OrcamentoSimples.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veiculos") // Renomeando a tabela para português
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "cor")
    private String cor;

    @Column(name = "ano") // Mapeando explicitamente para evitar conflitos
    private Integer ano;

    @Column(name = "placa")
    private String placa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietario_id") // Renomeando a coluna de chave estrangeira
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CustomerModel proprietario;


}
