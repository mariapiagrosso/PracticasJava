package com.coderhouse.dto;


import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Modelo de asignacion de NewFacturaReq DTO")
public class NewFacturaReq {
    @Schema(description = "ID del cliente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long clienteId;

    @Schema(description = "Lista de detalles del producto", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DetalleProductoRequest> detalles;

    public static class DetalleProductoRequest {

        @Schema(description = "ID del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private Long productoId;

        @Schema(description = "Cantidad del producto", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer cantidad;

		public Long getProductoId() {
			// TODO Auto-generated method stub
			return null;
		}

	

}
}
