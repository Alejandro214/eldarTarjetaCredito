package com.eldar.tarjetaCredito.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eldar.tarjetaCredito.iservice.ITarjetaCreditoService;
import com.eldar.tarjetaCredito.model.TarjetaCreditoResponse;


@RestController
public class TarjetaCreditoController {
	
	@Autowired
	private ITarjetaCreditoService iTarjetaCreditoServiceimpl;

	@GetMapping(value="/checkrate",produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<?> getRate(@RequestParam String cardNumber) {
		
		Optional<TarjetaCreditoResponse> responseOptional = iTarjetaCreditoServiceimpl.getCreditCardNameAndRate(cardNumber);
		
		if(responseOptional.isEmpty()) 
			return new ResponseEntity<>("El numero de tarjeta no existe",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<TarjetaCreditoResponse>(responseOptional.get(),HttpStatus.OK);
		
	}
}
