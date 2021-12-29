package com.eldar.tarjetaCredito.serviceImpl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eldar.tarjetaCredito.model.TarjetaCredito;
import com.eldar.tarjetaCredito.model.TarjetaCreditoResponse;
import com.eldar.tarjetaCredito.tasa.EstrategiaTasaTarjeta;
import com.eldar.tarjetaCredito.tasa.TasaAmex;
import com.eldar.tarjetaCredito.tasa.TasaNara;
import com.eldar.tarjetaCredito.tasa.TasaVisa;


import com.eldar.tarjetaCredito.tasa.EstrategiaTasa;


import com.eldar.tarjetaCredito.dao.*;
import com.eldar.tarjetaCredito.iservice.ITarjetaCreditoService;



@Service
public class TarjetaCreditoServiceImpl implements ITarjetaCreditoService {
	
	@Autowired
	private ITarjetaCreditoDAO iTarjetaCreditoDao;
	
	
	@Override
	public String getInformacionTarjeta(TarjetaCredito tarjeta) {	
		return "Tarjeat de Credito: \n "
				+ "	marca = " + tarjeta.getMarca() + ",\n"
				+ "	numero tajerta = " + tarjeta.getNumero() + ",\n"
				+ "	cardHolder = " + tarjeta.getCardholder() + ", \n"
				+ "	fecha de vencimiento = " + tarjeta.getFechaVencimiento() ;
		
	}
	@Override
	public boolean sonTarjetasIguales(TarjetaCredito tarjeta1,TarjetaCredito tarjeta2) {
		if (tarjeta1 == tarjeta2)
			return true;
		if (tarjeta1 == null || tarjeta2 == null)
			return false;
		if (tarjeta1.getCardholder() == null) {
			if (tarjeta2.getCardholder() != null)
				return false;
		} else if (!tarjeta1.getCardholder().equals(tarjeta2.getCardholder()))
			return false;
		if (tarjeta1.getNumero() == null) {
			if (tarjeta2.getNumero() != null)
				return false;
		} else if (!tarjeta1.getNumero().equals(tarjeta2.getNumero()))
			return false;
		if (tarjeta1.getFechaVencimiento() == null) {
			if (tarjeta2.getFechaVencimiento() != null)
				return false;
		} else if (!tarjeta1.getFechaVencimiento().equals(tarjeta2.getFechaVencimiento()))
			return false;
		if (tarjeta1.getMarca() == null) {
			if (tarjeta2.getMarca() != null)
				return false;
		} else if (!tarjeta1.getMarca().equals(tarjeta2.getMarca()))
			return false;
		return true;
	}
	@Override
	public boolean isValidCreditCard(TarjetaCredito tarjeta) {
		String fechaVencimiento = tarjeta.getFechaVencimiento();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth fechaVenciYearMonth = YearMonth.parse(fechaVencimiento,formatter);
        return fechaVenciYearMonth.isAfter(YearMonth.now());
	}
	@Override
	public Optional<TarjetaCreditoResponse> getCreditCardNameAndRate(String numeroTarjeta) {
		Optional<TarjetaCredito> tarjetaCreditoOptional = this.iTarjetaCreditoDao.getTarjetaCreditoByNumero(numeroTarjeta);
		if(tarjetaCreditoOptional.isEmpty()) return Optional.empty();
		
		String marcaTarjeta = tarjetaCreditoOptional.get().getMarca();
		
		EstrategiaTasaTarjeta estrategiaTasaTarjeta = this.getEstrategiaTasa().getEstrategiaTasa(marcaTarjeta);
		return Optional.of ( new TarjetaCreditoResponse(marcaTarjeta,estrategiaTasaTarjeta.getTasa(LocalDate.now())));
	}
	
	//Este constructor solo se utiliza para el ejercicio 1
	public TarjetaCreditoServiceImpl() {
		this.iTarjetaCreditoDao = new TarjetaCreditoDAO();
	}
	
	
	public EstrategiaTasa getEstrategiaTasa() {
		Set<EstrategiaTasaTarjeta> estrategiasSet = new HashSet<EstrategiaTasaTarjeta>();
		TasaAmex tasaAmex = new TasaAmex();
		TasaVisa TasaVisa = new TasaVisa();
		TasaNara TasaNara = new TasaNara();
		estrategiasSet.add(tasaAmex);
		estrategiasSet.add(TasaVisa);
		estrategiasSet.add(TasaNara);
		return new EstrategiaTasa(estrategiasSet);
	}

}
