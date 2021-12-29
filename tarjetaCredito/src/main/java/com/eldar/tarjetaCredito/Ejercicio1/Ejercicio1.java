package com.eldar.tarjetaCredito.Ejercicio1;



import com.eldar.tarjetaCredito.Operacion.Operacion;
import com.eldar.tarjetaCredito.Operacion.ValidarOperacion;
import com.eldar.tarjetaCredito.model.TarjetaCredito;
import com.eldar.tarjetaCredito.serviceImpl.TarjetaCreditoServiceImpl;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		
		//Creo las tarjetas de Visa, Nara y Amex
		TarjetaCredito tarjetaCrecidoVisa = new TarjetaCredito();
		tarjetaCrecidoVisa.setMarca("Visa");
		tarjetaCrecidoVisa.setCardholder("Mario Bros");
		tarjetaCrecidoVisa.setFechaVencimiento("12/20");
		tarjetaCrecidoVisa.setNumero("4242424242424242");
		
		TarjetaCredito tarjetaCreditoNara = new TarjetaCredito();
		tarjetaCreditoNara.setMarca("Nara");
		tarjetaCreditoNara.setCardholder("Jose zaraza");
		tarjetaCreditoNara.setFechaVencimiento("05/30");
		tarjetaCreditoNara.setNumero("5275726798585458");
		
		TarjetaCredito tarjetaCreditoAmex = new TarjetaCredito();
		tarjetaCreditoAmex.setMarca("Amex");
		tarjetaCreditoAmex.setCardholder("Pedro picapiedra");
		tarjetaCreditoAmex.setFechaVencimiento("08/30");
		tarjetaCreditoAmex.setNumero("375987654321001");
		
		
		//Creo las operaciones
		Operacion operacion1 = new Operacion(999d);
		Operacion operacion2 = new Operacion(9999d);
		
		
		//Creo el servicio que se encargara de las consultas de las tarjetas
		TarjetaCreditoServiceImpl tarjetaCreditoService = new TarjetaCreditoServiceImpl();
		
		//Creo el objeto que valida las operaciones
		ValidarOperacion validarOperacion = new ValidarOperacion();
		
		//obtengo info de la tarjeta
		
		System.out.println("Info de la tarjeta \n" + tarjetaCreditoService.getInformacionTarjeta(tarjetaCrecidoVisa));
		
		//Comparo si las tarjetas son iguales
		System.out.println("Las tarjetas son iguales? " + tarjetaCreditoService.sonTarjetasIguales( tarjetaCrecidoVisa, tarjetaCreditoNara));
		
		//Chequeo que las tartejas sean validas
		System.out.println("La tarjeta es valida? " + tarjetaCreditoService.isValidCreditCard(tarjetaCrecidoVisa));
		
		System.out.println("La tarjeta es valida? " + tarjetaCreditoService.isValidCreditCard(tarjetaCreditoNara));
		
		System.out.println("La tarjeta es valida? " + tarjetaCreditoService.isValidCreditCard(tarjetaCreditoAmex));

		
		
		// Marca y tasa de las tarjetas
		System.out.println("La marca y tasa de la tarjeta es : " + tarjetaCreditoService.getCreditCardNameAndRate(tarjetaCrecidoVisa.getNumero()));
		System.out.println("La marca y tasa de la tarjeta es : " + tarjetaCreditoService.getCreditCardNameAndRate(tarjetaCreditoNara.getNumero()));
		System.out.println("La marca y tasa de la tarjeta es : " + tarjetaCreditoService.getCreditCardNameAndRate(tarjetaCreditoAmex.getNumero()));

		
		//Validacion de las operaciones
		try {
			System.out.println("Validacion de la  operacion 1: " + validarOperacion.validateOperation(operacion1));
			System.out.println("Validacion de la  operacion 2: " + validarOperacion.validateOperation(operacion2));	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
