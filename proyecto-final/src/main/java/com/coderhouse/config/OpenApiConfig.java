package com.coderhouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	@Bean
	OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("Facturador Maria Pia Grosso | Proyecto final CoderHouse")
						.version("1.1.0")
						.description("La API REST proporciona distintos endpoints con la finalidad de realizar operaciones "
                        		+ "CRUD (Crear, Leer, Actualizar, Eliminar) tanto para clientes como "
                        		+ "para productos. como asi tambien, generar compras de productos, y listar las diferentes "
                        		+ "facturas generadas por las mismas."
                        		+ "La Api está documentada utilizando Swagger, lo que facilita la comprensión de los endpoints y su uso.")
						.contact(new Contact()
								.name("Maria Pia Grosso")
								.email("mariapiagrosso@gmail.com")
								.url("https://coderhouse.com.ar"))
						.license(new License()
								.name("Licencia")
								.url(""))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
	}
	
	
}
