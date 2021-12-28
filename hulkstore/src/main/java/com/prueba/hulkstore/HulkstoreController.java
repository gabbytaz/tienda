/**
 * 
 */
package com.prueba.hulkstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.hulkstore.business.CatalogosBusiness;
import com.prueba.hulkstore.business.TransaccionBusiness;
import com.prueba.hulkstore.model.DetalleTransaccionModel;
import com.prueba.hulkstore.model.EmpleadoModel;
import com.prueba.hulkstore.model.ProductoModel;
import com.prueba.hulkstore.model.ReporteKardexModel;
import com.prueba.hulkstore.model.TipoTransaccionModel;
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
@RestController
@RequestMapping("/api")
public class HulkstoreController {

	@Autowired
	CatalogosBusiness catalogosBusiness;

	@Autowired
	TransaccionBusiness transaccionBusiness;

	@GetMapping("/getProducto/{id}")
	public ProductoModel getProducto(@PathVariable int id){
		ProductoModel productoModel = null;

		try {
			Producto producto = catalogosBusiness.buscarProducto(id);
			productoModel = new ProductoModel();
			productoModel.setIdproducto(producto.getIdproducto());
			productoModel.setDescripcion(producto.getDescripcion());

		}catch (Exception e) {
			System.out.println("error al consultar el producto por Id "+e);
		}
		return productoModel;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getProductos")
	public List<ProductoModel> getProductosList(){
		List<ProductoModel> productoModelList =null;
		List<Producto> productoList = catalogosBusiness.buscarProductos();

		if(!productoList.isEmpty()) {
			productoModelList= new ArrayList<ProductoModel>();
			for (Producto producto : productoList) {
				ProductoModel productoModel = null;

				if(producto.getKardex() == null) {
					productoModel = new ProductoModel(producto.getIdproducto(),
							producto.getDescripcion());
				}else {
					productoModel = new ProductoModel(producto.getIdproducto(),
							producto.getDescripcion(),producto.getKardex().getCantidadkardex(),
							producto.getKardex().getValorkardex());
				}

				productoModelList.add(productoModel);
			}
		}

		return productoModelList;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getEmpleados")
	public List<EmpleadoModel> getEmpleados(){
		List<EmpleadoModel> empleadoModelList = null;

		try {
			List<Empleado> empleados = catalogosBusiness.buscarEmpleados();
			if(!empleados.isEmpty()) {

				empleadoModelList = new ArrayList<EmpleadoModel>();
				for (Empleado empleado : empleados) {
					EmpleadoModel empleadoModel = new EmpleadoModel(empleado.getCedula(),empleado.getNombre(),empleado.getApellido());
					empleadoModelList.add(empleadoModel);
				}

			}
		}catch (Exception e) {
			System.out.println("error al obtener los empleados "+e);
		}

		return empleadoModelList;
	}

	@GetMapping("/getEmpleadoPorCedula/{cedula}")
	public EmpleadoModel getEmpleadoPorCedula(@PathVariable String cedula){
		EmpleadoModel empleadoModel = null;

		try {
			Empleado empleado = catalogosBusiness.buscarEmpleado(cedula);
			empleadoModel = new EmpleadoModel(empleado.getCedula(),empleado.getNombre(),empleado.getApellido());

		}catch (Exception e) {
			System.out.println("error al consultar el empleado por cedula "+e);
		}

		return empleadoModel;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getTipoTransaccion")
	public List<TipoTransaccionModel> getTipoTransaccion(){
		List<TipoTransaccionModel> tipoTransaccionModelList = null;

		try {
			List<TipoTransaccion> tiposTransaccion = catalogosBusiness.buscarTipoTransaccion();
			if(!tiposTransaccion.isEmpty()) {

				tipoTransaccionModelList = new ArrayList<TipoTransaccionModel>();
				for (TipoTransaccion tipoTransaccion : tiposTransaccion) {
					TipoTransaccionModel tipoTransaccionModel = new TipoTransaccionModel(tipoTransaccion.getIdtipotransaccion(),tipoTransaccion.getTipotransaccion());
					tipoTransaccionModelList.add(tipoTransaccionModel);
				}

			}
		}catch (Exception e) {
			System.out.println("error al obtener los tipos de transaccion "+e);
		}

		return tipoTransaccionModelList;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/transaccion")
	public TransaccionModel guardarTransaccion(@RequestBody TransaccionModel transaccionModel){
		TransaccionModel transaccionModelnew = new TransaccionModel();
		
		try {
			List<Transaccion> transaccionesList = new ArrayList<Transaccion>();

			for (DetalleTransaccionModel detalle : transaccionModel.getDetalleTransaccionModel()) {
				//pasar a entidades
				Transaccion transaccion = new Transaccion();
				transaccion.setFecha(new Date());
				transaccion.setIdempleado(transaccionModel.getCedula());
				transaccion.setIdtipotransaccion(transaccionModel.getIdtipotransaccion());
				//validar ultima y asignar siguiente
				transaccion.setCantidad(detalle.getCantidad());
				transaccion.setPrecio(detalle.getPrecio());
				transaccion.setTotal(detalle.getTotal());

				transaccion.setDetalleKardex(new DetalleKardex());
				Kardex kardex = new Kardex();
				kardex.setIdproducto(detalle.getIdproducto());
				transaccion.getDetalleKardex().setKardex(kardex);

				transaccionesList.add(transaccion);
			}

			transaccionBusiness.realizarTransaccion(transaccionesList);
			transaccionModelnew.setCedula("ok");						
		}catch (Exception e) {
			System.out.println(e.getMessage());
			transaccionModelnew.setCedula(e.getMessage());
		}
		return transaccionModelnew;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getReporteKardex/{idproducto}")
	public List<ReporteKardexModel> getReporteKardex(@PathVariable int idproducto){

		List<ReporteKardexModel> reporte = transaccionBusiness.buildReporteKardex(idproducto);

		return reporte;
	}

}
