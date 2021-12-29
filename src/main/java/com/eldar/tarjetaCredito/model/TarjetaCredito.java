package com.eldar.tarjetaCredito.model;


import lombok.Data;

@Data
public class TarjetaCredito {
	
	private String marca;
	private String numero;
	private String cardholder;
	private String fechaVencimiento;
	
}
