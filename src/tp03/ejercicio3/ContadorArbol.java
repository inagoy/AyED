package tp03.ejercicio3;
import tp03.ejercicio1.*; 
import tp02.ejercicio2.*;

public class ContadorArbol {
	
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.setArbol(arbol);
	}
	
	public ArbolBinario<Integer> getArbol() {
		return arbol;
	}
	
	public void setArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	private void numerosParesRecursivoInOrder (ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> l) {
		if (a.tieneHijoIzquierdo())
			this.numerosParesRecursivoInOrder(a.getHijoIzquierdo(), l);
		if (a.getDato() % 2 == 0)
			l.agregarFinal(a.getDato());
		if (a.tieneHijoDerecho())
			this.numerosParesRecursivoInOrder(a.getHijoDerecho(), l);
	}

	private void numerosParesRecursivoPostOrder (ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> l) {
		if (a.tieneHijoIzquierdo())
			this.numerosParesRecursivoPostOrder(a.getHijoIzquierdo(), l);
		if (a.tieneHijoDerecho())
			this.numerosParesRecursivoPostOrder(a.getHijoDerecho(), l);
		if (a.getDato() % 2 == 0)
			l.agregarFinal(a.getDato());
	}
	
	public ListaEnlazadaGenerica<Integer> numerosPares(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		//this.numerosParesRecursivoInOrder(this.getArbol() , lista);
		this.numerosParesRecursivoPostOrder(this.getArbol() , lista);
		return lista;
	}
	
}
