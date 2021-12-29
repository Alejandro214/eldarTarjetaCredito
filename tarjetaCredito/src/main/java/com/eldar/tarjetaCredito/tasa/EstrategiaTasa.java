package com.eldar.tarjetaCredito.tasa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class EstrategiaTasa {
	
	private Map<String,EstrategiaTasaTarjeta> EstrategiasTasa;
	
	@Autowired
	public  EstrategiaTasa(Set<EstrategiaTasaTarjeta> strategySet) {
		this.setEstrategiasTasa(strategySet);
	}
	
	public Map<String,EstrategiaTasaTarjeta> getEstrategiasTasa() {
		return this.EstrategiasTasa;
	}
	
	public EstrategiaTasaTarjeta getEstrategiaTasa(String marca)  {
		
		return EstrategiasTasa.get(marca);
		
	  }
	
	private void setEstrategiasTasa(Set<EstrategiaTasaTarjeta> estrategiasTasa) {
	      EstrategiasTasa = new HashMap<String, EstrategiaTasaTarjeta>();
	      estrategiasTasa.forEach( 
	    		  	estrategia -> EstrategiasTasa.put(estrategia.getMarca(), estrategia));
	}
}
