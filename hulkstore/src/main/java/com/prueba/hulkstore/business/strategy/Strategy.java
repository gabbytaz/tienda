/**
 * 
 */
package com.prueba.hulkstore.business.strategy;

import com.prueba.hulkstore.persistencia.DetalleKardex;
import com.prueba.hulkstore.persistencia.Kardex;
import com.prueba.hulkstore.persistencia.Transaccion;

/**
 * 
 * @author Gabbytaz
 *
 */
public interface Strategy {
	
	DetalleKardex gestionarTransaccion(Transaccion transaccion, Kardex kardex)throws Exception;

}
