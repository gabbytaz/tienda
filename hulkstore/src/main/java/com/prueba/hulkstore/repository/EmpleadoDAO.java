/**
 * 
 */
package com.prueba.hulkstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.hulkstore.persistencia.Empleado;

/**
 * @author Gabby
 *
 */
@Component
public class EmpleadoDAO {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	/**
	 * 
	 * @param cedula del empleado
	 * @return
	 */
	public Optional<Empleado> buscarEmpleadoPorId (String cedula){
		return empleadoRepository.findById(cedula);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Empleado> buscarEmpleados() {
		return empleadoRepository.findAll();
	}
	
}
