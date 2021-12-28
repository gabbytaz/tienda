package com.prueba.hulkstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.hulkstore.persistencia.Empleado;
import com.prueba.hulkstore.persistencia.Kardex;
import com.prueba.hulkstore.persistencia.Producto;
import com.prueba.hulkstore.persistencia.TipoTransaccion;
import com.prueba.hulkstore.persistencia.Transaccion;
import com.prueba.hulkstore.repository.EmpleadoDAO;
import com.prueba.hulkstore.repository.ProductoDAO;
import com.prueba.hulkstore.repository.TipoTransaccionDAO;
import com.prueba.hulkstore.repository.TransaccionDAO;
/**
 * 
 * @author Gabbytaz
 *
 */
public class HulkstoreDaoTest {

	@Autowired
	ProductoDAO productoDAO;

	@Autowired
	EmpleadoDAO empleadoDAO;

	@Autowired
	TipoTransaccionDAO tipoTransaccionDAO;

	@Autowired
	TransaccionDAO transaccionDAO;

	@Test
	public void obtenerProductoPorId() {
		int id = 1;
		Producto producto = productoDAO.buscarProductoPorId(id).get();	
		assertEquals("camisas", producto.getDescripcion());
	}

	@Test
	public void obtenerProductos() {
		List<Producto> productos = productoDAO.buscarProductos();
		assertNotNull(productos);
	}

	@Test
	public void buscarEmpleadoPorId() {
		String cedula = "1721458956";
		Empleado empleado = empleadoDAO.buscarEmpleadoPorId(cedula).get();
		assertNotNull(empleado);
	}

	@Test
	public void buscarEmpleados() {
		List<Empleado> empleados = empleadoDAO.buscarEmpleados();
		assertNotNull(empleados);
	}

	@Test
	public void buscarTipoTransaccion() {
		List<TipoTransaccion> tipoTransaccion = tipoTransaccionDAO.buscarTipoTransaccion();
		assertNotNull(tipoTransaccion);
	}

	@Test
	public void crearTransaccion() {
		Transaccion transaccion = new Transaccion();
		transaccion.setFecha(new Date());
		transaccion.setIdempleado("1721458956");
		transaccion.setIdtipotransaccion(1);
		transaccion.setCantidad(2);
		transaccion.setPrecio(2);
		transaccion.setTotal(transaccion.getCantidad() * transaccion.getPrecio());
		transaccionDAO.crearTransaccion(transaccion);
		assertNotNull(transaccion.getIdtransaccion());
	}

	@Test
	public void crearKardex() {
		Kardex kardex = new Kardex();
		kardex.setIdproducto(1);
		kardex.setCantidadkardex(2);
		kardex.setValorkardex(2);
		kardex.setTotalkardex(kardex.getCantidadkardex() * kardex.getValorkardex());
		assertNotNull(kardex.getIdkardex());
	}
}