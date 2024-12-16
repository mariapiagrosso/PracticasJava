package com.coderhouse;

import com.coderhouse.mascotas.Macota;
import com.coderhouse.mascotas.Perro;


public class Main {

	public static void main(String[] args) throws PerroException {
		
		Perro unPerro = new Perro();
		
		unPerro.setNombre("Firulay");
		try {
			unPerro.setEdad(22);
		} catch (PerroException error) {
			System.err.println("Error, " + error.getMessage());
		} finally {
			System.out.println("Finalizo la Validacion de la PerroException.!");
		}
		
		unPerro.setTamanio("Mediano");
		unPerro.setRaza("Caniche");
		unPerro.setColor("Blanco");
		unPerro.caminar();
		unPerro.ladrar();

		System.out.println(unPerro);
		
//		Macota unaMascota = new Macota();
//		unaMascota.setNombre("Rex");
//		unaMascota.setColor("Blanco");
//		unaMascota.setTamanio("Grande");
//		unaMascota.setEdad(6);
//		
//		unaMascota.caminar();
//		unaMascota.comer();

		Macota nuevaMascota = new Macota("Godshilla", "Negro", "Mediano", 6);
		
		nuevaMascota.caminar();
		nuevaMascota.comer();
		
				
		
	}

}
