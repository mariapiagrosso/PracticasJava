package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Categoria;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

@SpringBootApplication
public class SegundaEntregaApplication implements CommandLineRunner {
	
	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(SegundaEntregaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {
			
			Categoria categoria1 = new Categoria ("Consolas");
			Categoria categoria2 = new Categoria ("Accesorios");
			Categoria categoria3 = new Categoria ("Celulares");
			

			Producto producto1 = new Producto("PS4 Pro");
			Producto producto2 = new Producto("PS4 Fat");
			Producto producto3 = new Producto("PS4 Slim");
			Producto producto4 = new Producto("PS5 Standard Edition");
			Producto producto5 = new Producto("PS5 Digital Edition");
			Producto producto6 = new Producto("Xbox X");
			Producto producto7 = new Producto("Xbox S");
			Producto producto8 = new Producto("Nintendo Switch Original");
			Producto producto9 = new Producto("Nintendo Switch Mejorada");
			Producto producto10 = new Producto("Nintendo Switch OLED");
			Producto producto11 = new Producto("Nintendo Switch Lite");
			Producto producto12 = new Producto("Auriculares JBL Tune 510BT Negro");
			Producto producto13 = new Producto("Auriculares JBL Tune 510BT Azul");
			Producto producto14 = new Producto("Joystick Inalambrico Xbox S/X");
			Producto producto15 = new Producto("Joystick PS5");
			Producto producto16 = new Producto("Samsung Galaxy A15");
			Producto producto17 = new Producto("Samsung Galaxy A25");
			Producto producto18 = new Producto("Xiaomi Redmi 13C");
			Producto producto19 = new Producto("Iphone 16 Pro Max");

			Cliente cliente1 = new Cliente("Fravega", "E32855827", 32855827);
			Cliente cliente2 = new Cliente("Play For Fun", "E25878987", 25878987);
			Cliente cliente3 = new Cliente("Eduardo Madero SA", "E36897544", 36897544);
			Cliente cliente4 = new Cliente("Tech Game", "E35555888", 35555888);
			
			dao.persistirCategoria(categoria1);
			dao.persistirCategoria(categoria2);
			dao.persistirCategoria(categoria3);
			
			dao.persistirProducto(producto1);
			dao.persistirProducto(producto2);
			dao.persistirProducto(producto3);
			dao.persistirProducto(producto4);
			dao.persistirProducto(producto5);
			dao.persistirProducto(producto6);
			dao.persistirProducto(producto7);
			dao.persistirProducto(producto8);
			dao.persistirProducto(producto9);
			dao.persistirProducto(producto10);
			dao.persistirProducto(producto11);
			dao.persistirProducto(producto12);
			dao.persistirProducto(producto13);
			dao.persistirProducto(producto14);
			dao.persistirProducto(producto15);
			dao.persistirProducto(producto16);
			dao.persistirProducto(producto17);
			dao.persistirProducto(producto18);
			dao.persistirProducto(producto19);
			
			dao.persistirCliente(cliente1);
			dao.persistirCliente(cliente2);
			dao.persistirCliente(cliente3);
			dao.persistirCliente(cliente4);
			
			dao.asignarCategoriaAProducto(producto1.getId(), categoria1.getId());
			dao.asignarCategoriaAProducto(producto12.getId(), categoria2.getId());
			dao.asignarCategoriaAProducto(producto16.getId(), categoria3.getId());

		} catch (Exception e) {
			e.printStackTrace(System.err);

		}

	}
}
