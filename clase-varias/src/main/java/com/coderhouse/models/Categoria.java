package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Categorias")

public class Categoria {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
	private Long id;
	
	@Column(unique = true, nullable = true)
	private String nombre;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
	


	public Categoria() {
		super();
		
	}

	public Categoria(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", productos=" + productos + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
