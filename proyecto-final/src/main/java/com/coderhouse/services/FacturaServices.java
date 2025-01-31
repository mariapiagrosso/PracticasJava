package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coderhouse.models.Factura;
import com.coderhouse.repositories.FacturaRepository;


import jakarta.transaction.Transactional;

@Service
public class FacturaServices {

	@Autowired
	private FacturaRepository facturaRepository;

	
	
	public List<Factura> getAllFacturas() {
		return facturaRepository.findAll();
	}
	
	public Factura findById(Long id) {
		return facturaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));
	}
	
	   @Transactional
	    public Factura crearFactura(Factura factura) {
	        return facturaRepository.save(factura);
	    }

	public void eliminarFactura(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
