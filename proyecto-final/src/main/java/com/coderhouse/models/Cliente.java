package com.coderhouse.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Modelo de Cliente")
@Entity
@Table(name = "Clientes")
public class Cliente {

	@Schema(description = "Id de Cliente, generado automáticamente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement

	private Long id;
	
	@Schema(description = "Nombre del cliente", example = "Maria", requiredMode = Schema.RequiredMode.REQUIRED)
	@Column(name = "Nombre")
	private String nombre;
	
	@Schema(description = "Apellido del cliente", example = "Grosso", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(nullable = false, length = 100)
    private String apellido;

	@Schema(description = "Codigo del cliente", example = "E12345678", requiredMode = Schema.RequiredMode.REQUIRED)
	@Column(unique = true, nullable = false) // Unico y notnull
	private String codcli;

	@Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
	@Column(unique = true, nullable = false) // Unico y notnull
	private int dni;
	
	@Schema(description = "Email del cliente", example = "maria.grosso@example.com")
    @Column(unique = true, length = 100)
    private String email;
	
	@Schema(description = "Fecha de Alta del Cliente", example = "2025/01/15")
    private LocalDateTime createdAt;

	@Schema(description = "Listado de productos que adquirio el cliente")
	@ManyToMany(mappedBy = "Clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();

	

}
