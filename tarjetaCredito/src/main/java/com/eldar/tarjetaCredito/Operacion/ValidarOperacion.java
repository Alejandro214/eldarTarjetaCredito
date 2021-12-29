package com.eldar.tarjetaCredito.Operacion;

import com.eldar.tarjetaCredito.exception.LimiteMontoOperacion;

public class ValidarOperacion {
	
	private  Double maxTotal = 1000d;
	
	public String validateOperation(Operacion operation) throws LimiteMontoOperacion {
		if (operation.getAmount() >= maxTotal) {
			throw new LimiteMontoOperacion();
		}
		return "Operacion realiza con exito";
	}
}
