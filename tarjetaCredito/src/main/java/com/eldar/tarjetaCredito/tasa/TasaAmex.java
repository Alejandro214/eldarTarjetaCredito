package com.eldar.tarjetaCredito.tasa;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TasaAmex implements EstrategiaTasaTarjeta {
	
	private final BigDecimal tasaTarjetaAmex = BigDecimal.valueOf(0.1); 

	@Override
	public BigDecimal getTasa(LocalDate date) {
		BigDecimal mes = BigDecimal.valueOf(date.getMonthValue());
		
		return mes.multiply(tasaTarjetaAmex);
	}

	@Override
	public String getMarca() {
		return "Amex";
	}
}
