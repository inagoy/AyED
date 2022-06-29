package tp04.ejercicio1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		if (!this.esVacio()) {
			ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
			preOrden(this, lista);
			return lista;
		}
		return null;
	}
	
	private void preOrden(ArbolGeneral<T> arbol, ListaEnlazadaGenerica<T> lista) {
		lista.agregarFinal(arbol.getDato());
		if (!this.esHoja()) {
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin())
				preOrden(hijos.proximo(),lista);
		}
	}

	public Integer altura() {
		int altura = -1;
		if (!this.esHoja()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()){
				altura = Math.max(altura,hijos.proximo().altura());
			}
		}			
		return ++altura;
	}
	
	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux!=null) {
				if (aux.getDato()== dato)
					return nivel;
				else if (aux.tieneHijos()){
						ListaGenerica<ArbolGeneral<T>> hijos = aux.getHijos();
						hijos.comenzar();
						while (!hijos.fin())
							cola.encolar(hijos.proximo());
				}
			} else if (!cola.esVacia()){
				cola.encolar(null);
				nivel++;
			}
		}
		
		return -1;
	}

		public Integer ancho() {
			ArbolGeneral<T> aux;;
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
			cola.encolar(this);
			cola.encolar(null);
			int cantidadNodos = 0;
			int cantidadNodosMaximo = 1;
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					if (aux.tieneHijos()) {
						ListaGenerica<ArbolGeneral<T>> lHijos = aux.getHijos();
						lHijos.comenzar();
						while (!lHijos.fin()) {
							cola.encolar(lHijos.proximo());
							++cantidadNodos;
						}
					}
				} else if (!cola.esVacia()) {
					cola.encolar(null);
					cantidadNodosMaximo = Math.max(cantidadNodosMaximo, cantidadNodos);
					cantidadNodos = 0;
				}
			}
			return cantidadNodosMaximo;
		}
		
		private ArbolGeneral<T> buscarArbol(ArbolGeneral<T> a, T dato){
			if ( (a != null) && (!a.esVacio())) {
				if (a.getDato() == dato)
					return a;
				else if (a.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos = a.getHijos();
					hijos.comenzar();
					while (!hijos.fin())
						buscarArbol(hijos.proximo(), dato);
				}
			}
			return null;
		}
		public boolean esAncestro(T a, T b) {

			ArbolGeneral<T>arbolA = buscarArbol(this, a);
			return ((buscarArbol(arbolA, b))!=null);

		
		}
		
}