package com.coderhouse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Modelo de asignacion de Categoria DTO", title = "Asignaciones DTO")
public class AsignacionCategoriaProductoDTO {
	
	 @Schema(description = "Producto ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long productoId;
	 
	 @Schema(description = "Categoria ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Long categoriaId;

}
