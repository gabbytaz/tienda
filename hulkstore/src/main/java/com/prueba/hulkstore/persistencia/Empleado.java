/**
 * 
 */
package com.prueba.hulkstore.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Gabbytaz
 *
 */
@Entity(name="empleado")
public class Empleado {
	
	/**
	 * cedula del empleado
	 */
	@Id
	private String cedula;
	
	/**
	 * nombre del empleado
	 */
	@Column(name = "nombre")
	private String nombre;
	
	/**
	 * apellido del empleado
	 */
	@Column(name = "apellido")
	private String apellido;
	
//	@OneToMany(mappedBy = "idempleado")
//	private List<Transaccion> transacciones;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
