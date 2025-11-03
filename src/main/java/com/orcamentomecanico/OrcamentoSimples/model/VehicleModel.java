package com.orcamentomecanico.OrcamentoSimples.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String color;

    private Integer year;

    private String registration;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerModel owner;


}
