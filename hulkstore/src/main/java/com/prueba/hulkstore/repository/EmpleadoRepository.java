/**
 * 
 */
package com.prueba.hulkstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.hulkstore.persistencia.Empleado;

/**
 * @author Gabby
 *
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
	
}	
