package com.coderhouse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.FacturaDTO;
import com.coderhouse.dto.NewFacturaReq;
import com.coderhouse.services.FacturacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Compras", description = "API para la gestión de compras de productos")
@RestController
@RequestMapping("/api/factura")
public class FacturacionController {
	 private final FacturacionService facturacionService;

	    public FacturacionController(FacturacionService facturacionService) {
	        this.facturacionService = facturacionService;
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable NewFacturaReq id) {
	        return ResponseEntity.ok(facturacionService.crearFactura(id));
	    }

	    
	    @Operation(summary = "Crear una nueva factura")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Factura creada con éxito"),
	        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	    })
	    @PostMapping
	    public ResponseEntity<FacturaDTO> crearFactura(@RequestBody NewFacturaReq request) {
	        return ResponseEntity.ok(facturacionService.crearFactura(request));
	    }

	   

}
