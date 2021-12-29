package com.eldar.tarjetaCredito.exception;

import lombok.Data;

@Data
public class LimiteMontoOperacion extends Exception {
	 private String message;
	 
	    public LimiteMontoOperacion() {
	    	this.message = "El monto ingresado supera el maximo";
	    	
	    }
	    

	    
	    
}
