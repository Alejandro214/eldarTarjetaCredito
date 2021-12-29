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

	@GetMapping(value="/operation/fee",produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<?> getRate(@RequestParam String cardNumber,@RequestParam Integer amount) {
		
		Optional<TarjetaCreditoResponse> responseOptional = iTarjetaCreditoServiceimpl.getCreditCardNameAndRate(cardNumber);
		
		if(responseOptional.isEmpty()) 
			return new ResponseEntity<>("El numero de tarjeta no existe",HttpStatus.NOT_FOUND);
		
		String messege = "El importe total de la operación de $" +amount.toString() 
		+ " con la marca " + responseOptional.get().getMarca() + " es de: $ " + amount + responseOptional.get().getTasa();
		return new ResponseEntity<String>(messege,HttpStatus.OK);
		
	}
}
