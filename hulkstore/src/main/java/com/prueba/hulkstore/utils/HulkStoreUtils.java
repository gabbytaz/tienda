/**
 * 
 */
package com.prueba.hulkstore.utils;

/**
 * 
 * @author Gabbytaz
 *
 */
public final class HulkStoreUtils {

	/**
	 * 
	 * @param divisor 
	 * @param dividendo
	 * @param scale numero de decimales que se desea obtener
	 * @return
	 */
	public static float obtenerPromedio(float divisor, float dividendo, int scale) {
		float valorPromedio = divisor/dividendo;
		float valor = (Math.round(valorPromedio * scale) / scale);
		System.out.println(valor);
		return valor;
	}

}
