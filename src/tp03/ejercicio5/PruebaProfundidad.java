package tp03.ejercicio5;
import tp03.ejercicio1.ArbolBinario;


public class PruebaProfundidad {

	public static void main(String[] args) {
		
		/*
						   2
				     3          3
	 	          4    1      5    3
	 	                              
			
		*/
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(2);
		
		ArbolBinario<Integer> h1i_raiz = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> h1d_raiz = new ArbolBinario<Integer>(3);
		
		raiz.agregarHijoIzquierdo(h1i_raiz);
		raiz.agregarHijoDerecho(h1d_raiz);
		
		ArbolBinario<Integer> h2i_h1i = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> h2d_h1i = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> h2i_h1d = new ArbolBinario<Integer>(5);	
		ArbolBinario<Integer> h2d_h1d = new ArbolBinario<Integer>(3);		
		
		
		h1i_raiz.agregarHijoIzquierdo(h2i_h1i);
		h1i_raiz.agregarHijoDerecho(h2d_h1i);
		h1d_raiz.agregarHijoIzquierdo(h2i_h1d);
		h1d_raiz.agregarHijoDerecho(h2d_h1d);
		
		ProfundidadDeArbolBinario test = new ProfundidadDeArbolBinario(raiz);
		System.out.println(test.sumaElementosProfundidad(2));
	}

}
