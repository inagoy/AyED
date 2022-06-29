package tp03.ejercicio1;

public class Prueba {

	public static void main(String[] args) {
		
		/*
						   30
				     10         50
	 	           0   20          60
	 	                              70
			
		*/
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(30);
		
		ArbolBinario<Integer> h1i_raiz = new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> h1d_raiz = new ArbolBinario<Integer>(50);
		
		raiz.agregarHijoIzquierdo(h1i_raiz);
		raiz.agregarHijoDerecho(h1d_raiz);
		
		ArbolBinario<Integer> h2i_h1i = new ArbolBinario<Integer>(0);
		ArbolBinario<Integer> h2d_h1i = new ArbolBinario<Integer>(20);
		ArbolBinario<Integer> h2d_h1d = new ArbolBinario<Integer>(60);		
		
		h1i_raiz.agregarHijoIzquierdo(h2i_h1i);
		h1i_raiz.agregarHijoDerecho(h2d_h1i);		
		h1d_raiz.agregarHijoDerecho(h2d_h1d);
		
		ArbolBinario<Integer> h3d_h2d = new ArbolBinario<Integer>(70);
		h2d_h1d.agregarHijoDerecho(h3d_h2d);
		
		System.out.println("-----Arbol inOrder-----");
		raiz.inOrder();
		System.out.println();
		System.out.println("-----Cantidad de hojas-----");
		System.out.println(raiz.contarHojas());
		System.out.println("-----Espejo inOrder-----");
		raiz.espejo().inOrder();
		System.out.println();
		System.out.println("-----Arbol porNiveles-----");
		raiz.entreNiveles(2,2);
		
		System.out.println("Altura: " + raiz.altura());
	}
}
