package tp04.ejercicio1;
import tp02.ejercicio2.*;

public class TestArbolGeneral {

	public static void main(String[] args) {
		ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
		
		f.agregarHijo(h);
		f.agregarHijo(i);
		
		g.agregarHijo(j);
		
		lista.agregarFinal(c);
		lista.agregarFinal(d);
		lista.agregarFinal(e);
		
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(13,lista);

		
		lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		lista.agregarFinal(b);
		lista.agregarFinal(f);
		lista.agregarFinal(g);
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(11,lista);
		
		Integer x = 11; 
		Integer y = 13;
		System.out.println(a.esAncestro(x,y));
	}

}
