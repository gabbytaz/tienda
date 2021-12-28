/**
 * 
 */
package com.prueba.hulkstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.hulkstore.persistencia.Producto;

/**
 * 
 * @author Gabbytaz
 *
 */
@Component
public class ProductoDAO {
	
	@Autowired
	ProductosRepository productosRepository;
	
	/**
	 * 
	 * @param id de producto
	 * @return
	 */
	public Optional<Producto> buscarProductoPorId (int id){
		return productosRepository.findById(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Producto> buscarProductos() {
		return productosRepository.findAll();
	}
	
}
