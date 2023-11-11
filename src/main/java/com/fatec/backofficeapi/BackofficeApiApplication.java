package com.fatec.backofficeapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "backoffice", version = "1", description = "API desenvolvida para o trabalho de Estrutura de Dados"))
public class BackofficeApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackofficeApiApplication.class, args);
	}

}
