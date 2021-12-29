package com.eldar.tarjetaCredito.Operacion;

import lombok.Data;

@Data
public class Operacion {

	private Double amount;	
	
	public Operacion(Double amount) {
		this.amount = amount;
	}
}
