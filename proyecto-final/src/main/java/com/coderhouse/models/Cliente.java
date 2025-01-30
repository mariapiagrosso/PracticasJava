package com.coderhouse.models;


import java.util.ArrayList;
import java.util.List;

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
@Entity
@Table(name = "Clientes")
public class Cliente {


	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement

	private Long id;
	
	@Column(name = "Nombre")
	private String nombre;

	@Column(unique = true, nullable = false) // Unico y notnull
	private String codcli;

	@Column(unique = true, nullable = false) // Unico y notnull
	private int dni;

	@ManyToMany(mappedBy = "Clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();

	
//
//	public Cliente() {
//		super();
//
//	}
//
//	public Cliente(String nombre, String codcli, int dni) {
//		super();
//		this.nombre = nombre;
//		this.codcli = codcli;
//		this.dni = dni;
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
//	public String getCodcli() {
//		return this.codcli;
//	}
//
//	public void setCodcli(String codcli) {
//		this.codcli = codcli;
//	}
//
//	public int getDni() {
//		return this.dni;
//	}
//
//	public void setDni(int dni) {
//		this.dni = dni;
//	}
//
//	public List<Producto> getProductos() {
//		return productos;
//	}
//
//	public void setProductos(List<Producto> productos) {
//		this.productos = productos;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Cliente [id=" + id + ", nombre=" + nombre + ", codcli=" + codcli + ", dni=" + dni + ", productos="
//				+ productos +  "]";
//	}

}
