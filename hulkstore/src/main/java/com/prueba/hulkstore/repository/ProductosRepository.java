/**
 * 
 */
package com.prueba.hulkstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.Producto;

/**
 * 
 * @author Gabbytaz
 *
 */
@Repository
public interface ProductosRepository extends JpaRepository<Producto, Integer> {
	
	@Query(value="SELECT idproducto, descripcion FROM producto where idproducto= ?1")
	Producto buscarProducto (int id);

}	
