package com.coderhouse.models;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Schema(description = "Modelo del Detalle de la Factura")
@Entity
@Table(name = "facturas_detalle")
public class FacturaDetalle {
	
	@Schema(description = "Id del detalle de la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	 @Schema(description = "Factura relacionada con este detalle")
	    @ManyToOne
	    @JoinColumn(name = "factura_id", nullable = false)
	    private Factura factura;
	 
	
	

}
