package com.eldar.tarjetaCredito.dao;

import java.util.Optional;

import com.eldar.tarjetaCredito.model.TarjetaCredito;

public interface  ITarjetaCreditoDAO {
	public Optional<TarjetaCredito> getTarjetaCreditoByNumero(String numero);

}
