package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
			joinColumns = @JoinColumn(name = "producto_id"), 
			inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	@JsonIgnore
	private List<Cliente> Clientes = new ArrayList<>();

	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	

//	public Producto() {
//		super();
//
//	}
//
//	public Producto(String nombre) {
//		super();
//		this.nombre = nombre;
//	}
//
//	public Long getId() {
//		return this.id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return this.nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public List<Cliente> getClientes() {
//		return Clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		Clientes = clientes;
//	}
//
//
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//
//	@Override
//	public String toString() {
//		return "Producto [id=" + id + ", nombre=" + nombre + "]";
//	}
	
}
