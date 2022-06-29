package tp03.ejercicio3;
import tp03.ejercicio1.ArbolBinario;
import tp02.ejercicio2.*;

public class PruebaContador {

	public static void main(String[] args) {
		
		/*
						   30
				     10         55
	 	           0   21          63
	 	                              74
			
		*/
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(30);
		
		ArbolBinario<Integer> h1i_raiz = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> h1d_raiz = new ArbolBinario<Integer>(55);
		
		raiz.agregarHijoIzquierdo(h1i_raiz);
		raiz.agregarHijoDerecho(h1d_raiz);
		
		ArbolBinario<Integer> h2i_h1i = new ArbolBinario<Integer>(0);
		ArbolBinario<Integer> h2d_h1i = new ArbolBinario<Integer>(21);
		ArbolBinario<Integer> h2d_h1d = new ArbolBinario<Integer>(63);		
		
		h1i_raiz.agregarHijoIzquierdo(h2i_h1i);
		h1i_raiz.agregarHijoDerecho(h2d_h1i);		
		h1d_raiz.agregarHijoDerecho(h2d_h1d);
		
		ArbolBinario<Integer> h3d_h2d = new ArbolBinario<Integer>(74);
		h2d_h1d.agregarHijoDerecho(h3d_h2d);
		
		ContadorArbol test = new ContadorArbol(raiz);
		ListaEnlazadaGenerica<Integer> lista = test.numerosPares();
		System.out.println(lista.toString());
	}

}
