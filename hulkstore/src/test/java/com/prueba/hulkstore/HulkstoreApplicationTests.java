package com.prueba.hulkstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prueba.hulkstore.business.CatalogosBusiness;
import com.prueba.hulkstore.business.TransaccionBusiness;
import com.prueba.hulkstore.model.DetalleTransaccionModel;
import com.prueba.hulkstore.model.ReporteKardexModel;
import com.prueba.hulkstore.model.TransaccionModel;
import com.prueba.hulkstore.persistencia.DetalleKardex;
import com.prueba.hulkstore.persistencia.Empleado;
import com.prueba.hulkstore.persistencia.Kardex;
import com.prueba.hulkstore.persistencia.Producto;
import com.prueba.hulkstore.persistencia.TipoTransaccion;
import com.prueba.hulkstore.persistencia.Transaccion;

/**
 * 
 * @author Gabbytaz
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HulkstoreApplicationTests {

	@Autowired
	CatalogosBusiness catalogosBusiness;

	@Autowired
	TransaccionBusiness transaccionBusiness;

	@Test
	public void contextLoads() {
		
	}

	@Test
	public void buscarProductoPorId() {
		int idProducto=1;
		Producto producto = catalogosBusiness.buscarProducto(idProducto);
		System.out.println("valor obtenido "+producto.getDescripcion());
		String expected ="camisetas";
		assertEquals(expected, producto.getDescripcion());
	}

	@Test
	public void buscarProductos() {

		List<Producto> productos = catalogosBusiness.buscarProductos();
		for (Producto producto : productos) {
			System.out.println("producto "+producto.getIdproducto()+" "+producto.getDescripcion());
			System.out.println("cantidad kardex "+producto.getKardex().getCantidadkardex());
		}
		assertNotNull(productos);
	}

	@Test
	public void getEmpleadoPorCedula() {
		String cedula="1721458956";
		Empleado empleado = catalogosBusiness.buscarEmpleado(cedula);
		assertEquals("Gabriela", empleado.getNombre());
	}

	@Test
	public void getEmpleados() {
		List<Empleado> empleados = catalogosBusiness.buscarEmpleados();

		if(!empleados.isEmpty()) {
			for (Empleado empleado : empleados) {
				System.out.println("nombre empleado: "+empleado.getNombre());
			}
		}
		assertNotNull(empleados);
	}

	@Test 
	public void obtenerTiposTransaccion(){
		List<TipoTransaccion> tiposTransaccion = catalogosBusiness.buscarTipoTransaccion();
		System.out.println("tipos de transacciones");
		for (TipoTransaccion tipoTransaccion : tiposTransaccion) {
			System.out.println(tipoTransaccion.getTipotransaccion());
		}
		assertNotNull(tiposTransaccion);
	}

	@Test
	public void crearTransaccion() {

		TransaccionModel transaccionModel = new TransaccionModel();
		transaccionModel.setCedula("1721458956");
		transaccionModel.setFecha(new Date());
		transaccionModel.setIdtipotransaccion(2);

		List<DetalleTransaccionModel> detalles = new ArrayList<DetalleTransaccionModel>();

		int idproducto = 1;
		int cantidad = 1;
		float precio = (float) 3;
		float total = cantidad * precio;
		DetalleTransaccionModel detalleTransaccionModel = new DetalleTransaccionModel(idproducto,cantidad,precio,total);
		detalles.add(detalleTransaccionModel);

		//		idproducto = 2;
		//		cantidad = 8;
		//		precio = 4;
		//		total = cantidad * precio;
		//		DetalleTransaccionModel detalleTransaccionModel2 = new DetalleTransaccionModel(idproducto,cantidad,precio,total);
		//		detalles.add(detalleTransaccionModel2);
		transaccionModel.setDetalleTransaccionModel(detalles);

		//simulacion modelo a entidad
		List<Transaccion> transaccionesList = new ArrayList<Transaccion>();

		for (DetalleTransaccionModel detalle : transaccionModel.getDetalleTransaccionModel()) {
			//pasar a entidades
			Transaccion transaccion = new Transaccion();
			transaccion.setFecha(transaccionModel.getFecha());
			transaccion.setIdempleado(transaccionModel.getCedula());
			transaccion.setIdtipotransaccion(transaccionModel.getIdtipotransaccion());
			transaccion.setCantidad(detalle.getCantidad());
			transaccion.setPrecio(detalle.getPrecio());
			transaccion.setTotal(detalle.getTotal());
			transaccion.setDetalleKardex(new DetalleKardex());
			Kardex kardex = new Kardex();
			kardex.setIdproducto(detalle.getIdproducto());
			transaccion.getDetalleKardex().setKardex(kardex);

			transaccionesList.add(transaccion);
		}

		try {
			transaccionBusiness.realizarTransaccion(transaccionesList);
		} catch (Exception e) {
			System.out.println("errror: "+e.getMessage());
		}

	}

	@Test
	public void reporteKardex() {
		Kardex kardex = transaccionBusiness.reporteKardexProducto(1);
		if(kardex!=null) {
			System.out.println("kardex "+kardex.getIdkardex()+"cantidad "+kardex.getCantidadkardex());

			for (DetalleKardex  detalleKardex : kardex.getDetallesKardex()) {
				System.out.println("id detalle "+detalleKardex.getIddetallekardex()+" id transaccion "+ detalleKardex.getTransaccion().getIdtransaccion());
			}

		}
		assertNotNull(kardex);
	}

	@Test
	public void construirReporte() {
		List<ReporteKardexModel> detalleReporteKardexModelL = transaccionBusiness.buildReporteKardex(1);

		for (ReporteKardexModel detalleReporteKardexModel : detalleReporteKardexModelL) {

			System.out.println("kardex producto : "+detalleReporteKardexModel.getNombreproducto());
			System.out.println("Ingreso "+detalleReporteKardexModel.getCantidadIngreso()+" "+detalleReporteKardexModel.getValorIngreso()+" "+detalleReporteKardexModel.getTotalIngreso());
			System.out.println("Egreso "+detalleReporteKardexModel.getCantidadEgreso()+" "+detalleReporteKardexModel.getValorEgreso()+" "+detalleReporteKardexModel.getTotalEgreso());
			System.out.println("Saldo "+detalleReporteKardexModel.getCantidadSaldo()+" "+detalleReporteKardexModel.getValorSaldo()+" "+detalleReporteKardexModel.getTotalSaldo());
		}
		assertNotNull(detalleReporteKardexModelL);
	}
	
}
