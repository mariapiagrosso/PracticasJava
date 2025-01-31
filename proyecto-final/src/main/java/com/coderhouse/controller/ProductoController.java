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

import com.coderhouse.dto.AsignacionCategoriaProductoDTO;
import com.coderhouse.models.Producto;
import com.coderhouse.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	
	@Operation(summary = "Obtener Lista de Productos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de Productos obtenida Correctamente", 
					content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener a los Productos", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProductos() {
		try {
			List<Producto> productos = productoService.getAllProductos();
			return ResponseEntity.ok(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Obtener un Producto por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto obtenido Correctamente", content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Producto", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
		try {
			Producto producto = productoService.getProductoById(id);
			return ResponseEntity.ok(producto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Creacion de un Producto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Producto creado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Producto", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		try {
			Producto createdProducto = productoService.createProducto(producto);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Operation(summary = "Edicion o Modificacion de un Producto por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto editado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Producto", 
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
		try {
			Producto updatedProducto = productoService.updateProducto(id, productoDetails);
			return ResponseEntity.ok(updatedProducto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Eliminacion de un Producto por su ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Producto eliminado Correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar Obtener el Producto", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
		try {
			productoService.deleteProducto(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@Operation(summary = "Asignación de Categoria a un Producto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Categoria asignada correctamente", content = {
					@Content(mediaType = "application/json", 
							schema = @Schema(implementation = Producto.class)) }),
			@ApiResponse(responseCode = "404", description = "Error al intentar obtener el Producto o Categoria", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "500", description = "Error interno del Servidor", 
			content = @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping("/asignar-categoria")
	public ResponseEntity<Producto> asignarCategoriaAProducto(@RequestBody AsignacionCategoriaProductoDTO dto){
		try {
			
			Producto productoActualizado = productoService.asignarCategoriaAProducto(
					dto.getProductoId(), 
					dto.getCategoriaId()
					);
			return ResponseEntity.ok(productoActualizado);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
		}
	}
	
}
