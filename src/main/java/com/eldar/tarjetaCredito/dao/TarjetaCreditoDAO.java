package com.eldar.tarjetaCredito.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.eldar.tarjetaCredito.model.TarjetaCredito;

@Repository
public class TarjetaCreditoDAO implements ITarjetaCreditoDAO {
	
	private final static Map<String,TarjetaCredito> tarjetasCredito;
	
	static {
		TarjetaCredito tarjetaVisa = new TarjetaCredito();
		tarjetaVisa.setMarca("Visa");
		tarjetaVisa.setCardholder("Mario Bros");
		tarjetaVisa.setFechaVencimiento("12/20");
		tarjetaVisa.setNumero("4242424242424242");
		
		TarjetaCredito tarjetaNara = new TarjetaCredito();
		tarjetaNara.setMarca("Nara");
		tarjetaNara.setCardholder("Jose zaraza");
		tarjetaNara.setFechaVencimiento("05/30");
		tarjetaNara.setNumero("5275726798585458");
		
		
		TarjetaCredito tarjetaAmex = new TarjetaCredito();
		tarjetaAmex.setMarca("Amex");
		tarjetaAmex.setCardholder("Pedro picapiedra");
		tarjetaAmex.setFechaVencimiento("08/30");
		tarjetaAmex.setNumero("375987654321001");
		
	    tarjetasCredito = new HashMap<>();
	    tarjetasCredito.put("4242424242424242", tarjetaVisa);
	    tarjetasCredito.put("5275726798585458", tarjetaNara);
	    tarjetasCredito.put("375987654321001", tarjetaAmex);

	    
	    

	    
	}
	
	@Override
	public Optional<TarjetaCredito> getTarjetaCreditoByNumero(String numero) {
		TarjetaCredito tarjetaCredito = tarjetasCredito.get(numero);
		if(tarjetaCredito == null) return Optional.empty();
		return Optional.of(tarjetaCredito);
	}
}
