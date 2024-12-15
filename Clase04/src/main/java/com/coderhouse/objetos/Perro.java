package com.coderhouse.objetos;

public class Perro {
	
	//Variable de clase
	private static final int EDAD_MAXIMA = 15;
	
	String mensajeDeError = "El Perro no vive mas de " + EDAD_MAXIMA + "años de edad.";

	// Variables de instancia o Atributos del Objeto
	private String nombre;
	private String raza;
	private String color;
	private String tamanio;
	private int edad;
	
	
	//Metodos 
	public void ladrar(){
		String nombreDelPerro = getNombre(); //Variable Local
		System.out.println("El perro " + nombreDelPerro + " esta ladrando.!");
	}
	
	public void caminar(){
		System.out.println("El perro " + getNombre() + " esta caminando.!");
	}
	
	public void comer(){
		System.out.println("El perro " + getNombre() + "  esta comiendo.!");
	}
	
 	//Getters y Setters

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
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
			this.edad = edad;
		}
		
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + ", color=" + color + ", tamanio=" + tamanio + ", edad="
				+ edad + "]";
	}

	

	

	
	
	
}