/**
 * 
 */
package com.prueba.hulkstore.model;

/**
 * 
 * @author Gabbytaz
 *
 */
public class DetalleTransaccionModel {
	
	private int idtransaccion;
	
	private int idproducto;
	
	private int cantidad;
	
	private float precio;
	
	private float total;
	private String nombreproducto;
	
	public DetalleTransaccionModel() {
		
	}
	
	/**
	 * @param idtransaccion
	 * @param idproducto
	 * @param cantidad
	 * @param precio
	 * @param total
	 */
	public DetalleTransaccionModel(int idproducto, int cantidad, float precio, float total) {
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
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
	 * @return the idproducto
	 */
	public int getIdproducto() {
		return idproducto;
	}

	/**
	 * @param idproducto the idproducto to set
	 */
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
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

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	
}
