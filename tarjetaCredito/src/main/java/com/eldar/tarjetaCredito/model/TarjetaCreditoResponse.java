package com.eldar.tarjetaCredito.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TarjetaCreditoResponse {
	

	private String marca;
	private BigDecimal tasa;
	
	public TarjetaCreditoResponse(String creditCardName, BigDecimal calculoTasa) {
		this.marca = creditCardName;
		this.tasa = calculoTasa;
	}

}
