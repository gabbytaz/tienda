package com.prueba.hulkstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.hulkstore.persistencia.TipoTransaccion;

/**
 * 
 * @author Gabbytaz
 *
 */
@Component
public class TipoTransaccionDAO {
	@Autowired
	TipoTransaccionRepository tipoTransaccionRepository;
	
	/**
	 * 
	 * @param id de tipo transaccion
	 * @return
	 */
	public Optional<TipoTransaccion> buscarTipoTransaccionId (int id){
		return tipoTransaccionRepository.findById(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<TipoTransaccion> buscarTipoTransaccion() {
		return tipoTransaccionRepository.findAll();
	}
}
