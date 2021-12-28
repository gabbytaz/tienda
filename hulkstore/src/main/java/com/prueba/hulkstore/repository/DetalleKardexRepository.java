/**
 * 
 */
package com.prueba.hulkstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.DetalleKardex;

/**
 * @author Gabby
 *
 */
@Repository
public interface DetalleKardexRepository extends JpaRepository<DetalleKardex, Integer> {
	
	@Query(value="SELECT dk FROM detallekardex dk INNER JOIN transaccion t on t.idtransaccion= dk.idtransaccion WHERE dk.idkardex = :id ")
	List<DetalleKardex> buscarDetalleKardexPorIdKardex (@Param("id") int id);

}
