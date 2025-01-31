package com.coderhouse.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "Modelo de Factura")
@Entity
@Table(name = "facturas")
public class Factura {

	 @Schema(description = "Id factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Schema(description = "Fecha de la Factura", requiredMode = Schema.RequiredMode.REQUIRED)
	 @Column(nullable = false)
	  private LocalDateTime fechaFactura;
	 
	 @Schema(description = "Monto total de la factura", example = "150000.00", requiredMode = Schema.RequiredMode.REQUIRED)
	 @Column(nullable = false)
	 private BigDecimal montoTotalFactura;
	 
	 
	 
	 @Schema(description = "Detalle de la factura")
	 @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnore
	 private List<FacturaDetalle> detalles = new ArrayList<>();



	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}



	public void copiarDatosCliente() {
		// TODO Auto-generated method stub
		
	}
	 
}
