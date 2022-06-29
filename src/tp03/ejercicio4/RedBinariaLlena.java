package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class RedBinariaLlena {
	
	private ArbolBinario<Integer> red;
	
	public RedBinariaLlena(ArbolBinario<Integer> red) {
		this.red = red;
	}
	
	private int retardoReenvio(ArbolBinario<Integer> a) {
		int max = a.getDato();
		int aux = 0;
		if (!a.esHoja()) {
			aux= Math.max(aux, retardoReenvio(a.getHijoIzquierdo()));	
			aux= Math.max(aux, retardoReenvio(a.getHijoDerecho()));	
		}
		return max+aux;
	}
	
	public int retardoReenvio() {
		
		return retardoReenvio(red);
	}
}
