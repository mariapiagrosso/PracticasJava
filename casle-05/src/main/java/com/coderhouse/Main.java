package com.coderhouse;

import com.coderhouse.mascotas.Perro;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Perro unPerro = new Perro();
		
		unPerro.setNombre("Firulay");
		unPerro.setEdad(5);
		unPerro.setTamanio("Mediano");
		unPerro.setRaza("Caniche");
		unPerro.setColor("Blanco");
		unPerro.caminar();
		unPerro.ladrar();

		//System.out.println(unPerro);
		


		
		
				
		
	}

}
