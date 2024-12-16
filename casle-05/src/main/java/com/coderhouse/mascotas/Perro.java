package com.coderhouse.mascotas;

public class Perro extends Macota {

	private String raza;
	
	public void ladrar(){
		System.out.println("El perro  " + getNombre() + " esta ladrando.!");
	}
	
	@Override // Sobrescritura de metodo
	public void caminar() {
		System.out.println("El Perro " + getNombre() + " esta Caminando en el Parque.!");
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

//	@Override
//	public String toString() {
//		return "Hola Gente como va?";
//	}

}
