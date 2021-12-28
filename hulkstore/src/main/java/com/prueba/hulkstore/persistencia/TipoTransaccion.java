/**
 * 
 */
package com.prueba.hulkstore.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Gabbytaz
 *
 */

@Entity(name="tipotransaccion")
public class TipoTransaccion {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipotransaccion;
	
	/**
	 * 
	 */
	@Column(name = "tipotransaccion")
	private String tipotransaccion;
	
//	@OneToMany(mappedBy = "idtipotransaccion")
//	private List<Transaccion> transacciones;

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
	 * @return the tipotransaccion
	 */
	public String getTipotransaccion() {
		return tipotransaccion;
	}

	/**
	 * @param tipotransaccion the tipotransaccion to set
	 */
	public void setTipotransaccion(String tipotransaccion) {
		this.tipotransaccion = tipotransaccion;
	}

	/**
	 * @return the transacciones
	 */
//	public List<Transaccion> getTransacciones() {
//		return transacciones;
//	}

	/**
	 * @param transacciones the transacciones to set
	 */
//	public void setTransacciones(List<Transaccion> transacciones) {
//		this.transacciones = transacciones;
//	}

}
