/**
 * 
 */
package com.prueba.hulkstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.Transaccion;

/**
 * 
 * @author Gabbytaz
 *
 */
@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
	
	@Query("SELECT coalesce(max(t.numerotransaccion), 0) FROM transaccion t")
	Long getNumeroTransaccion();

}
