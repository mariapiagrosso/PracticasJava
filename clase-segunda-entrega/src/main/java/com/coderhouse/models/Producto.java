package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

@Entity
@Table(name = "Productos")
public class Producto {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement

	private Long id;
	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_cliente", 
			joinColumns = @JoinColumn(name = "Producto_id"), 
			inverseJoinColumns = @JoinColumn(name = "Cliente_id"))
	
	private List<Cliente> Clientes = new ArrayList<>();

	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	

	public Producto() {
		super();

	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", Clientes=" + Clientes + ", createdAt=" + createdAt
				+ "]";
	}

}
