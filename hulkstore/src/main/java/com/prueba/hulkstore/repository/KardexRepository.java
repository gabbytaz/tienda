/**
 * 
 */
package com.prueba.hulkstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.Kardex;

/**
 * 
 * @author Gabbytaz
 *
 */
@Repository
public interface KardexRepository extends JpaRepository<Kardex, Integer> {
	
	@Query(value="SELECT k FROM kardex k WHERE k.idproducto = :id ")
	Kardex buscarKardexPorIdProducto (@Param("id") int id);

}
