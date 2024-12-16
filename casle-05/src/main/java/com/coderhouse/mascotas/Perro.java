package com.coderhouse.mascotas;

public class Perro extends Macota {

	private String raza;
	
	public void ladrar(){
		System.out.println("El perro  " + getNombre() + " esta ladrando.!");
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + "]";
	}

}
