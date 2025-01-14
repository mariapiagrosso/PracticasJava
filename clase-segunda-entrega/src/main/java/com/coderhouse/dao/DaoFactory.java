package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Categoria;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persistirCliente(Cliente cliente) {
		em.persist(cliente);
	}

	@Transactional
	public void persistirProducto(Producto producto) {
		em.persist(producto);
	}
	
	@Transactional
	public void persistirCategoria(Categoria categoria) {
		em.persist(categoria);
	}
	
	@Transactional
	public Producto getProductoById(Long productoId) throws Exception {
		try {
			
			TypedQuery<Producto> query = em.createQuery("SELECT p FROM Producto p WHERE p.id", Producto.class);
			return query.setParameter("id", productoId).getSingleResult();
		} catch(Exception e) {
			throw new Exception("El Producto no existe.!");
		}
		
	}
	
	@Transactional
	public Categoria getCategoriaById(Long categoriaId) throws Exception {
		try {
			
			TypedQuery<Categoria> query = em.createQuery("SELECT ca FROM Categoria ca WHERE ca.id", Categoria.class);
			return query.setParameter("id", categoriaId).getSingleResult();
		} catch(Exception e) {
			throw new Exception("El Categoria no existe.!");
		}
		
	}
	
	
	@Transactional
	public void asignarCategoriaAProducto(Long productoId, Long categoriaId) throws Exception {
		
		Producto producto = getProductoById( productoId);
		
		if(producto == null) {
			throw new Exception("El producto con id: " + productoId + "no existe");
		}
		
		Categoria categoria = getCategoriaById(categoriaId);
		
		if(categoria == null) {
			throw new Exception("El categoria con id: " + categoriaId + "no existe");
		}
		
		producto.setCategoria(categoria);
		
		em.merge(producto);
		
	}

}
