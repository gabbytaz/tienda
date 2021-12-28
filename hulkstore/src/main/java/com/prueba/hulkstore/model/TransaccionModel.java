/**
 * 
 */
package com.prueba.hulkstore.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Gabbytaz
 *
 */
public class TransaccionModel {
	
	private int numerotransaccion;
	
	private Date fecha;
			
	private String cedula;
	
	private int idtipotransaccion;
	
	private List<DetalleTransaccionModel> detalleTransaccionModel;

	/**
	 * @return the numero_transaccion
	 */
	public int getNumerotransaccion() {
		return numerotransaccion;
	}

	/**
	 * @param numero_transaccion the numero_transaccion to set
	 */
	public void setNumerotransaccion(int numerotransaccion) {
		this.numerotransaccion = numerotransaccion;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the idtipotransaccion
	 */
	public int getIdtipotransaccion() {
		return idtipotransaccion;
	}

	/**
	 * @param idtipotransaccion the idtipotransaccion to set
	 */
	public void setIdtipotransaccion(int idtipotransaccion) {
		this.idtipotransaccion = idtipotransaccion;
	}

	/**
	 * @return the detalleTransaccionModel
	 */
	public List<DetalleTransaccionModel> getDetalleTransaccionModel() {
		return detalleTransaccionModel;
	}

	/**
	 * @param detalleTransaccionModel the detalleTransaccionModel to set
	 */
	public void setDetalleTransaccionModel(List<DetalleTransaccionModel> detalleTransaccionModel) {
		this.detalleTransaccionModel = detalleTransaccionModel;
	}
	
}
