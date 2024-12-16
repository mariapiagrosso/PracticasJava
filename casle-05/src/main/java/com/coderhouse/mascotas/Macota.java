package com.coderhouse.mascotas;


public class Macota {

	private static final int EDAD_MAXIMA = 15;
	String mensajeDeError = "El Perro no vive mas de " + EDAD_MAXIMA + "años de edad.";

	private String nombre;
	private String color;
	private String tamanio;
	private int edad;

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

	public void setEdad(int edad) throws Exception  {
		if (edad > EDAD_MAXIMA) {
			throw new Exception (mensajeDeError);
		} else {
			this.edad = edad;}
		}

	@Override
	public String toString() {
		return "Macota [nombre=" + nombre + ", color=" + color + ", tamanio=" + tamanio + ", edad=" + edad + "]";
	}

}
