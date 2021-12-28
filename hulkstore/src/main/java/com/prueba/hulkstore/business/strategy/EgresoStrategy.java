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
public class EgresoStrategy implements Strategy {

	@Override
	public DetalleKardex gestionarTransaccion(Transaccion transaccion, Kardex kardex) throws Exception {
		System.out.println("Egreso");
		if(kardex.getCantidadkardex() <= transaccion.getCantidad()) {
			throw new Exception("Error el producto no tiene stock para realizar la Salida de mercaderia");
		}
		//llenar detalle kardex
		DetalleKardex detalleKardex = new DetalleKardex();
		detalleKardex.setIdkardex(kardex.getIdkardex());
		detalleKardex.setIdtransaccion(transaccion.getIdtransaccion());
		//saldos anteriores
		detalleKardex.setCantidadanterior(kardex.getCantidadkardex());
		detalleKardex.setValoranterior(kardex.getValorkardex());
		detalleKardex.setTotalanterior(kardex.getTotalkardex());
		//saldos actuales
		detalleKardex.setCantidadactual(kardex.getCantidadkardex() - transaccion.getCantidad());

		if(kardex.getTotalkardex() >= transaccion.getTotal())
			detalleKardex.setTotalactual(kardex.getTotalkardex() - transaccion.getTotal());

		detalleKardex.setValoractual(kardex.getValorkardex());
		
		return detalleKardex;
	}

}
