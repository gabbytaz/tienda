/**
 * 
 */
package com.prueba.hulkstore.persistencia;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Gabbytaz
 *
 */
@Entity(name="kardex")
public class Kardex {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idkardex")
	private int idkardex;
	
	@Column(name= "cantidadkardex")
	private int cantidadkardex;
	
	@Column(name= "valorkardex")
	private float valorkardex;
	
	@Column(name= "totalkardex")
	private float totalkardex;
	
	@Column(name= "idproducto")
	private int idproducto;
	
	@OneToOne
	@JoinColumn(name = "idproducto", insertable=false, updatable=false)
	private Producto producto;
	
	@OneToMany
	@JoinColumn(name = "idkardex", insertable=false, updatable=false)
	private List<DetalleKardex>detallesKardex;

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
	 * @return the cantidadkardex
	 */
	public int getCantidadkardex() {
		return cantidadkardex;
	}

	/**
	 * @param cantidadkardex the cantidadkardex to set
	 */
	public void setCantidadkardex(int cantidadkardex) {
		this.cantidadkardex = cantidadkardex;
	}

	/**
	 * @return the valorkardex
	 */
	public float getValorkardex() {
		return valorkardex;
	}

	/**
	 * @param valorkardex the valorkardex to set
	 */
	public void setValorkardex(float valorkardex) {
		this.valorkardex = valorkardex;
	}

	/**
	 * @return the totalkardex
	 */
	public float getTotalkardex() {
		return totalkardex;
	}

	/**
	 * @param totalkardex the totalkardex to set
	 */
	public void setTotalkardex(float totalkardex) {
		this.totalkardex = totalkardex;
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
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the detallesKardex
	 */
	public List<DetalleKardex> getDetallesKardex() {
		return detallesKardex;
	}

	/**
	 * @param detallesKardex the detallesKardex to set
	 */
	public void setDetallesKardex(List<DetalleKardex> detallesKardex) {
		this.detallesKardex = detallesKardex;
	}

}
