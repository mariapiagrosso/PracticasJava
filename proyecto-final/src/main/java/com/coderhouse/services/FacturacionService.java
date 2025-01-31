package com.coderhouse.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coderhouse.dto.FacturaDTO;
import com.coderhouse.dto.NewFacturaReq;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Factura;
import com.coderhouse.models.FacturaDetalle;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.FacturaRepository;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

public class FacturacionService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    
    @Transactional
    public FacturaDTO crearFactura(NewFacturaReq request) {
       
        // Buscar cliente
        Cliente cliente = clienteRepository.findById(request.getClienteId())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear factura
        Factura factura = new Factura();
        factura.setCliente(cliente);


        // Copiar datos del cliente
        factura.copiarDatosCliente();

        // Procesar detalles
        List<FacturaDetalle> detalles = new ArrayList<>();
        BigDecimal totalFactura = BigDecimal.ZERO;

        for (NewFacturaReq.DetalleProductoRequest detalle : request.getDetalles()) {
            productoRepository.findById(detalle.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
        }

       

        factura.setDetalles(detalles); 
        factura.setMontoTotalFactura(totalFactura);

        // Guardar
        facturaRepository.save(factura);
		return null;
    }


	public List<FacturaDTO> obtenerTodasLasFacturas() {
		// TODO Auto-generated method stub
		return null;
	}


	public FacturaDTO obtenerFactura(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}


   

             
	 

