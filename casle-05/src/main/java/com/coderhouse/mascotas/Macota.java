package com.coderhouse.mascotas;

import com.coderhouse.PerroException;

public class Macota {

	private static final int EDAD_MAXIMA = 15;
	String mensajeDeError = "El Perro no vive mas de " + EDAD_MAXIMA + "años de edad.";

	private String nombre;
	private String color;
	private String tamanio;
	private int edad;
	
	//Constructor
	
	public Macota() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//Sobrecarga de constructores
	public Macota(String nombre, String color, String tamanio, int edad) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.tamanio = tamanio;
		this.edad = edad;
	}



	public void caminar() {
		System.out.println("La mascota  " + getNombre() + " esta caminando.!");
	}



	public void comer() {
		System.out.println("La mascota " + getNombre() + "  esta comiendo.!");
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) throws PerroException  {
		if (edad > EDAD_MAXIMA) {
			throw new PerroException (mensajeDeError);
		} else {
			this.edad = edad;}
		}

	@Override
	public String toString() {
		return "Macota [nombre=" + nombre + ", color=" + color + ", tamanio=" + tamanio + ", edad=" + edad + "]";
	}

}
