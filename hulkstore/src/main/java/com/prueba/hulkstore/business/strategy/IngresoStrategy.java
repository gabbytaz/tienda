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
public class IngresoStrategy implements Strategy {

	@Override
	public DetalleKardex gestionarTransaccion(Transaccion transaccion, Kardex kardex)throws Exception {
		System.out.println("Ingreso");

		//llenar detalle kardex
		DetalleKardex detalleKardex = new DetalleKardex();
		detalleKardex.setIdkardex(kardex.getIdkardex());
		detalleKardex.setIdtransaccion(transaccion.getIdtransaccion());
		//saldos anteriores
		detalleKardex.setCantidadanterior(kardex.getCantidadkardex());
		detalleKardex.setValoranterior(kardex.getValorkardex());
		detalleKardex.setTotalanterior(kardex.getTotalkardex());
		//saldos actuales
		detalleKardex.setCantidadactual(kardex.getCantidadkardex() + transaccion.getCantidad());
		detalleKardex.setTotalactual(kardex.getTotalkardex() + transaccion.getTotal());
		
		double scale = Math.pow(10, 2);
		float valorPromedio = detalleKardex.getTotalactual()/detalleKardex.getCantidadactual();
		float valor = (float) (Math.round(valorPromedio * scale) / scale);
	    System.out.println(valor);
	    
	    detalleKardex.setValoractual(valor);

		return detalleKardex;
	}

}
