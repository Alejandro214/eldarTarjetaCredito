package com.eldar.tarjetaCredito.iservice;


import java.util.Optional;

import com.eldar.tarjetaCredito.model.TarjetaCredito;
import com.eldar.tarjetaCredito.model.TarjetaCreditoResponse;

public interface ITarjetaCreditoService {
	
	public String getInformacionTarjeta(TarjetaCredito tarjeta) ;
	
	public boolean sonTarjetasIguales(TarjetaCredito tarjeta1,TarjetaCredito tarjeta2) ;
	
	public boolean isValidCreditCard(TarjetaCredito tarjeta) ;
	
	public Optional<TarjetaCreditoResponse> getCreditCardNameAndRate(String creditCardNumber) ;
}
