package com.orcamentomecanico.OrcamentoSimples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.orcamentomecanico.OrcamentoSimples.model"})
public class OrcamentoSimplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrcamentoSimplesApplication.class, args);
	}

}
