package com.coderhouse.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDTO {

private Long clienteId;
	
	private List<Long> productoIds;
	
}
