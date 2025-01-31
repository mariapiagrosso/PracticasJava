package com.coderhouse.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Modelo de asignacion de factura DTO")
public class FacturaDTO {
	
	
	private List<Long> productoIds;

	  @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	    private Long id;

	    @Schema(description = "Número de la factura", example = "FA111147", requiredMode = Schema.RequiredMode.REQUIRED)
	    private String numeroFactura;

	    @Schema(description = "ID del cliente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	    private Long clienteId;

	    @Schema(description = "Nombre del cliente", example = "Maria", requiredMode = Schema.RequiredMode.REQUIRED)
	    private String nombreCliente;


	    @Schema(description = "Fecha de la factura", requiredMode = Schema.RequiredMode.REQUIRED)
	    private LocalDateTime fechaFactura;

	    @Schema(description = "Total de la factura", example = "585000.99", requiredMode = Schema.RequiredMode.REQUIRED)
	    private BigDecimal totalFactura;

	    @Schema(description = "Detalle de la factura", requiredMode = Schema.RequiredMode.REQUIRED)
	    private List<FacturaDetalleDTO> detalles;

	
}
