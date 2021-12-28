/**
 * 
 */
package com.prueba.hulkstore.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.hulkstore.business.strategy.Strategy;
import com.prueba.hulkstore.business.strategy.StrategyFactory;
import com.prueba.hulkstore.model.ReporteKardexModel;
import com.prueba.hulkstore.persistencia.DetalleKardex;
import com.prueba.hulkstore.persistencia.Kardex;
import com.prueba.hulkstore.persistencia.Transaccion;
import com.prueba.hulkstore.repository.TransaccionDAO;
import com.prueba.hulkstore.utils.ConstantesHulKStore;

/**
 * 
 * @author Gabbytaz
 *clase definida para manejar el negocio de la transaccion realizada en la tienda online.
 */
@Service
public class TransaccionBusiness {

	@Autowired
	StrategyFactory strategyFactory;

	@Autowired
	TransaccionDAO transaccionDAO;

	/**
	 * realiza la transaccion sea ingreso o egreso.
	 * @param transaccionesList lista de los productos a procesar
	 * @throws Exception 
	 */
	public void realizarTransaccion(List<Transaccion> transaccionesList) throws Exception {

		for (Transaccion transaccion : transaccionesList) {

			transaccionDAO.crearTransaccion(transaccion);

			Kardex kardex = buscarKardexPorProducto(transaccion.getDetalleKardex().getKardex().getIdproducto());
			//sino tiene kardex armar objeto con los valores actuales
			if(kardex == null) {
				kardex = new Kardex();
				kardex.setIdproducto(transaccion.getDetalleKardex().getKardex().getIdproducto());
				transaccionDAO.crearKardex(kardex);
			}

			Strategy estrategia = strategyFactory.obtenerEstrategia(transaccion.getIdtipotransaccion());
			System.out.println("strategy "+ estrategia.getClass().getName());

			DetalleKardex detalleKardex;
			try {
				detalleKardex = estrategia.gestionarTransaccion(transaccion,kardex);
			} catch (Exception e) {
				String mensaje = "El producto "+kardex.getIdproducto()+ e.getMessage();
				throw new Exception(mensaje);
			}	
			transaccionDAO.crearDetalleKardex(detalleKardex);

			//actualizar valores saldos actuales al kardex 
			kardex.setCantidadkardex(detalleKardex.getCantidadactual());
			kardex.setValorkardex(detalleKardex.getValoractual());
			kardex.setTotalkardex(detalleKardex.getTotalactual());
			transaccionDAO.actualizarKardex(kardex);

		}

	}

	/**
	 * buscar el kardex por id producto. 
	 * @param idproducto
	 * @return
	 */
	private Kardex buscarKardexPorProducto(int idproducto) {
		return transaccionDAO.buscarKardexPorIdProducto(idproducto);	
	}

	/**
	 * busca el detalle del kardex por el id kardex.
	 * @param idKardex
	 * @return
	 */
	private List<DetalleKardex>buscarDetallesKardex(int idKardex){		
		return transaccionDAO.buscarDetallesKardex(idKardex);	
	}

	/**
	 * generar reporte del kardex por producto con sus detalles.
	 * @param idProducto
	 * @return Kardex entidad
	 */
	public Kardex reporteKardexProducto(int idProducto) {

		Kardex kardex = buscarKardexPorProducto(idProducto);
		if(kardex != null) {
			List<DetalleKardex> detallesKardex = buscarDetallesKardex(kardex.getIdkardex());
			kardex.setDetallesKardex(detallesKardex);
		}			

		return kardex;
	}

	/**
	 * construir el reporte del kardex por producto a partir del metodo reporteKardexProducto.
	 * @param idproducto
	 * @return ReporteKardexModel objeto para la interfaz
	 */
	public List<ReporteKardexModel> buildReporteKardex(int idproducto) {

		List<ReporteKardexModel> reporteKardexModelList = new ArrayList<ReporteKardexModel>();
		Kardex kardex = reporteKardexProducto(idproducto);
		if(kardex != null) {

			for (DetalleKardex detalleKardex : kardex.getDetallesKardex()) {	
				ReporteKardexModel reporteKardexModel = asignarDetalleKardex(detalleKardex);
				reporteKardexModel.setNombreproducto(kardex.getProducto().getDescripcion());
				reporteKardexModelList.add(reporteKardexModel);
			}

		}
		return reporteKardexModelList;
	}

	/**
	 * asigna el detalle del kardex entidad al model para construir el reporte.
	 * @param detalleKardex
	 * @return ReporteKardexModel
	 */
	private ReporteKardexModel asignarDetalleKardex(DetalleKardex detalleKardex) {

		ReporteKardexModel detalleReporteKardexModel = new ReporteKardexModel();

		if(detalleKardex.getTransaccion().getIdtipotransaccion() == ConstantesHulKStore.INGRESO_TRANSACCION) {
			detalleReporteKardexModel.setCantidadIngreso(detalleKardex.getTransaccion().getCantidad());
			detalleReporteKardexModel.setValorIngreso(detalleKardex.getTransaccion().getPrecio());
			detalleReporteKardexModel.setTotalIngreso(detalleKardex.getTransaccion().getTotal());
		}

		if(detalleKardex.getTransaccion().getIdtipotransaccion() == ConstantesHulKStore.EGRESO_TRANSACCION) {
			detalleReporteKardexModel.setCantidadEgreso(detalleKardex.getTransaccion().getCantidad());
			detalleReporteKardexModel.setValorEgreso(detalleKardex.getTransaccion().getPrecio());
			detalleReporteKardexModel.setTotalEgreso(detalleKardex.getTransaccion().getTotal());
		}

		detalleReporteKardexModel.setCantidadSaldo(detalleKardex.getCantidadactual());
		detalleReporteKardexModel.setValorSaldo(detalleKardex.getValoractual());
		detalleReporteKardexModel.setTotalSaldo(detalleKardex.getTotalactual());

		detalleReporteKardexModel.setFecha(getFechaString(detalleKardex.getTransaccion().getFecha()));
		detalleReporteKardexModel.setIdtipotransaccion(detalleKardex.getTransaccion().getIdtipotransaccion());

		return detalleReporteKardexModel;
	}

	/**
	 * transforma la fecha date a string
	 * @param fechaTransaccion
	 * @return
	 */
	private String getFechaString( Date fechaTransaccion) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fechaTransaccionStr = sdf.format(fechaTransaccion);
		return fechaTransaccionStr;
	}

	public StrategyFactory getStrategyFactory() {
		return strategyFactory;
	}

	public TransaccionDAO getTransaccionDAO() {
		return transaccionDAO;
	}

}
