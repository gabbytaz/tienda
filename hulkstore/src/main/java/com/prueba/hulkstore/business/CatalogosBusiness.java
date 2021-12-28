/**
 * 
 */
package com.prueba.hulkstore.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.hulkstore.persistencia.Empleado;
import com.prueba.hulkstore.persistencia.Producto;
import com.prueba.hulkstore.persistencia.TipoTransaccion;
import com.prueba.hulkstore.repository.EmpleadoDAO;
import com.prueba.hulkstore.repository.ProductoDAO;
import com.prueba.hulkstore.repository.TipoTransaccionDAO;

/**
 * 
 * @author Gabbytaz
 * clase administracion de los catalogos definidos para el funcionamiento de la tienda online.
 */

@Service
public class CatalogosBusiness {

	@Autowired
	ProductoDAO productoDAO;

	@Autowired
	EmpleadoDAO empleadoDAO;

	@Autowired
	TipoTransaccionDAO tipoTransaccionDAO;

	/**
	 * buscar el producto por id producto.
	 * @param id del producto
	 * @return
	 */
	public Producto buscarProducto (int id){
		Producto producto = productoDAO.buscarProductoPorId(id).get();	
		return producto;
	}

	/**
	 * buscar los empleados.
	 * @return
	 */
	public List<Empleado> buscarEmpleados(){
		return empleadoDAO.buscarEmpleados();
	}

	/**
	 * buscar los empleados por cedula.
	 * @param cedula del empleado
	 * @return
	 */
	public Empleado buscarEmpleado (String cedula){
		Empleado empleado = empleadoDAO.buscarEmpleadoPorId(cedula).get();	
		return empleado;
	}

	/**
	 * buscar todos los productos.
	 * @return
	 */
	public List<Producto> buscarProductos(){
		return productoDAO.buscarProductos();
	}

	/**
	 * buscar los tipos de las transacciones.
	 * @return
	 */
	public List<TipoTransaccion> buscarTipoTransaccion(){
		return tipoTransaccionDAO.buscarTipoTransaccion();
	}

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}

}
