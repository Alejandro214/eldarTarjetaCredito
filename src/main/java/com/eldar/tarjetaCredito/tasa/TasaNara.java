package com.eldar.tarjetaCredito.tasa;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;


@Data
public class TasaNara implements EstrategiaTasaTarjeta {
	private final BigDecimal tasaTarjetaNara = BigDecimal.valueOf(0.5); 

	@Override
	public BigDecimal getTasa(LocalDate date) {
		BigDecimal mes = BigDecimal.valueOf(date.getDayOfMonth());
		
		return mes.multiply(tasaTarjetaNara);
	}

	@Override
	public String getMarca() {
		return "Nara";
	}
}
