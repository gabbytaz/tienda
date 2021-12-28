/**
 * 
 */
package com.prueba.hulkstore.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * 
 * @author Gabbytaz
 *
 */
@Entity(name="detallekardex")
public class DetalleKardex {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetallekardex;
	
	/**
	 * 
	 */
	@Column(name = "cantidadanterior")
	private int cantidadanterior;
	
	/**
	 * 
	 */
	@Column(name = "valoranterior")
	private float valoranterior;
	
	/**
	 * 
	 */
	@Column(name = "totalanterior")
	private float totalanterior;
	
	/**
	 * 
	 */
	@Column(name = "cantidadactual")
	private int cantidadactual;
	
	/**
	 * 
	 */
	@Column(name = "valoractual")
	private float valoractual;
	
	/**
	 * 
	 */
	@Column(name = "totalactual")
	private float totalactual;
	
	/**
	 * 
	 */
	@Column(name = "idkardex")
	private int idkardex;
	
	/**
	 * 
	 */
	@Column(name = "idtransaccion")
	private int idtransaccion;
	
	@ManyToOne
	@JoinColumn(name = "idkardex", insertable=false, updatable=false)
	private Kardex kardex;
	
	@OneToOne
	@JoinColumn(name = "idtransaccion", insertable=false, updatable=false)
	private Transaccion transaccion;

	/**
	 * @return the iddetallekardex
	 */
	public int getIddetallekardex() {
		return iddetallekardex;
	}

	/**
	 * @param iddetallekardex the iddetallekardex to set
	 */
	public void setIddetallekardex(int iddetallekardex) {
		this.iddetallekardex = iddetallekardex;
	}

	/**
	 * @return the cantidadanterior
	 */
	public int getCantidadanterior() {
		return cantidadanterior;
	}

	/**
	 * @param cantidadanterior the cantidadanterior to set
	 */
	public void setCantidadanterior(int cantidadanterior) {
		this.cantidadanterior = cantidadanterior;
	}

	/**
	 * @return the valoranterior
	 */
	public float getValoranterior() {
		return valoranterior;
	}

	/**
	 * @param valoranterior the valoranterior to set
	 */
	public void setValoranterior(float valoranterior) {
		this.valoranterior = valoranterior;
	}

	/**
	 * @return the totalanterior
	 */
	public float getTotalanterior() {
		return totalanterior;
	}

	/**
	 * @param totalanterior the totalanterior to set
	 */
	public void setTotalanterior(float totalanterior) {
		this.totalanterior = totalanterior;
	}

	/**
	 * @return the cantidadactual
	 */
	public int getCantidadactual() {
		return cantidadactual;
	}

	/**
	 * @param cantidadactual the cantidadactual to set
	 */
	public void setCantidadactual(int cantidadactual) {
		this.cantidadactual = cantidadactual;
	}

	/**
	 * @return the valoractual
	 */
	public float getValoractual() {
		return valoractual;
	}

	/**
	 * @param valoractual the valoractual to set
	 */
	public void setValoractual(float valoractual) {
		this.valoractual = valoractual;
	}

	/**
	 * @return the totalactual
	 */
	public float getTotalactual() {
		return totalactual;
	}

	/**
	 * @param totalactual the totalactual to set
	 */
	public void setTotalactual(float totalactual) {
		this.totalactual = totalactual;
	}

	/**
	 * @return the idkardex
	 */
	public int getIdkardex() {
		return idkardex;
	}

	/**
	 * @param idkardex the idkardex to set
	 */
	public void setIdkardex(int idkardex) {
		this.idkardex = idkardex;
	}

	/**
	 * @return the idtransaccion
	 */
	public int getIdtransaccion() {
		return idtransaccion;
	}

	/**
	 * @param idtransaccion the idtransaccion to set
	 */
	public void setIdtransaccion(int idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	/**
	 * @return the kardex
	 */
	public Kardex getKardex() {
		return kardex;
	}

	/**
	 * @param kardex the kardex to set
	 */
	public void setKardex(Kardex kardex) {
		this.kardex = kardex;
	}

	/**
	 * @return the transaccion
	 */
	public Transaccion getTransaccion() {
		return transaccion;
	}

	/**
	 * @param transaccion the transaccion to set
	 */
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}
		
}
