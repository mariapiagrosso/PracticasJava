package com.coderhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; //(Se comento para ver otra forma de declaracion, esta corresponde a la linea 23

public class Clase03 {

	public static void main(String[] args) {
		//Iteraciones
		
		int [] numerosEnteros = new int [6];
		
		numerosEnteros[0] = 10;
		numerosEnteros[1] = 5;
		numerosEnteros[2] = 3;
		numerosEnteros[4] = 9;
		numerosEnteros[5] = 13;
//		numerosEnteros[6] = 0;
		
		System.out.println("Posicion en memoria es: " + numerosEnteros); 
		System.out.println("El Array numerosEnteros tiene: " + numerosEnteros.length + 
				" elementos" );
		System.out.println("El eleento con indice 0 es: " + numerosEnteros[0]);
		System.out.println("Todo el Array: " + Arrays.toString(numerosEnteros)); //Para poder importar la clase tenemos que escrinor Arrays.toString y ahi nos apollamos en Array y nos aparece Import
		
//		String[] palabras = {
//				"Hola",
//				"Mundo",
//				"Coder",
//				};
//		
//		System.out.println("El Array palabras tiene " + palabras.length + " elementos");
		
		//listas
		
		List<String> listaDeNombres =  new ArrayList<>();
		List<String> listaDeNombres2 =  new ArrayList<>();
		
		listaDeNombres.add("Ana");
		listaDeNombres.add("Juan");
		listaDeNombres2.add("Maria");
		listaDeNombres2.add("Susana");
		listaDeNombres2.add("Lucas");
		
		listaDeNombres.addAll(listaDeNombres2);
		
		System.out.println("La lista de nombres tiene: " + listaDeNombres.size());
		
		
		
		
		
		
		}
		
		

	}


