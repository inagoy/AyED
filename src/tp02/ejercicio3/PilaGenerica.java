
package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class PilaGenerica<T> {
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void apilar(T elem) {
		datos.agregarFinal(elem);
	}
	
	public T desapilar() {
		T ret = tope();
		datos.eliminarEn(datos.tamanio());
		return ret;
	}
	public T tope() {
		return datos.elemento(datos.tamanio());
	}
	public boolean esVacia() {
		return datos.esVacia();
	}
}
