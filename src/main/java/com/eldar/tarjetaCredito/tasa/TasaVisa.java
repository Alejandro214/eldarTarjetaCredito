package com.eldar.tarjetaCredito.tasa;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TasaVisa  implements EstrategiaTasaTarjeta{
	
	@Override
	public BigDecimal getTasa(LocalDate date) {
		
		int anioInt = Integer.valueOf(date.toString().substring(2, 4));
		
		BigDecimal anio = BigDecimal.valueOf(anioInt);
		BigDecimal mes = BigDecimal.valueOf(date.getMonthValue());
		
		return anio.divide(mes);
	}

	@Override
	public String getMarca() {
		return "Visa";
	}

}
