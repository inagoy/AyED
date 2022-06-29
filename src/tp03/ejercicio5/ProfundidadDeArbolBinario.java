package tp03.ejercicio5;
import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		ArbolBinario<Integer> v;
		ColaGenerica<ArbolBinario<Integer>>  cola = new ColaGenerica<ArbolBinario<Integer>>();
		
		cola.encolar(arbol);
		cola.encolar(null);
		int nivel= 0;
		
		while (!cola.esVacia() && nivel<= p) {
			v = cola.desencolar();
			if (v!=null) {
				if (nivel== p) 
					suma += v.getDato();
				
			    if (v.tieneHijoIzquierdo())
			    	cola.encolar(v.getHijoIzquierdo());
				if (v.tieneHijoDerecho())
					cola.encolar(v.getHijoDerecho());
			} else if (!cola.esVacia()){
				cola.encolar(null);
				nivel ++;
			}
		}
		return suma;
	}
}
