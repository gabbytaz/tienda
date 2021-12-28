/**
 * 
 */
package com.prueba.hulkstore.model;

/**
 * 
 * @author Gabbytaz
 *
 */
public class ProductoModel {


	private int idproducto;

	private String descripcion;
	
	private int stock;

	private float valor;
	
	public ProductoModel() {
		
	}
	
	public ProductoModel(int idproducto,String descripcion) {
		this.idproducto = idproducto;
		this.descripcion = descripcion;
	}
	
	public ProductoModel(int idproducto,String descripcion,int stock, float valor) {
		this.idproducto = idproducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.valor = valor;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the valor
	 */
	public float getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(float valor) {
		this.valor = valor;
	}

}
