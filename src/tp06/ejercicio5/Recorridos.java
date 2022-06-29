package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp06.ejercicio3.*;

public class Recorridos<T> {
	
	public ListaGenerica<Vertice<T>> dfs (Grafo<T> grafo){
		
		ListaGenerica<Vertice<T>> res = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio() + 1];
		for (int i= 1; i<grafo.listaDeVertices().tamanio();i++) {
			if (!marcas[i]) {
				dfs(i, grafo, res, marcas);
			}
		}
		return res;
	}
	
	private void dfs(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> res, 
			boolean [] marcas) {
		marcas[i]= true;
		Vertice <T> v = grafo.listaDeVertices().elemento(i);
		res.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int posAdy = ady.proximo().verticeDestino().getPosicion();
			if (!marcas[posAdy])
				dfs(posAdy, grafo, res, marcas);	
		}
	}
	
	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){
		ListaGenerica<Vertice<T>> res = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean [] marcas = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i=1; i<grafo.listaDeVertices().tamanio(); i++) {
			if (!marcas[i])
				bfs(i,grafo,marcas,res);
		}
		return res;
	}
	
	private void bfs (int i, Grafo<T> grafo, boolean [] marcas,
			ListaGenerica<Vertice<T>> res) {
		
		ListaGenerica<Arista<T>> ady;
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>();
		marcas[i]= true;
		cola.encolar(grafo.listaDeVertices().elemento(i));
		while (!cola.esVacia()) {
			Vertice<T> v = cola.desencolar();
			res.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Vertice<T> aux = ady.proximo().verticeDestino();
				if (!marcas[aux.getPosicion()]) {
					marcas[aux.getPosicion()] = true;
					cola.encolar(aux);
				}
			}
		}
		
	}
}
