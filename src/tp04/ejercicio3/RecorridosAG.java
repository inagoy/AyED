package tp04.ejercicio3;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class RecorridosAG {
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> res = new ListaEnlazadaGenerica<Integer>();
		if ((a != null) && (!a.esVacio())) {
			numerosImparesMayoresQuePreOrden(a,n,res);
		}
		return res;
	}
	private void numerosImparesMayoresQuePreOrden (ArbolGeneral <Integer> a,
			Integer n, ListaGenerica<Integer> res){
		
		Integer dato = a.getDato();
		if ((dato % 2 != 0) && (dato>n))
				res.agregarFinal(dato);
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			hijos.comenzar();
			while (!hijos.fin()) {
				numerosImparesMayoresQuePreOrden(hijos.proximo(), n, res);
			}
		}
	}
	

	
	public ListaGenerica<Integer> numerosImparesMayoresQuePosOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> res = new ListaEnlazadaGenerica<Integer>();
		if ((a != null) && (!a.esVacio())) {
			numerosImparesMayoresQuePosOrden(a, n, res);
		}
		return res;
	}
	
	private void numerosImparesMayoresQuePosOrden (ArbolGeneral <Integer> a,
			Integer n, ListaGenerica<Integer> res){
		
		Integer dato = a.getDato();
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			hijos.comenzar();
			while (!hijos.fin()) {
				numerosImparesMayoresQuePosOrden(hijos.proximo(), n, res);
			}
		}
		if ((dato % 2 != 0) && (dato>n))
			res.agregarFinal(dato);
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a, Integer n){
		ListaGenerica<Integer> res = new ListaEnlazadaGenerica<Integer>();
		if ((a != null) && (!a.esVacio())) {
			numerosImparesMayoresQueInOrden(a,n,res);
		}
		return res;
	}
	private void numerosImparesMayoresQueInOrden (ArbolGeneral <Integer> a,
			Integer n, ListaGenerica<Integer> res){
		
		Integer dato = a.getDato();
		if (a.tieneHijos()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			hijos.comenzar();
			numerosImparesMayoresQueInOrden(hijos.proximo(), n,res);
			
			if ((dato % 2 != 0) && (dato>n))
				res.agregarFinal(dato);
			
			while (!hijos.fin()) 
				numerosImparesMayoresQueInOrden(hijos.proximo(), n,res);
		
		} else if ((dato % 2 != 0) && (dato>n))
			res.agregarFinal(dato);
	}
	
	public ListaGenerica<Integer>numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> res = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		if ((a != null) && (!a.esVacio())) {
			cola.encolar(a);
			ArbolGeneral<Integer> v;
			while (!cola.esVacia()) {
				v = cola.desencolar();
				Integer dato = v.getDato();
				if ((dato % 2 != 0) && (dato>n))
					res.agregarFinal(dato);
				if (v.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = v.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						cola.encolar(hijos.proximo());
				}
			}
		}
		return res;
	}
}
