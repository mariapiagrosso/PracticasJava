package com.coderhouse;

import com.coderhouse.objetos.Perro;

public class Clase04 {

	public static void main(String[] args) throws Exception {
		
		Perro primerPerro = new Perro();
		
		primerPerro.setNombre("Firulay");
		primerPerro.setColor("Gris");
		primerPerro.setRaza("Caniche");
		primerPerro.setTamanio("Chico");
		primerPerro.setEdad(2);
		
		//System.out.println(primerPerro); NOS DA EL ESPACIO EN MEMORIA
		System.out.println(primerPerro.getNombre());
		System.out.println(primerPerro.getColor());
		System.out.println(primerPerro.getRaza());
		System.out.println(primerPerro.getTamanio());
		System.out.println(primerPerro.getEdad());
		
		primerPerro.caminar();
		primerPerro.ladrar();
		primerPerro.comer();
		
		
		String [] nombres = new String[] {
			"Gabriel",
			"Oclivar",
			"Sara",
			"Matias",
			"Marcelo",
			"Alejandrro"
		};
				
		imprimirListaDeNombres(nombres);
	}

	private static void imprimirListaDeNombres(String[] nombreDePersonas) {
		for(String nombre: nombreDePersonas) {
			System.out.println("Nombre: "+ nombre);
		}
			
	}
	
}
