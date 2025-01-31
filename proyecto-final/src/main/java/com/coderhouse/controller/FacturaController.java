package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.FacturaDTO;
import com.coderhouse.models.Factura;
import com.coderhouse.services.FacturaServices;
import com.coderhouse.services.FacturacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;





@Tag(name = "Facturas", description = "API para la gestión de facturas")
@RestController
@RequestMapping("/api/factura")
public class FacturaController {
	
	 @Autowired
	    private FacturaServices FacturaServices;
			
	  @Autowired
	    private FacturacionService facturacionService;

	   
	  @Operation(summary = "Obtener Lista de Facturas")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Lista de Facturas obtenida Correctamente", 
						content = {
						@Content(mediaType = "application/json", 
								schema = @Schema(implementation = Factura.class)) }),
				@ApiResponse(responseCode = "404", description = "Error al intentar Obtener a los Facturas", 
				content = @Content(mediaType = "application/json", 
				schema = @Schema(implementation = ErrorResponse.class))),
				@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
				content = @Content(mediaType = "application/json", 
				schema = @Schema(implementation = ErrorResponse.class))) })
	    @GetMapping
	    public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
	        try {
	            List<FacturaDTO> facturas = facturacionService.obtenerTodasLasFacturas();
	            return ResponseEntity.ok(facturas); // 200
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
	        }
	    }

	    @Operation(summary = "Obtener una factura por ID con detalles", description = "Obtiene una factura/compra específica por su ID con sus detalles")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Factura encontrada con éxito"),
	        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
	        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	    })
	    @GetMapping("/{id}")
	    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
	        try {
	            FacturaDTO factura = facturacionService.obtenerFactura(id);
	            return ResponseEntity.ok(factura); // 200
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
	        }
	    }

	    @Operation(summary = "Crear una nueva factura")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Factura creada con éxito"),
	        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	    })
	    @PostMapping("/create")
	    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
	        try {
	            Factura facturaCreada = FacturaServices.crearFactura(factura);
	            return ResponseEntity.status(HttpStatus.CREATED).body(facturaCreada);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
	        }
	    }

	    @Operation(summary = "Borrar una factura por ID")
	    @ApiResponses(value = {
	        @ApiResponse(responseCode = "204", description = "Factura borrada con éxito"),
	        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
	        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	    })
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteFacturaById(@PathVariable Long id) {
	        try {
	        	FacturaServices.eliminarFactura(id);
	            return ResponseEntity.noContent().build(); // 204
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.notFound().build(); // 404
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
	        }
	    }
	  
}
