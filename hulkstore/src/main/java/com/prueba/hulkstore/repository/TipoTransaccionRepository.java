package com.prueba.hulkstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.TipoTransaccion;

/**
 * 
 * @author Gabbytaz
 *
 */
@Repository
public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion, Integer> {

}
