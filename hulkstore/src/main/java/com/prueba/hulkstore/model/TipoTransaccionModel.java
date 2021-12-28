package com.prueba.hulkstore.model;

/**
 * 
 * @author Gabbytaz
 *
 */

public class TipoTransaccionModel {

	private int idtipotransaccion;
	private String tipotransaccion;
	
	public TipoTransaccionModel() {}
	
	public TipoTransaccionModel(int idtipotransaccion, String tipotransaccion) {
		this.idtipotransaccion = idtipotransaccion;
		this.tipotransaccion = tipotransaccion;
	}
	public int getIdtipotransaccion() {
		return idtipotransaccion;
	}
	public void setIdtipotransaccion(int idtipotransaccion) {
		this.idtipotransaccion = idtipotransaccion;
	}
	public String getTipotransaccion() {
		return tipotransaccion;
	}
	public void setTipotransaccion(String tipotransaccion) {
		this.tipotransaccion = tipotransaccion;
	}
}
