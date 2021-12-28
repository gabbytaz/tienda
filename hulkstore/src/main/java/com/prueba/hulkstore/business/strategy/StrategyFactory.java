/**
 * 
 */
package com.prueba.hulkstore.business.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.prueba.hulkstore.utils.ConstantesHulKStore;

/**
 * 
 * @author Gabbytaz
 *
 */
@Component
public class StrategyFactory {
		
	private Map<Integer,Strategy> estrategias = new HashMap<Integer, Strategy>();
	
	public StrategyFactory () {
		this.inicializarEstrategia();
	}
	
	private void inicializarEstrategia() {
		estrategias.put(ConstantesHulKStore.INGRESO_TRANSACCION, new IngresoStrategy());
		estrategias.put(ConstantesHulKStore.EGRESO_TRANSACCION, new EgresoStrategy());		
	}
	
	/**
	 * 
	 * @param tipo
	 * @return
	 */
	public Strategy obtenerEstrategia(int tipo) {
		if(estrategias.containsKey(tipo)) {
			return estrategias.get(tipo);
		}
		return null;	
	}
		
}
