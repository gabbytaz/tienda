/**
 * 
 */
package com.prueba.hulkstore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.hulkstore.persistencia.DetalleKardex;
import com.prueba.hulkstore.persistencia.Kardex;
import com.prueba.hulkstore.persistencia.Transaccion;

/**
 * 
 * @author Gabbytaz
 *
 */
@Component
public class TransaccionDAO {

	@Autowired
	TransaccionRepository transaccionRepository;

	@Autowired
	KardexRepository kardexRepository;

	@Autowired
	DetalleKardexRepository detalleKardexRepository;

	/**
	 * buscar kardex por id del producto.
	 * @param idproducto
	 * @return
	 */
	public Kardex buscarKardexPorIdProducto(int idproducto) {
		return	kardexRepository.buscarKardexPorIdProducto(idproducto);		
	}

	/**
	 * crear la transaccion y asignar el numero de la transaccion.
	 * @param transaccion a procesar
	 */
	public void crearTransaccion(Transaccion transaccion) {
		transaccion.setNumerotransaccion(getNumeroTransaccion());
		transaccionRepository.save(transaccion);
	}

	/**
	 * generar numero transaccion una transaccion afecta a varios productos.
	 * @return
	 */
	private int getNumeroTransaccion() {
		int numeroTransaccion = transaccionRepository.getNumeroTransaccion().intValue()+1;
		return numeroTransaccion;
	}

	/**
	 * crear kardex de la transaccion.
	 * @param kardex
	 */
	public void crearKardex(Kardex kardex) {
		kardexRepository.save(kardex);
	}

	/**
	 * actualizar kardex. 
	 * @param kardex
	 */
	public void actualizarKardex(Kardex kardex) {
		kardexRepository.save(kardex);
	}
	/**
	 * crear detalle kardex de la transaccion.
	 * @param detalleKardex
	 */
	public void crearDetalleKardex(DetalleKardex detalleKardex) {
		detalleKardexRepository.save(detalleKardex);
	}

	/**
	 * obtener los detalles del kardex por id kardex.
	 * @param idKardex
	 * @return
	 */
	public List<DetalleKardex> buscarDetallesKardex(int idKardex){
		return detalleKardexRepository.buscarDetalleKardexPorIdKardex(idKardex);
	}

}
