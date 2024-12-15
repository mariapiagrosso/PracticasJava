package com.coderhouse.mascotas;

public class Mascotas {
	
	private String nombre;
	private String  raza;
	private String color;
	private String tamanio;
	private String edad;
	
	public void caminar () {
		System.out.println("La mascota " + getNombre() + " esta caminando.!");
	}
	
	public void comer () {
		System.out.println("La mascota " + getNombre() + " esta caminando.!");
	}
	
	public String getNombre() {
		return this.nombre
	}

}
