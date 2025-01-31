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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dto.FacturaDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Obtener Lista de Cursos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Cliente obtenida Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener a los Clientes", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping //("/all-clientes")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		try {
			List<Cliente> clientes = clienteService.getAllClientes();
			return ResponseEntity.ok(clientes); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}

	}

	@Operation(summary = "Obtener un Cliente por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente obtenido Correctamente", content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Cliente", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		try {
			Cliente cliente = clienteService.findById(id);
			return ResponseEntity.ok(cliente); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	
	@Operation(summary = "Creacion de un Cliente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cliente creado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Curso", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping //("/agregar-nuevo-cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {
			Cliente clienteCreado = clienteService.saveCliente(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado); // 201 Created
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

	
	@Operation(summary = "Edicion o Modificacion de un Cliente por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente editado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Cliente", 
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateClienteById(@PathVariable Long id, @RequestBody Cliente clienteModificado) {
		try {
			Cliente updateCliente = clienteService.updateClienteById(id, clienteModificado);
			return ResponseEntity.ok(updateCliente);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deteClienteById(@PathVariable Long id) {
		try {
			clienteService.deleteClienteById(id);
			return ResponseEntity.noContent().build(); // 204

		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}
	
	@Operation(summary = "Relacionar a un Cliente a un Producto, usando DTO")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente relacionado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar relacionar al  Cliente, o El Cliente no existe", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping("/Factura")
	public ResponseEntity<Cliente> facturaClienteAProducto (@RequestBody FacturaDTO dto){
		try {
			
			Cliente cliente = clienteService.facturaClienteAProducto(dto);
			return ResponseEntity.ok(cliente);
			
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build(); // 400

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
		}
	}

}
