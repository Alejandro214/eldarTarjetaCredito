package com.eldar.tarjetaCredito.tasa;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface EstrategiaTasaTarjeta {
	BigDecimal getTasa(LocalDate date);
	String getMarca();
}
