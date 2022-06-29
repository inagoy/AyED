package tp02.ejercicio3;
import tp02.ejercicio2.*;

public class ColaGenerica<T>{
	private ListaEnlazadaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void encolar(T elem) {
		datos.agregarFinal(elem);
	}
	public T desencolar() {
		T ret = datos.elemento(1);
		datos.eliminarEn(1);
		return ret;
	}
	public T tope() {
		return datos.elemento(datos.tamanio());
	} 
	public boolean esVacia() {
		return datos.esVacia();
	}
}
