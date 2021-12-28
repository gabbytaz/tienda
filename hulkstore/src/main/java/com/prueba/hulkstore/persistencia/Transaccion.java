/**
 * 
 */
package com.prueba.hulkstore.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * 
 * @author Gabbytaz
 *
 */
@Entity(name="transaccion")
public class Transaccion {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtransaccion;
	
	/**
	 * 
	 */
	@Column(name = "fecha")
	private Date fecha;
	
	/**
	 * 
	 */
	@Column(name = "cantidad")
	private int cantidad;
	
	/**
	 * 
	 */
	@Column(name = "precio")
	private float precio;
	
	/**
	 * 
	 */
	@Column(name = "total")
	private float total;
	
	/**
	 * 
	 */
	@Column(name = "idempleado")
	private String idempleado;
	
	/**
	 * 
	 */
	@Column(name = "idtipotransaccion")
	private int idtipotransaccion;
	
	/**
	 * 
	 */
	@Column(name = "numerotransaccion")
	private int numerotransaccion;
	
//	@ManyToOne
//	@JoinColumn(name = "idempleado", insertable=false, updatable=false)
//	private Empleado empleado;
	
//	@ManyToOne
//	@JoinColumn(name = "idtipotransaccion", insertable=false, updatable=false)
	//private TipoTransaccion tipoTransaccion;
	
	@Transient
	@OneToOne
	@JoinColumn(name = "idtransaccion", insertable=false, updatable=false)
	private DetalleKardex detalleKardex;
	
	/**
	 *
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the idempleado
	 */
	public String getIdempleado() {
		return idempleado;
	}

	/**
	 * @param idempleado the idempleado to set
	 */
	public void setIdempleado(String idempleado) {
		this.idempleado = idempleado;
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
	 * @return the numerotransaccion
	 */
	public int getNumerotransaccion() {
		return numerotransaccion;
	}

	/**
	 * @param numerotransaccion the numerotransaccion to set
	 */
	public void setNumerotransaccion(int numerotransaccion) {
		this.numerotransaccion = numerotransaccion;
	}

	/**
	 * @return the empleado
	 */
/*	public Empleado getEmpleado() {
		return empleado;
	}/*

	/**
	 * @param empleado the empleado to set
	 */
	/*public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}/*s

	/**
	 * @return the tipoTransaccion
	 */
//	public TipoTransaccion getTipoTransaccion() {
//		return tipoTransaccion;
//	}

	/**
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
//	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
//		this.tipoTransaccion = tipoTransaccion;
//	}

	/**
	 * @return the detalleKardex
	 */
	public DetalleKardex getDetalleKardex() {
		return detalleKardex;
	}

	/**
	 * @param detalleKardex the detalleKardex to set
	 */
	public void setDetalleKardex(DetalleKardex detalleKardex) {
		this.detalleKardex = detalleKardex;
	}
	
}
