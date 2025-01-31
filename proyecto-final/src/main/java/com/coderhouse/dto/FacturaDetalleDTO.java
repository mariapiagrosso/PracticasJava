package com.coderhouse.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Modelo de asignacion de factura detalle DTO")
public class FacturaDetalleDTO {
	  @Schema(description = "Nombre del producto", example = "Play Station", requiredMode = Schema.RequiredMode.REQUIRED)
	    private String nombreProducto;

	    @Schema(description = "Cantidad del producto", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
	    private Integer cantidad;

	    @Schema(description = "Precio unitario del producto", example = "10000.99", requiredMode = Schema.RequiredMode.REQUIRED)
	    private BigDecimal precioUnitario;

	    @Schema(description = "Subtotal del detalle de factura", example = "5288.99", requiredMode = Schema.RequiredMode.REQUIRED)
	    private BigDecimal subtotal;

}
