package com.coderhouse.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Schema(description = "Modelo de Producto", title = "Modelo de Producto")
@Entity
@Table(name = "Productos")
public class Producto {

	@Schema(description = "ID del Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
	private Long id;
	
	 @Schema(description = "Nombre del producto", example = "PS4 PRO", requiredMode = Schema.RequiredMode.REQUIRED)
	 @Column(nullable = false)
	private String nombre;
	 
	 @Schema(description = "Precio del producto", example = "5875.29", requiredMode = Schema.RequiredMode.REQUIRED)
	 @Column(nullable = false)
	 private BigDecimal precioVentaProducto;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_cliente", 
			joinColumns = @JoinColumn(name = "producto_id"), 
			inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	@JsonIgnore
	private List<Cliente> Clientes = new ArrayList<>();

	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	

	
}
