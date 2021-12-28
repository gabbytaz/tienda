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
import javax.persistence.OneToOne;

/**
 * 
 * @author Gabbytaz
 *
 */
@Entity(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name = "idproducto", insertable=false, updatable=false)
	private Kardex kardex;

	/**
	 * @return the idProducto
	 */
	public int getIdproducto() {
		return idproducto;
	}

	/**
	 * @param idProducto the idProducto to set
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
	

}
